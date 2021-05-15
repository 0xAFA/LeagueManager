package main;

import main.ui.ConsoleUI;
import team.repository.TeamManager;
import team.repository.TeamMemoryRepository;

public class ConsoleApp {

    /**
     * Punto de inicio del programa, que crea una liga y carga su interfaz de usuario.
     * @param args Argumentos de consola, que no utilizamos.
     */
    public static void main(String[] args) {

        TeamMemoryRepository teams = new TeamMemoryRepository();
        TeamManager teamManager = new TeamManager(teams);

        ConsoleUI ui = new ConsoleUI();

        ui.display("Bienvenido a LeagueManager.");

        while (true) {
            ui.display("\nPor favor, seleccione una opcion.");
            ui.display("1. Crear equipos de forma aleatoria.");
            ui.display("2. Generar partidos de forma aleatoria.");
            ui.display("3. Ver la clasificacion.");
            int i = ui.requestInt("4. Salir.");

            int n;
            switch (i) {
                case 1:
                    n = ui.requestInt("Introduzca el numero de equipos a generar.");
                    teamManager.generateRandomTeams(n);
                    break;
                case 2:
                    n = ui.requestInt("Introduzca el numero de partidos a generar.");
                    teamManager.generateRandomMatches(n);
                    break;
                case 3:
                    if(teams.size() == 0) {
                        ui.display("Aun no se ha anadido ningun equipo a esta liga.");
                    } else {
                        ui.showStandings(teams.readAll());
                    }
                    break;
                case 4: System.exit(0);
                default:
                    ui.display("Opcion incorrecta. Por favor, intentelo de nuevo.");
            }
        }
    }
}
