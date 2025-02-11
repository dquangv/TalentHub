package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.MajorDTORequest;
import org.example.backend.dto.response.account.freelancer.MajorDTOResponse;
import org.example.backend.entity.child.account.freelancer.Major;
import org.example.backend.repository.MajorRepository;
import org.example.backend.service.intf.account.freelancer.MajorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService {

    private final MajorRepository majorRepository;

    @Override
    public MajorDTOResponse create(MajorDTORequest majorDTORequest) {
        Major major = new Major();
        major.setMajorName(majorDTORequest.getMajorName());

        major = majorRepository.save(major);
        return new MajorDTOResponse(major.getId(), major.getMajorName());
    }

    @Override
    public Optional<MajorDTOResponse> getById(Long id) {
        Optional<Major> major = majorRepository.findById(id);
        return major.map(m -> new MajorDTOResponse(m.getId(), m.getMajorName()));
    }

    @Override
    public List<MajorDTOResponse> getAll() {
        List<Major> majors = majorRepository.findAll();
        return majors.stream()
                .map(m -> new MajorDTOResponse(m.getId(), m.getMajorName()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        if (majorRepository.existsById(id)) {
            majorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

