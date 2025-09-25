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

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void addJob(Job job) {
        jobs.add(job);
    }
}
