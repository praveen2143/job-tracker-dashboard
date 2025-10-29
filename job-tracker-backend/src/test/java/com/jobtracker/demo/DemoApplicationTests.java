package com.jobtracker.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = com.jobtracker.demo.jobtracker.JobTrackerApplication.class)

@ActiveProfiles("test")
class JobTrackerApplicationTests {

    @Test
    void contextLoads() {
    }
}
