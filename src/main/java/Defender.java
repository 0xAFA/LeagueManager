/**
 * Clase que representa un delantero.
 * @author Andrés Fernández
 */
public class Defender extends Player {

    /**
     * Constructor que crea un delantero a partir de su nombre y su dorsal.
     * @param name Nombre
     * @param number Dorsal
     */
    public Defender (String name, int number) {
        super(name, number, "DEF");
    }

}