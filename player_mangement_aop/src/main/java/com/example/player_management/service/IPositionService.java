package com.example.player_management.service;

import com.example.player_management.model.Position;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
