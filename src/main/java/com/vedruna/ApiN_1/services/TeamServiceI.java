package com.vedruna.ApiN_1.services;

import java.util.List;
import com.vedruna.ApiN_1.dto.TeamDTO;
import com.vedruna.ApiN_1.persistance.models.Team;

public interface TeamServiceI {
    List<TeamDTO> showAllTeams();
    TeamDTO showTeamByName(String name);
    void saveTeam(Team team);
    void deleteTeam(Integer id);
}
