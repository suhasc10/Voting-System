package com.project.vote.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vote.Entity.Voter;
import com.project.vote.Repository.VoterRepository;
import com.project.vote.service.VoterService;

@Service
public class VoterServiceImpl implements VoterService 
{

 private final VoterRepository voterRepository;

 @Autowired
 public VoterServiceImpl(VoterRepository voterRepository) 
 {
     this.voterRepository = voterRepository;
 }

 @Override
 public void saveVoter(Voter voter) 
 {
	 voterRepository.save(voter);
 }

 @Override
 public List<Voter> getAllVoters() 
 {
     return voterRepository.findAll();
 }

 @Override
 public Voter getVoterById(Long id) 
 {
     return voterRepository.findById(id).orElse(null);
 }

 @Override
 public void updateVoter(Voter voter) 
 {
	 voterRepository.save(voter);
 }

 @Override
 public void deleteVoterById(Long id) 
 {
	 voterRepository.deleteById(id);
 }
}

