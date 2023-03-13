package com.example.player_football.controller;

import com.example.player_football.model.Player;
import com.example.player_football.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/players")
public class PlayerRestController {
    @Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public ResponseEntity<List<Player>> findAll() {
        List<Player> playerList = playerService.findAll();
        if (playerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<Player>> save(@RequestBody Player player) {
        playerService.save(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
