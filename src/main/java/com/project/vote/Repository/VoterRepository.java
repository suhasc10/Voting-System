package com.project.vote.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vote.Entity.Voter;

public interface VoterRepository extends JpaRepository<Voter, Long> 
{
	Voter findByUsername(String username);
}

