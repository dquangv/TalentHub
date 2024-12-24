package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.service.intf.account.freelancer.FreelancerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

    @Override
    public FreelancerJobDTOResponse create(FreelancerJobDTORequest freelancerDTORequest) {
        return null;
    }

    @Override
    public Optional<FreelancerJobDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<FreelancerJobDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
