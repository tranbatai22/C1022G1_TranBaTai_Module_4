package com.example.player_web_service.service;

import com.example.player_web_service.model.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    List<Player> findAll();

    Optional<Player> findById(int id);

    Player save(Player player);
}
