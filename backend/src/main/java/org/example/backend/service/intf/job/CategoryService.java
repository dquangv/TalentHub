package org.example.backend.service.intf.job;

import org.example.backend.dto.request.job.CategoryDTORequest;
import org.example.backend.dto.response.job.CategoryDTOResponse;
import org.example.backend.entity.child.job.Category;
import org.example.backend.service.BaseService;

public interface CategoryService extends BaseService<CategoryDTORequest, CategoryDTOResponse, Long> {
    CategoryDTOResponse update(Long id, CategoryDTORequest categoryDTORequest);
}
