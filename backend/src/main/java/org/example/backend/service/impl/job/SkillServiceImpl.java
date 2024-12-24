package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.SkillDTORequest;
import org.example.backend.dto.response.job.SkillDTOResponse;
import org.example.backend.entity.child.job.Skill;
import org.example.backend.service.intf.job.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    @Override
    public SkillDTOResponse create(SkillDTORequest skillDTORequest) {
        return null;
    }

    @Override
    public Optional<SkillDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<SkillDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
