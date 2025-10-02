package com.ductrungsl.JobApp.repository;

import com.ductrungsl.JobApp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>
{
}
