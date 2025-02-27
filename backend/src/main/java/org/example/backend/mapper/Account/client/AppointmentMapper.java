package org.example.backend.mapper.Account.client;

import org.example.backend.dto.request.account.client.AppointmentDetailDTORequest;
import org.example.backend.dto.response.account.client.AppointmentDetailDTOResponse;
import org.example.backend.entity.child.account.client.Appointment;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.mapper.BaseMapper;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.FreelancerJobRepository;
import org.example.backend.service.intf.account.client.ClientService;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {ClientService.class, FreelancerJobService.class})
public interface AppointmentMapper extends BaseMapper<Appointment, AppointmentDetailDTORequest, AppointmentDetailDTOResponse> {

    @Mapping(source = "appointment.id", target = "id")
    @Mapping(source = "appointment.startTime", target = "startTime")
    @Mapping(source = "appointment.duration", target = "duration")
    @Mapping(source = "appointment.topic", target = "topic")
    @Mapping(source = "appointment.description", target = "description")
    @Mapping(source = "appointment.link", target = "link")
    AppointmentDetailDTOResponse toResponseDto(Appointment appointment);

    @Mapping(source = "dto.startTime", target = "startTime")
    @Mapping(source = "dto.duration", target = "duration")
    @Mapping(source = "dto.topic", target = "topic")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.link", target = "link")
    Appointment toEntity(AppointmentDetailDTORequest dto);

}
