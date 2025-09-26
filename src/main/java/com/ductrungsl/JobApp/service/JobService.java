package com.ductrungsl.JobApp.service;

import com.ductrungsl.JobApp.entity.Job;
import com.ductrungsl.JobApp.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService  {
    private final JobRepository jobRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public void addJob(Job job) {
        jobRepository.save(job);
    }

    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public boolean deleteJobById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateJobById(Long id, Job updatedJob) {
        if (jobRepository.existsById(id)) {
            updatedJob.setId(id);
            jobRepository.save(updatedJob);
            return true;
        }
        return false;
    }
}
