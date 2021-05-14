import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * Programa que crea y administra una liga de futbol.
 * @author Andrés Fernández
 */
public class League {

    private Vector<Team> teams = new Vector<>();
    private Vector<Match> matchHistory = new Vector<>();
    private String name;
    private Interface ui;

    public League(String name) {
        this.name = name;
    }

    /**
     * Devuelve el nombre de la liga.
     * @return Nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve el vector de equipos que participan en la liga.
     * @return Equipos
     */
    public Vector<Team> getTeams() {
        return teams;
    }

    /**
     * Añade un equipo a la liga.
     * @param team Equipo.
     */
    public void addTeam (Team team) {
        teams.add(team);
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
            int team1index, team2index;
            do {
                team1index = random.nextInt(teamsLen);
                team2index = random.nextInt(teamsLen);
            } while (team1index == team2index);

            // Generar el partido, con un número de goles aleatorio para cada equipo,
            // y añadirlo a la liga.
            Match match = new Match(teams.get(team1index), teams.get(team2index),
                    random.nextInt(5), random.nextInt(5), false);
            matchHistory.add(match);
        }
    }

    /**
     * Genera una representacion legible de los equipos que forman parte de la liga.
     * @return String que contiene los equipos y su puntuacion.
     */
    public String displayTeams () {
        String sRet = "Clasificacion: \n\n";
        for (Team team : teams) {
            sRet += team.toString() + ": " + team.getPoints() + " puntos\n";
        }
        return sRet;
    }

    /**
     * Funcion principal del programa, que implementa la interaccion con el usuario.
     */
    public void runLeague() {

        while (true) {
            Interface ui = new Interface();
            ui.display("\nPor favor, seleccione una opcion.");
            ui.display("1. Crear equipos de forma aleatoria.");
            ui.display("2. Generar partidos de forma aleatoria.");
            ui.display("3. Ver la clasificacion.");
            int i = ui.requestInt("4. Salir.");

            int n;
            switch (i) {
                case 1:
                    n = ui.requestInt("Introduzca el numero de equipos a generar.");
                    generateRandomTeams(n);
                    break;
                case 2:
                    n = ui.requestInt("Introduzca el numero de partidos a generar.");
                    generateRandomMatches(n);
                    break;
                case 3:
                    if(teams.size() == 0) {
                        ui.display("Aun no se ha anadido ningun equipo a esta liga.");
                    } else {
                    if(matchHistory.size() == 0) ui.display("Aun no se ha jugado ningun partido en esta liga.");
                    ui.showStandings(teams);
                    }
                    break;
                case 4: System.exit(0);
                default:
                    ui.display("Opcion incorrecta. Por favor, intentelo de nuevo.");
            }
        }

    }
}