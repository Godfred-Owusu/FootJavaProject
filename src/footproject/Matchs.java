package footproject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matchs {
    private Teams userTeam;
    private Teams opponentTeam;
    private int userScore;
    private int opponentScore;
    private Random random = new Random();

    public Matchs(Teams userTeam, Teams opponentTeam) {
        this.userTeam = userTeam;
        this.opponentTeam = opponentTeam;
        this.userScore = generateRealisticScore();
        this.opponentScore = generateRealisticScore();

        System.out.println("Your team scored: " + userScore);
        System.out.println("Opponent team scored: " + opponentScore);

        if (userScore > opponentScore) {
            System.out.println("Your team " + userTeam.getTeamName() + " won!");
            updateClassement(userTeam, opponentTeam, false);  // User's team wins
        } else if (userScore < opponentScore) {
            System.out.println("Opponent team " + opponentTeam.getTeamName() + " won!");
            updateClassement(opponentTeam, userTeam, false);  // Opponent's team wins
        } else {
            System.out.println("It's a draw!");
            updateClassement(userTeam, opponentTeam, true);  // Draw
        }
    }

    private int generateRealisticScore() {
        double lambda = 1.5;  // Moyenne de buts par équipe
        double l = Math.exp(-lambda);
        int k = 0;
        double p = 1.0;

        do {
            k++;
            p *= random.nextDouble();
        } while (p > l);

        return k - 1;
    }
    
    public void updateClassement(Teams winner, Teams loser, boolean isDraw) {
        String filePath = "Ligue1.txt";  
        List<String[]> teamsData = new ArrayList<>();

        // Charger les données existantes depuis le fichier
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] teamData = line.split(",");
                if (teamData.length == 8) {  // Vérifie que chaque ligne a le bon nombre de colonnes
                    teamsData.add(teamData);
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Ajout d'équipes si elles n'existent pas
        if (findTeam(teamsData, winner.getTeamName()) == null) {
            teamsData.add(new String[]{winner.getTeamName(), "0", "0", "0", "0", "0", "0", "0"});
        }
        if (findTeam(teamsData, loser.getTeamName()) == null) {
            teamsData.add(new String[]{loser.getTeamName(), "0", "0", "0", "0", "0", "0", "0"});
        }

        // Mise à jour des statistiques
        for (String[] teamData : teamsData) {
            if (teamData[0].equals(winner.getTeamName())) {
                if (isDraw) {
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[5] = String.valueOf(Integer.parseInt(teamData[5]) + 1);  // +1 nul
                    teamData[7] = String.valueOf(Integer.parseInt(teamData[7]) + 1);  // +1 point
                } else {
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[4] = String.valueOf(Integer.parseInt(teamData[4]) + 1);  // +1 victoire
                    teamData[7] = String.valueOf(Integer.parseInt(teamData[7]) + 3);  // +3 points
                }
            } else if (teamData[0].equals(loser.getTeamName())) {
                if (isDraw) {
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[5] = String.valueOf(Integer.parseInt(teamData[5]) + 1);  // +1 nul
                    teamData[7] = String.valueOf(Integer.parseInt(teamData[7]) + 1);  // +1 point
                } else {
                    teamData[3] = String.valueOf(Integer.parseInt(teamData[3]) + 1);  // +1 match
                    teamData[6] = String.valueOf(Integer.parseInt(teamData[6]) + 1);  // +1 défaite
                }
            }
        }

        // Écriture des données mises à jour dans le fichier
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] teamData : teamsData) {
                writer.write(String.join(",", teamData));
                writer.newLine();
            }
            System.out.println("Successfully written updated data to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        String currentDir = System.getProperty("user.dir");

        // Mise à jour des fichiers des équipes
        /*
        // Mise à jour des fichiers des équipes avec leurs nouvelles statistiques
        winner.saveTeamToFile(currentDir + "/" + winner.getTeamName() + ".txt");
        loser.saveTeamToFile(currentDir + "/" + loser.getTeamName() + ".txt");
        */
    }
    
    

    // Méthode pour trouver une équipe dans la liste des données
    private String[] findTeam(List<String[]> teamsData, String teamName) {
        for (String[] team : teamsData) {
            if (team[0].equals(teamName)) {
                return team;
            }
        }
        return null;  // retourne null si l'équipe n'est pas trouvée
    }
}
