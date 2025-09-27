package com.wecp.progressive.controller;

<<<<<<< HEAD
import com.wecp.progressive.dao.TeamDAO;
import com.wecp.progressive.entity.Team;
import com.wecp.progressive.exception.TeamAlreadyExistsException;
import com.wecp.progressive.exception.TeamDoesNotExistException;
=======
import com.wecp.progressive.entity.Team;
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
import com.wecp.progressive.service.impl.TeamServiceImplArraylist;
import com.wecp.progressive.service.impl.TeamServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ExceptionHandler;
=======
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

   // @Autowired
    //@Qualifier("teamServiceImplJpa")
    private TeamServiceImplArraylist teamServiceImplArraylist;

    @Autowired
    private TeamServiceImplJpa teamServiceImplJpa;

<<<<<<< HEAD
    //handle exception 500 method
    @ExceptionHandler(TeamAlreadyExistsException.class)
    public ResponseEntity<?> handleTeamAlreadyExistsException(TeamAlreadyExistsException t){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TeamDoesNotExistException.class)
    public ResponseEntity<?> handleTeamDoesNotExistException(TeamDoesNotExistException t){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> handleSQLException(SQLException s){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping()
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamServiceImplJpa.getAllTeams();

=======
    @GetMapping()
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamServiceImplJpa.getAllTeams();
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable int teamId) {
        Team team = teamServiceImplJpa.getTeamById(teamId);
<<<<<<< HEAD
        if(team==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
=======
>>>>>>> 03b6f3e6055d47f107e87e6c604234d2bead24f3
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addTeam(@RequestBody Team team) 
    {
        int t = teamServiceImplJpa.addTeam(team);
        return new ResponseEntity<>(team.getTeamId(), HttpStatus.CREATED);
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<Void> updateTeam(@PathVariable int teamId, @RequestBody Team team) {
        teamServiceImplJpa.updateTeam(team);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int teamId) {
        teamServiceImplJpa.deleteTeam(teamId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Team>> getAllTeamsFromArrayList(){
        List<Team> teamList = teamServiceImplArraylist.getAllTeams();
        return new ResponseEntity<>(teamList, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addTeamToArrayList(@RequestBody Team team) {
        int t = teamServiceImplArraylist.addTeam(team);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Team>> getAllTeamsSortedByNameFromArrayList() {
        List<Team> team = teamServiceImplArraylist.getAllTeamsSortedByName();
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
