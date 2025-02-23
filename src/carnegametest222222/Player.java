/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carnegametest222222;

/**
 *
 * @author JustClick
 */
public class Player {
        private String playerName;
        private int playerAmount;
        private Double score;

    public Player(String playerName, int playerAmount, Double score) {
        this.playerName = playerName;
        this.playerAmount = playerAmount;
        this.score = null;
    }
        public String getPlayerName() {
        return playerName;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
