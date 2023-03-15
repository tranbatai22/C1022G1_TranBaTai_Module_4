package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.repository.IPlayerRepository;
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
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Optional<Player> findById(int id) {
        return playerRepository.findById(id);
    }
}
