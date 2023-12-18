package com.project.vote.service;

import java.util.List;

import com.project.vote.Entity.Vote;


public interface VoteService 
{
	void saveVote(Vote vote);
	List<Vote> getAllVotes();
	List<Vote> getVotesByCustomer(Long customerId);
	void updateVote(Vote vote);
	void deleteVoteById(Long id);
}

