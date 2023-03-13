package com.example.management_player_football.controller;

import com.example.management_player_football.dto.FavoriteDto;
import com.example.management_player_football.dto.PlayerDto;
import com.example.management_player_football.model.Player;
import com.example.management_player_football.service.IPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("favorite")
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @ModelAttribute("favorite")
    public FavoriteDto initFavorite() {
        return new FavoriteDto();
    }

    @GetMapping("")
    public String showList(Model model, @CookieValue(value = "playerId", required = false, defaultValue = "-1") int id) {
        model.addAttribute("playerList", playerService.findAll());
        return "/player/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("playerDetail", playerService.findById(id));
        return "/player/detail";
    }

    @GetMapping("create/{id}")
    public String addFavorite(@PathVariable int id, @SessionAttribute("favoriteDto") FavoriteDto favoriteDto,
                              HttpServletResponse response) {
        for (Player p : playerService.findAll()) {
            if (playerService.findById(id).isPresent()) {
                p.setStatus(p.getStatus() + 1);
            }
        }

        Player player = playerService.findById(id).get();
        PlayerDto playerDto = new PlayerDto();
        BeanUtils.copyProperties(player, playerDto);
        favoriteDto.addFavoritePlayer(playerDto);

        Cookie cookie = new Cookie("playerId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/favorite");
        response.addCookie(cookie);
        return "redirect:/favorite";
    }
}
