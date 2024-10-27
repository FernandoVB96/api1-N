package com.vedruna.ApiN_1.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedruna.ApiN_1.persistance.models.Player;

@Repository
public interface PlayerRepositoryI extends JpaRepository<Player,Integer> {
    Player findByName(String name);
}
