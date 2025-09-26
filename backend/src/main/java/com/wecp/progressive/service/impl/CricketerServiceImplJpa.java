package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.repository.CricketerRepository;
import com.wecp.progressive.service.CricketerService;
import com.wecp.progressive.entity.*;
import java.util.List;
import java.util.Comparator;
import java.sql.SQLException;

@Service
public class CricketerServiceImplJpa implements CricketerService
{
    private CricketerRepository cricketerRepository;

    @Autowired
    public CricketerServiceImplJpa(CricketerRepository cricketerRepository) {
        this.cricketerRepository = cricketerRepository;
    }

    public List<Cricketer> getAllCricketers() throws SQLException
    {
        return (cricketerRepository.findAll());
    }

    public Integer addCricketer(Cricketer cricketer) throws SQLException
    {
        Cricketer obj = cricketerRepository.save(cricketer);
        return (obj.getCricketerId());
    }

    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException
    {
        List<Cricketer> list = cricketerRepository.findAll();
        list.sort(Comparator.comparing(Cricketer::getExperience));
        return (list);
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException 
    {
        //CricketerService.super.deleteCricketer(cricketerId);
        cricketerRepository.deleteById(cricketerId);
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException 
    {
        //CricketerService.super.updateCricketer(cricketer);

        Cricketer cricketerObj = cricketerRepository.findById(cricketer.getCricketerId()).get();
        cricketerObj.setCricketerName(cricketer.getCricketerName());
        cricketerObj.setTeamId(cricketer.getTeamId());
        cricketerObj.setAge(cricketer.getAge());
        cricketerObj.setNationality(cricketer.getNationality());
        cricketerObj.setExperience(cricketer.getExperience());
        cricketerObj.setRole(cricketer.getRole());
        cricketerObj.setTotalRuns(cricketer.getTotalRuns());
        cricketerObj.setTotalWickets(cricketer.getTotalWickets());

        cricketerRepository.save(cricketerObj);
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException 
    {
        //return CricketerService.super.getCricketerById(cricketerId);
        return cricketerRepository.findByCricketerId(cricketerId);
    }

    @Override
    public List<Cricketer> getCricketersByTeam(int teamId) throws SQLException 
    {
       // return CricketerService.super.getCricketersByTeam(teamId);
       return cricketerRepository.findByTeam_TeamId(teamId);
    }

}