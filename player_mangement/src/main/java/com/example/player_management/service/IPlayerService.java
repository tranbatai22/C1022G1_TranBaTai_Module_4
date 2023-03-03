package com.example.player_management.service;

import com.example.player_management.model.Player;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IPlayerService {
//    List<Player> findAll();
//
//    void delete(int id);
//
//    Optional<Player> findById(int id);

    Page<Player> searchByName(String name, String fromDate, String toDate, Pageable pageable);
}
