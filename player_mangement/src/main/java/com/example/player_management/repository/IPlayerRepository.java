package com.example.player_management.repository;

import com.example.player_management.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.time.LocalDate;

public interface IPlayerRepository extends JpaRepository<Player, Integer> {
    Page<Player> searchByNameContainingAndDayOfBirthBetween(String name, @Param("startDate") LocalDate startDate,
                                                            @Param("endDate") LocalDate endDate, Pageable pageable);
}
