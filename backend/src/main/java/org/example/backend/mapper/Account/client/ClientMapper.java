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
    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "user.account.email", target = "email")
    @Mapping(source = "user.province", target = "province")
    @Mapping(source = "user.country", target = "country")
    @Mapping(source = "user.image", target = "image")
    ClientDTOResponse toResponseDto(Client client);
}