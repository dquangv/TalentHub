package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.SchoolDTORequst;
import org.example.backend.entity.child.account.freelancer.School;
import org.example.backend.service.intf.account.Freelancer.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    @Override
    public SchoolDTORequst create(SchoolDTORequst schoolDTORequst) {
        return null;
    }

    @Override
    public Optional<SchoolDTORequst> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<SchoolDTORequst> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
