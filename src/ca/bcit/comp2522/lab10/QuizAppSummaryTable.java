package ca.bcit.comp2522.lab10;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Represents the summary statistics screen of the Quiz App, displaying round results in a table.
 *
 * @author Kiet Tran
 *
 * @version 1.0
 */
public class QuizAppSummaryTable
{
    private final VBox root;
    private final TableView<RoundInstance> table;
    private final Button backButton;

    /**
     * Constructs a ca.bcit.comp2522.lab10.SummaryTable screen, initializing the results table and back button.
     */
    public QuizAppSummaryTable()
    {
        this.root = new VBox();
        this.table = table();
        this.backButton = backButton();

        this.root.getStyleClass().add("summary-Root");
        this.table.getStyleClass().add("summary-Table");
        this.backButton.getStyleClass().add("summary-BackButton");

        this.root.getChildren().addAll( this.table,
                                        this.backButton);
    }

    /**
     * Populates the table with the given list of round results.
     *
     * @param rounds the list of ca.bcit.comp2522.lab10.RoundInstance objects to display
     */
    public final void insertData(final List<RoundInstance> rounds)
    {
        this.table.getItems().clear();
        this.table.getItems().addAll(rounds);
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
     * Returns the results table view.
     *
     * @return the TableView of ca.bcit.comp2522.lab10.RoundInstance objects
     */
    public final TableView<RoundInstance> getTable()
    {
        return this.table;
    }

    /**
     * Returns the back button.
     *
     * @return the back Button
     */
    public final Button getBackButton()
    {
        return this.backButton;
    }

    /*
     * Creates and configures the table used to display round results.
     *
     * @return the configured TableView of RoundInstance objects
     */
    private TableView<RoundInstance> table()
    {
        final TableView<RoundInstance> table;
        final TableColumn<RoundInstance, Integer> numberCol;
        final TableColumn<RoundInstance, String> questionCol;
        final TableColumn<RoundInstance, String> userAnswerCol;
        final TableColumn<RoundInstance, String> actualAnswerCol;
        final TableColumn<RoundInstance, String> markCol;
        final PropertyValueFactory<RoundInstance, Integer> numberFactory;
        final PropertyValueFactory<RoundInstance, String> questionFactory;
        final PropertyValueFactory<RoundInstance, String> userAnswerFactory;
        final PropertyValueFactory<RoundInstance, String> actualAnswerFactory;
        final PropertyValueFactory<RoundInstance, String> markFactory;

        table = new TableView<>();
        numberCol = new TableColumn<>("Number");
        questionCol = new TableColumn<>("Question");
        userAnswerCol = new TableColumn<>("Your Answer");
        actualAnswerCol = new TableColumn<>("Actual Answer");
        markCol = new TableColumn<>("Mark");
        numberFactory = new PropertyValueFactory<>("roundNumber");
        questionFactory = new PropertyValueFactory<>("roundQuestion");
        userAnswerFactory = new PropertyValueFactory<>("userAnswer");
        actualAnswerFactory = new PropertyValueFactory<>("actualAnswer");
        markFactory = new PropertyValueFactory<>("roundMark");

        numberCol.setCellValueFactory(numberFactory);
        questionCol.setCellValueFactory(questionFactory);
        userAnswerCol.setCellValueFactory(userAnswerFactory);
        actualAnswerCol.setCellValueFactory(actualAnswerFactory);
        markCol.setCellValueFactory(markFactory);

        table.getColumns().add(numberCol);
        table.getColumns().add(questionCol);
        table.getColumns().add(userAnswerCol);
        table.getColumns().add(actualAnswerCol);
        table.getColumns().add(markCol);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        return table;
    }

    /*
     * Creates the button that returns to the ending screen.
     *
     * @return the back Button
     */
    private Button backButton()
    {
        final Button backButton;

        backButton = new Button();

        backButton.setText("Back");

        return backButton;
    }
}