package com.project.vote.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vote.Entity.Voter;
import com.project.vote.Entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> 
{
	List<Vote> findByVoter(Voter voter);
}

