
package footproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author methiss
 */
public class FootProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
        Matchs match = new Matchs(teamsList, "null");
        
        ligue1.printLeaderboard("Ligue1");


    }
    
}
    
