package com.example.player_management.aop;

import com.example.player_management.dto.PlayerDto;
import com.example.player_management.model.Player;
import com.example.player_management.service.impl.PlayerService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAOP {

    @Autowired
    private PlayerService playerService;

    @Pointcut("execution(* com.example.management_player_football.controller.PlayerController.update(..))&&args(playerDto,*,*,*)")
    public void getAllUpdate(PlayerDto playerDto) {
    }

    @After(value = "getAllUpdate(playerDto)", argNames = "playerDto")
    public void printUpdate(PlayerDto playerDto) {
        int count = 0;
        for (Player player : playerService.findAll()) {
            if (player.isStatus() == true) {
                count++;
            }
        }

        System.out.println("Trạng thái của cầu thủ " + playerDto.getName() + " đã bị chuyển đổi thành " + playerDto.isStatus());
        System.out.println("Số lượng cầu thủ đăng kí là: " + count);
    }
}

