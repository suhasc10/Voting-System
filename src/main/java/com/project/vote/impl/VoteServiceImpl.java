package com.project.vote.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vote.Entity.Voter;
import com.project.vote.Entity.Vote;
import com.project.vote.Repository.VoteRepository;
import com.project.vote.service.VoteService;


@Service
public abstract class VoteServiceImpl implements VoteService 
{

 private final VoteRepository voteRepository;

 @Autowired
 public VoteServiceImpl(VoteRepository voteRepository) 
 {
     this.voteRepository = voteRepository;
 }

 @Override
 public void saveVote(Vote vote) 
 {
     voteRepository.save(vote);
 }

 @Override
 public List<Vote> getAllVotes() 
 {
     return voteRepository.findAll();
 }

 public List<Vote> getVotesByVoter(Long voterId) 
 {
	 	Voter voter = new Voter();
	 	voter.setId(voterId);
	    return voteRepository.findByVoter(voter);
	}

 @Override
 public void updateVote(Vote vote) 
 {
     voteRepository.save(vote);
 }

 @Override
 public void deleteVoteById(Long id) 
 {
     voteRepository.deleteById(id);
 }

}

