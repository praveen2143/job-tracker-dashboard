package com.jobtracker.demo.jobtracker.repository;

import com.jobtracker.demo.jobtracker.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyContainingIgnoreCase(String company);
    List<Job> findByStatus(String status);
}
