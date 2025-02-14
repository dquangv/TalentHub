package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.SkillDTORequest;
import org.example.backend.dto.response.job.SkillDTOResponse;
import org.example.backend.entity.child.job.Skill;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.job.SkillMapper;
import org.example.backend.repository.SkillRepository;
import org.example.backend.service.intf.job.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;

    @Override
    public SkillDTOResponse create(SkillDTORequest skillDTORequest) {
        if (skillDTORequest == null) {
            throw new BadRequestException("Skill request cannot be null");
        }

        if (skillDTORequest.getSkillName() == null || skillDTORequest.getSkillName().isEmpty()) {
            throw new BadRequestException("Skill name cannot be null or empty");
        }

        Skill skill = skillMapper.toEntity(skillDTORequest);

        return skillMapper.toResponseDto(skillRepository.save(skill));
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
