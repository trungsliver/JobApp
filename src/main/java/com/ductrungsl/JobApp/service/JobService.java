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
//    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void addJob(Job job) {
//        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        return jobs.stream().filter(
                job -> job.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}
