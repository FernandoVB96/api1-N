package com.vedruna.ApiN_1.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedruna.ApiN_1.persistance.models.Team;

@Repository
public interface TeamRepositoryI extends JpaRepository<Team,Integer> {
    Team findByName(String name);
}
