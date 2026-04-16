package ca.bcit.comp2522.lab10;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the ending screen of the Quiz App, displaying the player's score and navigation options.
 *
 * @author Kiet Tran, AngEng Nay
 *
 * @version 1.0
 */
public class QuizAppEnding
{
    private final Label title;
    private final Button summaryButton;
    private final Button restartButton;
    private final VBox root;

    /**
     * Constructs a ca.bcit.comp2522.lab10.QuizAppEnding screen, initializing the score label and navigation buttons.
     */
    public QuizAppEnding()
    {
        this.root = new VBox();

        this.title = title();
        this.restartButton = restartButton();
        this.summaryButton = summaryButton();

        this.root.getStyleClass().add("ending-Root");
        this.title.getStyleClass().add("ending-Title");
        this.restartButton.getStyleClass().add("ending-RestartButton");
        this.summaryButton.getStyleClass().add("ending-SummaryButton");

        this.root.getChildren().addAll( this.title,
                                        this.restartButton,
                                        this.summaryButton);

    }

    /**
     * Updates the title label to display the player's final score.
     *
     * @param score the number of correct answers achieved by the player
     */
    public final void setTitleScore(final int score)
    {
        this.title.setText("You got " + score + "/10");
    }

    /**
     * Returns the root VBox layout node for this screen.
     *
     * @return the root VBox
     */
    public final VBox getRoot()
    {
        return this.root;
    }

    /**
     * Returns the button that navigates to the summary statistics screen.
     *
     * @return the summary Button
     */
    public final Button getSummaryButton()
    {
        return this.summaryButton;
    }

    /**
     * Returns the button that restarts the game.
     *
     * @return the restart Button
     */
    public final Button getRestartButton()
    {
        return this.restartButton;
    }


    /*
     * Creates the title label for the ending screen.
     *
     * @return the title Label
     */
    private Label title()
    {
        final Label title;

        title = new Label();

        return title;
    }

    /*
     * Creates the button that opens the summary statistics screen.
     *
     * @return the summary Button
     */
    private Button summaryButton()
    {
        final Button summary;

        summary = new Button();

        summary.setText("View statistics");

        return summary;
    }

    /*
     * Creates the button that restarts the quiz.
     *
     * @return the restart Button
     */
    private Button restartButton()
    {
        final Button restartButton;

        restartButton = new Button();

        restartButton.setText("Play Again?");

        return restartButton;
    }
}