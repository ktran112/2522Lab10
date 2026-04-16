package ca.bcit.comp2522.lab10;

import java.util.Scanner;

/**
 * Utility class for reading and validating user input from the console.
 *
 * @author Kiet Tran, AngEng Nay
 *
 * @version 1.0
 */
public class InputValidator
{
    private InputValidator() {}

    /**
     * Validates user input.
     * Constraints:
     *  - Cannot be null
     *  - Cannot be blank
     *
     * @param input to be validated
     * @return true if input is non-null and not blank; false otherwise.
     */
    public static boolean validateInput(final String input)
    {
        return !(input == null || input.isBlank());
    }

    /**
     * Reads a non-blank string from the console, re-prompting until valid input is given.
     *
     * @return the trimmed lowercase string entered by the user
     */
    public static String userInput()
    {
        String input;
        final Scanner scan;

        scan = new Scanner(System.in);

        input = scan.nextLine().trim().toLowerCase();

        while (!validateInput(input))
        {
            System.out.println("Empty guess. Try again.");
            input = scan.nextLine().trim().toLowerCase();
        }

        return input;
    }
}