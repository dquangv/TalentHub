package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.request.account.freelancer.FreelancerSkillDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerSkillDTOResponse;

import java.util.List;

public interface FreelancerSkillService {
    List<FreelancerSkillDTOResponse> getAllSkills();

    List<FreelancerSkillDTOResponse> getSkillsByFreelancerId(Long freelancerId);

    FreelancerSkillDTOResponse addSkillToFreelancer(FreelancerSkillDTORequest request);

    void removeSkillFromFreelancer(Long freelancerId, Long skillId);

    FreelancerSkillDTOResponse updateFreelancerSkill(Long id, FreelancerSkillDTORequest request);
}