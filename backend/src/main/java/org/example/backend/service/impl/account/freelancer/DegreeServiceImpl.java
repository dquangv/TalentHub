package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.DegreeDTORequest;
import org.example.backend.dto.response.account.freelancer.DegreeDTOResponse;
import org.example.backend.service.intf.account.freelancer.DegreeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DegreeServiceImpl implements DegreeService {

    @Override
    public DegreeDTOResponse create(DegreeDTORequest degreeDTORequest) {
        return null;
    }

    @Override
    public Optional<DegreeDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<DegreeDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
