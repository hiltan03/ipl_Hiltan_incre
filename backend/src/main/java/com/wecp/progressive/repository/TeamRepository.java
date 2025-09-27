package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>
{
    public Team findByTeamId(int teamId);
<<<<<<< HEAD
    Team findByTeamName(String name);
=======
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
}
