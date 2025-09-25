package com.ductrungsl.JobApp.controller;

import com.ductrungsl.JobApp.entity.Job;
import com.ductrungsl.JobApp.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/add")
    public String addJob(@RequestBody  Job job){
        jobService.addJob(job);
        return "Job added successfully!";
    }
}
