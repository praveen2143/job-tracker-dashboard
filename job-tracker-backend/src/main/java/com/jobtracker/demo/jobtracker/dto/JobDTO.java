package com.jobtracker.demo.jobtracker.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobDTO {
    private Long id;
    private String company;
    private String position;
    private String status;
    private String location;
    private LocalDate appliedDate;
}
