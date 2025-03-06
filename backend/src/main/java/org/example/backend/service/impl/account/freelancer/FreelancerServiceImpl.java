package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.FreelancerDTORequest;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerDTOResponse;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.Category;
import org.example.backend.entity.child.account.User;
import org.example.backend.repository.ClientReviewRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.CategoryRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.intf.account.freelancer.FreelancerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

    private final FreelancerRepository freelancerRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public FreelancerDTOResponse create(FreelancerDTORequest freelancerDTORequest) {
        Category category = categoryRepository.findById(freelancerDTORequest.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Category ID"));
        User user = userRepository.findById(freelancerDTORequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));

        Freelancer f = new Freelancer();
//        freelancer.setImage(freelancerDTORequest.getImage());
        f.setHourlyRate(freelancerDTORequest.getHourlyRate());
        f.setDescription(freelancerDTORequest.getDescription());
        f.setCategory(category);
        f.setUser(user);

        f = freelancerRepository.save(f);

        return new FreelancerDTOResponse(
                f.getId(),
                f.getUser().getFirstName() + f.getUser().getLastName(),
                f.getHourlyRate(),
                f.getDescription(),
                f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                        ? f.getCategory().getCategoryTitle()
                        : "No category",
                f.getUser().getId(),
                f.getUser().getImage(),
                clientReviewRepository.findAverageRating(f.getId()),
                f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                        .stream()
                        .map(fs -> fs.getSkill().getSkillName())
                        .collect(Collectors.toList()) : List.of()
        );
    }

    private final ClientReviewRepository clientReviewRepository;

    @Override
    public Optional<FreelancerDTOResponse> getById(Long id) {
        Optional<Freelancer> freelancer = freelancerRepository.findById(id);
        return freelancer.map(f -> new FreelancerDTOResponse(
                f.getId(),
                f.getUser().getFirstName() + f.getUser().getLastName(),
                f.getHourlyRate(),
                f.getDescription(),
                f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                        ? f.getCategory().getCategoryTitle()
                        : "No category",
                f.getUser().getId(),
                f.getUser().getImage(),
                clientReviewRepository.findAverageRating(f.getId()),
                f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                        .stream()
                        .map(fs -> fs.getSkill().getSkillName())
                        .collect(Collectors.toList()) : List.of()
        ));
    }
    @Override
    public List<FreelancerDTOResponse> getAll() {
        List<Freelancer> freelancers = freelancerRepository.findAll();
        return freelancers.stream()
                .map(f -> new FreelancerDTOResponse(
                        f.getId(),
                        f.getUser().getFirstName() + f.getUser().getLastName(),
                        f.getHourlyRate(),
                        f.getDescription(),
                        f.getCategory() != null && f.getCategory().getCategoryTitle() != null
                                ? f.getCategory().getCategoryTitle()
                                : "No category",
                        f.getUser().getId(),
                        f.getUser().getImage(),
                       clientReviewRepository.findAverageRating(f.getId()),
                        f.getFreelancerSkills() != null ? f.getFreelancerSkills()
                                .stream()
                                .map(fs -> fs.getSkill().getSkillName())
                                .collect(Collectors.toList()) : List.of()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public Boolean deleteById(Long id) {

        if (freelancerRepository.existsById(id)) {
            freelancerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
