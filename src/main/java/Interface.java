import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Interfaz por pantalla.
 * @author Andrés Fernández
 */
public class Interface {

    private final Scanner in;

    /**
     * Constructor que crea un Scanner.
     */
    public Interface() {
        in = new Scanner(System.in);
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
    public void showStandings(Vector<Team> teams) {

        display("Clasificacion:");

        teams.sort(Comparator.comparing(Team::getPoints).reversed());

        for (int i = 0; i < teams.size(); i++) {
            display((i+1) + ". " + teams.get(i).toString() + ": " + teams.get(i).getPoints() + " puntos");

        }

    }

}