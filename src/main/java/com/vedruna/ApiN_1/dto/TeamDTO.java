package com.vedruna.ApiN_1.dto;

import java.util.ArrayList;
import java.util.List;
import com.vedruna.ApiN_1.persistance.models.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Integer teamId;
    private String nombre;
    private List<PlayerDTO> players; 

    public TeamDTO(Team t) {
        this.teamId = t.getTeamId();
        this.nombre = t.getName();
        this.players = new ArrayList<>();
        if (t.getPlayersWithTeam() != null) {
            t.getPlayersWithTeam().forEach(player -> {
                this.players.add(new PlayerDTO(player));
            });
        }
    }
}
