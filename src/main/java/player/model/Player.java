package player.model;

import java.io.Serial;
import java.io.Serializable;

/**
 * Clase abstracta que representa a un futbolista.
 * @author Andrés Fernández
 */
public abstract class Player implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;
    protected String name;
    protected int number;
    protected String position;

    /**
     * Constructor que crea un jugador con su nombre, dorsal y posicion.
     * @param name Nombre
     * @param number Dorsal
     * @param position Posicion
     */
    protected Player(String name, int number, String position) {
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public String getPosition() {
        return this.position;
    }

}