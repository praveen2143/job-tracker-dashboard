package com.jobtracker.demo.jobtracker.service;

import com.jobtracker.demo.jobtracker.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> getAllJobs();
    JobDTO getJobById(Long id);
    JobDTO createJob(JobDTO jobDTO);
    JobDTO updateJob(Long id, JobDTO jobDTO);
    void deleteJob(Long id);
    List<JobDTO> searchByCompany(String company);
    List<JobDTO> filterByStatus(String status);
}

