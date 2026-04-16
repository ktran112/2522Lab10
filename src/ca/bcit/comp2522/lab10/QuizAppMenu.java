package ca.bcit.comp2522.lab10;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the main menu screen of the Quiz App.
 *
 * @author Kiet Tran, AngEng Nay
 *
 * @version 1.0
 */
public class QuizAppMenu
{
    private final Label title;
    private final Label description;
    private final Button startButton;
    private final VBox root;

    /**
     * Constructs a ca.bcit.comp2522.lab10.QuizAppMenu, initializing the title, description, and start button.
     */
    public QuizAppMenu()
    {
        this.root = new VBox();

        this.title = title();
        this.startButton = startButton();
        this.description = description();

        this.root.getStyleClass().add("menu-Root");
        this.title.getStyleClass().add("menu-Title");
        this.startButton.getStyleClass().add("menu-StartButton");
        this.description.getStyleClass().add("menu-Description");

        this.root.getChildren().addAll( this.title,
                                        this.description,
                                        this.startButton);
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
     * Returns the button that starts the quiz.
     *
     * @return the start Button
     */
    public final Button getStartButton()
    {
        return this.startButton;
    }

    /*
     * Creates the title label for the menu screen.
     *
     * @return the title Label
     */
    private Label title()
    {
        final Label title;

        title = new Label();

        title.setText("Quiz Game");

        return title;
    }

    /*
     * Creates the description label for the menu screen.
     *
     * @return the description Label
     */
    private Label description()
    {
        final Label description;

        description = new Label();

        description.setText("Try to answer 10 questions correctly!");

        return description;
    }

    /*
     * Creates the button that starts the quiz.
     *
     * @return the start Button
     */
    private Button startButton()
    {
        final Button startButton;

        startButton = new Button();

        startButton.setText("START");

        return startButton;
    }
}