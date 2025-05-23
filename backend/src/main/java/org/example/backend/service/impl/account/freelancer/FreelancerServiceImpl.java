package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.CreateFreelancerDTORequest;
import org.example.backend.dto.request.account.freelancer.FreelancerDTORequest;
import org.example.backend.dto.request.account.freelancer.UpdateHourlyRateDTORequest;
import org.example.backend.dto.response.account.freelancer.*;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.Category;
import org.example.backend.entity.child.account.User;
import org.example.backend.enums.StatusAccount;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Account.freelancer.CreateFreelancerMapper;
import org.example.backend.mapper.Account.freelancer.UpdateHourlyRateMapper;
import org.example.backend.repository.*;
import org.example.backend.service.intf.account.freelancer.FreelancerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

    private final FreelancerRepository freelancerRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CreateFreelancerMapper createFreelancerMapper;
    private final UpdateHourlyRateMapper updateHourlyRateMapper;
    private final FreelancerJobRepository freelancerJobRepository;

    @Override
    public FreelancerDTOResponse updateCategory(Long freelancerId, Long categoryId) {
        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new BadRequestException("Freelancer not found with ID: " + freelancerId));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new BadRequestException("Category not found with ID: " + categoryId));

        freelancer.setCategory(category);
        Freelancer updatedFreelancer = freelancerRepository.save(freelancer);

        return new FreelancerDTOResponse(
                updatedFreelancer.getId(),
                updatedFreelancer.getUser().getFirstName() + updatedFreelancer.getUser().getLastName(),
                updatedFreelancer.getHourlyRate(),
                updatedFreelancer.getDescription(),
                updatedFreelancer.getCategory() != null && updatedFreelancer.getCategory().getCategoryTitle() != null
                        ? updatedFreelancer.getCategory().getCategoryTitle()
                        : "Chưa có",
                updatedFreelancer.getUser().getId(),
                updatedFreelancer.getUser().getImage(),
                clientReviewRepository.findAverageRating(updatedFreelancer.getId()),
                updatedFreelancer.getFreelancerSkills() != null ? updatedFreelancer.getFreelancerSkills()
                        .stream()
                        .map(fs -> fs.getSkill().getSkillName())
                        .collect(Collectors.toList()) : List.of()
        );
    }

    @Override
    public FreelancerDTOResponse create(FreelancerDTORequest freelancerDTORequest) {
        Category category = categoryRepository.findById(freelancerDTORequest.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Category ID"));
        User user = userRepository.findById(freelancerDTORequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));

        Freelancer f = new Freelancer();
//        freelancer.setImage(freelancerDTORequest.getImage());
        f.setHourlyRate(freelancerDTORequest.getHourlyRate());
        f.setDescription(freelancerDTORequest.getDescription());
        f.setCategory(category);
        f.setUser(user);

        f = freelancerRepository.save(f);

        return new FreelancerDTOResponse(
                f.getId(),
                f.getUser().getFirstName() + f.getUser().getLastName(),
                f.getHourlyRate(),
                f.getDescription(),
                f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                        ? f.getCategory().getCategoryTitle()
                        : "Chưa có",
                f.getUser().getId(),
                f.getUser().getImage(),
                clientReviewRepository.findAverageRating(f.getId()),
                f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                        .stream()
                        .map(fs -> fs.getSkill().getSkillName())
                        .collect(Collectors.toList()) : List.of()
        );
    }

    private final ClientReviewRepository clientReviewRepository;

    @Override
    public Optional<FreelancerDTOResponse> getById(Long id) {
        Optional<Freelancer> freelancer = freelancerRepository.findById(id);
        return freelancer.map(f -> new FreelancerDTOResponse(
                f.getId(),
                f.getUser().getFirstName() + f.getUser().getLastName(),
                f.getHourlyRate(),
                f.getDescription(),
                f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                        ? f.getCategory().getCategoryTitle()
                        : "Chưa có",
                f.getUser().getId(),
                f.getUser().getImage(),
                clientReviewRepository.findAverageRating(f.getId()),
                f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                        .stream()
                        .map(fs -> fs.getSkill().getSkillName())
                        .collect(Collectors.toList()) : List.of()
        ));
    }
    @Override
    public List<FreelancerDTOResponse> getAll() {
        List<Freelancer> freelancers = freelancerRepository.findAll();
        return freelancers.stream()
                .map(f -> new FreelancerDTOResponse(
                        f.getId(),
                        f.getUser().getFirstName() + " " + f.getUser().getLastName(),
                        f.getHourlyRate(),
                        f.getDescription(),
                        f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                                ? f.getCategory().getCategoryTitle()
                                : "Chưa có",
                        f.getUser().getId(),
                        f.getUser().getImage(),
                       clientReviewRepository.findAverageRating(f.getId()),
                        f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                                .stream()
                                .map(fs -> fs.getSkill().getSkillName())
                                .collect(Collectors.toList()) : List.of()
                ))
                .collect(Collectors.toList());
    }

    public List<FreelancerAdminDTOResponse> getAllByAdmin() {
        List<Freelancer> freelancers = freelancerRepository.findAll();
        return freelancers.stream()
                .map(f -> new FreelancerAdminDTOResponse(
                        f.getId(),
                        f.getUser().getFirstName() + " " + f.getUser().getLastName(),
                        f.getUser().getAccount().getEmail(),
                        f.getHourlyRate(),
                        f.getDescription(),
                        f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                                ? f.getCategory().getCategoryTitle()
                                : "Chưa có",
                        f.getUser().getId(),
                        f.getUser().getImage(),
                        clientReviewRepository.findAverageRating(f.getId()),
                        f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                                .stream()
                                .map(fs -> fs.getSkill().getSkillName())
                                .collect(Collectors.toList()) : List.of()
                ))
                .collect(Collectors.toList());
    }



    @Override
    public Boolean deleteById(Long id) {

        if (freelancerRepository.existsById(id)) {
            freelancerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CreateFreelancerDTOResponse createProfile(CreateFreelancerDTORequest createFreelancerDTORequest) {

        User user = userRepository.findById(createFreelancerDTORequest.getUserId())
                .orElseThrow(() -> new BadRequestException("User not found"));

        createFreelancerDTORequest.setUserId(user.getId());

        Category category = categoryRepository.findById(createFreelancerDTORequest.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Category ID"));

        createFreelancerDTORequest.setCategoryId(category.getId());

        Freelancer freelancer = freelancerRepository.save(createFreelancerMapper.toEntity(createFreelancerDTORequest));

        return createFreelancerMapper.toResponseDto(freelancer);
    }

    @Override
    public UpdateHourlyRateDTOResponse updateHourlyRate(UpdateHourlyRateDTORequest request) {
        Freelancer freelancer = freelancerRepository.findById(request.getFreelancerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Freelancer ID"));

        freelancer.setHourlyRate(request.getHourlyRate());
        Freelancer updatedFreelancer = freelancerRepository.save(freelancer);

        return updateHourlyRateMapper.toResponseDto(updatedFreelancer);
    }

    @Override
    public List<FreelancerDTOResponse> getFreelancersByCategoryId(Long categoryId) {
        List<Freelancer> freelancers = freelancerRepository.findActiveFreelancersByCategoryId(categoryId, StatusAccount.BANNED);
        return freelancers.stream()
                .map(f -> new FreelancerDTOResponse(
                        f.getId(),
                        f.getUser().getFirstName() + " " + f.getUser().getLastName(),
                        f.getHourlyRate(),
                        f.getDescription(),
                        f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                                ? f.getCategory().getCategoryTitle()
                                : "Chưa có",
                        f.getUser().getId(),
                        f.getUser().getImage(),
                        clientReviewRepository.findAverageRating(f.getId()),
                        f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                                .stream()
                                .map(fs -> fs.getSkill().getSkillName())
                                .collect(Collectors.toList()) : List.of()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<FreelancerWithJobsDTOResponse> getFreelancersByClientId(Long clientId) {
        List<Freelancer> freelancers = freelancerJobRepository.findFreelancersByClientId(clientId);

        return freelancers.stream().map(freelancer -> {
            List<Map<String, Object>> jobInfos = freelancerJobRepository.findJobInfoByFreelancerIdAndClientId(
                    freelancer.getId(), clientId);

            List<FreelancerWithJobsDTOResponse.JobInfo> jobs = jobInfos.stream()
                    .map(info -> FreelancerWithJobsDTOResponse.JobInfo.builder()
                            .id(((Number) info.get("id")).longValue())
                            .title((String) info.get("title"))
                            .status(info.get("status") != null ? info.get("status").toString() : null)
                            .build())
                    .collect(Collectors.toList());

            Float rating = clientReviewRepository.findAverageRating(freelancer.getId());

            return FreelancerWithJobsDTOResponse.builder()
                    .userId(freelancer.getUser().getId())
                    .fullName(freelancer.getUser().getFirstName() + " " + freelancer.getUser().getLastName())
                    .avatar(freelancer.getUser().getImage())
                    .rating(rating != null ? rating : 0.0f)
                    .jobs(jobs)
                    .build();
        }).collect(Collectors.toList());
    }

    public boolean checkValidFreelancer(Long freelancerId) {
        Freelancer freelancer = freelancerRepository.findById(freelancerId).get();
        User user = freelancer.getUser();
        Account account = user.getAccount();

        if (account.getStatus().equals(StatusAccount.BANNED)) return false;

        return true;
    }
}
