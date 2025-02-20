package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.FreelancerDTORequest;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerDTOResponse;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.Category;
import org.example.backend.entity.child.account.User;
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
        // Retrieve entities using provided IDs
        Category category = categoryRepository.findById(freelancerDTORequest.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Category ID"));
        User user = userRepository.findById(freelancerDTORequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));

        // Map from DTO to entity
        Freelancer freelancer = new Freelancer();
//        freelancer.setImage(freelancerDTORequest.getImage());
        freelancer.setHourlyRate(freelancerDTORequest.getHourlyRate());
        freelancer.setDescription(freelancerDTORequest.getDescription());
        freelancer.setCategory(category);
        freelancer.setUser(user);

        // Save the Freelancer entity
        freelancer = freelancerRepository.save(freelancer);

        // Return the response DTO
        return new FreelancerDTOResponse(
                freelancer.getId(),
//                freelancer.getImage(),
                freelancer.getHourlyRate(),
                freelancer.getDescription(),
                freelancer.getCategory().getCategoryTitle(),
                freelancer.getUser().getId()
        );
    }


    @Override
    public Optional<FreelancerDTOResponse> getById(Long id) {
        Optional<Freelancer> freelancer = freelancerRepository.findById(id);
        return freelancer.map(f -> new FreelancerDTOResponse(
                f.getId(),
//                f.getImage(),
                f.getHourlyRate(),
                f.getDescription(),
                f.getCategory().getCategoryTitle(),
                f.getUser().getId()
        ));
    }

    @Override
    public List<FreelancerDTOResponse> getAll() {
        List<Freelancer> freelancers = freelancerRepository.findAll();
        return freelancers.stream()
                .map(f -> new FreelancerDTOResponse(
                        f.getId(),
//                        f.getImage(),
                        f.getHourlyRate(),
                        f.getDescription(),
                        f.getCategory().getCategoryTitle(),
                        f.getUser().getId()
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
