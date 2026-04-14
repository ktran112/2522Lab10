package ca.bcit.comp2522.lab10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Entry point for the Quiz App JavaFX app.
 *
 * @author Kiet Tran
 *
 * @version 1.0
 */
public class Main extends Application
{
    /**
     * Initializes and displays all scenes and links event handlers.
     *
     * @param primary the primary stage provided by the JavaFX runtime
     *
     * @throws IOException if any scene component cannot be initialized
     */
    @Override
    public void start(final Stage primary) throws IOException
    {
        final Scene sceneMenu;
        final Scene scenePlaying;
        final Scene sceneEnding;
        final Scene sceneSummary;
        final QuizAppMenu menu;
        final QuizAppPlaying playing;
        final QuizAppEnding ending;
        final QuizAppSummaryTable summary;

        menu = new QuizAppMenu();
        playing = new QuizAppPlaying();
        ending = new QuizAppEnding();
        summary = new QuizAppSummaryTable();

        sceneMenu = new Scene(menu.getRoot(), 600, 700);
        scenePlaying = new Scene(playing.getRoot(), 600, 700);
        sceneEnding = new Scene(ending.getRoot(), 600, 700);
        sceneSummary = new Scene(summary.getRoot(), 600, 700);

        primary.setTitle("Quiz App");
        primary.setScene(sceneMenu);
        primary.show();

        menu.getStartButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
        {
            primary.setScene(scenePlaying);
        });

        playing.getSubmitButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
        {
            if (playing.isGameEnd())
            {
                primary.setScene(sceneEnding);
            }
        });

        playing.getTextField().addEventHandler(KeyEvent.KEY_PRESSED, event ->
        {
            if (playing.isGameEnd() && event.getCode() == KeyCode.ENTER)
            {
                ending.setTitleScore(playing.getCurrentScore());
                primary.setScene(sceneEnding);
            }
        });

        ending.getRestartButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
        {
            playing.resetGame();
            playing.setGameEndFalse();
            primary.setScene(scenePlaying);
        });

        ending.getSummaryButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
        {
            summary.insertData(playing.getListOfRounds());
            primary.setScene(sceneSummary);
        });

        summary.getBackButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
        {
            primary.setScene(sceneEnding);
        });

        playing.isGameEndProperty().addListener((observable, o, n) ->
        {
            if (n == true)
            {
                ending.setTitleScore(playing.getCurrentScore());
                primary.setScene(sceneEnding);
            }
        });
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(final String[] args)
    {
        launch(args);
    }
}