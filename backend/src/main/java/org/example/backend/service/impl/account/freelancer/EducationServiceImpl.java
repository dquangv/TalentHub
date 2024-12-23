package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.EducationDTORequest;
import org.example.backend.entity.child.account.freelancer.Education;
import org.example.backend.service.intf.account.Freelancer.EducationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    @Override
    public EducationDTORequest create(EducationDTORequest educationDTORequest) {
        return null;
    }

    @Override
    public Optional<EducationDTORequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<EducationDTORequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
