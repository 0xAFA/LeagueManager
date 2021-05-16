package team.repository;

import common.FileMethods;
import team.model.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

/**
 * Repositorio de equipo que almacena los datos en disco.
 * @author Andrés Fernández
 */
public class TeamFileRepository implements TeamRepository {

    HashMap<String, Team> teams = new HashMap<>();
    private final String path = "data/teams.dat";
    private FileMethods<Team> fm = new FileMethods<>();
    private Random r = new Random();

    @Override
    public void add(Team team) {
        teams.put(team.getName(), team);
        fm.writeMapToFile(teams, path);
    }

    @Override
    public boolean exists(String nombre) {
        return teams.containsKey(nombre);
    }

    @Override
    public Team get(String nombre) {
        return teams.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        teams.remove(nombre);
        fm.writeMapToFile(teams, path);
    }

    @Override
    public ArrayList<Team> readAll() {
        teams = fm.readMapFromFile(path);
        Collection<Team> values = teams.values(); // Pasar los valores de map a arraylist
        ArrayList<Team> rE=new ArrayList<>(values);
        return rE;
    }

    @Override
    public int size() {
        return teams.size();
    }

    @Override
    public Team getRandom() {
        // Obtener un valor aleatorio de un HashMap
        // Fuente: https://stackoverflow.com/questions/12385284/how-to-select-a-random-key-from-a-hashmap-in-java/12385392#12385392
        ArrayList<String> keysAsArray = new ArrayList<>(teams.keySet());
        return teams.get(keysAsArray.get(r.nextInt(keysAsArray.size())));
    }
}
