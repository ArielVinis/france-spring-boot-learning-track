package com.proposalmanagement.proposal.application.list;

import com.proposalmanagement.proposal.domain.OwnerId;
import com.proposalmanagement.proposal.domain.Proposal;

import java.util.List;

public interface Strategy {
    List<Proposal> getProposals(OwnerId ownerId);

    AccessScope getScope();
}
