package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.FreelancerReviewDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerReviewDTOResponse;
import org.example.backend.service.intf.account.freelancer.FreelancerReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreelancerReviewServiceImpl implements FreelancerReviewService {

    @Override
    public FreelancerReviewDTOResponse create(FreelancerReviewDTORequest freelancerReviewDTORequest) {
        return null;
    }

    @Override
    public Optional<FreelancerReviewDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<FreelancerReviewDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
