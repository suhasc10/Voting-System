package com.project.vote.service;

import java.util.List;

import com.project.vote.Entity.Voter;

public interface VoterService 
{
	void saveVoter(Voter voter);
	List<Voter> getAllVoters();
	Voter getVoterById(Long id);
	void updateVoter(Voter voter);
	void deleteVoterById(Long id);
}
