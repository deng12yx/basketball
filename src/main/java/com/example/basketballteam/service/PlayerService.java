package com.example.basketballteam.service;

import com.example.basketballteam.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAllPlayer();
    Player selectById(int id);
    int updatePlayer(Player player);
    List<Player> findPlayerBy2020();
    List<Player> findPlayerBy2021();
    List<Player> findPlayerBy2022();
    int addPlayer(Player player);
}
