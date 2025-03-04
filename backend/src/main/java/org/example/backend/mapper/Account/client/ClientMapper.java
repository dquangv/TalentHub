package org.example.backend.mapper.Account.client;

import org.example.backend.dto.response.account.client.ClientDTOResponse;
import org.example.backend.entity.child.account.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "jobsCount", expression = "java(client.getJobs().size())")
    @Mapping(target = "appointmentsCount", expression = "java(client.getAppointments().size())")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source="user.account.email", target = "email")
    @Mapping(source="user.address", target = "address")
    ClientDTOResponse toResponseDto(Client client);
}
