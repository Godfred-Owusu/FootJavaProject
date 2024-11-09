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
    public Coach(String commonName, String firstName, String nationality, 
                 int experienceYears, Teams team) {
        super(commonName, firstName, nationality);
        this.experienceYears = experienceYears;
        this.team = team;
        this.yellowCards = 0;
        this.redCards = 0;
    }
    
    public int getExperienceYears() {
        return experienceYears;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }
    
    public Teams getTeam() {
        return this.team;
    }
    
    public void setTeam(Teams team) {
        this.team = team;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    

}