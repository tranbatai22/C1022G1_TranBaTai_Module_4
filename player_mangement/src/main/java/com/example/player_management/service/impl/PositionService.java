package com.example.player_management.service.impl;

import com.example.player_management.model.Position;
import com.example.player_management.repository.IPositionRepository;
import com.example.player_management.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
