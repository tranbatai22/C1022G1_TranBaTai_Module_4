package com.example.player_football.service;

import com.example.player_football.model.Player;

import java.util.List;

public interface IPlayerService {
    void save(Player player);

    List<Player> findAll();
}
