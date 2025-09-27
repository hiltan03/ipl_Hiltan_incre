package com.wecp.progressive.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wecp.progressive.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote,Integer>{
    //@Query("select count(v) from Vote v where v.category = :category")
    Long countByCategory(String category);
    
    @Modifying
    @Transactional
    @Query("delete from Vote v where v.team.teamId = :teamId")
    void deleteByTeamId(int teamId);

    @Modifying
    @Transactional
    @Query("delete from Vote v where v.cricketer.cricketerId = :cricketerId")
    void deleteByCricketerId(int cricketerId);
}
