package org.example.backend.dto.response.job;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryDTOResponse {
    private Long id;
    private String categoryTitle;
}