package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.CompanyDTORequest;
import org.example.backend.dto.response.account.client.CompanyDTOResponse;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.CompanyRepository;
import org.example.backend.service.intf.account.client.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ClientRepository clientRepository;

    @Override
    public Optional<CompanyDTOResponse> update(Long id, CompanyDTORequest companyDTORequest) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setCompanyName(companyDTORequest.getCompanyName());
            company.setAddress(companyDTORequest.getAddress());
            company.setPhoneContact(companyDTORequest.getPhoneContact());
            company.setIndustry(companyDTORequest.getIndustry());
            if (companyDTORequest.getClientId() != null) {
                Optional<Client> clientOptional = clientRepository.findById(companyDTORequest.getClientId());
                clientOptional.ifPresent(company::setClient);
            }

            Company updatedCompany = companyRepository.save(company);

            return Optional.of(new CompanyDTOResponse(
                    updatedCompany.getId(),
                    updatedCompany.getCompanyName(),
                    updatedCompany.getAddress(),
                    updatedCompany.getPhoneContact(),
                    updatedCompany.getIndustry(),
                    updatedCompany.getClient() != null ? updatedCompany.getClient().getId() : null
            ));
        }

        return Optional.empty();
    }
    @Override
    public CompanyDTOResponse create(CompanyDTORequest companyDTORequest) {
        Company company = new Company();
        company.setCompanyName(companyDTORequest.getCompanyName());
        company.setAddress(companyDTORequest.getAddress());
        company.setPhoneContact(companyDTORequest.getPhoneContact());
        company.setIndustry(companyDTORequest.getIndustry());

        Optional<Client> client = clientRepository.findById(companyDTORequest.getClientId());
        client.ifPresent(company::setClient);

        Company savedCompany = companyRepository.save(company);

        return new CompanyDTOResponse(
                savedCompany.getId(),
                savedCompany.getCompanyName(),
                savedCompany.getAddress(),
                savedCompany.getPhoneContact(),
                savedCompany.getIndustry(),
                savedCompany.getClient() != null ? savedCompany.getClient().getId() : null
        );
    }

    @Override
    public Optional<CompanyDTOResponse> getById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(c -> new CompanyDTOResponse(
                c.getId(),
                c.getCompanyName(),
                c.getAddress(),
                c.getPhoneContact(),
                c.getIndustry(),
                c.getClient() != null ? c.getClient().getId() : null
        ));
    }

    @Override
    public List<CompanyDTOResponse> getAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> new CompanyDTOResponse(
                        company.getId(),
                        company.getCompanyName(),
                        company.getAddress(),
                        company.getPhoneContact(),
                        company.getIndustry(),
                        company.getClient() != null ? company.getClient().getId() : null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
