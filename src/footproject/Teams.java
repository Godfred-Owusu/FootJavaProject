
package footproject;

/**
 * @author methiss
 */

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teams {
    private String teamName;
    private String homeStadium;
    //private Coach coach;
    //private List<Player> players;
    private int totalGoals;
    private int matchesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int points;


    // Constructor
    public Teams(String teamName, String homeStadium) {
        this.teamName = teamName;
        this.homeStadium = homeStadium;
        //this.coach = coach;
        //this.players = new ArrayList<>();
        this.totalGoals = 0;
        this.points = 0;
        this.matchesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        
        if (!teamExistsInFile("Ligue1")) {
            // If the team doesn't exist, save it to the file
            saveTeamToFile("Ligue1");
        } else {
            System.out.println("Team " + teamName + " already exists in the file.");
        }
    }
    /*
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }
    */
    public void updatePoints(int points) {
        this.points += points;
    }

    public void updateGoals(int goals) {
        this.totalGoals += goals;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHomeStadium() {
        return homeStadium;
    }

    public void setHomeStadium(String homeStadium) {
        this.homeStadium = homeStadium;
    }
    /*
    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Player> getPlayers() {
        return players;
    }
    */
    public int getTotalGoals() {
        return totalGoals;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }
    
    
    private void saveTeamToFile(String Filepath) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Filepath+".txt", true))) {
            writer.write(teamName + "," + homeStadium + "," + totalGoals + "," + matchesPlayed + "," + wins + "," + draws + "," + losses + "," + points);
            writer.newLine();
            System.out.println("Team " + teamName + " saved to file.");
            
        } catch (IOException e) {
            System.out.println("Error saving team to file: " + e.getMessage());
        }
    }
    
    private boolean teamExistsInFile(String Filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Filepath+".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] teamData = line.split(",");
                if (teamData[0].equals(teamName)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false; 
    }

}
