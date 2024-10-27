package com.vedruna.ApiN_1.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vedruna.ApiN_1.dto.PlayerDTO;
import com.vedruna.ApiN_1.persistance.models.Player;
import com.vedruna.ApiN_1.persistance.models.Team;
import com.vedruna.ApiN_1.persistance.repository.PlayerRepositoryI;
import com.vedruna.ApiN_1.persistance.repository.TeamRepositoryI;



@Service
public class PlayerServiceImpl implements PlayerServiceI {

    @Autowired
    PlayerRepositoryI playerRepo;

    @Autowired
    TeamRepositoryI teamRepo;

    @Override
    public List<PlayerDTO> showAllPlayers() {
        List<Player> players = playerRepo.findAll();
        List<PlayerDTO> playersDTO = new ArrayList<>();
    
        for (Player p : players) {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setPlayerId(p.getPlayerId());
            playerDTO.setNombre(p.getName());
            playerDTO.setEdad(p.getAge());
    
            if (p.getPlayerTeam() != null) {
                playerDTO.setNombreEquipo(p.getPlayerTeam().getName());
            } else {
                playerDTO.setNombreEquipo(null);
            }
    
            playersDTO.add(playerDTO);
        }
        return playersDTO;
    }
    

    @Override
    public PlayerDTO showPlayerByName(String nombre) {
        return new PlayerDTO(playerRepo.findByName(nombre));
    }

    @Override
    public void savePlayer(Player player) {
        playerRepo.save(player);
    }

    @Override
    public void assignTeamToPlayer(Integer playerId, Integer idequipo) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        Team team = teamRepo.findById(idequipo)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        player.setPlayerTeam(team);
        playerRepo.save(player);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepo.deleteById(id);
    }
}