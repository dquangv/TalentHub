package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.FreelancerSkillDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerSkillDTOResponse;
import org.example.backend.service.intf.account.freelancer.FreelancerSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FreelancerSkillServiceImpl implements FreelancerSkillService {

    @Override
    public FreelancerSkillDTOResponse create(FreelancerSkillDTORequest freelancerSkillDTORequest) {
        return null;
    }

    @Override
    public Optional<FreelancerSkillDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<FreelancerSkillDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
