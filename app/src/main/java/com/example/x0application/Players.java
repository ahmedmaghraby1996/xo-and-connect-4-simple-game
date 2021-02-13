package com.example.x0application;

import java.io.Serializable;

public class Players  implements Serializable {
    private  String p1name,p2name,round;
    private Integer player1,player2;
public Players(){}
    public Players(String p1name, String p2name, Integer player1, Integer player2,String round) {
        this.p1name = p1name;
        this.p2name = p2name;
        this.player1 = player1;
        this.player2 = player2;
        this.round=round;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getP1name() {
        return p1name;
    }

    public void setP1name(String p1name) {
        this.p1name = p1name;
    }

    public String getP2name() {
        return p2name;
    }

    public void setP2name(String p2name) {
        this.p2name = p2name;
    }

    public Integer getPlayer1() {
        return player1;
    }

    public void setPlayer1(Integer player1) {
        this.player1 = player1;
    }

    public Integer getPlayer2() {
        return player2;
    }

    public void setPlayer2(Integer player2) {
        this.player2 = player2;
    }
}
