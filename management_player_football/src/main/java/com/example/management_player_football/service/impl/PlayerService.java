package com.example.management_player_football.service.impl;

import com.example.management_player_football.model.Player;
import com.example.management_player_football.repository.IPlayerRepository;
import com.example.management_player_football.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(int id) {
             return playerRepository.findById(id);
        }
}
