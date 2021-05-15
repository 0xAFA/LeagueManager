package team.repository;

import team.model.Team;

import java.util.ArrayList;

public interface TeamRepository {

    void add(Team team);
    boolean exists(String nombre);
    Team get(String nombre);
    void remove(String nombre);
    ArrayList<Team> readAll();
    int size();
    Team getRandom();

}
