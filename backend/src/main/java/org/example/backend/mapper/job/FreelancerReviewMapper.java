package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.FreelancerReviewDTORequest;
import org.example.backend.dto.response.job.FreelancerReviewDTOResponse;
import org.example.backend.entity.child.account.freelancer.FreelancerReview;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FreelancerReviewMapper extends BaseMapper<FreelancerReview, FreelancerReviewDTORequest, FreelancerReviewDTOResponse> {
}
