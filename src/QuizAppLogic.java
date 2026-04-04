import java.util.List;
import java.util.Scanner;

public class QuizAppLogic
{


    public static final boolean validateInput(final String input)
    {
        return !(input == null || input.isBlank());
    }

    public static final String userInput()
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


