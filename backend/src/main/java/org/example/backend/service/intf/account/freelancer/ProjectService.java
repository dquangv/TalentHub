package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.request.account.freelancer.ProjectDTORequest;
import org.example.backend.dto.response.account.freelancer.ProjectDTOResponse;
import org.example.backend.entity.child.account.freelancer.Project;
import org.example.backend.service.BaseService;

import java.util.List;

public interface ProjectService extends BaseService<Project, ProjectDTOResponse, Long> {
    List<ProjectDTOResponse> getByFreelancerId(Long freelancerId);

    ProjectDTOResponse update(Long id, ProjectDTORequest projectDTORequest);
}