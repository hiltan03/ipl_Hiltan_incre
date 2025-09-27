package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
=======
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wecp.progressive.entity.Cricketer;
import java.util.List;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Integer>
{
    public Cricketer findByCricketerId(int cricketerId);

    public List<Cricketer> findByTeam_TeamId(int teamId);

<<<<<<< HEAD
    public Long countByTeam_TeamId(int teamId);
    

    @Modifying
    @Transactional
    @Query("delete from Cricketer c where c.teamId = :teamId")
=======
    @Modifying
    @Transactional
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
    public Void deleteByTeamId(int teamId);
}
