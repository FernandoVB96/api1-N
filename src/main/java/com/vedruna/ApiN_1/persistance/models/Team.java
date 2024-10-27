package com.vedruna.ApiN_1.persistance.models;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="equipos")
public class Team implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idequipo")
    private int teamId;

    @Column(name="nombre")
    private String name;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="playerTeam")
    private List<Player> playersWithTeam;
}
