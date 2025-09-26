package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.repository.MatchRepository;
import com.wecp.progressive.service.MatchService;
import com.wecp.progressive.entity.*;
import java.sql.SQLException;

import java.util.*;

@Service
public class MatchServiceImplJpa implements MatchService
{   
    private MatchRepository matchRepository;

    @Autowired
    public MatchServiceImplJpa(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() throws SQLException
    {
        return matchRepository.findAll();
    }

    public Match getMatchById(int matchId) throws SQLException
    {
        return matchRepository.findByMatchId(matchId);
    }

    public Integer addMatch(Match match) throws SQLException
    {
       Match m = matchRepository.save(match);
       return m.getMatchId();
    }

    public void updateMatch(Match match) throws SQLException
    {
        Match m = matchRepository.findById(match.getMatchId()).get();
        m.setFirstTeamId(match.getFirstTeamId());
        m.setMatchId(match.getMatchId());
        m.setSecondTeamId(match.getSecondTeamId());
        m.setMatchDate(m.getMatchDate());
        m.setVenue(match.getVenue());
        m.setResult(match.getResult());
        m.setWinnerTeamId(match.getWinnerTeamId());
        m.setStatus(match.getStatus());
       m =  matchRepository.save(m);

       
    }

    public void deleteMatch(int matchId) throws SQLException
    {
        matchRepository.deleteById(matchId);
    }

    @Override
    public List<Match> getAllMatchesByStatus(String status) throws SQLException 
    {
       // return MatchService.super.getAllMatchesByStatus(status);
       return matchRepository.findAllByStatus(status);
    }  
}