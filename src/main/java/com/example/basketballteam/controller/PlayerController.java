package com.example.basketballteam.controller;

import com.example.basketballteam.model.BaseResult;
import com.example.basketballteam.model.Player;
import com.example.basketballteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping("/player/addPlayer")
    public String addPlayer() {
        return "addNewPlayer";
    }

    @RequestMapping("/player/updatePlayer={playerId}")
    public String updatePlayers(@PathVariable("playerId") int playerId, ModelMap map) {
        Player player = playerService.selectById(playerId);
        map.addAttribute("player", player);
        return "updatePlayer";
    }


// ...

    @RequestMapping(value = "/addPlayerIn", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addNewPlayer(String playerName, MultipartFile playerSelfieImage, int playerPosition, String playerClass, String playerInfo, int playerScore) {
        BaseResult result = new BaseResult();
        Player player = new Player();
        String savePath = "D:\\开摆\\数据库\\basketballTeam\\src\\main\\resources\\static\\image";
        if (playerSelfieImage != null && !playerSelfieImage.isEmpty()) {
            try {
                // 生成唯一的文件名
                String originalFilename = playerSelfieImage.getOriginalFilename();
                String extension = StringUtils.getFilenameExtension(originalFilename);
                String fileName = System.currentTimeMillis() + "." + extension;

                // 拼接文件保存的完整路径
                savePath = savePath + File.separator + fileName;
                // 保存图片文件到服务器
                File saveFile = new File(savePath);
                playerSelfieImage.transferTo(saveFile);
                String SelfieImage="/static/image/"+fileName;
                // 设置Player对象的图片路径
                player.setPlayerSelfieImage(SelfieImage);
            } catch (IOException e) {
                e.printStackTrace();
                // 图片保存出现异常
                result.setCode(-1);
                return result;
            }
        }

        player.setPlayerClass(playerClass);
        player.setPlayerName(playerName);
        player.setPlayerScore(playerScore);
        player.setPlayerPosition(playerPosition);
        player.setPlayerInfo(playerInfo);

        result.setCode(playerService.addPlayer(player));
        return result;
    }


    @RequestMapping(value = "/updatePlayerIn", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updatePlayer(int playerId, String playerName, String playerSelfieImage, int playerPosition, String playerClass, String playerInfo, int playerScore) {
        BaseResult result = new BaseResult();
        Player player = new Player(playerId, playerName, playerSelfieImage, playerPosition, playerClass, playerInfo, playerScore);
        result.setCode(playerService.updatePlayer(player));
        return result;
    }
}
