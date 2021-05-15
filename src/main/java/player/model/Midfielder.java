package player.model;

/**
 * Clase que representa un delantero.
 * @author Andrés Fernández
 */
public class Midfielder extends Player {

    /**
     * Constructor que crea un delantero a partir de su nombre y su dorsal.
     * @param name Nombre
     * @param number Dorsal
     */
    public Midfielder (String name, int number) {
        super(name, number, "CEN");
    }

}