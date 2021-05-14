import java.util.Vector;

/**
 * Clase principal del programa.
 * @author Andrés Fernández
 */
public class LeagueManager {

    private static Vector<League> leagues = new Vector<>();
    private static Interface ui;

    /**
     * Crea una liga con un nombre dado y la anade al programa.
     * @param name Nombre de la liga.
     */
    public static void addLeague(String name) {
        leagues.add(new League(name));
    }

    /**
     * Anade una liga al programa.
     * @param league Liga
     */
    public static void addLeague(League league) {
        leagues.add(league);
    }

    /**
     * Recupera una liga a partir de su nombre.
     * @param name Nombre
     * @return Liga; o null si no se encuentra
     */
    public static League getLeague(String name) {
        League lRet = null;
        for (League league : leagues) {
            if(league.getName().equals(name)) {
                lRet = league;
                break;
            }
        }
        return lRet;
    }

    /**
     * Punto de inicio del programa, que crea una liga y carga su interfaz de usuario.
     * @param args Argumentos de consola, que no utilizamos.
     */
    public static void main(String[] args) {

        ui = new Interface();
        ui.display("Bienvenido a LeagueManager.");

        League demoLeague = new League("Liga de demostracion");
        addLeague(demoLeague);
        demoLeague.runLeague();
    }

}