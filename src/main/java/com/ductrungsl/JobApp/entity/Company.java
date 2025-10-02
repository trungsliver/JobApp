package com.ductrungsl.JobApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Job> jobs;;

//    private List<Review> reviews;

    public Company(String name, String description, List<Job> jobs) {
        this.name = name;
        this.description = description;
        this.jobs = jobs;
    }
}
