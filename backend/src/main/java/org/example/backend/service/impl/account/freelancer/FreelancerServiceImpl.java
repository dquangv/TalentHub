package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.service.intf.account.Freelancer.FreelancerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

    @Override
    public FreelancerJobDTORequest create(FreelancerJobDTORequest freelancerDTORequest) {
        return null;
    }

    @Override
    public Optional<FreelancerJobDTORequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<FreelancerJobDTORequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
