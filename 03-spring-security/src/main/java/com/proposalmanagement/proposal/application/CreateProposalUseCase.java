package com.proposalmanagement.proposal.application;

import com.proposalmanagement.proposal.application.input.CreateProposalInput;
import com.proposalmanagement.proposal.application.output.ProposalOutput;
import com.proposalmanagement.proposal.domain.Owner;
import com.proposalmanagement.proposal.domain.ProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProposalUseCase {
    private final ProposalRepository proposalRepository;

    public CreateProposalUseCase(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public ProposalOutput execute(CreateProposalInput input, Owner owner) {
        var proposal = input.toDomain(owner);
        var saved = proposalRepository.save(proposal);

        return ProposalOutput.from(saved);
    }
}
