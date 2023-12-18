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

import com.project.vote.Entity.Voter;
import com.project.vote.service.VoterService;

@RestController
@RequestMapping("/voter")
public class VoterController 
{
    private final VoterService voterService;

    @Autowired
    public VoterController(VoterService voterService) 
    {
        this.voterService = voterService;
    }

    // Create Voter
    @PostMapping("/create")
    public ResponseEntity<String> createVoter(@RequestBody Voter voter) 
    {
    	voterService.saveVoter(voter);
        return new ResponseEntity<>("Voter created successfully", HttpStatus.CREATED);
    }

    // Read All Voters
    @GetMapping("/all")
    public ResponseEntity<List<Voter>> getAllVoters() 
    {
        List<Voter> voters = voterService.getAllVoters();
        return new ResponseEntity<>(voters, HttpStatus.OK);
    }

    // Read Voter by ID
    @GetMapping("/id")
    public ResponseEntity<Voter> getVoterById(@PathVariable Long id) 
    {
    	Voter voter = voterService.getVoterById(id);
        if (voter != null) {
            return new ResponseEntity<>(voter, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update Voter
    @PutMapping("/update")
    public ResponseEntity<String> updateVoter(@RequestBody Voter voter) 
    {
    	voterService.updateVoter(voter);
        return new ResponseEntity<>("Voter updated successfully", HttpStatus.OK);
    }

    // Delete Voter
    @DeleteMapping("/delete/id")
    public ResponseEntity<String> deleteVoter(@PathVariable Long id) 
    {
    	voterService.deleteVoterById(id);
        return new ResponseEntity<>("Voter deleted successfully", HttpStatus.OK);
    }
}

