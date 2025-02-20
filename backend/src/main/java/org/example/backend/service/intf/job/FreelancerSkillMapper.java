package org.example.backend.service.intf.job;



import org.example.backend.dto.request.account.freelancer.FreelancerSkillDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerSkillDTOResponse;
import org.example.backend.entity.child.account.freelancer.FreelancerSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FreelancerSkillMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "freelancer.id", source = "freelancerId")
    @Mapping(target = "skill.id", source = "skillId")
    FreelancerSkill toEntity(FreelancerSkillDTORequest dto);

    @Mapping(target = "freelancerId", source = "freelancer.id")
    @Mapping(target = "skillId", source = "skill.id")
    @Mapping(target = "skillName", source = "skill.skillName")
    FreelancerSkillDTOResponse toDTO(FreelancerSkill entity);
}