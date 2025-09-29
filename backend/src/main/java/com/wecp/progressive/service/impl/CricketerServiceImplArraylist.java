package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.service.CricketerService;

public class CricketerServiceImplArraylist implements CricketerService
{
    public static List<Cricketer> cricketers = new ArrayList<Cricketer>();
    
    public CricketerServiceImplArraylist()
    {
        cricketers.add(new Cricketer(13, 1,"Kohli", 37, "Indian", 7, "Batter", 37000, 3));
        cricketers.add(new Cricketer(7, 2, "Ajay", 27, "Indian", 5, "Bowler", 7000, 10));
    }


    @Override
    public Integer addCricketer(Cricketer cricketer) 
    {
        this.cricketers.add(cricketer);
        return (cricketers.size());
    }

    @Override
    public void emptyArrayList() 
    {
        //CricketerService.super.emptyArrayList();
        cricketers = new ArrayList<Cricketer>();
    }

    @Override
    public List<Cricketer> getAllCricketers() 
    {
        return (cricketers);
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() 
    {

        if(this.cricketers == null || this.cricketers.isEmpty())
        {
            cricketers.add(new Cricketer(13, 1,"Kohli", 37, "Indian", 7, "Batter", 37000, 3));
            cricketers.add(new Cricketer(7, 2, "Ajay", 27, "Indian", 5, "Bowler", 7000, 10));
        }
        List<Cricketer> sortedCricketers = new ArrayList<>(this.cricketers);

        sortedCricketers.sort(Comparator.comparing(Cricketer::getExperience));
        return (sortedCricketers);
        // Collections.sort(cricketers);
        // return (cricketers);
    }
    
}