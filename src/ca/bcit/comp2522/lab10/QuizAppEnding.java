package ca.bcit.comp2522.lab10;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the ending screen of the Quiz App, displaying the player's score and navigation options.
 *
 * @author Kiet Tran
 *
 * @version 1.0
 */
public class QuizAppEnding
{
    private static final int UNIVERSAL_SPACING = 10;
    private static final String UNIVERSAL_STYLE = "-fx-font-size: 18px;";

    private static final double TITLE_MAX_WIDTH = -1;
    private static final double TITLE_TOP_MARG = -1;
    private static final double TITLE_RIGHT_MARG = -1;
    private static final double TITLE_BOTTOM_MARG = -1;
    private static final double TITLE_LEFT_MARG = -1;
    private static final double TITLE_TOP_PAD = -1;
    private static final double TITLE_RIGHT_PAD = -1;
    private static final double TITLE_BOTTOM_PAD = -1;
    private static final double TITLE_LEFT_PAD = -1;
    private static final String TITLE_STYLE = "-fx-font-size: 54px; -fx-font-weight: bold;";

    private static final double RESTART_BUTTON_MAX_WIDTH = -1;
    private static final double RESTART_BUTTON_TOP_MARG = 40;
    private static final double RESTART_BUTTON_RIGHT_MARG = -1;
    private static final double RESTART_BUTTON_BOTTOM_MARG = -1;
    private static final double RESTART_BUTTON_LEFT_MARG = -1;
    private static final double RESTART_BUTTON_TOP_PAD = 10;
    private static final double RESTART_BUTTON_RIGHT_PAD = 10;
    private static final double RESTART_BUTTON_BOTTOM_PAD = 10;
    private static final double RESTART_BUTTON_LEFT_PAD = 10;
    private static final String RESTART_BUTTON_STYLE = "-fx-font-size: 24px; -fx-text-fill: #06402B; -fx-background-color: #96D9C0;";

    private static final double SUMMARY_MAX_WIDTH = -1;
    private static final double SUMMARY_TOP_MARG = 10;
    private static final double SUMMARY_RIGHT_MARG = -1;
    private static final double SUMMARY_BOTTOM_MARG = -1;
    private static final double SUMMARY_LEFT_MARG = -1;
    private static final double SUMMARY_TOP_PAD = 10;
    private static final double SUMMARY_RIGHT_PAD = 10;
    private static final double SUMMARY_BOTTOM_PAD = 10;
    private static final double SUMMARY_LEFT_PAD = 10;
    private static final String SUMMARY_STYLE = "-fx-font-size: 20px; -fx-background-color: #36F6C0;";

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

        this.root.setAlignment(Pos.CENTER);
        this.root.setSpacing(UNIVERSAL_SPACING);
        this.root.setStyle(UNIVERSAL_STYLE);

        this.root.getChildren().add(this.title);
        this.root.getChildren().add(this.summaryButton);
        this.root.getChildren().add(this.restartButton);
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

    private final Label title()
    {
        final Label title;

        title = new Label();

        title.setStyle(TITLE_STYLE);

        VBox.setMargin(title, new Insets(TITLE_TOP_MARG,
                TITLE_RIGHT_MARG,
                TITLE_BOTTOM_MARG,
                TITLE_LEFT_MARG));

        title.setPadding(new Insets(TITLE_TOP_PAD,
                TITLE_RIGHT_PAD,
                TITLE_BOTTOM_PAD,
                TITLE_LEFT_PAD));

        return title;
    }

    private final Button summaryButton()
    {
        final Button summary;

        summary = new Button();

        summary.setText("View statistics");
        summary.setStyle(SUMMARY_STYLE);

        VBox.setMargin(summary, new Insets(SUMMARY_TOP_MARG,
                SUMMARY_RIGHT_MARG,
                SUMMARY_BOTTOM_MARG,
                SUMMARY_LEFT_MARG));

        summary.setPadding(new Insets(SUMMARY_TOP_PAD,
                SUMMARY_RIGHT_PAD,
                SUMMARY_BOTTOM_PAD,
                SUMMARY_LEFT_PAD));

        return summary;
    }

    private final Button restartButton()
    {
        final Button restartButton;

        restartButton = new Button();

        restartButton.setText("Play Again?");
        restartButton.setStyle(RESTART_BUTTON_STYLE);

        VBox.setMargin(restartButton, new Insets(RESTART_BUTTON_TOP_MARG,
                RESTART_BUTTON_RIGHT_MARG,
                RESTART_BUTTON_BOTTOM_MARG,
                RESTART_BUTTON_LEFT_MARG));

        restartButton.setPadding(new Insets(RESTART_BUTTON_TOP_PAD,
                RESTART_BUTTON_RIGHT_PAD,
                RESTART_BUTTON_BOTTOM_PAD,
                RESTART_BUTTON_LEFT_PAD));

        return restartButton;
    }
}