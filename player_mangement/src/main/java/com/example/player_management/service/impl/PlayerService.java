package com.example.player_management.service.impl;

import com.example.player_management.model.Player;
import com.example.player_management.repository.IPlayerRepository;
import com.example.player_management.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public Page<Player> searchByName(String name, String fromDate, String toDate, Pageable pageable) {
        return playerRepository.searchByNameContainingAndDayOfBirthBetween("%" + name + "%", LocalDate.parse(fromDate), LocalDate.parse(toDate), pageable);
    }

//    @Override
//    public List<Player> findAll() {
//        return playerRepository.findAll();
//    }
//
//    @Override
//    public void delete(int id) {
//        playerRepository.deleteById(id);
//    }
//
//    @Override
//    public Optional<Player> findById(int id) {
//        return playerRepository.findById(id);
//    }

}