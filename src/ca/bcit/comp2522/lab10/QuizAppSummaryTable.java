package ca.bcit.comp2522.lab10;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private static final int UNIVERSAL_SPACING = 10;
    private static final String UNIVERSAL_STYLE = "-fx-font-size: 18px;";
    private static final double UNIVERSAL_MESSAGE_DURATION_SECONDS = 3;

    private static final double TABLE_MAX_WIDTH = -1;
    private static final double TABLE_TOP_MARG = -1;
    private static final double TABLE_RIGHT_MARG = -1;
    private static final double TABLE_BOTTOM_MARG = 0;
    private static final double TABLE_LEFT_MARG = -1;
    private static final double TABLE_TOP_PAD = 0;
    private static final double TABLE_RIGHT_PAD = -1;
    private static final double TABLE_BOTTOM_PAD = -1;
    private static final double TABLE_LEFT_PAD = -1;
    private static final String TABLE_STYLE = "-fx-font-size:12px; -fx-text-fill: black; -fx-font-weight: bold;";

    private static final double BACK_BUTTON_MAX_WIDTH = -1;
    private static final double BACK_BUTTON_TOP_MARG = 80;
    private static final double BACK_BUTTON_RIGHT_MARG = -1;
    private static final double BACK_BUTTON_BOTTOM_MARG = -1;
    private static final double BACK_BUTTON_LEFT_MARG = -1;
    private static final double BACK_BUTTON_TOP_PAD = 10;
    private static final double BACK_BUTTON_RIGHT_PAD = 10;
    private static final double BACK_BUTTON_BOTTOM_PAD = 10;
    private static final double BACK_BUTTON_LEFT_PAD = 10;
    private static final String BACK_BUTTON_STYLE = "-fx-font-size: 24px; -fx-text-fill: #06402B; -fx-background-color: #96D9C0";

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

        this.root.setAlignment(Pos.CENTER);
        this.root.setSpacing(UNIVERSAL_SPACING);
        this.root.setStyle(UNIVERSAL_STYLE);

        this.root.getChildren().add(this.table);
        this.root.getChildren().add(this.backButton);
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

    private final TableView<RoundInstance> table()
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

        VBox.setMargin(table, new Insets(TABLE_TOP_MARG,
                TABLE_RIGHT_MARG,
                TABLE_BOTTOM_MARG,
                TABLE_LEFT_MARG));

        table.setPadding(new Insets(TABLE_TOP_PAD,
                TABLE_RIGHT_PAD,
                TABLE_BOTTOM_PAD,
                TABLE_LEFT_PAD));

        table.setStyle(TABLE_STYLE);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        return table;
    }

    private final Button backButton()
    {
        final Button backButton;

        backButton = new Button();

        backButton.setText("Back");
        backButton.setStyle(BACK_BUTTON_STYLE);

        VBox.setMargin(backButton, new Insets(BACK_BUTTON_TOP_MARG,
                BACK_BUTTON_RIGHT_MARG,
                BACK_BUTTON_BOTTOM_MARG,
                BACK_BUTTON_LEFT_MARG));

        backButton.setPadding(new Insets(BACK_BUTTON_TOP_PAD,
                BACK_BUTTON_RIGHT_PAD,
                BACK_BUTTON_BOTTOM_PAD,
                BACK_BUTTON_LEFT_PAD));

        return backButton;
    }
}