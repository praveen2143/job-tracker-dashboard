package com.jobtracker.demo.jobtracker.controller;

import com.jobtracker.demo.jobtracker.dto.JobDTO;
import com.jobtracker.demo.jobtracker.exception.ResourceNotFoundException;
import com.jobtracker.demo.jobtracker.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*") // adjust origin for production
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs(@RequestParam(value = "company", required = false) String company,
                                                   @RequestParam(value = "status", required = false) String status) {
        if (company != null && !company.isEmpty()) {
            return ResponseEntity.ok(jobService.searchByCompany(company));
        }
        if (status != null && !status.isEmpty()) {
            return ResponseEntity.ok(jobService.filterByStatus(status));
        }
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @PostMapping
    public ResponseEntity<JobDTO> createJob(@Validated @RequestBody JobDTO jobDTO) {
        JobDTO created = jobService.createJob(jobDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @Validated @RequestBody JobDTO jobDTO) {
        JobDTO updated = jobService.updateJob(id, jobDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    // Simple exception handler (could be global)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
