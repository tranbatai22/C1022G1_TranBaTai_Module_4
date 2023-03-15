package com.example.player_web_service.repository;

import com.example.player_web_service.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
}
