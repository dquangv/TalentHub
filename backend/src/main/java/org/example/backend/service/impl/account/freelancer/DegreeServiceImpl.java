package org.example.backend.service.impl.account.freelancer;


import java.util.List;
import java.util.Optional;


import lombok.RequiredArgsConstructor;

import org.example.backend.dto.request.account.freelancer.DegreeDTORequest;
import org.example.backend.dto.response.account.freelancer.DegreeDTOResponse;
import org.example.backend.dto.response.account.freelancer.SchoolDTOResponse;
import org.example.backend.entity.child.account.freelancer.Degree;
import org.example.backend.entity.child.account.freelancer.School;
import org.example.backend.repository.DegreeRepository;
import org.example.backend.service.intf.account.freelancer.DegreeService;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DegreeServiceImpl implements DegreeService {
    @Override
    public DegreeDTOResponse update(Long id, DegreeDTORequest degreeDTORequest) {
        Optional<Degree> optionalDegree = degreeRepository.findById(id);
        if (!optionalDegree.isPresent()) {
            return null;
        }

        Degree degree = optionalDegree.get();
        degree.setDegreeTitle(degreeDTORequest.getDegreeTitle());

        degree = degreeRepository.save(degree);

        return new DegreeDTOResponse(degree.getId(), degree.getDegreeTitle());
    }

    private final DegreeRepository degreeRepository;

    @Override
    public DegreeDTOResponse create(DegreeDTORequest degreeDTORequest) {
        Degree degree = new Degree();
        degree.setDegreeTitle(degreeDTORequest.getDegreeTitle());
        degree = degreeRepository.save(degree);

        return new DegreeDTOResponse(degree.getId(), degree.getDegreeTitle());
    }

    @Override
    public Optional<DegreeDTOResponse> getById(Long id) {
        Optional<Degree> degree = degreeRepository.findById(id);
        return degree.map(d -> new DegreeDTOResponse(d.getId(), d.getDegreeTitle()));
    }

    @Override
    public List<DegreeDTOResponse> getAll() {
        List<Degree> degrees = degreeRepository.findAll();
        return degrees.stream()
                .map(d -> new DegreeDTOResponse(d.getId(), d.getDegreeTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        if (degreeRepository.existsById(id)) {
            degreeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

