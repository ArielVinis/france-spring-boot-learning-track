package com.compliance.application;

import com.compliance.domain.Company;
import com.compliance.domain.CompanyRepository;
import com.compliance.domain.CompliancePolicy;
import com.compliance.domain.ComplianceScreening;
import com.compliance.infrastructure.rest.client.AntiMoneyLaunderingClient;
import com.compliance.infrastructure.rest.client.SanctionClient;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeCompanyRiskUseCase {
    private final SanctionClient sanctionClient;
    private final AntiMoneyLaunderingClient antiMoneyLaunderingClient;
    private final CompanyRepository companyRepository;

    public AnalyzeCompanyRiskUseCase(SanctionClient sanctionClient,
                                     AntiMoneyLaunderingClient antiMoneyLaunderingClient,
                                     CompanyRepository companyRepository) {
        this.sanctionClient = sanctionClient;
        this.antiMoneyLaunderingClient = antiMoneyLaunderingClient;
        this.companyRepository = companyRepository;
    }

    public void execute(Company company) {
        var sanctions = sanctionClient.getCompanyRisk(company.getRegistrationNumber()).toDomain();
        var amlProfile = antiMoneyLaunderingClient.screening(company.getRegistrationNumber()).toDomain();

        var screening = new ComplianceScreening(sanctions, amlProfile);
        var riskAssessment = CompliancePolicy.evaluate(screening);

        company.applyRiskAssessment(riskAssessment);
        companyRepository.save(company);
    }
}
