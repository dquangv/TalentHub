package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.MajorDTORequst;
import org.example.backend.entity.child.account.freelancer.Major;
import org.example.backend.service.intf.account.Freelancer.MajorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService {

    @Override
    public MajorDTORequst create(MajorDTORequst majorDTORequst) {
        return null;
    }

    @Override
    public Optional<MajorDTORequst> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<MajorDTORequst> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
