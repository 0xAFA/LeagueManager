package team.model;

import player.model.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

/**
 * Clase que representa un equipo de futbol.
 * @author Andrés Fernández
 */
public class Team implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Vector<Player> players = new Vector<>();
    private int points = 0;

    public String getName() {
        return name;
    }

    public Vector<Player> getPlayers() {
        return players;
    }

    /**
     * Añade un jugador al equipo.
     * @param player Jugador a añadir.
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Elimina un jugador del equipo.
     * @param player Jugador que va a ser eliminado.
     */
    public void removePlayer (Player player) {
        if (players.contains(player)) players.remove(player);
    }

    /**
     * Elimina un jugador del equipo.
     * @param playerName Nombre del jugador que va a ser eliminado.
     */
    public void removePlayer (String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                players.remove(player);
                break;
            }
        }
    }

    /**
     * Devuelve los puntos que el equipo ha conseguido en la liga.
     * @return Puntos.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Suma puntos a un equipo.
     * @param newPoints Puntos a anadir.
     */
    public void addPoints(int newPoints) {
        this.points += newPoints;
    }

    /**
     * Crea un conjunto de jugadores con nombre y numero aleatorios y los agrega al equipo.
     * @param n
     */
    public void generateRandomPlayers (int n) {

        String[] names = {"Antonio", "Manuel", "Jose", "Francisco", "David", "Juan", "Jose Antonio", "Javier",
                "Daniel", "Jose Luis", "Francisco Javier", "Carlos", "Jesus", "Alejandro", "Miguel",
                "Jose Manuel", "Rafael", "Miguel Angel", "Pedro", "Pablo", "Angel", "Sergio", "Jose Maria",
                "Fernando", "Jorge", "Luis", "Alberto", "Juan Carlos", "Alvaro", "Adrian", "Juan Jose",
                "Diego", "Raul", "Ivan", "Juan Antonio", "Ruben", "Enrique", "Oscar", "Ramon", "Vicente",
                "Andres", "Juan Manuel", "Joaquin", "Santiago", "Victor", "Eduardo", "Mario", "Roberto",
                "Jaime", "Francisco Jose"};

        String[] surnames = {"Garcia", "Rodriguez", "Gonzalez", "Fernandez", "Lopez", "Martinez", "Sanchez",
                "Perez", "Gomez", "Martin", "Jimenez", "Ruiz", "Hernandez", "Diaz", "Moreno", "Muñoz", "Alvarez",
                "Romero", "Alonso", "Gutierrez", "Navarro", "Torres", "Dominguez", "Vazquez", "Ramos", "Gil",
                "Ramirez", "Serrano", "Blanco", "Molina", "Morales", "Suarez", "Ortega", "Delgado", "Castro",
                "Ortiz", "Marin", "Rubio", "Sanz", "Nuñez", "Medina", "Iglesias", "Cortes", "Castillo", "Garrido",
                "Santos", "Lozano", "Guerrero", "Cano", "Prieto"};

        Random random = new Random();

        for (int i = 1; i <= n; i++) {
            String playerName = names[random.nextInt(n)] + " " + surnames[random.nextInt(n)];
            switch(random.nextInt(3)) {
                case 0 -> addPlayer(new Goalkeeper(playerName, i));
                case 1 -> addPlayer(new Defender(playerName, i));
                case 2 -> addPlayer(new Midfielder(playerName, i));
                case 3 -> addPlayer(new Striker(playerName, i));
            }

        }
    }

    /**
     * Constructor que crea un equipo vacio.
     * @param name Nombre del equipo.
     */
    public Team (String name) {
        this.name = name;
    }

    /**
     * Constructor que crea un equipo y le asigna jugadores.
     * @param name Nombre del equipo.
     * @param players Jugadores iniciales.
     */
    public Team (String name, Vector<Player> players) {
        this.name = name;
        this.players = players;
    }

    /**
     * Devuelve una representacion legible del equipo, que coincide con su nombre.
     * @return Nombre del equipo.
     */
    public String toString() {
        return this.getName();
    }

}
