package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.ClientDTORequest;
import org.example.backend.dto.request.account.client.UpdatePriceAndTypeDTORequest;
import org.example.backend.dto.response.account.client.*;
import org.example.backend.dto.response.job.ClientReviewDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.account.client.ClientReview;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.enums.StatusAccount;
import org.example.backend.exception.BadRequestException;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.Account.client.ActiveClientMapper;
import org.example.backend.mapper.Account.client.ClientMapper;
import org.example.backend.mapper.Account.client.UpdatePriceAndTypeMapper;
import org.example.backend.repository.*;
import org.example.backend.service.intf.account.client.ClientService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final ClientMapper clientMapper;
    private final UpdatePriceAndTypeMapper updatePriceAndTypeMapper;
    private final CompanyRepository companyRepository;
    private final ClientReviewRepository clientReviewRepository;
    private final ActiveClientMapper activeClientMapper;
    private final FreelancerJobRepository freelancerJobRepository;

    @Override
    public ClientDTOResponse create(ClientDTORequest clientDTORequest) {
        User user = userRepository.findById(clientDTORequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Client client = new Client();
        client.setFromPrice(clientDTORequest.getFromPrice());
        client.setToPrice(clientDTORequest.getToPrice());
        client.setTypePrice(clientDTORequest.getTypePrice());
        client.setUser(user);

        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponseDto(savedClient);
    }

    @Override
    public Optional<ClientDTOResponse> getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return Optional.of(clientMapper.toResponseDto(client.get()));
        }
        return Optional.empty();
    }


    @Override
    public List<ClientDTOResponse> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::toResponseDto).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Client findById(Long clientId) {
        if (clientId == null) {
            throw new BadRequestException("Client id is null");
        }

        return clientRepository.findById(clientId)
                .orElseThrow(() -> new BadRequestException("Client not found"));
    }
    @Override
    public UpdatePriceAndTypeDTOResponse updatePriceAndType(UpdatePriceAndTypeDTORequest updatePriceAndTypeDTORequest) {

        clientRepository.updatePrice(
                updatePriceAndTypeDTORequest.getClientId(),
                updatePriceAndTypeDTORequest.getFromPrice(),
                updatePriceAndTypeDTORequest.getToPrice(),
                updatePriceAndTypeDTORequest.getTypePrice()
        );

        Client updatedClient = clientRepository.findById(updatePriceAndTypeDTORequest.getClientId())
                .orElseThrow(() -> new BadRequestException("Client not found after update"));

        return updatePriceAndTypeMapper.toResponseDto(updatedClient);
    }
    @Override
    public List<CompanyDTOResponse> getCompaniesByClientId(Long clientId) {
        // First verify client exists
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client not found with id: " + clientId));

        // Get companies associated with this client
        List<Company> companies = companyRepository.findByClientId(clientId);

        // Convert to DTOs
        return companies.stream()
                .map(company -> new CompanyDTOResponse(
                        company.getId(),
                        company.getCompanyName(),
                        company.getAddress(),
                        company.getPhoneContact(),
                        company.getIndustry(),
                        company.getClient().getId()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActiveClientDTOResponse> getAllActiveClients() {
        List<Client> activeClients = clientRepository.findByUser_Account_StatusNot(StatusAccount.BANNED);

        List<ActiveClientDTOResponse> response = new ArrayList<>();

        for (Client client : activeClients) {
            List<ClientReview> reviews = getClientReviews(client.getId());

            List<Company> companies = companyRepository.findByClientId(client.getId());
            List<CompanyDTOResponse> companyDTOs = companies.stream()
                    .map(company -> new CompanyDTOResponse(
                            company.getId(),
                            company.getCompanyName(),
                            company.getAddress(),
                            company.getPhoneContact(),
                            company.getIndustry(),
                            company.getClient() != null ? company.getClient().getId() : null
                    ))
                    .collect(Collectors.toList());

            ActiveClientDTOResponse dto = activeClientMapper.toActiveClientResponse(
                    client,
                    reviews,
                    companyDTOs
            );

            response.add(dto);
        }

        return response;
    }
    @Override
    public ClientDetailDTOResponse getClientDetail(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client not found with id: " + clientId));

        List<ClientReview> reviews = getClientReviews(clientId);

        List<Company> companies = companyRepository.findByClientId(clientId);
        List<CompanyDTOResponse> companyDTOs = companies.stream()
                .map(company -> new CompanyDTOResponse(
                        company.getId(),
                        company.getCompanyName(),
                        company.getAddress(),
                        company.getPhoneContact(),
                        company.getIndustry(),
                        company.getClient() != null ? company.getClient().getId() : null
                ))
                .collect(Collectors.toList());

        List<ClientReviewDTOResponse> reviewDTOs = new ArrayList<>();

        for (ClientReview review : reviews) {
            FreelancerJob freelancerJob = freelancerJobRepository.findByClientReviewId(review.getId());
            if (freelancerJob != null) {
                String reviewerName = getReviewerName(review.getId());
                String projectTitle = freelancerJob.getJob() != null ? freelancerJob.getJob().getTitle() : "Unknown Project";
                String freelancerAvatar = null;
                if (freelancerJob.getFreelancer() != null &&
                        freelancerJob.getFreelancer().getUser() != null) {
                    freelancerAvatar = freelancerJob.getFreelancer().getUser().getImage();
                }
                ClientReviewDTOResponse reviewDTO = activeClientMapper.toClientReviewResponseWithProjectDetails(
                        review,
                        reviewerName,
                        projectTitle,
                        freelancerJob,
                        freelancerAvatar
                );

                reviewDTOs.add(reviewDTO);
            } else {
                String reviewerName = "Unknown Reviewer";
                reviewDTOs.add(activeClientMapper.toClientReviewResponse(review, reviewerName));
            }
        }

        return activeClientMapper.toClientDetailResponse(
                client,
                reviews,
                companyDTOs,
                reviewDTOs
        );
    }

    private List<ClientReview> getClientReviews(Long clientId) {
        return clientReviewRepository.findByClientId(clientId);
    }

    private String getReviewerName(Long reviewId) {
        FreelancerJob job = freelancerJobRepository.findByClientReviewId(reviewId);
        if (job != null && job.getFreelancer() != null && job.getFreelancer().getUser() != null) {
            User user = job.getFreelancer().getUser();
            return user.getFirstName() + " " + user.getLastName();
        }
        return "Unknown Reviewer";
    }

    public boolean checkValidClient(Long id) {
        Client client = clientRepository.findById(id).get();
        User user = client.getUser();
        Account account = user.getAccount();

        if (account.getStatus().equals(StatusAccount.BANNED)) {
            return false;
        }

        return true;
    }
}
