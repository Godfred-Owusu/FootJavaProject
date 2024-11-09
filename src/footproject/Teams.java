    package footproject;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    public class Teams {
        private String teamName;
        private String homeStadium;
        private Coach coach;
        private List<Player> players;
        private int totalGoals;
        private int matchesPlayed;
        private int wins;
        private int draws;
        private int losses;
        private int points;

        // Constructor
        public Teams(String teamName, String homeStadium, Coach coach) {
            this.teamName = teamName;
            this.homeStadium = homeStadium;
            this.coach = coach;
            this.players = new ArrayList<>();
            this.totalGoals = 0;
            this.points = 0;
            this.matchesPlayed = 0;
            this.wins = 0;
            this.losses = 0;
            this.draws = 0;

            System.out.println("Team constructor called for: " + teamName);
        }

         public Teams(String teamName, String homeStadium, Coach coach, List<Player> players, int totalGoals, int matchesPlayed, int wins, int draws, int losses, int points) {
            this.teamName = teamName;
            this.homeStadium = homeStadium;
            this.coach = coach;
            this.players = players;
            this.totalGoals = totalGoals;
            this.matchesPlayed = matchesPlayed;
            this.wins = wins;
            this.draws = draws;
            this.losses = losses;
            this.points = points;
        }

         // Ajoute un joueur à l'équipe
        public void addPlayer(Player player) {
            players.add(player);
        }

         // Méthode pour enregistrer l'équipe et les joueurs dans un fichier texte
        public void saveTeamToFile(String filename) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                // Informations de base de l'équipe
                writer.write("Team Name: " + teamName);
                writer.newLine();
                writer.write("Home Stadium: " + homeStadium);
                writer.newLine();

                // Informations de l'entraîneur
                writer.write("Coach: " + coach.getCommonName());
                writer.newLine();
                writer.write("Nationality: " + coach.getNationality());
                writer.newLine();
                writer.write("Experience: " + coach.getExperienceYears() + " years");
                writer.newLine();
                writer.write("Yellow Cards: " + coach.getYellowCards());
                writer.newLine();
                writer.write("Red Cards: " + coach.getRedCards());
                writer.newLine();

                // Statistiques de l'équipe
                writer.write("Total Goals: " + totalGoals);
                writer.newLine();
                writer.write("Matches Played: " + matchesPlayed);
                writer.newLine();
                writer.write("Wins: " + wins);
                writer.newLine();
                writer.write("Draws: " + draws);
                writer.newLine();
                writer.write("Losses: " + losses);
                writer.newLine();
                writer.write("Points: " + points);
                writer.newLine();

                // Informations sur les joueurs
                for (Player player : players) {
                    writer.newLine();  // Ligne vide entre chaque joueur
                    writer.write("Player:");
                    writer.newLine();
                    writer.write("  Name: " + player.getCommonName());
                    writer.newLine();
                    writer.write("  Position: " + player.getPosition());
                    writer.newLine();
                    writer.write("  Number: " + player.getPlayerNumber());
                    writer.newLine();
                    writer.write("  Sponsor: " + player.getSponsor());
                    writer.newLine();
                    writer.write("  Nationality: " + player.getNationality());
                    writer.newLine();
                    writer.write("  Goals: " + player.getGoalsScored());
                    writer.newLine();
                    writer.write("  Assists: " + player.getAssists());
                    writer.newLine();
                    writer.write("  Yellow Cards: " + player.getYellowCards());
                    writer.newLine();
                    writer.write("  Red Cards: " + player.getRedCards());
                    writer.newLine();
                    writer.write("  Injured: " + (player.isInjured() ? "Yes" : "No"));
                }

            } catch (IOException e) {
                System.err.println("Erreur lors de l'enregistrement de l'équipe dans le fichier : " + e.getMessage());
            }
        }


            public void loadTeamFromFile(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                String teamName = "", homeStadium = "";
                String coachName = "", coachFirstName = "", coachNationality = "";
                int coachExperience = 0;
                int totalGoals = 0, matchesPlayed = 0, wins = 0, draws = 0, losses = 0, points = 0;

                while ((line = br.readLine()) != null) {
                    line = line.trim();

                    // Lire les informations de l'équipe
                    if (line.startsWith("Team Name:")) {
                        teamName = line.substring(line.indexOf(":") + 1).trim();
                    } else if (line.startsWith("Home Stadium:")) {
                        homeStadium = line.substring(line.indexOf(":") + 1).trim();
                    } else if (line.startsWith("Coach:")) {
                        String fullName = line.substring(line.indexOf(":") + 1).trim();
                        String[] nameParts = fullName.split(" ");
                        coachFirstName = nameParts[0];
                        coachName = nameParts[1];
                    } else if (line.startsWith("Nationality:")) {
                        coachNationality = line.substring(line.indexOf(":") + 1).trim();
                    } else if (line.startsWith("Experience:")) {
                        coachExperience = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim().replace(" years", ""));
                    } else if (line.startsWith("Total Goals:")) {
                        totalGoals = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                    } else if (line.startsWith("Matches Played:")) {
                        matchesPlayed = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                    } else if (line.startsWith("Wins:")) {
                        wins = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                    } else if (line.startsWith("Draws:")) {
                        draws = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                    } else if (line.startsWith("Losses:")) {
                        losses = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                    } else if (line.startsWith("Points:")) {
                        points = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());

                    // Lire les informations des joueurs
                    } else if (line.startsWith("Player:")) {
                        Player player = parsePlayer(br);
                        players.add(player);  // Ajouter le joueur à la liste des joueurs
                    }
                }

                // Initialiser l'entraîneur et l'équipe
                //this.coach = new Coach(coachName, coachFirstName, coachNationality, coachExperience, Teams);
                this.teamName = teamName;
                this.homeStadium = homeStadium;
                this.totalGoals = totalGoals;
                this.matchesPlayed = matchesPlayed;
                this.wins = wins;
                this.draws = draws;
                this.losses = losses;
                this.points = points;

            } catch (IOException e) {
                System.err.println("Erreur de lecture du fichier : " + e.getMessage());
            }
        }

        private Player parsePlayer(BufferedReader br) throws IOException {
            String line;
            String commonName = "", firstName = "", surname = "", nationality = "";
            String sponsor = "", position = "";
            int playerNumber = 0, goalsScored = 0, assists = 0, yellowCards = 0, redCards = 0;
            boolean injured = false;

            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                line = line.trim();

                if (line.startsWith("Name:")) {
                    String fullName = line.substring(line.indexOf(":") + 1).trim();
                    String[] nameParts = fullName.split(" ");
                    commonName = nameParts[0];
                    firstName = nameParts[1];
                    surname = nameParts[2];
                } else if (line.startsWith("Position:")) {
                    position = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Number:")) {
                    playerNumber = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Sponsor:")) {
                    sponsor = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Nationality:")) {
                    nationality = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Goals:")) {
                    goalsScored = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Assists:")) {
                    assists = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Yellow Cards:")) {
                    yellowCards = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Red Cards:")) {
                    redCards = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Injured:")) {
                    injured = line.substring(line.indexOf(":") + 1).trim().equalsIgnoreCase("Yes");
                }
            }

            // Créer un objet Player avec les informations extraites
            Player player = new Player(commonName, firstName, surname, nationality, sponsor, position, playerNumber);
            player.setGoalsScored(goalsScored);
            player.setAssists(assists);
            player.setYellowCards(yellowCards);
            player.setRedCards(redCards);
            player.setInjured(injured);
            return player;
        }





        // Getters and Setters ...


        public String getTeamName() {
            return teamName;
        }

        public String getHomeStadium() {
            return homeStadium;
        }

        public Coach getCoach() {
            return coach;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public int getTotalGoals() {
            return totalGoals;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public int getWins() {
            return wins;
        }

        public int getDraws() {
            return draws;
        }

        public int getLosses() {
            return losses;
        }

        public int getPoints() {
            return points;
        }

        // Setters
        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public void setHomeStadium(String homeStadium) {
            this.homeStadium = homeStadium;
        }

        public void setCoach(Coach coach) {
            this.coach = coach;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setTotalGoals(int totalGoals) {
            this.totalGoals = totalGoals;
        }

        public void setMatchesPlayed(int matchesPlayed) {
            this.matchesPlayed = matchesPlayed;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }

        public void setPoints(int points) {
            this.points = points;
        }

    }
