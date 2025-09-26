package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.service.TeamService;

@Service
public class TeamServiceImplArraylist implements TeamService
{
    List<Team> teams = new ArrayList<Team>();
    
    public TeamServiceImplArraylist()
    {
        teams.add(new Team(1, "RCB", "Bangolre", "Kingfisher", 2007));
        teams.add(new Team(2, "SRH", "Hyderabad", "Sunnetwork", 1999));
    }

    @Override
    public int addTeam(Team team) 
    {
        this.teams.add(team);
        return (this.teams.size());
    }

    @Override
    public void emptyArrayList()
    {
        //TeamService.super.emptyArrayList();
        teams = new ArrayList<Team>();
    }

    @Override
    public List<Team> getAllTeams() 
    {
        return (teams);
    }

    @Override
    public List<Team> getAllTeamsSortedByName() 
    {

        if(this.teams == null || this.teams.isEmpty())
        {
            return (new ArrayList<Team>());
        }
        // List<Team> sortedTeams = new ArrayList<>(this.teams);
        // sortedTeams.sort(Comparator.comparing(Team::getTeamName));
        // return (sortedTeams);
        Collections.sort(this.teams);
        return (this.teams);
    }
    
}