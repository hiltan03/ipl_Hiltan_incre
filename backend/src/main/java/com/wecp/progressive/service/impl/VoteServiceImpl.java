package com.wecp.progressive.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Vote;
import com.wecp.progressive.repository.VoteRepository;
import com.wecp.progressive.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService  {
    
    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> getAllVotes(){
        return voteRepository.findAll();
    }
    public int createVote(Vote vote){
        voteRepository.save(vote);
        return vote.getVoteId();
    }
    public Map<String,Long> getVotesCountOfAllCategories(){
        Map<String,Long> map = new HashMap<>();

        map.put("Team", voteRepository.countByCategory("Team"));
        map.put("Batsman",voteRepository.countByCategory("Batsman"));
        map.put("Bowler",voteRepository.countByCategory("Bowler"));
        map.put("All-rounder",voteRepository.countByCategory("All-rounder"));
        map.put("Wicketkeeper",voteRepository.countByCategory("Wicketkeeper"));

        return map;
        
        
    }
}