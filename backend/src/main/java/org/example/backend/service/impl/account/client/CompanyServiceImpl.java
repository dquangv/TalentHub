package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.CompanyDTORequest;
import org.example.backend.dto.response.account.client.CompanyDTOResponse;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.service.intf.account.client.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Override
    public CompanyDTOResponse create(CompanyDTORequest companyDTORequest) {
        return null;
    }

    @Override
    public Optional<CompanyDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<CompanyDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
