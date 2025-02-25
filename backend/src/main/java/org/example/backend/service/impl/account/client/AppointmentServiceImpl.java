package org.example.backend.service.impl.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.client.AppointmentDetailDTORequest;
import org.example.backend.dto.response.account.client.AppointmentDetailDTOResponse;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.account.client.Appointment;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Account.client.AppointmentMapper;
import org.example.backend.repository.AppointmentRepository;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.FreelancerJobRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.service.intf.account.client.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final FreelancerRepository freelancerRepository;
    private final FreelancerJobRepository freelancerJobRepository;
    private final ClientRepository clientRepository;

    @Override
    public AppointmentDetailDTOResponse getAppointmentDetail(Long clientId, Long jobId, Long freelancerId) {

        return null;
    }

    @Override
    public AppointmentDetailDTOResponse create(AppointmentDetailDTORequest appointmentDetailDTORequest) {
        if (appointmentDetailDTORequest == null) {
            throw new BadRequestException("appointmentDetailDTORequest cannot be null");
        }

        if (appointmentDetailDTORequest.getClientId() == null) {
            throw new BadRequestException("clientId cannot be null");
        }

        if (appointmentDetailDTORequest.getFreelancerJobId() == null) {
            throw new BadRequestException("freelancerJobId cannot be null");
        }

        if (appointmentDetailDTORequest.getStartTime() == null) {
            throw new BadRequestException("startTime cannot be null");
        }

        if (appointmentDetailDTORequest.getLink() == null) {
            throw new BadRequestException("link cannot be null");
        }

        Optional<FreelancerJob> freelancerJob = freelancerJobRepository.findById(appointmentDetailDTORequest.getFreelancerJobId());

        Freelancer freelancer = freelancerRepository.findById(freelancerJob.get().getFreelancer().getId()).get();
        User user = freelancer.getUser();
        Client client = clientRepository.findById(appointmentDetailDTORequest.getClientId()).get();

        Appointment appointment = appointmentMapper.toEntity(appointmentDetailDTORequest);
        appointment.setClient(client);
        appointment.setFreelancerJob(freelancerJob.get());
        appointmentRepository.save(appointment);

        AppointmentDetailDTOResponse appointmentDetailDTOResponse = appointmentMapper.toResponseDto(appointment);
        appointmentDetailDTOResponse.setName(freelancer.getUser().getLastName() + " " + freelancer.getUser().getFirstName());
        appointmentDetailDTOResponse.setMail(user.getAccount().getEmail());
        appointmentDetailDTOResponse.setPhone(user.getPhoneNumber());

        return appointmentDetailDTOResponse;
//        return new AppointmentDetailDTOResponse();
    }

    @Override
    public Optional<AppointmentDetailDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<AppointmentDetailDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
