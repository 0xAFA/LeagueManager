/**
 * Clase que representa un delantero.
 * @author Andrés Fernández
 */
public class Striker extends Player {

    /**
     * Constructor que crea un delantero a partir de su nombre y su dorsal.
     * @param name Nombre
     * @param number Dorsal
     */
    public Striker(String name, int number) {
        super(name, number, "DEL");
    }

}