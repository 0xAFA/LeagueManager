import match.model.Match;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import team.model.Team;
import team.repository.TeamFileRepository;
import team.repository.TeamManager;
import team.repository.TeamMemoryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests para comprobar que el programa funciona correctamente.
 * @author Andrés Fernández
 */
class LeagueTest {

    @Test
    @DisplayName("Test de creación de un partido")
    public void testMatch() {
        TeamMemoryRepository repo = new TeamMemoryRepository();
        TeamManager teams = new TeamManager(repo);
        Team team1 = new Team("Equipo 1");
        Team team2 = new Team("Equipo 2");
        teams.addTeam(team1);
        teams.addTeam(team2);
        Match match = new Match(team1, team2, 3, 0, false);

        assertEquals("Equipo 1", team1.getName());
        assertEquals("Equipo 2", team2.getName());
        assertEquals(2, teams.getTeams().size());
        assertEquals(3, team1.getPoints());
        assertEquals(0, team2.getPoints());
    }

    @Test
    @DisplayName("Test de creación de un partido con el repositorio de archivos")
    public void testMatchFileRepo() {
        TeamFileRepository repo = new TeamFileRepository();
        TeamManager teams = new TeamManager(repo);
        Team team1 = new Team("Equipo 1");
        Team team2 = new Team("Equipo 2");
        teams.addTeam(team1);
        teams.addTeam(team2);
        Match match = new Match(team1, team2, 3, 0, false);

        assertEquals("Equipo 1", team1.getName());
        assertEquals("Equipo 2", team2.getName());
        assertEquals(2, teams.getTeams().size());
        assertEquals(3, team1.getPoints());
        assertEquals(0, team2.getPoints());
    }

    @Test
    @DisplayName("Test de generación aleatoria de equipos y partidos")
    public void testRandomGen() {
        TeamMemoryRepository repo = new TeamMemoryRepository();
        TeamManager teams = new TeamManager(repo);
        teams.generateRandomTeams(20);
        assertEquals(20,teams.getTeams().size());
        teams.generateRandomMatches(100);
    }
}

