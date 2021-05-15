package main;

import team.model.Team;

import java.util.Comparator;
import java.util.Scanner;
//import java.util.Vector;
//
//public class ConsoleApp {
//
//    /**
//     * Punto de inicio del programa, que crea una liga y carga su interfaz de usuario.
//     * @param args Argumentos de consola, que no utilizamos.
//     */
//    public static void main(String[] args) {
//
//        ui = new Interface();
//        ui.display("Bienvenido a LeagueManager.");
//
//        League demoLeague = new League("Liga de demostracion");
//        addLeague(demoLeague);
//        demoLeague.runLeague();
//    }
//
//    /**
//     * Funcion principal del programa, que implementa la interaccion con el usuario.
//     */
//    public void runLeague() {
//
//        while (true) {
//            Interface ui = new Interface();
//            ui.display("\nPor favor, seleccione una opcion.");
//            ui.display("1. Crear equipos de forma aleatoria.");
//            ui.display("2. Generar partidos de forma aleatoria.");
//            ui.display("3. Ver la clasificacion.");
//            int i = ui.requestInt("4. Salir.");
//
//            int n;
//            switch (i) {
//                case 1:
//                    n = ui.requestInt("Introduzca el numero de equipos a generar.");
//                    generateRandomTeams(n);
//                    break;
//                case 2:
//                    n = ui.requestInt("Introduzca el numero de partidos a generar.");
//                    generateRandomMatches(n);
//                    break;
//                case 3:
//                    if(teams.size() == 0) {
//                        ui.display("Aun no se ha anadido ningun equipo a esta liga.");
//                    } else {
//                        if(matchHistory.size() == 0) ui.display("Aun no se ha jugado ningun partido en esta liga.");
//                        ui.showStandings(teams);
//                    }
//                    break;
//                case 4: System.exit(0);
//                default:
//                    ui.display("Opcion incorrecta. Por favor, intentelo de nuevo.");
//            }
//        }
//
//    }
//}
//
///**
// * Interfaz por pantalla.
// * @author Andrés Fernández
// */
//public class Interface {
//
//    private final Scanner in;
//
//
//    /**
//     * Genera una representacion legible de los equipos que forman parte de la liga.
//     * @return String que contiene los equipos y su puntuacion.
//     */
//    public String displayTeams () {
//        String sRet = "Clasificacion: \n\n";
//        for (Team team : teams) {
//            sRet += team.toString() + ": " + team.getPoints() + " puntos\n";
//        }
//        return sRet;
//    }
//
//    /**
//     * Constructor que crea un Scanner.
//     */
//    public Interface() {
//        in = new Scanner(System.in);
//    }
//
//    /**
//     * Muestra un mensaje por pantalla al usuario.
//     * @param message Mensaje
//     */
//    public void display(String message) {
//        System.out.println(message);
//    }
//
//    /**
//     * Pide al usuario introducir un entero.
//     * @param message Mensaje que se muestra por pantalla
//     * @return Entero introducido por el usuario
//     */
//    public int requestInt(String message) {
//        display(message);
//        int rInt = Integer.parseInt(in.nextLine());
//        return rInt;
//    }
//
//    /**
//     * Pide al usuario introducir texto.
//     * @param message Mensaje que se muestra por pantalla
//     * @return Texto introducido por el usuario
//     */
//    public String requestString(String message) {
//        String rStr = in.nextLine();
//        return rStr;
//    }
//
//    /**
//     * Muestra por pantalla la clasificacion.
//     * @param teams Lista de equipos
//     */
//    public void showStandings(Vector<Team> teams) {
//
//        display("Clasificacion:");
//
//        teams.sort(Comparator.comparing(Team::getPoints).reversed());
//
//        for (int i = 0; i < teams.size(); i++) {
//            display((i+1) + ". " + teams.get(i).toString() + ": " + teams.get(i).getPoints() + " puntos");
//
//        }
//
//    }
//
//}
