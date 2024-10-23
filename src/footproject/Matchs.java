package footproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Matchs {
    
    private List<Teams> teams;
    private String result;
     
    public Matchs(List<Teams> teams, String result){
        this.teams = teams;
        this.result = result;
        
        if(result.equals(teams.get(0).getTeamName())){
            updateClassement(teams.get(0), teams.get(1), false);  
        }
        else if(result.equals(teams.get(1).getTeamName())){
            updateClassement(teams.get(1), teams.get(0), false);  
        }
        else {
            updateClassement(teams.get(0), teams.get(1), true);  
        }
    }
    
    public void updateClassement(Teams gagnant, Teams perdant, boolean isDraw) {
        String filePath = "Ligue1";  
        List<String[]> teamsData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] teamData = line.split(",");
                teamsData.add(teamData);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        for (String[] teamData : teamsData) {
            if (teamData[0].equals(gagnant.getTeamName())) {
                if(isDraw){
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[5] = String.valueOf(Integer.parseInt(teamData[5]) + 1);  // +1 nul
                    teamData[7] = String.valueOf(Integer.parseInt(teamData[7]) + 1);  // +1 point
                } else {
                    
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[4] = String.valueOf(Integer.parseInt(teamData[4]) + 1);  // +1 win
                    teamData[7] = String.valueOf(Integer.parseInt(teamData[7]) + 3);  // +3 points
                }
            }
            else if (teamData[0].equals(perdant.getTeamName())) {
                if (isDraw) {
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[5] = String.valueOf(Integer.parseInt(teamData[5]) + 1);  // +1 nul
                    teamData[7] = String.valueOf(Integer.parseInt(teamData[7]) + 1);  // +1 point pour les deux équipes
                } else {
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[6] = String.valueOf(Integer.parseInt(teamData[6]) + 1);  // +1 défaite
                }
            }
        }

        // Réécrire le fichier avec les nouvelles données
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + ".txt"))) {
            for (String[] teamData : teamsData) {
                writer.write(String.join(",", teamData));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
