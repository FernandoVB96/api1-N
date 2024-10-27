package com.vedruna.ApiN_1.dto;

import com.vedruna.ApiN_1.persistance.models.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Integer playerId;
    private String nombre;
    private Integer edad;
    private String nombreEquipo; 

    public PlayerDTO(Player p) {
        this.playerId = p.getPlayerId();
        this.nombre = p.getName();
        this.edad = p.getAge();
        this.nombreEquipo = p.getPlayerTeam() != null ? p.getPlayerTeam().getName() : null;
    }
}