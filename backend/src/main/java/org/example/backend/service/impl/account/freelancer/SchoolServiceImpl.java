package org.example.backend.service.impl.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.SchoolDTORequest;
import org.example.backend.dto.response.account.freelancer.SchoolDTOResponse;
import org.example.backend.entity.child.account.freelancer.School;
import org.example.backend.repository.SchoolRepository;
import org.example.backend.service.intf.account.freelancer.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
    public SchoolDTOResponse create(SchoolDTORequest schoolRequestDTO) {
        School school = new School();
        school.setSchoolName(schoolRequestDTO.getSchoolName());

        school = schoolRepository.save(school);

        return new SchoolDTOResponse(school.getId(), school.getSchoolName());
    }

    @Override
    public Optional<SchoolDTOResponse> getById(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        return school.map(s -> new SchoolDTOResponse(s.getId(), s.getSchoolName()));
    }

    @Override
    public List<SchoolDTOResponse> getAll() {
        List<School> schools = schoolRepository.findAll();
        return schools.stream()
                .map(s -> new SchoolDTOResponse(s.getId(), s.getSchoolName()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public SchoolDTOResponse update(Long id, SchoolDTORequest schoolDTORequest) {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if (!optionalSchool.isPresent()) {
            return null;
        }

        School school = optionalSchool.get();
        school.setSchoolName(schoolDTORequest.getSchoolName());

        school = schoolRepository.save(school);

        return new SchoolDTOResponse(school.getId(), school.getSchoolName());
    }

}
