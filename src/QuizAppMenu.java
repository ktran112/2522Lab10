import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class QuizAppMenu
{
    private static final int    UNIVERSAL_SPACING   = 10;
    private static final String UNIVERSAL_STYLE     = "-fx-font-size: 18px;";

    private static final double TITLE_MAX_WIDTH     = -1;
    private static final double TITLE_TOP_MARG      = -1;
    private static final double TITLE_RIGHT_MARG    = -1;
    private static final double TITLE_BOTTOM_MARG   = -1;
    private static final double TITLE_LEFT_MARG     = -1;
    private static final double TITLE_TOP_PAD       = -1;
    private static final double TITLE_RIGHT_PAD     = -1;
    private static final double TITLE_BOTTOM_PAD    = -1;
    private static final double TITLE_LEFT_PAD      = -1;
    private static final String TITLE_STYLE         = "-fx-font-size: 72px; -fx-text-fill: blue; -fx-font-weight: bold;";

    private static final double START_BUTTON_MAX_WIDTH     = -1;
    private static final double START_BUTTON_TOP_MARG      = 80;
    private static final double START_BUTTON_RIGHT_MARG    = -1;
    private static final double START_BUTTON_BOTTOM_MARG   = -1;
    private static final double START_BUTTON_LEFT_MARG     = -1;
    private static final double START_BUTTON_TOP_PAD       = 10;
    private static final double START_BUTTON_RIGHT_PAD     = 10;
    private static final double START_BUTTON_BOTTOM_PAD    = 10;
    private static final double START_BUTTON_LEFT_PAD      = 10;
    private static final String START_BUTTON_STYLE         = "-fx-font-size: 24px; -fx-text-fill: #06402B; -fx-background-color: #96D9C0";

    private static final double DESCRIPTION_MAX_WIDTH     = -1;
    private static final double DESCRIPTION_TOP_MARG      = 10;
    private static final double DESCRIPTION_RIGHT_MARG    = -1;
    private static final double DESCRIPTION_BOTTOM_MARG   = -1;
    private static final double DESCRIPTION_LEFT_MARG     = -1;
    private static final double DESCRIPTION_TOP_PAD       = 10;
    private static final double DESCRIPTION_RIGHT_PAD     = 10;
    private static final double DESCRIPTION_BOTTOM_PAD    = 10;
    private static final double DESCRIPTION_LEFT_PAD      = 10;
    private static final String DESCRIPTION_STYLE         = "-fx-font-size: 20px;";

    private final Label title;
    private final Label description;
    private final Button startButton;
    private final VBox root;

    public QuizAppMenu()
    {
        this.root = new VBox();

        this.title = title();
        this.startButton = startButton();
        this.description = description();

        this.root.setAlignment(Pos.CENTER);
        this.root.setSpacing(UNIVERSAL_SPACING);
        this.root.setStyle(UNIVERSAL_STYLE);

        this.root.getChildren().add(this.title);
        this.root.getChildren().add(this.description);
        this.root.getChildren().add(this.startButton);
    }

    public final VBox getRoot()
    {
        return this.root;
    }

    private final Label title()
    {
        final Label title;

        title = new Label();

        title.setText("Quiz Game");
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

    private final Label description()
    {
        final Label description;

        description = new Label();

        description.setText("Try to answer 10 questions correctly!");
        description.setStyle(DESCRIPTION_STYLE);

        VBox.setMargin(description, new Insets(DESCRIPTION_TOP_MARG,
                                               DESCRIPTION_RIGHT_MARG,
                                               DESCRIPTION_BOTTOM_MARG,
                                               DESCRIPTION_LEFT_MARG));

        description.setPadding(new Insets(DESCRIPTION_TOP_PAD,
                                    DESCRIPTION_RIGHT_PAD,
                                    DESCRIPTION_BOTTOM_PAD,
                                    DESCRIPTION_LEFT_PAD));

        return description;
    }


    private final Button startButton()
    {
        final Button startButton;

        startButton = new Button();

        startButton.setText("START");
        startButton.setStyle(START_BUTTON_STYLE);

        VBox.setMargin(startButton, new Insets(START_BUTTON_TOP_MARG,
                                               START_BUTTON_RIGHT_MARG,
                                               START_BUTTON_BOTTOM_MARG,
                                               START_BUTTON_LEFT_MARG));

        startButton.setPadding(new Insets(START_BUTTON_TOP_PAD,
                                          START_BUTTON_RIGHT_PAD,
                                          START_BUTTON_BOTTOM_PAD,
                                          START_BUTTON_LEFT_PAD));

        return startButton;
    }

    public final Button getStartButton()
    {
        return this.startButton;
    }

}
