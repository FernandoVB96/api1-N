package com.vedruna.ApiN_1.services;


import java.util.List;
import com.vedruna.ApiN_1.dto.PlayerDTO;
import com.vedruna.ApiN_1.persistance.models.Player;

public interface PlayerServiceI {
    List<PlayerDTO> showAllPlayers();
    PlayerDTO showPlayerByName(String name);
    void savePlayer(Player player);
    void deletePlayer(Integer id);
    void assignTeamToPlayer(Integer playerId, Integer idteam);

}
