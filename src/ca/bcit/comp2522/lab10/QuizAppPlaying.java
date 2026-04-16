package ca.bcit.comp2522.lab10;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
 * @author Kiet Tran, AngEng Nay
 *
 * @version 1.0
 */
public class QuizAppPlaying
{
    private static final int QUESTION_AMOUNT = 10;
    private static final int COUNT_MIN = 0;
    private static final int COUNT_MAX = Integer.MAX_VALUE;

    private static final String DIRECTORY = "questions.txt";

    private static final double UNIVERSAL_MESSAGE_DURATION_SECONDS = 3;
    private static final int UNIVERSAL_TIMER_LENGTH_SECONDS = 60;

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

        this.root.getStyleClass().add("playing-Root");
        this.question.getStyleClass().add("playing-Question");
        this.textField.getStyleClass().add("playing-TextField");
        this.submitButton.getStyleClass().add("playing-SubmitButton");
        this.score.getStyleClass().add("playing-Score");
        this.timer.getStyleClass().add("playing-Timer");

        this.root.getChildren().addAll( this.question,
                                        this.textField,
                                        this.submitButton,
                                        this.score,
                                        this.timer);
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
                this.blankInputMessage.getStyleClass().add("playing-BlankInputMessage");
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

    /*
     * Updates the current question and answer using the current question index.
     */
    private void updateQuestionAnswer()
    {
        final String[] questionAnswer;

        questionAnswer = listOfQuestions.get(currentQuestionCount).split("\\|");

        this.currentQuestion = questionAnswer[0];
        this.currentAnswer = questionAnswer[1];

        this.question.setText(this.currentQuestion);
    }

    /*
     * Updates the score label to reflect the player's current score.
     */
    private void updateScore()
    {
        this.score.setText("Your score: " + this.currentScore);
    }

    /*
     * Updates the timer label with the given remaining time.
     *
     * @param time the number of seconds remaining
     */
    private void updateTimer(final int time)
    {
        this.timer.setText("Timer: " + time);
    }

    /*
     * Starts and runs the countdown timer for the quiz.
     */
    private void timerLogic()
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

    /*
     * Checks the player's submitted answer, records the round result,
     * and updates the score and feedback message.
     */
    private void checkAnswer()
    {
        final RoundInstance round;
        final String mark;

        if (this.userAnswer.trim().equalsIgnoreCase(this.currentAnswer.trim()))
        {
            this.correctMessage = correctMessage();
            this.correctMessage.getStyleClass().add("playing-CorrectMessage");
            popMessage(this.correctMessage);
            ++this.currentScore;
            mark = "Correct";
        }

        else
        {
            this.incorrectMessage = incorrectMessage();
            this.incorrectMessage.getStyleClass().add("playing-IncorrectMessage");
            popMessage(this.incorrectMessage);
            mark = "Incorrect";
        }

        round = new RoundInstance(this.currentQuestionCount + 1, this.currentQuestion, this.userAnswer, this.currentAnswer, mark);

        ++this.currentQuestionCount;

        this.listOfRounds.add(round);
    }

    /*
     * Creates the label used to display quiz questions.
     *
     * @return the question Label
     */
    private Label question()
    {
        final Label question;

        question = new Label();

        return question;
    }

    /*
     * Creates the text field used for entering answers and
     * attaches its keyboard event handlers.
     *
     * @return the answer TextField
     */
    private TextField textField()
    {
        final TextField inputField;

        inputField = new TextField();

        inputField.setPromptText("Enter your answer");

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

    /*
     * Creates the submit button and attaches its mouse click handler.
     *
     * @return the submit Button
     */
    private Button submitButton()
    {
        final Button btn;

        btn = new Button();

        btn.setText("Submit");

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> onSubmit());

        return btn;
    }

    /*
     * Creates the score label.
     *
     * @return the score Label
     */
    private Label score()
    {
        final Label score;

        score = new Label();

        return score;
    }

    /*
     * Creates the timer label.
     *
     * @return the timer Label
     */
    private Label timer()
    {
        final Label timer;

        timer = new Label();

        timer.setVisible(false);

        return timer;
    }

    /*
     * Creates the popup label shown when the input field is blank.
     *
     * @return the blank input message Label
     */
    private Label blankInputMessage()
    {
        final Label blankInputMessage;

        blankInputMessage = new Label();

        blankInputMessage.setText("Text field is empty");

        return blankInputMessage;
    }

    /*
     * Creates the popup label shown when the submitted answer is incorrect.
     *
     * @return the incorrect message Label
     */
    private Label incorrectMessage()
    {
        final Label incorrectMessage;

        incorrectMessage = new Label();

        incorrectMessage.setText("Incorrect \uD83D\uDE14");

        return incorrectMessage;
    }

    /*
     * Creates the popup label shown when the submitted answer is correct.
     *
     * @return the correct message Label
     */
    private Label correctMessage()
    {
        final Label correctMessage;

        correctMessage = new Label();

        correctMessage.setText("Correct \uD83D\uDE01");

        return correctMessage;
    }
}