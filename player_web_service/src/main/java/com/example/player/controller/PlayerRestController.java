package com.example.player.controller;

import com.example.player.model.Player;
import com.example.player.service.IPlayerService;
import com.example.player.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")
public class PlayerRestController {
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private ITeamService teamService;

    @GetMapping("")
    public ResponseEntity<List<Player>> findAll() {
        List<Player> playerList = playerService.findAll();
        if (playerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Player> detail(@PathVariable int id) {
        Optional<Player> player = playerService.findById(id);

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(player, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<List<Player>> add(@RequestBody Player player) {
        playerService.save(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<List<Player>> edit(@RequestBody Player player) {
        playerService.save(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
