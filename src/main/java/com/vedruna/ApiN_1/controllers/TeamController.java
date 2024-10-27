package com.vedruna.ApiN_1.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vedruna.ApiN_1.dto.TeamDTO;
import com.vedruna.ApiN_1.persistance.models.Team;
import com.vedruna.ApiN_1.services.TeamServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/team")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamServiceI teamMngmnt;
    
    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamMngmnt.showAllTeams();
    }

    @GetMapping("/name/{name}")
    public TeamDTO showUserByName(@PathVariable String name) {
        return teamMngmnt.showTeamByName(name);
    }

    @PostMapping("/insert")
    public String postTeam(@RequestBody Team team) {
        teamMngmnt.saveTeam(team);

        return "Team saved";
    }

    @DeleteMapping("delete/{idEquipo}")
    public String deleteTeam(@PathVariable Integer idEquipo) {
        teamMngmnt.deleteTeam(idEquipo);
        
        return "Team deleted";
    }
}
