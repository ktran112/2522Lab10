package ca.bcit.comp2522.lab10;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

/**
 * Represents the active gameplay screen of the Quiz App.
 *
 * @author Kiet Tran
 *
 * @version 1.0
 */
public class QuizAppPlaying
{
    private static final int QUESTION_AMOUNT = 10;
    private static final int COUNT_MIN = 0;
    private static final int COUNT_MAX = Integer.MAX_VALUE;

    private static final String DIRECTORY = "questions.txt";

    private static final int UNIVERSAL_SPACING = 10;
    private static final String UNIVERSAL_STYLE = "-fx-font-size: 18px;";
    private static final double UNIVERSAL_MESSAGE_DURATION_SECONDS = 3;
    private static final int UNIVERSAL_TIMER_LENGTH_SECONDS = 60;

    private static final double QUESTION_MAX_WIDTH = -1;
    private static final double QUESTION_TOP_MARG = 40;
    private static final double QUESTION_RIGHT_MARG = -1;
    private static final double QUESTION_BOTTOM_MARG = -1;
    private static final double QUESTION_LEFT_MARG = -1;
    private static final double QUESTION_TOP_PAD = -1;
    private static final double QUESTION_RIGHT_PAD = -1;
    private static final double QUESTION_BOTTOM_PAD = -1;
    private static final double QUESTION_LEFT_PAD = -1;

    private static final double TEXT_FIELD_MAX_WIDTH = 300;
    private static final double TEXT_FIELD_MIN_WIDTH = 100;
    private static final double TEXT_FIELD_TOP_MARG = 20;
    private static final double TEXT_FIELD_RIGHT_MARG = -1;
    private static final double TEXT_FIELD_BOTTOM_MARG = -1;
    private static final double TEXT_FIELD_LEFT_MARG = -1;
    private static final double TEXT_FIELD_TOP_PAD = 10;
    private static final double TEXT_FIELD_RIGHT_PAD = 10;
    private static final double TEXT_FIELD_BOTTOM_PAD = 10;
    private static final double TEXT_FIELD_LEFT_PAD = 10;

    private static final double SUBMIT_BTN_MAX_WIDTH = 200;
    private static final double SUBMIT_BTN_TOP_MARG = 80;
    private static final double SUBMIT_BTN_RIGHT_MARG = -1;
    private static final double SUBMIT_BTN_BOTTOM_MARG = -1;
    private static final double SUBMIT_BTN_LEFT_MARG = -1;
    private static final double SUBMIT_BTN_TOP_PAD = -1;
    private static final double SUBMIT_BTN_RIGHT_PAD = -1;
    private static final double SUBMIT_BTN_BOTTOM_PAD = -1;
    private static final double SUBMIT_BTN_LEFT_PAD = -1;
    private static final String SUBMIT_BTN_STYLE = "-fx-font-size: 24px; -fx-text-fill: #06402B; -fx-background-color: #96D9C0;";

    private static final double SCORE_MAX_WIDTH = 200;
    private static final double SCORE_TOP_MARG = -1;
    private static final double SCORE_RIGHT_MARG = -1;
    private static final double SCORE_BOTTOM_MARG = -1;
    private static final double SCORE_LEFT_MARG = -1;
    private static final double SCORE_TOP_PAD = -1;
    private static final double SCORE_RIGHT_PAD = -1;
    private static final double SCORE_BOTTOM_PAD = -1;
    private static final double SCORE_LEFT_PAD = -1;

    private static final double TIMER_MAX_WIDTH = 200;
    private static final double TIMER_TOP_MARG = -1;
    private static final double TIMER_RIGHT_MARG = -1;
    private static final double TIMER_BOTTOM_MARG = -1;
    private static final double TIMER_LEFT_MARG = -1;
    private static final double TIMER_TOP_PAD = -1;
    private static final double TIMER_RIGHT_PAD = -1;
    private static final double TIMER_BOTTOM_PAD = -1;
    private static final double TIMER_LEFT_PAD = -1;

    private static final double BLANK_INPUT_MESSAGE_MAX_WIDTH = -1;
    private static final double BLANK_INPUT_MESSAGE_TOP_MARG = -1;
    private static final double BLANK_INPUT_MESSAGE_RIGHT_MARG = -1;
    private static final double BLANK_INPUT_MESSAGE_BOTTOM_MARG = 0;
    private static final double BLANK_INPUT_MESSAGE_LEFT_MARG = -1;
    private static final double BLANK_INPUT_MESSAGE_TOP_PAD = 0;
    private static final double BLANK_INPUT_MESSAGE_RIGHT_PAD = -1;
    private static final double BLANK_INPUT_MESSAGE_BOTTOM_PAD = -1;
    private static final double BLANK_INPUT_MESSAGE_LEFT_PAD = -1;
    private static final String BLANK_INPUT_MESSAGE_STYLE = "-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold;";

    private static final double INCORRECT_MESSAGE_MAX_WIDTH = -1;
    private static final double INCORRECT_MESSAGE_TOP_MARG = -1;
    private static final double INCORRECT_MESSAGE_RIGHT_MARG = -1;
    private static final double INCORRECT_MESSAGE_BOTTOM_MARG = 0;
    private static final double INCORRECT_MESSAGE_LEFT_MARG = -1;
    private static final double INCORRECT_MESSAGE_TOP_PAD = 0;
    private static final double INCORRECT_MESSAGE_RIGHT_PAD = -1;
    private static final double INCORRECT_MESSAGE_BOTTOM_PAD = -1;
    private static final double INCORRECT_MESSAGE_LEFT_PAD = -1;
    private static final String INCORRECT_MESSAGE_STYLE = "-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold;";

    private static final double CORRECT_MESSAGE_MAX_WIDTH = -1;
    private static final double CORRECT_MESSAGE_TOP_MARG = -1;
    private static final double CORRECT_MESSAGE_RIGHT_MARG = -1;
    private static final double CORRECT_MESSAGE_BOTTOM_MARG = 0;
    private static final double CORRECT_MESSAGE_LEFT_MARG = -1;
    private static final double CORRECT_MESSAGE_TOP_PAD = 0;
    private static final double CORRECT_MESSAGE_RIGHT_PAD = -1;
    private static final double CORRECT_MESSAGE_BOTTOM_PAD = -1;
    private static final double CORRECT_MESSAGE_LEFT_PAD = -1;
    private static final String CORRECT_MESSAGE_STYLE = "-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold;";

    private final VBox root;
    private final Label question;
    private final TextField textField;
    private final Button submitButton;
    private final Label score;
    private final Label timer;

    private Label blankInputMessage;
    private Label incorrectMessage;
    private Label correctMessage;

    private final List<String> listOfQuestions;
    private final List<RoundInstance> listOfRounds;

    private int currentScore;
    private int currentTimeSeconds;
    private String currentQuestion;
    private String currentAnswer;
    private String userAnswer;
    private int currentQuestionCount;
    private boolean popupMessage;
    private boolean timerStart;
    private final BooleanProperty gameEnd;

    /**
     * Constructs a ca.bcit.comp2522.lab10.QuizAppPlaying screen, loading questions and initializing all UI components.
     *
     * @throws IOException if the questions file cannot be read
     */
    public QuizAppPlaying() throws IOException
    {
        final String[] questionAnswer;

        this.root = new VBox();
        this.question = question();
        this.textField = textField();
        this.submitButton = submitButton();
        this.score = score();
        this.timer = timer();

        this.currentScore = COUNT_MIN;
        this.currentQuestionCount = COUNT_MIN;
        this.currentTimeSeconds = UNIVERSAL_TIMER_LENGTH_SECONDS;

        this.listOfQuestions = FileToList.read(DIRECTORY);
        Collections.shuffle(this.listOfQuestions);

        this.listOfRounds = new ArrayList<>();

        questionAnswer = listOfQuestions.getFirst().split("\\|");

        this.currentQuestion = questionAnswer[0];
        this.currentAnswer = questionAnswer[1];

        this.question.setText(this.currentQuestion);

        this.gameEnd = new SimpleBooleanProperty(false);

        this.root.setAlignment(Pos.CENTER);
        this.root.setSpacing(UNIVERSAL_SPACING);
        this.root.setStyle(UNIVERSAL_STYLE);

        this.root.getChildren().add(this.question);
        this.root.getChildren().add(this.textField);
        this.root.getChildren().add(this.submitButton);
        this.root.getChildren().add(this.score);
        this.root.getChildren().add(this.timer);
    }

    /**
     * Displays a temporary popup message label in the root layout.
     *
     * @param message the Label to display temporarily
     */
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
        });

        pause.play();
    }

    /**
     * Processes the current text field input as an answer submission.
     */
    public final void onSubmit()
    {
        if (InputValidator.validateInput(this.textField.getText()))
        {
            this.root.getChildren().remove(this.blankInputMessage);
            this.userAnswer = this.textField.getText();
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

        this.gameEnd.set(currentQuestionCount == QUESTION_AMOUNT);
    }

    /**
     * Resets the game state and shuffles questions for a new round.
     */
    public final void resetGame()
    {
        this.timer.setVisible(false);
        Collections.shuffle(listOfQuestions);
        this.currentQuestionCount = COUNT_MIN;
        this.currentScore = COUNT_MIN;
        this.listOfRounds.clear();
        this.currentTimeSeconds = UNIVERSAL_TIMER_LENGTH_SECONDS;
        this.gameEnd.set(false);
        this.timerStart = false;
        updateQuestionAnswer();
        updateScore();
    }

    /**
     * Sets the game end property to false.
     */
    public final void setGameEndFalse()
    {
        this.gameEnd.set(false);
    }

    /**
     * Returns the root VBox layout node for this screen.
     *
     * @return the root VBox
     */
    public VBox getRoot()
    {
        return this.root;
    }

    /**
     * Returns the question label.
     *
     * @return the question Label
     */
    public Label getQuestion()
    {
        return this.question;
    }

    /**
     * Returns the answer text field.
     *
     * @return the answer TextField
     */
    public TextField getTextField()
    {
        return this.textField;
    }

    /**
     * Returns the submit button.
     *
     * @return the submit Button
     */
    public Button getSubmitButton()
    {
        return this.submitButton;
    }

    /**
     * Returns the score label.
     *
     * @return the score Label
     */
    public Label getScore()
    {
        return this.score;
    }

    /**
     * Returns the blank input message label.
     *
     * @return the blank input message Label
     */
    public Label getBlankInputMessage()
    {
        return this.blankInputMessage;
    }

    /**
     * Returns the incorrect answer message label.
     *
     * @return the incorrect message Label
     */
    public Label getIncorrectMessage()
    {
        return this.incorrectMessage;
    }

    /**
     * Returns the correct answer message label.
     *
     * @return the correct message Label
     */
    public Label getCorrectMessage()
    {
        return this.correctMessage;
    }

    /**
     * Returns the list of questions loaded from file.
     *
     * @return the list of question strings
     */
    public List<String> getListOfQuestions()
    {
        return this.listOfQuestions;
    }

    /**
     * Returns the player's current score.
     *
     * @return the current score
     */
    public int getCurrentScore()
    {
        return this.currentScore;
    }

    /**
     * Returns the current question string.
     *
     * @return the current question
     */
    public String getCurrentQuestion()
    {
        return this.currentQuestion;
    }

    /**
     * Returns the current correct answer string.
     *
     * @return the current answer
     */
    public String getCurrentAnswer()
    {
        return this.currentAnswer;
    }

    /**
     * Returns the player's most recent answer.
     *
     * @return the user's answer string
     */
    public String getUserAnswer()
    {
        return this.userAnswer;
    }

    /**
     * Returns the list of completed round instances.
     *
     * @return the list of ca.bcit.comp2522.lab10.RoundInstance objects
     */
    public List<RoundInstance> getListOfRounds()
    {
        return this.listOfRounds;
    }

    /**
     * Returns the current question count.
     *
     * @return the number of questions answered so far
     */
    public int getCurrentQuestionCount()
    {
        return this.currentQuestionCount;
    }

    /**
     * Returns whether a popup message is currently displayed.
     *
     * @return true if a popup message is visible, false otherwise
     */
    public boolean isPopupMessage()
    {
        return this.popupMessage;
    }

    /**
     * Returns the game end boolean property for listener binding.
     *
     * @return the gameEnd BooleanProperty
     */
    public final BooleanProperty isGameEndProperty()
    {
        return this.gameEnd;
    }

    /**
     * Returns whether the game has ended.
     *
     * @return true if the game has ended, false otherwise
     */
    public final boolean isGameEnd()
    {
        return this.gameEnd.get();
    }

    private final void updateQuestionAnswer()
    {
        final String[] questionAnswer;

        questionAnswer = listOfQuestions.get(currentQuestionCount).split("\\|");

        this.currentQuestion = questionAnswer[0];
        this.currentAnswer = questionAnswer[1];

        this.question.setText(this.currentQuestion);
    }

    private final void updateScore()
    {
        this.score.setText("Your score: " + this.currentScore);
    }

    private final void updateTimer(final int time)
    {
        this.timer.setText("Timer: " + time);
    }

    private final void timerLogic()
    {
        final Timeline timeline;

        timeline = new Timeline();

        timeline.getKeyFrames().add(new KeyFrame(
                Duration.seconds(1),
                event ->
                {
                    --this.currentTimeSeconds;
                    updateTimer(this.currentTimeSeconds);
                    this.timer.setVisible(true);

                    if (this.currentTimeSeconds <= COUNT_MIN)
                    {
                        timeline.stop();
                        this.gameEnd.set(true);
                    }
                }
        ));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private final void checkAnswer()
    {
        final RoundInstance round;
        final String mark;

        if (this.userAnswer.trim().equalsIgnoreCase(this.currentAnswer.trim()))
        {
            this.correctMessage = correctMessage();
            popMessage(this.correctMessage);
            ++this.currentScore;
            mark = "Correct";
        }

        else
        {
            this.incorrectMessage = incorrectMessage();
            popMessage(this.incorrectMessage);
            mark = "Incorrect";
        }

        round = new RoundInstance(this.currentQuestionCount + 1, this.currentQuestion, this.userAnswer, this.currentAnswer, mark);

        ++this.currentQuestionCount;

        this.listOfRounds.add(round);
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

        inputField.addEventHandler(KeyEvent.KEY_PRESSED, event ->
        {
            if (!this.timerStart)
            {
                this.timerStart = true;
                timerLogic();
            }

            if (event.getCode() == KeyCode.ENTER && !this.gameEnd.get())
            {
                onSubmit();
            }
        });

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

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> onSubmit());

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

    private final Label timer()
    {
        final Label timer;

        timer = new Label();

        timer.setVisible(false);

        VBox.setMargin(timer, new Insets(TIMER_TOP_MARG,
                TIMER_RIGHT_MARG,
                TIMER_BOTTOM_MARG,
                TIMER_LEFT_MARG));

        timer.setPadding(new Insets(TIMER_TOP_PAD,
                TIMER_RIGHT_PAD,
                TIMER_BOTTOM_PAD,
                TIMER_LEFT_PAD));

        return timer;
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