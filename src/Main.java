import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application
{

    @Override
    public void start(final Stage primary)
    {
        final Scene scene;
        final QuizAppGUI q;

        q = new QuizAppGUI();

        scene = new Scene(q.getRoot(), 600, 700);

        primary.setTitle("Quiz App");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }

}
