package com.ductrungsl.JobApp.service;

import com.ductrungsl.JobApp.entity.Job;
import com.ductrungsl.JobApp.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements JobRepository {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void addJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        return jobs.stream().filter(
                job -> job.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public void deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                break;
            }
        }
    }
}
