/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package footproject;

/**
 *
 * @author godfr
 */
public class Player extends Person {
    private String sponsor;
    private int playerNumber;
    private String position;
    private int goalsScored;
    private int assists;
    private int yellowCards;
    private int redCards;
    private boolean injured;

    public Player(String commonName, String firstName, String surname, String nationality,
                  String sponsor, String position,int playerNumber) {
        super(commonName, firstName, nationality);
        this.sponsor = sponsor;
        this.playerNumber = playerNumber;
        this.position = position;
        this.goalsScored = 0;
        this.assists = 0;
        this.yellowCards = 0;
        this.redCards = 0;
        this.injured = false;
    }
    
    public String getPosition() {
        return position;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getSponsor() {
        return sponsor;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public boolean isInjured() {
        return injured;
    }
    
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }
    
    

}
