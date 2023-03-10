package com.example.player.service;

import com.example.player.model.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    List<Player> findAll();

    void save(Player player);

    Optional<Player> findById(int id);
}
