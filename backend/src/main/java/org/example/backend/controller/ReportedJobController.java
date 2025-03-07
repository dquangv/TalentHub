package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.ReportedJobDTORequest;
import org.example.backend.dto.response.ReportedJobDTOResponse;
import org.example.backend.service.intf.ReportedJobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reported-jobs")
@RequiredArgsConstructor
public class ReportedJobController {

    private final ReportedJobService reportedJobService;

    @PostMapping
    public ResponseEntity<ReportedJobDTOResponse> create(@RequestBody ReportedJobDTORequest request) {
        ReportedJobDTOResponse response = reportedJobService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportedJobDTOResponse> update(@PathVariable Long id, @RequestBody ReportedJobDTORequest request) {
        ReportedJobDTOResponse response = reportedJobService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportedJobDTOResponse> getById(@PathVariable Long id) {
        return reportedJobService.getById(id)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ReportedJobDTOResponse>> getAll() {
        List<ReportedJobDTOResponse> response = reportedJobService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return reportedJobService.deleteById(id) ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
