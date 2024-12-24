package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.CategoryDTORequest;
import org.example.backend.dto.response.job.CategoryDTOResponse;
import org.example.backend.entity.child.job.Category;
import org.example.backend.service.intf.job.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Override
    public CategoryDTOResponse create(CategoryDTORequest categoryDTORequest) {
        return null;
    }

    @Override
    public Optional<CategoryDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<CategoryDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
