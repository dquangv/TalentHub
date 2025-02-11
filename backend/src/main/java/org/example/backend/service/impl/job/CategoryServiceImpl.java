package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.CategoryDTORequest;
import org.example.backend.dto.response.job.CategoryDTOResponse;
import org.example.backend.entity.child.job.Category;
import org.example.backend.repository.CategoryRepository;
import org.example.backend.service.intf.job.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTOResponse create(CategoryDTORequest categoryDTORequest) {
        Category category = new Category();
        category.setCategoryTitle(categoryDTORequest.getCategoryTitle());

        category = categoryRepository.save(category);

        return new CategoryDTOResponse(category.getId(), category.getCategoryTitle());
    }

    @Override
    public Optional<CategoryDTOResponse> getById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        return category.map(c -> new CategoryDTOResponse(c.getId(), c.getCategoryTitle()));
    }

    @Override
    public List<CategoryDTOResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(c -> new CategoryDTOResponse(c.getId(), c.getCategoryTitle()))
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
