package com.example.player.service;

import com.example.player.model.Team;
import com.example.player.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService{
    @Autowired
    private ITeamRepository teamRepository;
    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
