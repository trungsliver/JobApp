package com.ductrungsl.JobApp.service;

import com.ductrungsl.JobApp.entity.Company;
import com.ductrungsl.JobApp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public boolean deleteCompanyById(long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateCompanyById(long id, Company updatedCompany) {
        if (companyRepository.existsById(id)) {
            updatedCompany.setId(id);
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }
}
