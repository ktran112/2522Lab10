import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class QuizAppPlaying
{
    private static final int    QUESTION_AMOUNT = 10;

    private static final int    UNIVERSAL_SPACING                   = 10;
    private static final String UNIVERSAL_STYLE                     = "-fx-font-size: 18px;";
    private static final double UNIVERSAL_MESSAGE_DURATION_SECONDS  = 3;

    private static final double QUESTION_MAX_WIDTH     = -1;
    private static final double QUESTION_TOP_MARG      = 40;
    private static final double QUESTION_RIGHT_MARG    = -1;
    private static final double QUESTION_BOTTOM_MARG   = -1;
    private static final double QUESTION_LEFT_MARG     = -1;
    private static final double QUESTION_TOP_PAD       = -1;
    private static final double QUESTION_RIGHT_PAD     = -1;
    private static final double QUESTION_BOTTOM_PAD    = -1;
    private static final double QUESTION_LEFT_PAD      = -1;

    private static final double TEXT_FIELD_MAX_WIDTH   = 300;
    private static final double TEXT_FIELD_MIN_WIDTH   = 100;
    private static final double TEXT_FIELD_TOP_MARG    = 20;
    private static final double TEXT_FIELD_RIGHT_MARG  = -1;
    private static final double TEXT_FIELD_BOTTOM_MARG = -1;
    private static final double TEXT_FIELD_LEFT_MARG   = -1;
    private static final double TEXT_FIELD_TOP_PAD     = 10;
    private static final double TEXT_FIELD_RIGHT_PAD   = 10;
    private static final double TEXT_FIELD_BOTTOM_PAD  = 10;
    private static final double TEXT_FIELD_LEFT_PAD    = 10;

    private static final double SUBMIT_BTN_MAX_WIDTH   = 200;
    private static final double SUBMIT_BTN_TOP_MARG    = 80;
    private static final double SUBMIT_BTN_RIGHT_MARG  = -1;
    private static final double SUBMIT_BTN_BOTTOM_MARG = -1;
    private static final double SUBMIT_BTN_LEFT_MARG   = -1;
    private static final double SUBMIT_BTN_TOP_PAD     = -1;
    private static final double SUBMIT_BTN_RIGHT_PAD   = -1;
    private static final double SUBMIT_BTN_BOTTOM_PAD  = -1;
    private static final double SUBMIT_BTN_LEFT_PAD    = -1;
    private static final String SUBMIT_BTN_STYLE       = "-fx-font-size: 24px; -fx-text-fill: #06402B; -fx-background-color: #96D9C0";

    private static final double SCORE_MAX_WIDTH        = 200;
    private static final double SCORE_TOP_MARG         = -1;
    private static final double SCORE_RIGHT_MARG       = -1;
    private static final double SCORE_BOTTOM_MARG      = -1;
    private static final double SCORE_LEFT_MARG        = -1;
    private static final double SCORE_TOP_PAD          = -1;
    private static final double SCORE_RIGHT_PAD        = -1;
    private static final double SCORE_BOTTOM_PAD       = -1;
    private static final double SCORE_LEFT_PAD         = -1;

    private static final double BLANK_INPUT_MESSAGE_MAX_WIDTH        = -1;
    private static final double BLANK_INPUT_MESSAGE_TOP_MARG         = -1;
    private static final double BLANK_INPUT_MESSAGE_RIGHT_MARG       = -1;
    private static final double BLANK_INPUT_MESSAGE_BOTTOM_MARG      =  0;
    private static final double BLANK_INPUT_MESSAGE_LEFT_MARG        = -1;
    private static final double BLANK_INPUT_MESSAGE_TOP_PAD          =  0;
    private static final double BLANK_INPUT_MESSAGE_RIGHT_PAD        = -1;
    private static final double BLANK_INPUT_MESSAGE_BOTTOM_PAD       = -1;
    private static final double BLANK_INPUT_MESSAGE_LEFT_PAD         = -1;
    private static final String BLANK_INPUT_MESSAGE_STYLE            = "-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold;";

    private static final double INCORRECT_MESSAGE_MAX_WIDTH        = -1;
    private static final double INCORRECT_MESSAGE_TOP_MARG         = -1;
    private static final double INCORRECT_MESSAGE_RIGHT_MARG       = -1;
    private static final double INCORRECT_MESSAGE_BOTTOM_MARG      =  0;
    private static final double INCORRECT_MESSAGE_LEFT_MARG        = -1;
    private static final double INCORRECT_MESSAGE_TOP_PAD          =  0;
    private static final double INCORRECT_MESSAGE_RIGHT_PAD        = -1;
    private static final double INCORRECT_MESSAGE_BOTTOM_PAD       = -1;
    private static final double INCORRECT_MESSAGE_LEFT_PAD         = -1;
    private static final String INCORRECT_MESSAGE_STYLE            = "-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold;";

    private static final double CORRECT_MESSAGE_MAX_WIDTH        = -1;
    private static final double CORRECT_MESSAGE_TOP_MARG         = -1;
    private static final double CORRECT_MESSAGE_RIGHT_MARG       = -1;
    private static final double CORRECT_MESSAGE_BOTTOM_MARG      =  0;
    private static final double CORRECT_MESSAGE_LEFT_MARG        = -1;
    private static final double CORRECT_MESSAGE_TOP_PAD          =  0;
    private static final double CORRECT_MESSAGE_RIGHT_PAD        = -1;
    private static final double CORRECT_MESSAGE_BOTTOM_PAD       = -1;
    private static final double CORRECT_MESSAGE_LEFT_PAD         = -1;
    private static final String CORRECT_MESSAGE_STYLE            = "-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold;";

    private final VBox root;
    private final Label question;
    private final TextField textField;
    private final Button submitButton;
    private final Label score;

    private Label blankInputMessage;
    private Label incorrectMessage;
    private Label correctMessage;

    private final List<String> listOfQuestions;

    private int currentScore;
    private String currentQuestion;
    private String currentAnswer;
    private String userAnswer;
    private int currentQuestionCount;
    private boolean popupMessage;
    private boolean gameEnd;

    public QuizAppPlaying() throws IOException
    {
        final String[] questionAnswer;

        this.root = new VBox();
        this.question = question();
        this.textField = textField();
        this.submitButton = submitButton();
        this.score = score();

        this.currentScore = 0;
        this.currentQuestionCount = 0;

        this.listOfQuestions = FileToList.read("questions.txt");
        Collections.shuffle(this.listOfQuestions);

        questionAnswer = listOfQuestions.getFirst().split("\\|");

        this.currentQuestion =  questionAnswer[0];
        this.currentAnswer = questionAnswer[1];

        this.question.setText(this.currentQuestion);

        this.root.setAlignment(Pos.CENTER);
        this.root.setSpacing(UNIVERSAL_SPACING);
        this.root.setStyle(UNIVERSAL_STYLE);

        this.root.getChildren().add(this.question);
        this.root.getChildren().add(this.textField);
        this.root.getChildren().add(this.submitButton);
        this.root.getChildren().add(this.score);
    }

    private final void updateQuestionAnswer()
    {
        final String[] questionAnswer;

        System.out.println("Update");

        ++this.currentQuestionCount;

        questionAnswer = listOfQuestions.get(currentQuestionCount)
                                        .split("\\|");

        this.currentQuestion = questionAnswer[0];
        System.out.println(this.currentQuestion);
        this.currentAnswer = questionAnswer[1];
        System.out.println(this.currentAnswer);

        this.question.setText(this.currentQuestion);
    }

    private final void updateScore()
    {
        this.score.setText("Your score: " + this.currentScore);
    }

    private final void checkAnswer()
    {
        if (this.userAnswer.trim().equalsIgnoreCase(this.currentAnswer.trim()))
        {
            this.correctMessage = correctMessage();
            popMessage(this.correctMessage);
            System.out.println("CORRECT");
            ++this.currentScore;
        }

        else
        {
            this.incorrectMessage = incorrectMessage();
            popMessage(this.incorrectMessage);
            System.out.println("WRONG");

        }
    }

    public final void popMessage(final Label message)
    {
        final PauseTransition pause;

        pause = new PauseTransition(Duration.seconds(UNIVERSAL_MESSAGE_DURATION_SECONDS));

        message.setVisible(true);
        this.root.getChildren().addFirst(message);
        this.popupMessage = true;

        pause.setOnFinished(actionEvent ->
        {
            message.setVisible(false);
            this.root.getChildren().remove(message);
            this.popupMessage = false;

            System.out.println(this.popupMessage);
        });

        pause.play();
    }

    public final void onSubmit()
    {
        if (QuizAppLogic.validateInput(this.textField.getText()))
        {
            this.root.getChildren().remove(this.blankInputMessage);
            this.userAnswer = this.textField.getText();
            System.out.println(this.textField.getText());
            checkAnswer();
            updateScore();
            updateQuestionAnswer();
            this.textField.clear();
        }

        else
        {
            if (!this.popupMessage)
            {
                this.blankInputMessage = blankInputMessage();
                popMessage(this.blankInputMessage);
            }
        }

        this.gameEnd = currentQuestionCount == QUESTION_AMOUNT;
    }

    public final VBox getRoot()
    {
        return this.root;
    }

    public final boolean getGameEnd()
    {
        return this.gameEnd;
    }

    private final Label question()
    {
        final Label question;

        question = new Label();

        question.setAlignment(Pos.CENTER);
        question.setMaxWidth(QUESTION_MAX_WIDTH);

        VBox.setMargin(question, new Insets(QUESTION_TOP_MARG,
                                            QUESTION_RIGHT_MARG,
                                            QUESTION_BOTTOM_MARG,
                                            QUESTION_LEFT_MARG));

        question.setPadding(new Insets(QUESTION_TOP_PAD,
                                       QUESTION_RIGHT_PAD,
                                       QUESTION_BOTTOM_PAD,
                                       QUESTION_LEFT_PAD));
        return question;
    }


    private final TextField textField()
    {
        final TextField inputField;

        inputField = new TextField();

        inputField.setPromptText("Enter your answer");
        inputField.setMaxWidth(TEXT_FIELD_MAX_WIDTH);

        VBox.setMargin(inputField, new Insets(TEXT_FIELD_TOP_MARG,
                                              TEXT_FIELD_RIGHT_MARG,
                                              TEXT_FIELD_BOTTOM_MARG,
                                              TEXT_FIELD_LEFT_MARG));

        inputField.setPadding(new Insets(TEXT_FIELD_TOP_PAD,
                                         TEXT_FIELD_RIGHT_PAD,
                                         TEXT_FIELD_BOTTOM_PAD,
                                         TEXT_FIELD_LEFT_PAD));

        inputField.setOnAction(event->onSubmit());

        return inputField;
    }

    private final Button submitButton()
    {
        final Button btn;

        btn = new Button();

        btn.setText("Submit");

        btn.setMaxWidth(SUBMIT_BTN_MAX_WIDTH);
        btn.setStyle(SUBMIT_BTN_STYLE);

        VBox.setMargin(btn, new Insets(SUBMIT_BTN_TOP_MARG,
                                       SUBMIT_BTN_RIGHT_MARG,
                                       SUBMIT_BTN_BOTTOM_MARG,
                                       SUBMIT_BTN_LEFT_MARG));

        btn.setPadding(new Insets(SUBMIT_BTN_TOP_PAD,
                                  SUBMIT_BTN_RIGHT_PAD,
                                  SUBMIT_BTN_BOTTOM_PAD,
                                  SUBMIT_BTN_LEFT_PAD));

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, event->onSubmit());

            return btn;
        }

    private final Label score()
    {
        final Label score;

        score = new Label();

        VBox.setMargin(score, new Insets(SCORE_TOP_MARG,
                                         SCORE_RIGHT_MARG,
                                         SCORE_BOTTOM_MARG,
                                         SCORE_LEFT_MARG));

        score.setPadding(new Insets(SCORE_TOP_PAD,
                                    SCORE_RIGHT_PAD,
                                    SCORE_BOTTOM_PAD,
                                    SCORE_LEFT_PAD));

        return score;
    }

    private final Label blankInputMessage()
    {
        final Label blankInputMessage;

        blankInputMessage = new Label();

        blankInputMessage.setText("Text field is empty");
        blankInputMessage.setMaxWidth(BLANK_INPUT_MESSAGE_MAX_WIDTH);
        blankInputMessage.setStyle(BLANK_INPUT_MESSAGE_STYLE);

        VBox.setMargin(blankInputMessage, new Insets(BLANK_INPUT_MESSAGE_TOP_MARG,
                                                     BLANK_INPUT_MESSAGE_RIGHT_MARG,
                                                     BLANK_INPUT_MESSAGE_BOTTOM_MARG,
                                                     BLANK_INPUT_MESSAGE_LEFT_MARG));

        blankInputMessage.setPadding(new Insets(BLANK_INPUT_MESSAGE_TOP_PAD,
                                                BLANK_INPUT_MESSAGE_RIGHT_PAD,
                                                BLANK_INPUT_MESSAGE_BOTTOM_PAD,
                                                BLANK_INPUT_MESSAGE_LEFT_PAD));

        return blankInputMessage;
    }

    private final Label incorrectMessage()
    {
        final Label incorrectMessage;

        incorrectMessage = new Label();

        incorrectMessage.setText("Incorrect \uD83D\uDE14");
        incorrectMessage.setMaxWidth(INCORRECT_MESSAGE_MAX_WIDTH);
        incorrectMessage.setStyle(INCORRECT_MESSAGE_STYLE);

        VBox.setMargin(incorrectMessage, new Insets(INCORRECT_MESSAGE_TOP_MARG,
                                                    INCORRECT_MESSAGE_RIGHT_MARG,
                                                    INCORRECT_MESSAGE_BOTTOM_MARG,
                                                    INCORRECT_MESSAGE_LEFT_MARG));

        incorrectMessage.setPadding(new Insets(INCORRECT_MESSAGE_TOP_PAD,
                                               INCORRECT_MESSAGE_RIGHT_PAD,
                                               INCORRECT_MESSAGE_BOTTOM_PAD,
                                               INCORRECT_MESSAGE_LEFT_PAD));

        return incorrectMessage;
    }

    private final Label correctMessage()
    {
        final Label correctMessage;

        correctMessage = new Label();

        correctMessage.setText("Correct \uD83D\uDE01");
        correctMessage.setMaxWidth(CORRECT_MESSAGE_MAX_WIDTH);
        correctMessage.setStyle(CORRECT_MESSAGE_STYLE);

        VBox.setMargin(correctMessage, new Insets(CORRECT_MESSAGE_TOP_MARG,
                                                  CORRECT_MESSAGE_RIGHT_MARG,
                                                  CORRECT_MESSAGE_BOTTOM_MARG,
                                                  CORRECT_MESSAGE_LEFT_MARG));

        correctMessage.setPadding(new Insets(CORRECT_MESSAGE_TOP_PAD,
                                             CORRECT_MESSAGE_RIGHT_PAD,
                                             CORRECT_MESSAGE_BOTTOM_PAD,
                                             CORRECT_MESSAGE_LEFT_PAD));

        return correctMessage;
    }

}
