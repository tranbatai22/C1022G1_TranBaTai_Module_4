package com.example.player_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeam;
    private String nameTeam;
    @OneToMany(mappedBy = "team")
    private Set<Player> playerSet;

    public Team() {
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public void setPlayerSet(Set<Player> playerSet) {
        this.playerSet = playerSet;
    }
}
