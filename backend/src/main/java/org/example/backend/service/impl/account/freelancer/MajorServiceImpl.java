package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.MajorDTORequest;
import org.example.backend.dto.response.account.freelancer.MajorDTOResponse;
import org.example.backend.service.intf.account.freelancer.MajorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService {

    @Override
    public MajorDTOResponse create(MajorDTORequest majorDTORequst) {
        return null;
    }

    @Override
    public Optional<MajorDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<MajorDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
