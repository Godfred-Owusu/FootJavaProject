/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package footproject;

/**
 *
 * @author godfr
 */

public class Coach extends Person {
    private int experienceYears;
    private Teams team;
    private int yellowCards;
    private int redCards;

    // Constructor
    public Coach(String commonName, String firstName, String surname, String placeOfBirth, 
                 String dateOfBirth, String nationality, int size, int weight, 
                 int experienceYears, Teams team) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight);
        this.experienceYears = experienceYears;
        this.team = team;
        this.yellowCards = 0;
        this.redCards = 0;
    }
}