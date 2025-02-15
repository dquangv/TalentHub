package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.response.account.freelancer.FreelancerInfoResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.service.intf.account.freelancer.FreelancerInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreelancerInfoImpl implements FreelancerInfoService {
    private final FreelancerRepository freelancerRepository;

    @Override
    public List<FreelancerInfoResponse> getAllFreelancerInfo() {
        List<Freelancer> freelancers = freelancerRepository.findAll();

        return freelancers.stream().map(freelancer -> {
            FreelancerInfoResponse dto = new FreelancerInfoResponse();
            dto.setId(freelancer.getId());
            dto.setName(freelancer.getUser().getFirstName() + " " + freelancer.getUser().getLastName());
            dto.setTitle(freelancer.getUser().getTitle());
            dto.setAvatar(freelancer.getImage()); // Avatar là URL
            dto.setRating(4.9); // Giả định giá trị rating, bạn có thể lấy từ bảng đánh giá nếu có
            dto.setLocation(freelancer.getUser().getAddress());
            dto.setSkills(freelancer.getFreelancerSkills()
                    .stream()
                    .map(fs -> fs.getSkill().getSkillName())
                    .collect(Collectors.toList()));
            dto.setHourlyRate(freelancer.getHourlyRate() + "đ");

            return dto;
        }).collect(Collectors.toList());
    }
}
