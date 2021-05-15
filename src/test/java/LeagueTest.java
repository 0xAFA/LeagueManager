import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team.model.Team;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests para comprobar que el programa funciona correctamente.
 * @author Andrés Fernández
 */
class LeagueTest {

    private final League testLeague = new League("Test league");

    @Test
    @DisplayName("Test de creación de un partido")
    public void testMatch() {
        Team team1 = new Team("Equipo 1");
        Team team2 = new Team("Equipo 2");
        testLeague.addTeam(team1);
        testLeague.addTeam(team2);
        Match match = new Match(team1, team2, 3, 0, false);

        assertEquals("Equipo 1", team1.getName());
        assertEquals("Equipo 2", team2.getName());
        assertEquals(2, testLeague.getTeams().size());
        assertEquals(3, team1.getPoints());
        assertEquals(0, team2.getPoints());
    }

    @Test
    @DisplayName("Test de generación aleatoria de equipos y partidos")
    public void testRandomGen() {
        testLeague.generateRandomTeams(20);
        assertEquals(20,testLeague.getTeams().size());
        testLeague.generateRandomMatches(100);
}

}

