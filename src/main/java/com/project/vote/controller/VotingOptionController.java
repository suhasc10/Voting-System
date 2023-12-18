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

import com.project.vote.Entity.VotingOption;
import com.project.vote.service.VotingOptionService;

@RestController
@RequestMapping("/voting_option")
public class VotingOptionController 
{

    private final VotingOptionService votingOptionService;

    @Autowired
    public VotingOptionController(VotingOptionService votingOptionService) 
    {
        this.votingOptionService = votingOptionService;
    }

    // Create VotingOption
    @PostMapping("/create")
    public ResponseEntity<String> createVotingOption(@RequestBody VotingOption votingOption) 
    {
        votingOptionService.saveVotingOption(votingOption);
        return new ResponseEntity<>("Voting option created successfully", HttpStatus.CREATED);
    }

    // Read All VotingOptions
    @GetMapping("/all")
    public ResponseEntity<List<VotingOption>> getAllVotingOptions() 
    {
        List<VotingOption> votingOptions = votingOptionService.getAllVotingOptions();
        return new ResponseEntity<>(votingOptions, HttpStatus.OK);
    }

    // Read VotingOption by ID
    @GetMapping("/id")
    public ResponseEntity<VotingOption> getVotingOptionById(@PathVariable Long id) 
    {
        VotingOption votingOption = votingOptionService.getVotingOptionById(id);
        if (votingOption != null) {
            return new ResponseEntity<>(votingOption, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update VotingOption
    @PutMapping("/update")
    public ResponseEntity<String> updateVotingOption(@RequestBody VotingOption votingOption) 
    {
        votingOptionService.updateVotingOption(votingOption);
        return new ResponseEntity<>("Voting option updated successfully", HttpStatus.OK);
    }

    // Delete VotingOption
    @DeleteMapping("/delete/id")
    public ResponseEntity<String> deleteVotingOption(@PathVariable Long id) 
    {
        votingOptionService.deleteVotingOptionById(id);
        return new ResponseEntity<>("Voting option deleted successfully", HttpStatus.OK);
    }
}
