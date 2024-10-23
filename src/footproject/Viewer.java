/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package footproject;

/**
 *
 * @author godfr
 */
public class Viewer extends Person {
    private Teams supportTeam;

    public Viewer(String commonName, String firstName, String surname, String placeOfBirth, 
                  String dateOfBirth, String nationality, int size, int weight, Teams supportTeam) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight);
        this.supportTeam = supportTeam;
    }
}
