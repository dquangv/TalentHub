package org.example.backend.service.impl.account.freelancer;


import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.FreelancerSkillDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerSkillDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.account.freelancer.FreelancerSkill;
import org.example.backend.entity.child.job.Skill;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.FreelancerSkillRepository;
import org.example.backend.repository.SkillRepository;
import org.example.backend.service.intf.account.freelancer.FreelancerSkillService;
import org.example.backend.service.intf.job.FreelancerSkillMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreelancerSkillServiceImpl implements FreelancerSkillService {
    private final FreelancerSkillRepository freelancerSkillRepository;
    private final FreelancerRepository freelancerRepository;
    private final SkillRepository skillRepository;
    private final FreelancerSkillMapper freelancerSkillMapper;

    @Override
    public List<FreelancerSkillDTOResponse> getAllSkills() {
        return freelancerSkillRepository.findAll().stream()
                .map(freelancerSkillMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FreelancerSkillDTOResponse addSkillToFreelancer(FreelancerSkillDTORequest request) {
        Freelancer freelancer = freelancerRepository.findById(request.getFreelancerId())
                .orElseThrow(() -> new RuntimeException("Freelancer not found"));

        Skill skill = skillRepository.findById(request.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        FreelancerSkill freelancerSkill = new FreelancerSkill();
        freelancerSkill.setFreelancer(freelancer);
        freelancerSkill.setSkill(skill);

        return freelancerSkillMapper.toDTO(freelancerSkillRepository.save(freelancerSkill));
    }

    @Override
    @Transactional
    public void removeSkillFromFreelancer(Long freelancerId, Long skillId) {
        freelancerSkillRepository.deleteByFreelancer_IdAndSkill_Id(freelancerId, skillId);
    }

    @Override
    @Transactional
    public FreelancerSkillDTOResponse updateFreelancerSkill(Long id, FreelancerSkillDTORequest request) {
        FreelancerSkill freelancerSkill = freelancerSkillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FreelancerSkill not found"));

        Skill newSkill = skillRepository.findById(request.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        freelancerSkill.setSkill(newSkill);
        return freelancerSkillMapper.toDTO(freelancerSkillRepository.save(freelancerSkill));
    }
}