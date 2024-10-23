    package footproject;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Comparator;


    public class Competition {

        private String name;
        private String localisation;

        List<Teams> Leaderboard;

        public void printLeaderboard(String filePath) {

            List<String[]> teamsList = new ArrayList<>(); // Liste pour stocker les données des équipes

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath + ".txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] teamStats = line.split(",");
                    teamsList.add(teamStats);  
                }

                teamsList.sort(Comparator.comparingInt((String[] team) -> Integer.parseInt(team[7])).reversed());


                System.out.println("\nClassement de la " + filePath);
                System.out.printf("%-5s %-20s %-10s %-10s %-10s %-10s\n", "", "Équipe", "Victoire", "Nul", "Défaite", "Points"); // Titres alignés

                int place = 1;

                for (String[] teamStats : teamsList) {
                    System.out.printf("%-5d %-20s %-10s %-10s %-10s %-10s\n", 
                                   place, teamStats[0], teamStats[4], teamStats[5], teamStats[6], teamStats[7]);

                    place++;
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
