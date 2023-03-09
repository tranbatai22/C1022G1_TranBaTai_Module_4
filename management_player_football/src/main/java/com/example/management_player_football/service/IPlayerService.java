package com.example.management_player_football.service;

import com.example.management_player_football.model.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    List<Player> findAll();

    Optional<Player> findById(int id);
}
