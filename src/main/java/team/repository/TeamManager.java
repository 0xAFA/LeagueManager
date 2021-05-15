package team.repository;

import match.model.Match;
import team.model.Team;

import java.util.ArrayList;
import java.util.Random;

public class TeamManager {

    private final TeamRepository teams;

    public TeamManager(TeamRepository teams) {
        this.teams = teams;
    }

    /**
     * Devuelve el vector de equipos que participan en la liga.
     * @return Equipos
     */
    public ArrayList<Team> getTeams() {
        return teams.readAll();
    }


    /**
     * Crea n equipos con nombres aleatorios, y con una plantilla completa también aleatoria.
     * @param n Número de equipos a crear.
     */
    public void generateRandomTeams (int n) {

        int teamSize = 21;

        Random random = new Random();

        String[] prefixes = {"C.F.", "Deportivo de", "Union Deportiva", "F.C.", "Gimnastica de", "Real"};

        // Lista de las 50 ciudades más pobladas de España (fuente: INE)
        String[] cities = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza", "Malaga", "Las Palmas",
                "Bilbao", "Murcia", "Valladolid", "Cordoba", "Mallorca", "Vigo", "Alicante", "Gijon",
                "Hospitalet", "Granada", "La Coruna", "Vitoria", "Badalona", "Tenerife", "Oviedo", "Mostoles",
                "Elche", "Sabadell", "Santander", "Jerez", "San Sebastian", "Leganes", "Almeria",
                "Cartagena", "Tarrasa", "Alcala", "Fuenlabrada", "Pamplona", "Burgos", "Salamanca",
                "Albacete", "Leon", "Getafe", "Alcorcon", "Cadiz", "Huelva", "Castellon", "Badajoz", "Logrono",
                "Santa Coloma", "La Laguna", "Lleida", "Tarragona"};

        int prefLen = prefixes.length;
        int citiesLen = cities.length;

        for (int i = 0; i < n; i++) {
            String teamName = prefixes[random.nextInt(prefLen)] + " " + cities[random.nextInt(citiesLen)] +
                    " " + (1890 + random.nextInt(100));
            Team team = new Team(teamName);
            team.generateRandomPlayers(teamSize);
            addTeam(team);
        }
    }

    /**
     * Crea n partidos entre los equipos de la liga, con participantes y resultado aleatorios.
     * @param n Numero de equipos a crear.
     */
    public void generateRandomMatches (int n) {

        Random random = new Random();
        int teamsLen = teams.size();

        if (teamsLen <= 1) {
            System.out.println("No hay suficientes equipos. Volviendo al menu principal.");
            return;
        }

        for (int i = 1; i<=n; i++) {
            // Escoger dos equipos, asegurando que sean diferentes.
            Team team1, team2;
            do {
                team1 = teams.getRandom();
                team2 = teams.getRandom();
            } while (team1.getName().equals(team2.getName()));

            // Generar el partido, con un número de goles aleatorio para cada equipo.
            Match match = new Match(team1, team2,
                    random.nextInt(5), random.nextInt(5), false);
        }
    }


    public boolean addTeam (Team team) {
        boolean bRes=false;
        if(!teams.exists(team.getName())){
            teams.add(team);
            bRes=true;
        }
        return bRes;
    }

    public void remove(Team team) {
        remove(team.getName());
    }

    public void remove(String titulo) {
        boolean bRes = false;
        if (teams.exists(titulo)) {
            teams.remove(titulo);
            bRes = true;
        }
    }

    public ArrayList<Team> readAll(){
        return teams.readAll();
    }
}
