package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.CVDTORequest;
import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.service.intf.account.Freelancer.CVService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CVServiceImpl implements CVService {

    @Override
    public CVDTORequest create(CVDTORequest cvdtoRequest) {
        return null;
    }

    @Override
    public Optional<CVDTORequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<CVDTORequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
