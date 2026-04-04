import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application
{

    @Override
    public void start(final Stage primary) throws IOException
    {
        final Scene sceneMenu;
        final Scene scenePlaying;
        final QuizAppMenu menu;
        final QuizAppPlaying playing;

        menu = new QuizAppMenu();
        playing = new QuizAppPlaying();

        sceneMenu = new Scene(menu.getRoot(), 600, 700);
        scenePlaying = new Scene(playing.getRoot(), 600, 700);

        menu.getRoot().prefWidthProperty().bind(sceneMenu.widthProperty());
        menu.getRoot().prefHeightProperty().bind(sceneMenu.heightProperty());

        primary.setTitle("Quiz App");
        primary.setScene(sceneMenu);
        primary.show();

        menu.getStartButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
        {
            playing.getRoot().prefWidthProperty().bind(sceneMenu.widthProperty());
            playing.getRoot().prefHeightProperty().bind(sceneMenu.heightProperty());
            primary.setScene(scenePlaying);
        });
    }

    public static void main(final String[] args)
    {
        launch(args);
    }

}
