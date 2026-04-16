package ca.bcit.comp2522.lab10;

/**
 * Represents a single round of the Quiz App, storing the question, answers, and result.
 *
 * @author Kiet Tran, AngEng Nay
 *
 * @version 1.0
 */
public class RoundInstance
{
    private final int roundNumber;
    private final String roundQuestion;
    private final String userAnswer;
    private final String actualAnswer;
    private final String roundMark;

    /**
     * Constructs a RoundInstance with the given round details.
     *
     * @param roundNumber the sequential number of this round
     * @param roundQuestion the question presented to the player
     * @param userAnswer the answer submitted by the player
     * @param actualAnswer the correct answer to the question
     * @param roundMark the result of the round, either "Correct" or "Incorrect"
     */
    public RoundInstance(final int roundNumber,
                         final String roundQuestion,
                         final String userAnswer,
                         final String actualAnswer,
                         final String roundMark)
    {
        this.roundNumber = roundNumber;
        this.roundQuestion = roundQuestion;
        this.userAnswer = userAnswer;
        this.actualAnswer = actualAnswer;
        this.roundMark = roundMark;
    }

    /**
     * Returns the round number.
     *
     * @return the sequential round number
     */
    public final int getRoundNumber()
    {
        return this.roundNumber;
    }

    /**
     * Returns the question for this round.
     *
     * @return the round question string
     */
    public final String getRoundQuestion()
    {
        return this.roundQuestion;
    }

    /**
     * Returns the answer submitted by the player.
     *
     * @return the user's answer string
     */
    public final String getUserAnswer()
    {
        return this.userAnswer;
    }

    /**
     * Returns the correct answer for this round.
     *
     * @return the actual answer string
     */
    public final String getActualAnswer()
    {
        return this.actualAnswer;
    }

    /**
     * Returns the result mark for this round.
     *
     * @return the round mark, either "Correct" or "Incorrect"
     */
    public final String getRoundMark()
    {
        return this.roundMark;
    }
}