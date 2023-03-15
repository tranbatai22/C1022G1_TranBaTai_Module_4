package com.example.player_web_service.controller;

import com.example.player_web_service.model.Player;
import com.example.player_web_service.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/player")
public class PlayerRestController {
    @Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public ResponseEntity<List<Player>> findAll(){
        List<Player> playerList = playerService.findAll();
        if (playerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }
}
