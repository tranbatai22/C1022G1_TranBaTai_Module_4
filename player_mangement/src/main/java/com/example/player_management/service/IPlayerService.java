package com.example.player_management.service;

import com.example.player_management.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    List<Player> findAll();

    void delete(int id);

    void save(Player player);

    Optional<Player> findById(int id);

//    Page<Player> searchByName(String name, String fromDate, String toDate, Pageable pageable);

    Page<Player> findByName(String name, Pageable pageable);
}
