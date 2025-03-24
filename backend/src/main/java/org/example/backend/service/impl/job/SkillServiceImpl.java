package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.SkillDTORequest;
import org.example.backend.dto.response.job.SkillDTOResponse;
import org.example.backend.entity.child.account.freelancer.FreelancerSkill;
import org.example.backend.entity.child.job.JobSkill;
import org.example.backend.entity.child.job.Skill;
import org.example.backend.exception.BadRequestException;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.job.SkillMapper;
import org.example.backend.repository.FreelancerSkillRepository;
import org.example.backend.repository.JobSkillRepository;
import org.example.backend.repository.SkillRepository;
import org.example.backend.service.intf.job.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillMapper skillMapper;
    private final SkillRepository skillRepository;
    private final FreelancerSkillRepository freelancerSkillRepository;
    private final JobSkillRepository jobSkillRepository;
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
    public Optional<SkillDTOResponse> getById(Long id) {
        return skillRepository.findById(id)
                .map(skill -> {
                    Long quantityFreelancerSkill = freelancerSkillRepository.countBySkillId(skill.getId());
                    Long quantityJobSkill = jobSkillRepository.countBySkillId(skill.getId());

                    return new SkillDTOResponse(
                            skill.getId(),
                            skill.getSkillName(),
                            quantityFreelancerSkill,
                            quantityJobSkill
                    );
                });
    }

    @Override
    public List<SkillDTOResponse> getAll() {
        return skillRepository.findAll().stream()
                .map(skill -> {
                    Long quantityFreelancerSkill = freelancerSkillRepository.countBySkillId(skill.getId());
                    Long quantityJobSkill = jobSkillRepository.countBySkillId(skill.getId());

                    return new SkillDTOResponse(
                            skill.getId(),
                            skill.getSkillName(),
                            quantityFreelancerSkill,
                            quantityJobSkill
                    );
                })
                .collect(Collectors.toList());
    }
    @Override
    public Boolean deleteById(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);

        if (skill == null) {
            return false;
        }

        for (FreelancerSkill freelancerSkill : skill.getFreelancerSkills()) {
            freelancerSkillRepository.delete(freelancerSkill);
        }

        List<JobSkill> listJobSkills = jobSkillRepository.findBySkillId(skill.getId());
        for (JobSkill jobSkill : listJobSkills) {
            jobSkillRepository.delete(jobSkill);
        }

        skillRepository.deleteById(id);
        return true;
    }



    @Override
    public SkillDTOResponse update(Long id, SkillDTORequest skillDTORequest) {
        if (skillDTORequest == null) {
            throw new BadRequestException("Skill request cannot be null");
        }

        if (skillDTORequest.getSkillName() == null || skillDTORequest.getSkillName().isEmpty()) {
            throw new BadRequestException("Skill name cannot be null or empty");
        }

        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Skill not found with id: " + id));

        skill.setSkillName(skillDTORequest.getSkillName());
        return skillMapper.toResponseDto(skillRepository.save(skill));
    }
}