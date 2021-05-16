package team.repository;

import team.model.Team;

import java.util.ArrayList;

/**
 * Interfaz que define la funcionalidad que debe tener un repositorio de equipo.
 */
public interface TeamRepository {

    /**
     * Añade un equipo al repositorio.
     * @param team Equipo.
     */
    void add(Team team);

    /**
     * Comprueba si un equipo existe.
     * @param nombre Nombre del equipo.
     * @return true si el equipo está en el repositorio, false si no.
     */
    boolean exists(String nombre);

    /**
     * Devuelve un equipo con un nombre dado.
     * @param nombre Nombre del equipo.
     * @return Equipo.
     */
    Team get(String nombre);

    /**
     * Elimina un equipo del repositorio.
     * @param nombre Nombre del equipo.
     */
    void remove(String nombre);

    /**
     * Devuelve un ArrayList con todos los equipos.
     * @return ArrayList de equipos.
     */
    ArrayList<Team> readAll();

    /**
     * Devuelve el número de equipos registrados.
     * @return Número de equipos.
     */
    int size();

    /**
     * Devuelve un equipo aleatorio.
     * @return Equipo.
     */
    Team getRandom();

}
