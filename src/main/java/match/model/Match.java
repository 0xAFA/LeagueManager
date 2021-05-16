package match.model;

import team.model.Team;

import java.util.Date;

/**
 * Clase que representa un partido de futbol.
 * @author Andrés Fernández
 */
public class Match {

    private Date date;
    private final Team homeTeam, awayTeam;
    private final int homeGoals, awayGoals;
    private final boolean isFriendly;

    /**
     * Constructor que crea un partido y actualiza la puntuacion de cada equipo.
     * @param homeTeam Equipo local.
     * @param awayTeam Equipo visitante.
     * @param homeGoals Goles del equipo local.
     * @param awayGoals Goles del equipo visitante
     * @param isFriendly true si el partido es amistoso.
     */
    public Match(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals, boolean isFriendly) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.isFriendly = isFriendly;
        this.date = new Date();

        // Dar puntos a los equipos
        if(!isFriendly) {
            if(homeGoals > awayGoals) homeTeam.addPoints(3);
            if(homeGoals < awayGoals) awayTeam.addPoints(3);
            if(homeGoals == awayGoals) {
                homeTeam.addPoints(1);
                awayTeam.addPoints(1);
            }
        }
    }
}