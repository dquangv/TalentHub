package org.example.backend.mapper.Account.freelancer;

import org.example.backend.dto.request.account.freelancer.UpdateHourlyRateDTORequest;
import org.example.backend.dto.response.account.freelancer.UpdateHourlyRateDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UpdateHourlyRateMapper extends BaseMapper<Freelancer, UpdateHourlyRateDTORequest, UpdateHourlyRateDTOResponse> {

    @Mapping(source = "id", target = "freelancerId")
    UpdateHourlyRateDTOResponse toResponseDto(Freelancer entity);

    @Mapping(source = "freelancerId", target = "id")
    Freelancer toEntity(UpdateHourlyRateDTOResponse dto);

}
