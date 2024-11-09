package footproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class FootProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/Ligue1.txt";
        System.out.println("Le fichier sera enregistré ici : " + filePath);

        Competition ligue1 = new Competition();
        ligue1.printLeaderboard("Ligue1");

        // Création et ajout des équipes et des coachs
        Coach coachCity = new Coach("Guardiola", "Pep", "Spanish", 20, null);
        Teams teamCity = new Teams("Manchester City", "Etihad Stadium", coachCity);
        
        Coach coachLille = new Coach("Génésio", "Bruno", "French", 15, null);
        Teams teamLille = new Teams("Lille", "Stade Pierre-Mauroy", coachLille);
        
        // Ajout des joueurs à l'équipe de Manchester City
        teamCity.addPlayer(new Player("Haaland", "Erling", "Braut", "Norwegian", "Nike", "Forward", 9));
        teamCity.addPlayer(new Player("De Bruyne", "Kevin", "De Bruyne", "Belgian", "Adidas", "Midfielder", 17));

        // Ajout des joueurs à l'équipe de Lille
        teamLille.addPlayer(new Player("David", "Jonathan", "David", "Canadian", "Puma", "Forward", 9));
        
        // Enregistrement des équipes dans des fichiers texte
        teamCity.saveTeamToFile(currentDir + "/Manchester_City.txt");
        teamLille.saveTeamToFile(currentDir + "/Lille.txt");


         // Get user input
        System.out.print("Entrez le nom de votre équipe: ");
        String userTeamName = scanner.nextLine().trim();
        
        System.out.print("Entrez le nom de l'équipe adverse: ");
        String opponentTeamName = scanner.nextLine().trim();

        // Vérifier si les fichiers des équipes existent
        if (!teamFileExists(userTeamName, currentDir)) {
            System.out.println("L'équipe " + userTeamName + " n'existe pas.");
            return; // Sortir du programme ou gérer autrement
        }

        if (!teamFileExists(opponentTeamName, currentDir)) {
            System.out.println("L'équipe " + opponentTeamName + " n'existe pas.");
            return; // Sortir du programme ou gérer autrement
        }

     
        
        // Créer et gérer le résultat du match
        Teams userTeam = new Teams(userTeamName, "", null); 
        Teams opponentTeam = new Teams(opponentTeamName, "", null);
        new Matchs(userTeam, opponentTeam);

        // Imprimer le classement après le match
        ligue1.printLeaderboard("Ligue1");

        scanner.close();
    }

    private static boolean teamFileExists(String teamName, String directory) {
        // Créez le nom de fichier basé sur le nom de l'équipe
            String fileName = teamName.replace(" ", "_") + ".txt";
            File teamFile = new File(directory, fileName);
            return teamFile.exists(); // Vérifie si le fichier existe
    }
}
