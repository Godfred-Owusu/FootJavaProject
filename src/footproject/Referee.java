/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package footproject;

/**
 *
 * @author godfr
 */
public class Referee extends Person {
    private int experienceYears;
    private String role;

    public Referee(String commonName, String firstName, String surname, String placeOfBirth, 
                   String dateOfBirth, String nationality, int size, int weight, 
                   int experienceYears, String role) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight);
        this.experienceYears = experienceYears;
        this.role = role;
    }
}