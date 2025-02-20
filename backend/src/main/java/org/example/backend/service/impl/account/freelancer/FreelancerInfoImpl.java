package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.response.account.freelancer.FreelancerInfoDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.repository.ClientReviewRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.service.intf.account.freelancer.FreelancerInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreelancerInfoImpl implements FreelancerInfoService {
    private final FreelancerRepository freelancerRepository;
    private final ClientReviewRepository clientReviewRepository;

    @Override
    public List<FreelancerInfoDTOResponse> getAllFreelancerInfo() {
        List<Freelancer> freelancers = freelancerRepository.findAll();

        return freelancers.stream().map(freelancer -> {
            FreelancerInfoDTOResponse dto = new FreelancerInfoDTOResponse();
            dto.setId(freelancer.getId());
            dto.setName(freelancer.getUser().getFirstName() + " " + freelancer.getUser().getLastName());
            dto.setTitle(freelancer.getUser().getTitle());
//            dto.setAvatar(freelancer.getImage());
            dto.setLocation(freelancer.getUser().getAddress());

            Float rating = clientReviewRepository.findAverageRating(freelancer.getId());
            dto.setRating(rating != null ? rating : 0.0f);

            dto.setSkills(freelancer.getFreelancerSkills()
                    .stream()
                    .map(fs -> fs.getSkill().getSkillName())
                    .collect(Collectors.toList()));
            dto.setHourlyRate(freelancer.getHourlyRate() + "đ");

            return dto;
        }).collect(Collectors.toList());
    }
}
