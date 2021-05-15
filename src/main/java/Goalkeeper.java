/**
 * Clase que representa un delantero.
 * @author Andrés Fernández
 */
public class Goalkeeper extends Player {

    /**
     * Constructor que crea un delantero a partir de su nombre y su dorsal.
     * @param name Nombre
     * @param number Dorsal
     */
    public Goalkeeper(String name, int number) {
        super(name, number, "POR");
    }

}