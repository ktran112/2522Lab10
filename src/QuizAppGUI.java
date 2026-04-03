import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class QuizAppGUI
{

    private final GridPane root;

    public QuizAppGUI()
    {
        root = new GridPane();

        root.getChildren().add(displayQuestion("q"));
        root.getChildren().add(inputField());
        root.getChildren().add(submitButton());
        root.getChildren().add(displayScore(1));
    }

    public final GridPane getRoot()
    {
        return this.root;
    }

    public final Label displayQuestion(final String question)
    {
        final Label label;

        return new Label(question);
    }

    public final TextField inputField()
    {
        final TextField inputField;

        inputField = new TextField("Enter your answer");

        inputField.setOnAction(event ->
        {
            final String input;

            input = inputField.getText();
        });

        return inputField;
    }

    public final Button submitButton()
    {
        final Button btn;

        btn = new Button();

        btn.setText("Submit");

        btn.setOnAction(actionEvent ->
        {
            // Submits
        });

        return btn;

    }

    public final Label displayScore(final int currentScore)
    {
        final Label score;

        score = new Label("" + currentScore);

        return score;
    }



}
