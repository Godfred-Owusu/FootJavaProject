
package footproject;

/**
 * @author methiss
 */

public abstract class Person {
    protected String commonName;
    protected String firstName;
    protected String surname;
    protected String nationality;

    // Constructor
    public Person(String commonName, String firstName, String nationality) {
        this.commonName = commonName;
        this.firstName = firstName;
        this.nationality = nationality;

    }
    
     // Getters
    public String getCommonName() {
        return commonName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNationality() {
        return nationality;
    }

}
