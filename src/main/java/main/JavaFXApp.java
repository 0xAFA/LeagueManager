package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team.model.Team;
import team.repository.TeamManager;
import team.repository.TeamMemoryRepository;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Aplicación con interfaz de usuario gráfica.
 * @author Andrés Fernández
 */
public class JavaFXApp extends Application {

    TeamMemoryRepository teams = new TeamMemoryRepository();
    TeamManager tm = new TeamManager(teams);

    // Campos en la aplicación gráfica
    public TextField numTeams;
    public TextField numMatches;
    public Label textArea;

    /**
     * Punto de inicio.
     * @param stage Escenario de JavaFX
     */
    @Override
    public void start(Stage stage) {

        teams = new TeamMemoryRepository();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            stage.setTitle("LeagueManager");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error en la carga del archivo FXML.");
            System.exit(1);
        }
    }

    /**
     * Botón que permite cerrar la aplicación.
     */
    @FXML
    private void exit() {
        System.exit(0);
    }

    /**
     * Botón que añade equipos aleatorios.
     */
    @FXML
    private void addTeams() {
        try{
            int num = Integer.parseInt(numTeams.getText());
            tm.generateRandomTeams(num);
            textArea.setText("Generados " + numTeams.getText() + " equipos.");}
        catch (Exception e) {
            textArea.setText("El valor introducido no es un numero.");
        }
    }

    /**
     * Botón que añade partidos aleatorios.
     */
    @FXML
    private void addMatches() {
        try{
            int num = Integer.parseInt(numMatches.getText());
            if(tm.generateRandomMatches(num)){
                textArea.setText("Generados " + numMatches.getText() + " partidos.");
            } else {
                textArea.setText("No es posible generar partidos porque no hay equipos.");
            }
        } catch (Exception e) {
            textArea.setText("El valor introducido no es un numero.");
        }
    }

    /**
     * Botón que muestra en pantalla el equipo que lidera la competición, y sus puntos.
     */
    @FXML
    public void showLeader() {
        ArrayList<Team> teamList = teams.readAll();
        if(teamList.size() > 0) {
            teamList.sort(Comparator.comparing(Team::getPoints).reversed());
            Team leader = teamList.get(0);
            if(leader.getPoints() > 0) {
                textArea.setText("El lider es " + leader.getName() + " con " + leader.getPoints() +" puntos.");
            } else {
                textArea.setText("Aun no se ha jugado ningun partido.");
            }
        } else {
            textArea.setText("Aun no hay ningun equipo.");
        }
    }
}
