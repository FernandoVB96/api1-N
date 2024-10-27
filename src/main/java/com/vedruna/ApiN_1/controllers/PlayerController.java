package com.vedruna.ApiN_1.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vedruna.ApiN_1.dto.PlayerDTO;
import com.vedruna.ApiN_1.persistance.models.Player;
import com.vedruna.ApiN_1.services.PlayerServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerServiceI playerMngmnt;

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerMngmnt.showAllPlayers();
    }

    @GetMapping("/name/{name}")
    public PlayerDTO showUserByName(@PathVariable String name) {
        return playerMngmnt.showPlayerByName(name);
    }

    @PostMapping("/insert")
    public String postPlayer(@RequestBody Player player) {
        playerMngmnt.savePlayer(player);

        return "Player saved";
    }

    @PostMapping("assign/{idplayer}/{idteam}")
    public String assignTeamToPlayer(@PathVariable Integer idplayer, @PathVariable Integer idteam) {
        playerMngmnt.assignTeamToPlayer(idplayer, idteam);
        return "Team assigned to player";
    }
    

    @DeleteMapping("delete/{id}")
    public String deletePlayer(@PathVariable Integer id) {
        playerMngmnt.deletePlayer(id);
        
        return "Player deleted";
    }
}