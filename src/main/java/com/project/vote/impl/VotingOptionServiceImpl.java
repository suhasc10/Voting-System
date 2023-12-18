package com.project.vote.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vote.Entity.VotingOption;
import com.project.vote.Repository.VotingOptionRepository;
import com.project.vote.service.VotingOptionService;


@Service
public class VotingOptionServiceImpl implements VotingOptionService 
{

 private final VotingOptionRepository votingOptionRepository;

 @Autowired
 public VotingOptionServiceImpl(VotingOptionRepository votingOptionRepository) 
 {
     this.votingOptionRepository = votingOptionRepository;
 }

 @Override
 public void saveVotingOption(VotingOption votingOption) 
 {
     votingOptionRepository.save(votingOption);
 }

 @Override
 public List<VotingOption> getAllVotingOptions() 
 {
     return votingOptionRepository.findAll();
 }

 @Override
 public VotingOption getVotingOptionById(Long id) 
 {
     return votingOptionRepository.findById(id).orElse(null);
 }

 @Override
 public void updateVotingOption(VotingOption votingOption) 
 {
     votingOptionRepository.save(votingOption);
 }

 @Override
 public void deleteVotingOptionById(Long id) 
 {
     votingOptionRepository.deleteById(id);
 }
}

