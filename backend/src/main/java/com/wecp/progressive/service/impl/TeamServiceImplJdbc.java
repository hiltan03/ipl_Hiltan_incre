package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import com.wecp.progressive.dao.TeamDAO;
import com.wecp.progressive.entity.Team;
import com.wecp.progressive.service.TeamService;

public class TeamServiceImplJdbc implements TeamService
{
    private TeamDAO teamDAO;

    public TeamServiceImplJdbc(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    public int addTeam(Team team) throws SQLException
    {
        return teamDAO.addTeam(team);
    }

    @Override
    public void deleteTeam(int teamId) throws SQLException
    {
        //TeamService.super.deleteTeam(teamId);
        teamDAO.deleteTeam(teamId);
    }

    @Override
    public List<Team> getAllTeams() throws SQLException
    {
        return (teamDAO.getAllTeams());
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException
    {
        List<Team> teamsSoretdByName = teamDAO.getAllTeams();
        teamsSoretdByName.sort(Comparator.comparing(Team::getTeamName));
        return (teamsSoretdByName);
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException
    {
        //return TeamService.super.getTeamById(teamId);
        return teamDAO.getTeamById(teamId);
    }

    @Override
    public void updateTeam(Team team) throws SQLException
    {
        //TeamService.super.updateTeam(team);
        teamDAO.updateTeam(team);
    }

}