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
    private Teams team;

    public Player(String commonName, String firstName, String surname, String placeOfBirth, 
                  String dateOfBirth, String nationality, int size, int weight, 
                  String sponsor, int playerNumber, String position, Teams team) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight);
        this.sponsor = sponsor;
        this.playerNumber = playerNumber;
        this.position = position;
        this.team = team;
        this.goalsScored = 0;
        this.assists = 0;
        this.yellowCards = 0;
        this.redCards = 0;
        this.injured = false;
    }
}
