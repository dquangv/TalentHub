package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.JobSKillRequest;
import org.example.backend.entity.child.job.JobSkill;
import org.example.backend.service.intf.job.JobSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JobSkillServiceImpl implements JobSkillService {

    @Override
    public JobSKillRequest create(JobSKillRequest jobSKillRequest) {
        return null;
    }

    @Override
    public Optional<JobSKillRequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<JobSKillRequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
