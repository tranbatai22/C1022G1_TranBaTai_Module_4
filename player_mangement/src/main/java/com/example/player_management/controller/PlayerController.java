package com.example.player_management.controller;

import com.example.player_management.model.Player;
import com.example.player_management.service.IPlayerService;
import com.example.player_management.service.IPositionService;
import com.example.player_management.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IPositionService positionService;

//    @GetMapping("")
//    public String showList(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(name = "freeText", defaultValue = "")
//            String freeText, @RequestParam(value = "fromDate", defaultValue = "") String fromDate,
//                           @RequestParam(value = "toDate", defaultValue = "") String toDate,
//                           Model model) {
//        model.addAttribute("playerList", playerService.searchByName(freeText, fromDate, toDate, pageable));
//        model.addAttribute("search", freeText);
//        model.addAttribute("fromDate", fromDate);
//        model.addAttribute("toDate", toDate);
//        return "/player/list";
//
////    }
//
    @GetMapping("")
    public String showList(@PageableDefault(page = 0) Pageable pageable,
                           @RequestParam(name = "freeText", defaultValue = "") String freeText, Model model){
        model.addAttribute("playerList", playerService.findByName(freeText, pageable));
        model.addAttribute("teamList", teamService.findAll());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("freeText", freeText);
        return "/player/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("team", teamService.findAll());
        model.addAttribute("position", positionService.findAll());
        return "/player/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Player player, RedirectAttributes redirectAttributes) {
        playerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/player";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("idDelete") int id, RedirectAttributes redirectAttributes) {
        playerService.delete(id);
        redirectAttributes.addFlashAttribute(   "mess", "Xoá thành công");
        return "redirect:/player";
    }
    @GetMapping("/update/{id}")
    public String showFormEdit(Model model, @PathVariable int id) {
        model.addAttribute("player",playerService.findById(id));
        model.addAttribute("team", teamService.findAll());
        model.addAttribute("position", positionService.findAll());
        return "/player/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute Player player, RedirectAttributes redirectAttributes) {
        playerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/player";
    }
}
