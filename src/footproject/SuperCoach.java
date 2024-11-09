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

    public SuperCoach(String commonName, String firstName,  
                      String nationality, 
                      int experienceYears, Teams team, boolean havePaidRef) {
        super(commonName, firstName, nationality, experienceYears, team);
        this.havePaidRef = havePaidRef;
    }
}
