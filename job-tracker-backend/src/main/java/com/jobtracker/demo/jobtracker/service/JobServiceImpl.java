package com.jobtracker.demo.jobtracker.service;

import com.jobtracker.demo.jobtracker.dto.JobDTO;
import com.jobtracker.demo.jobtracker.exception.ResourceNotFoundException;
import com.jobtracker.demo.jobtracker.model.Job;
import com.jobtracker.demo.jobtracker.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository repo;

    public JobServiceImpl(JobRepository repo) {
        this.repo = repo;
    }

    private JobDTO toDto(Job job) {
        return JobDTO.builder()
                .id(job.getId())
                .company(job.getCompany())
                .position(job.getPosition())
                .status(job.getStatus())
                .location(job.getLocation())
                .appliedDate(job.getAppliedDate())
                .build();
    }

    private Job toEntity(JobDTO dto) {
        return Job.builder()
                .id(dto.getId())
                .company(dto.getCompany())
                .position(dto.getPosition())
                .status(dto.getStatus())
                .location(dto.getLocation())
                .appliedDate(dto.getAppliedDate())
                .build();
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found with id " + id));
        return toDto(job);
    }

    @Override
    public JobDTO createJob(JobDTO jobDTO) {
        Job saved = repo.save(toEntity(jobDTO));
        return toDto(saved);
    }

    @Override
    public JobDTO updateJob(Long id, JobDTO jobDTO) {
        Job existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found with id " + id));
        existing.setCompany(jobDTO.getCompany());
        existing.setPosition(jobDTO.getPosition());
        existing.setStatus(jobDTO.getStatus());
        existing.setLocation(jobDTO.getLocation());
        existing.setAppliedDate(jobDTO.getAppliedDate());
        Job updated = repo.save(existing);
        return toDto(updated);
    }

    @Override
    public void deleteJob(Long id) {
        Job existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found with id " + id));
        repo.delete(existing);
    }

    @Override
    public List<JobDTO> searchByCompany(String company) {
        return repo.findByCompanyContainingIgnoreCase(company).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<JobDTO> filterByStatus(String status) {
        return repo.findByStatus(status).stream().map(this::toDto).collect(Collectors.toList());
    }
}

