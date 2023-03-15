package com.example.player_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private String positionName;
    @OneToMany(mappedBy = "position")
    private Set<Player> playerSet;

    public Position() {
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public void setPlayerSet(Set<Player> playerSet) {
        this.playerSet = playerSet;
    }
}
