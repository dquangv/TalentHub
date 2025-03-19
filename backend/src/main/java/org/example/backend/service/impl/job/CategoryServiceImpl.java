package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.CategoryDTORequest;
import org.example.backend.dto.response.job.CategoryDTOResponse;
import org.example.backend.entity.child.job.Category;
import org.example.backend.repository.CategoryRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.JobRepository;
import org.example.backend.service.intf.job.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FreelancerRepository freelancerRepository;
    private final JobRepository jobRepository;

    @Override
    public CategoryDTOResponse create(CategoryDTORequest categoryDTORequest) {
        Category category = new Category();
        category.setCategoryTitle(categoryDTORequest.getCategoryTitle());

        category = categoryRepository.save(category);

        Long quantityFreelancer = freelancerRepository.countByCategoryId(category.getId());
        Long quantityJob = jobRepository.countByCategoryId(category.getId());

        return CategoryDTOResponse.builder()
                .id(category.getId())
                .categoryTitle(category.getCategoryTitle())
                .quantityFreelancer(quantityFreelancer)
                .quantityJob(quantityJob)
                .build();
    }

    @Override
    public Optional<CategoryDTOResponse> getById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            Long quantityFreelancer = freelancerRepository.countByCategoryId(id);
            Long quantityJob = jobRepository.countByCategoryId(id);

            return Optional.of(CategoryDTOResponse.builder()
                    .id(category.get().getId())
                    .categoryTitle(category.get().getCategoryTitle())
                    .quantityFreelancer(quantityFreelancer)
                    .quantityJob(quantityJob)
                    .build());
        }

        return Optional.empty();
    }

    @Override
    public List<CategoryDTOResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(c -> {
                    Long quantityFreelancer = freelancerRepository.countByCategoryId(c.getId());
                    Long quantityJob = jobRepository.countByCategoryId(c.getId());

                    return CategoryDTOResponse.builder()
                            .id(c.getId())
                            .categoryTitle(c.getCategoryTitle())
                            .quantityFreelancer(quantityFreelancer)
                            .quantityJob(quantityJob)
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
