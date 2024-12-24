package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.JobSkillDTORequest;
import org.example.backend.dto.response.job.JobSkillDTOResponse;
import org.example.backend.service.intf.job.JobSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JobSkillServiceImpl implements JobSkillService {

    @Override
    public JobSkillDTOResponse create(JobSkillDTORequest jobSKillRequest) {
        return null;
    }

    @Override
    public Optional<JobSkillDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<JobSkillDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
