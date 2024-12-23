package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.FreelancerSkillDTORequest;
import org.example.backend.entity.child.account.freelancer.FreelancerSkill;
import org.example.backend.service.intf.account.Freelancer.FreelancerSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FreelancerSkillServiceImpl implements FreelancerSkillService {

    @Override
    public FreelancerSkillDTORequest create(FreelancerSkillDTORequest freelancerSkillDTORequest) {
        return null;
    }

    @Override
    public Optional<FreelancerSkillDTORequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<FreelancerSkillDTORequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
