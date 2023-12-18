package com.project.vote.service;

import java.util.List;

import com.project.vote.Entity.VotingOption;


public interface VotingOptionService 
{
	void saveVotingOption(VotingOption votingOption);
	List<VotingOption> getAllVotingOptions();
	VotingOption getVotingOptionById(Long id);
	void updateVotingOption(VotingOption votingOption);
	void deleteVotingOptionById(Long id);
}
