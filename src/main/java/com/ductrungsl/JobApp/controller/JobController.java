package com.ductrungsl.JobApp.controller;

import com.ductrungsl.JobApp.entity.Company;
import com.ductrungsl.JobApp.entity.Job;
import com.ductrungsl.JobApp.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        if (jobService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id){
        Job job = jobService.findById(id);
        if(job == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.addJob(job);
//        Company company = job.getCompany();
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (!deleted) {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) {
        boolean updated = jobService.updateJobById(id, job);
        if (!updated) {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
    }
}
