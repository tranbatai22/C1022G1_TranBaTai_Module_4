package com.example.management_player_football.controller;

import com.example.management_player_football.dto.FavoriteDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
    @GetMapping("")
    public String showFavorite(@SessionAttribute(name = "favorite") FavoriteDto favoriteDto, Model model) {
        model.addAttribute("favoriteDto", favoriteDto);
        return "favorite/list";
    }
}
