package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.ClientReviewDTORequest;
import org.example.backend.dto.response.job.ClientReviewDTOResponse;
import org.example.backend.entity.child.account.client.ClientReview;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientReviewMapper extends BaseMapper<ClientReview, ClientReviewDTORequest, ClientReviewDTOResponse> {
}
