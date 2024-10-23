
package footproject;

/**
 * @author methiss
 */

public abstract class Person {
    protected String commonName;
    protected String firstName;
    protected String surname;
    protected String placeOfBirth;
    protected String dateOfBirth;
    protected String dateOfDeath;
    protected String nationality;
    protected int size;
    protected int weight;

    // Constructor
    public Person(String commonName, String firstName, String surname, String placeOfBirth, 
                  String dateOfBirth, String nationality, int size, int weight) {
        this.commonName = commonName;
        this.firstName = firstName;
        this.surname = surname;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.size = size;
        this.weight = weight;
    }
}

public class Player extends Person {
    private String sponsor;
    private int playerNumber;
    private String position;
    private int goalsScored;
    private int assists;
    private int yellowCards;
    private int redCards;
    private boolean injured;
    private Team team;

    // Constructor
    public Player(String commonName, String firstName, String surname, String placeOfBirth, 
                  String dateOfBirth, String nationality, int size, int weight, 
                  String sponsor, int playerNumber, String position, Team team) {
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


public class Coach extends Person {
    private int experienceYears;
    private Team team;
    private int yellowCards;
    private int redCards;

    // Constructor
    public Coach(String commonName, String firstName, String surname, String placeOfBirth, 
                 String dateOfBirth, String nationality, int size, int weight, 
                 int experienceYears, Team team) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight);
        this.experienceYears = experienceYears;
        this.team = team;
        this.yellowCards = 0;
        this.redCards = 0;
    }
}

public class SuperCoach extends Coach {
    private boolean havePaidRef;

    // Constructor
    public SuperCoach(String commonName, String firstName, String surname, String placeOfBirth, 
                      String dateOfBirth, String nationality, int size, int weight, 
                      int experienceYears, Team team, boolean havePaidRef) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight, experienceYears, team);
        this.havePaidRef = havePaidRef;
    }
}


public class Referee extends Person {
    private int experienceYears;
    private String role;

    // Constructor
    public Referee(String commonName, String firstName, String surname, String placeOfBirth, 
                   String dateOfBirth, String nationality, int size, int weight, 
                   int experienceYears, String role) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight);
        this.experienceYears = experienceYears;
        this.role = role;
    }
}


public class Viewer extends Person {
    private Team supportTeam;

    // Constructor
    public Viewer(String commonName, String firstName, String surname, String placeOfBirth, 
                  String dateOfBirth, String nationality, int size, int weight, Team supportTeam) {
        super(commonName, firstName, surname, placeOfBirth, dateOfBirth, nationality, size, weight);
        this.supportTeam = supportTeam;
    }
}
