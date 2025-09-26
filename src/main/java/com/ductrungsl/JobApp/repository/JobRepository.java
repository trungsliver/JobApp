package com.ductrungsl.JobApp.repository;

import com.ductrungsl.JobApp.entity.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository {
    List<Job> findAll();
    void addJob(Job job);
    Job findById(Long id);
    void deleteJobById(Long id);
}
