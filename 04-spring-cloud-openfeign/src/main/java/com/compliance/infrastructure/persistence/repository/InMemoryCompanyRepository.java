package com.compliance.infrastructure.persistence.repository;

import com.compliance.domain.Company;
import com.compliance.domain.CompanyRepository;
import com.compliance.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCompanyRepository implements CompanyRepository {
    private final CompanyEntityRepository repository;

    public InMemoryCompanyRepository(CompanyEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Company company) {
        var entity = CompanyEntity.from(company);
        repository.save(entity);
    }
}
