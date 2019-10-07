package se.lexicon.exceptions.trails;

import java.util.Scanner;

public class ExScanner {

    private Scanner scanner;

    public ExScanner()
    {
        scanner = new Scanner(System.in);
    }
    public ExScanner(String input)  //For test to fake input from user
    {
        scanner = new Scanner(input);
    }

    /***
     *
     * @return Will return a valid number from user
     */
    public double scanDouble()
    {
        double number = 0;
        boolean notANumber = true;

        while (notANumber)
        {
            try
            {
                number = Double.parseDouble(scanner.nextLine());
                notANumber = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println(e);
            }
        }

        return number;
    }

    public int scanInteger() throws NumberFormatException
    {
        int number = 0;

        number = Integer.parseInt(scanner.nextLine());

        return number;
    }
}
