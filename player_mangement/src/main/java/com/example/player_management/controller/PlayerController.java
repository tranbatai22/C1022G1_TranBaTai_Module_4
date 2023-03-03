package com.example.player_management.controller;

import com.example.player_management.model.Player;
import com.example.player_management.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.util.Optional;

@Controller
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public String showList(@PageableDefault(sort = "name",direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(name = "freeText", defaultValue = "")
            String freeText, @RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                           @RequestParam(value = "toDate", defaultValue = "") String toDate,
                           Model model) {
        model.addAttribute("playerList", playerService.searchByName(freeText, fromDate, toDate, pageable));
        model.addAttribute("search", freeText);
        return "/player/list";

    }
}
