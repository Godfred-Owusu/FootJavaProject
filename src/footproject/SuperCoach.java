/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package footproject;

/**
 *
 * @author godfr
 */
public class SuperCoach extends Coach {
    private boolean havePaidRef;

    public SuperCoach(String commonName, String firstName, String surname, String placeOfBirth, 
                      String dateOfBirth, String nationality, int size, int weight, 
                      int experienceYears, Teams team, boolean havePaidRef) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight, experienceYears, team);
        this.havePaidRef = havePaidRef;
    }
}
