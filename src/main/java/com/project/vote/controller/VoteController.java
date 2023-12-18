package com.project.vote.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.vote.Entity.Vote;
import com.project.vote.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController 
{
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) 
    {
        this.voteService = voteService;
    }

    // Create Vote
    @PostMapping("/create")
    public ResponseEntity<String> createVote(@RequestBody Vote vote) 
    {
        voteService.saveVote(vote);
        return new ResponseEntity<>("Vote created successfully", HttpStatus.CREATED);
    }

    // Read All Votes
    @GetMapping("/all")
    public ResponseEntity<List<Vote>> getAllVotes() 
    {
        List<Vote> votes = voteService.getAllVotes();
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    // Read Votes by Customer ID
    @GetMapping("/by-customer/customerId")
    public ResponseEntity<List<Vote>> getVotesByCustomer(@PathVariable Long customerId) 
    {
        List<Vote> votes = voteService.getVotesByCustomer(customerId);
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    // Update Vote
    @PutMapping("/update")
    public ResponseEntity<String> updateVote(@RequestBody Vote vote) 
    {
        voteService.updateVote(vote);
        return new ResponseEntity<>("Vote updated successfully", HttpStatus.OK);
    }

    // Delete Vote
    @DeleteMapping("/delete/id")
    public ResponseEntity<String> deleteVote(@PathVariable Long id) 
    {
        voteService.deleteVoteById(id);
        return new ResponseEntity<>("Vote deleted successfully", HttpStatus.OK);
    }
}
