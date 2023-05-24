package com.example.basketballteam.mapper;

import com.example.basketballteam.model.Player;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlayerMapper {
    @Select("select * from cyberspacesecuritybasketballteam.player")
    List<Player> findAllPlayer();

    @Select("select * from cyberspacesecuritybasketballteam.player where playerClass=2020")
    List<Player> findPlayerBy2020();

    @Select("select * from cyberspacesecuritybasketballteam.player where playerClass=2021")
    List<Player> findPlayerBy2021();

    @Select("select * from cyberspacesecuritybasketballteam.player where playerClass=2022")
    List<Player> findPlayerBy2022();

    @Select("select * from cyberspacesecuritybasketballteam.player where playerId=#{id}")
    Player selectById(int id);

    @Update("UPDATE cyberspacesecuritybasketballteam.players " +
            "SET playerName = #{playerName}, " +
            "playerSelfieImage = #{playerSelfieImage}, " +
            "playerPosition = #{playerPosition}, " +
            "playerClass = #{playerClass}, " +
            "playerInfo = #{playerInfo}, " +
            "playerScore = #{playerScore} " +
            "WHERE playerId = #{playerId}")
    int updatePlayer(Player player);

    @Insert("INSERT INTO cyberspacesecuritybasketballteam.player (playerName,playerSelfieImage,playerPosition,playerClass,playerInfo,playerScore) " +
            "VALUES (#{playerName}, #{playerSelfieImage}, #{playerPosition}, #{playerClass},#{playerInfo},#{playerScore} )")
    @Options(useGeneratedKeys = true, keyProperty = "playerId", keyColumn = "playerId")
    int addPlayer(Player player);
}
