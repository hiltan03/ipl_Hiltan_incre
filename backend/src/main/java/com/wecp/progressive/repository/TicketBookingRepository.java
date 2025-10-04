package com.wecp.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wecp.progressive.entity.TicketBooking;

public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer>
{
    List<TicketBooking> findByEmail(String email);
    //mod trans
    @Modifying
    @Transactional
    @Query("Delete from TicketBooking t where t.team.teamId = :teamId")
    void deleteByTeam(int teamId);


    @Modifying
    @Transactional
    @Query("Delete from TicketBooking t where t.match.matchId = :matchId")
    void deleteByMatchId(int matchId);
}
