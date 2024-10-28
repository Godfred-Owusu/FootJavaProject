
package footproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author methiss
 */
public class FootProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        // TODO code application logic here  FOOT PROJECT
        
        String currentDir = System.getProperty("user.dir"); // Répertoire courant
        String filePath = currentDir + "/Ligue1.txt";

        System.out.println("Le fichier sera enregistré ici : " + filePath);
                
        Teams Lyon = new Teams("Lyon", "Groupama Statium");
        Teams Lille = new Teams("Losc", "Pierre Mauroy");
        
        Competition ligue1 = new Competition();
        
        ligue1.printLeaderboard("Ligue1");
        
          
        List<Teams> teamsList = new ArrayList<>();
        teamsList.add(Lyon);
        teamsList.add(Lille);
        
        
//        code here
 

        // Get user input
        System.out.print("Enter your team name: ");
        String userTeamName = scanner.nextLine();

        System.out.print("Enter your home stadium: ");
        String userStadium = scanner.nextLine();

        System.out.print("Enter opponent team name: ");
        String opponentTeamName = scanner.nextLine();

        System.out.print("Enter opponent's home stadium: ");
        String opponentStadium = scanner.nextLine();

        System.out.print("Enter the number of goals you want to score: ");
        int userScore = scanner.nextInt();

        // Initialize teams
        Teams userTeam = new Teams(userTeamName, userStadium);
        Teams opponentTeam = new Teams(opponentTeamName, opponentStadium);

        // Create and handle match result
        new Matchs(userTeam, opponentTeam, userScore);

        scanner.close();
    
//        Matchs match = new Matchs(teamsList, "Lyon");
        
        ligue1.printLeaderboard("Ligue1");


    }
    
}
    
