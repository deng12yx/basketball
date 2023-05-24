package com.example.basketballteam.model;

public class Player {
    private int playerId;
    private String playerName;
    private String playerSelfieImage;
    private int playerPosition;
    private String playerClass;
    private String playerInfo;
    private int playerScore;
    public Player(){

    }

    public Player(int playerId, String playerName, String playerSelfieImage, int playerPosition, String playerClass, String playerInfo, int playerScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerSelfieImage = playerSelfieImage;
        this.playerPosition = playerPosition;
        this.playerClass = playerClass;
        this.playerInfo = playerInfo;
        this.playerScore = playerScore;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSelfieImage() {
        return playerSelfieImage;
    }

    public void setPlayerSelfieImage(String playerSelfieImage) {
        this.playerSelfieImage = playerSelfieImage;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(String playerInfo) {
        this.playerInfo = playerInfo;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
