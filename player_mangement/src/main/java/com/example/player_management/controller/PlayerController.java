package com.example.player_management.controller;

import com.example.player_management.dto.PlayerDto;
import com.example.player_management.model.Player;
import com.example.player_management.service.IPlayerService;
import com.example.player_management.service.IPositionService;
import com.example.player_management.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

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
                           @RequestParam(name = "freeText", defaultValue = "") String freeText, Model model) {
        model.addAttribute("playerList", playerService.findByName(freeText, pageable));
        model.addAttribute("teamList", teamService.findAll());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("freeText", freeText);
        return "/player/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("playerDto", new PlayerDto());
        model.addAttribute("teamList", teamService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "/player/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute PlayerDto playerDto,
                         RedirectAttributes redirectAttributes,
                         BindingResult bindingResult,
                         Model model) {
        new PlayerDto().validate(playerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("teamList", teamService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            return "/player/create";
        }
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/player";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("idDelete") int id, RedirectAttributes redirectAttributes) {
        playerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/player";
    }

    @GetMapping("/update/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        Optional<Player> player = playerService.findById(id);

        PlayerDto playerDto = new PlayerDto();
        BeanUtils.copyProperties(playerDto, player);

        model.addAttribute("playerDto", playerDto);
        model.addAttribute("teamList", teamService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated PlayerDto playerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {

        new PlayerDto().validate(playerDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("playerDto",playerDto);
            model.addAttribute("teamList", teamService.findAll());
            model.addAttribute("positionList", positionService.findAll());

            return "/player/update";
        }

        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Chinh sua thanh cong.");
        return "redirect:/player";
    }
}
