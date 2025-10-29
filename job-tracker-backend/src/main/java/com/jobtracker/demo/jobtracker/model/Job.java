package com.jobtracker.demo.jobtracker.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String position;

    private String title;

    private String status; // e.g., Applied, Interview, Offer, Rejected

    private String location;

    @Column(name = "applied_date")
    private LocalDate appliedDate;

    @PrePersist
    public void prePersist() {
        if (appliedDate == null) {
            appliedDate = LocalDate.now();
        }
    }
}

