package com.example.player.repository;

import com.example.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
}
