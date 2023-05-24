package com.example.basketballteam.service.impl;

import com.example.basketballteam.mapper.PlayerMapper;
import com.example.basketballteam.model.Player;
import com.example.basketballteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerMapper playerMapper;
    @Override
    public List<Player> findAllPlayer() {
        return this.playerMapper.findAllPlayer();
    }

    @Override
    public Player selectById(int id) {
        return this.playerMapper.selectById(id);
    }

    @Override
    public int updatePlayer(Player player) {
        return this.playerMapper.updatePlayer(player);
    }

    @Override
    public List<Player> findPlayerBy2020() {
        return this.playerMapper.findPlayerBy2020();
    }

    @Override
    public List<Player> findPlayerBy2021() {
        return this.playerMapper.findPlayerBy2021();
    }

    @Override
    public List<Player> findPlayerBy2022() {
        return this.playerMapper.findPlayerBy2022();
    }

    @Override
    public int addPlayer(Player player) {
        return this.playerMapper.addPlayer(player);
    }
}
