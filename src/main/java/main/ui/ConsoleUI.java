package main.ui;

import team.model.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Interfaz de usuario para la aplicación de consola.
 * @author Andrés Fernández
 */
public class ConsoleUI {

    private final Scanner in = new Scanner(System.in);

    /**
     * Genera una representacion legible de los equipos que forman parte de la liga.
     * @return String que contiene los equipos y su puntuacion.
     */
    public String displayTeams (ArrayList<Team> teams) {
        String sRet = "Clasificacion: \n\n";
        for (Team team : teams) {
            sRet += team.toString() + ": " + team.getPoints() + " puntos\n";
        }
        return sRet;
    }

    /**
     * Muestra un mensaje por pantalla al usuario.
     * @param message Mensaje
     */
    public void display(String message) {
        System.out.println(message);
    }

    /**
     * Pide al usuario introducir un entero.
     * @param message Mensaje que se muestra por pantalla
     * @return Entero introducido por el usuario
     */
    public int requestInt(String message) {
        display(message);
        int rInt = Integer.parseInt(in.nextLine());
        return rInt;
    }

    /**
     * Pide al usuario introducir texto.
     * @param message Mensaje que se muestra por pantalla
     * @return Texto introducido por el usuario
     */
    public String requestString(String message) {
        String rStr = in.nextLine();
        return rStr;
    }

    /**
     * Muestra por pantalla la clasificacion.
     * @param teams Lista de equipos
     */
    public void showStandings(ArrayList<Team> teams) {

        display("Clasificacion:");

        teams.sort(Comparator.comparing(Team::getPoints).reversed());

        for (int i = 0; i < teams.size(); i++) {
            display((i+1) + ". " + teams.get(i).toString() + ": " + teams.get(i).getPoints() + " puntos");
        }
    }
}
