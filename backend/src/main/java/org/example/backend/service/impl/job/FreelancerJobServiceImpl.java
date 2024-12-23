package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FreelancerJobServiceImpl implements FreelancerJobService {

    @Override
    public FreelancerJobDTORequest create(FreelancerJobDTORequest freelancerJobDTORequest) {
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
