package com.project.vote.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vote.Entity.VotingOption;

public interface VotingOptionRepository extends JpaRepository<VotingOption, Long> 
{
}
