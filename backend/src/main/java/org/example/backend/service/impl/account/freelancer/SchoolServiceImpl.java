package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.SchoolDTORequest;
import org.example.backend.dto.response.account.freelancer.SchoolDTOResponse;
import org.example.backend.service.intf.account.freelancer.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    @Override
    public SchoolDTOResponse create(SchoolDTORequest schoolDTORequst) {
        return null;
    }

    @Override
    public Optional<SchoolDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<SchoolDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
