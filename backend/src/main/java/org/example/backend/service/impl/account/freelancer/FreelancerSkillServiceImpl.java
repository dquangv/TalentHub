package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.FreelancerSkillDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerSkillDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.account.freelancer.FreelancerSkill;
import org.example.backend.entity.child.job.Skill;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.Account.freelancer.FreelancerSkillMapper;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.FreelancerSkillRepository;
import org.example.backend.repository.SkillRepository;
import org.example.backend.service.intf.account.freelancer.FreelancerSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreelancerSkillServiceImpl implements FreelancerSkillService {
    private final SkillRepository skillRepository;
    private final FreelancerRepository freelancerRepository;
    private final FreelancerSkillRepository freelancerSkillRepository;
    private final FreelancerSkillMapper freelancerSkillMapper;

    @Override
    public List<FreelancerSkillDTOResponse> getAllSkills() {
        return freelancerSkillRepository.findAll().stream()
                .map(freelancerSkillMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<FreelancerSkillDTOResponse> getSkillsByFreelancerId(Long freelancerId) {
        if (!freelancerRepository.existsById(freelancerId)) {
            throw new NotFoundException("Freelancer not found with id: " + freelancerId);
        }
        List<FreelancerSkill> freelancerSkills = freelancerSkillRepository.findByFreelancer_Id(freelancerId);
        return freelancerSkills.stream()
                .map(freelancerSkillMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FreelancerSkillDTOResponse addSkillToFreelancer(FreelancerSkillDTORequest request) {
        Skill skill = skillRepository.findById(request.getSkillId())
                .orElseThrow(() -> new NotFoundException("Skill not found with id: " + request.getSkillId()));

        Freelancer freelancer = freelancerRepository.findById(request.getFreelancerId())
                .orElseThrow(() -> new NotFoundException("Freelancer not found with id: " + request.getFreelancerId()));

        FreelancerSkill freelancerSkill = new FreelancerSkill();
        freelancerSkill.setFreelancer(freelancer);
        freelancerSkill.setSkill(skill);

        FreelancerSkill saved = freelancerSkillRepository.save(freelancerSkill);
        return freelancerSkillMapper.toDTO(saved);
    }

    @Override
    public void removeSkillFromFreelancer(Long freelancerId, Long skillId) {
        FreelancerSkill freelancerSkill = freelancerSkillRepository.findByFreelancer_IdAndSkill_Id(freelancerId, skillId)
                .orElseThrow(() -> new NotFoundException("FreelancerSkill not found"));
        freelancerSkillRepository.delete(freelancerSkill);
    }

    @Override
    public FreelancerSkillDTOResponse updateFreelancerSkill(Long id, FreelancerSkillDTORequest request) {
        FreelancerSkill existingFreelancerSkill = freelancerSkillRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("FreelancerSkill not found with id: " + id));

        Skill skill = skillRepository.findById(request.getSkillId())
                .orElseThrow(() -> new NotFoundException("Skill not found with id: " + request.getSkillId()));

        Freelancer freelancer = freelancerRepository.findById(request.getFreelancerId())
                .orElseThrow(() -> new NotFoundException("Freelancer not found with id: " + request.getFreelancerId()));

        existingFreelancerSkill.setFreelancer(freelancer);
        existingFreelancerSkill.setSkill(skill);

        FreelancerSkill updated = freelancerSkillRepository.save(existingFreelancerSkill);
        return freelancerSkillMapper.toDTO(updated);
    }
}