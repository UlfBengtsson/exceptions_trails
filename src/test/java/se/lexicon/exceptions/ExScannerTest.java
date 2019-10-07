package se.lexicon.exceptions;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import se.lexicon.exceptions.trails.ExScanner;

/**
 * Unit test for simple App.
 */
public class ExScannerTest
{

    @Test
    public void doubleNumberOkTest1()
    {
        String goodInput = "2.3";
        ExScanner scan = new ExScanner(goodInput);

        double result = scan.scanDouble();

        assertTrue( result == 2.3 );
    }

    @Test
    public void doubleNumberOkTest2()
    {
        String goodInput = "4.8";
        ExScanner scan = new ExScanner(goodInput);

        double result = scan.scanDouble();

        assertTrue( result == 4.8 );
    }

    @Test
    public void doubleNumberBadThenGoodTest()
    {
        String badInput = "nope\n2.3";
        ExScanner scan = new ExScanner(badInput);

        double result = scan.scanDouble();

        assertTrue( result == 2.3 );
    }

    @Test
    public void doubleNumberBadBadThenGoodTest()
    {
        String badInput = "nope\nhello?\n2.3";
        ExScanner scan = new ExScanner(badInput);

        double result = scan.scanDouble();

        assertTrue( result == 2.3 );
    }

    @Test
    public void intNumberOkTest1()
    {
        String goodInput = "2";
        ExScanner scan = new ExScanner(goodInput);

        int result = scan.scanInteger();

        assertTrue( result == 2 );
    }

    @Test
    public void intNumberOkTest2()
    {
        String goodInput = "32512";
        ExScanner scan = new ExScanner(goodInput);

        int result = scan.scanInteger();

        assertTrue( result == 32512 );
    }

    @Test
    public void intNumberBadThenGoodTest()
    {
        String badInput = "nope\n2";
        ExScanner scan = new ExScanner(badInput);
        boolean notOk = true;
        int result = 0;
        int badCounter = 0;

        do {
            try {
                result = scan.scanInteger();
                notOk = false;
            }
            catch (NumberFormatException e)
            {
                badCounter++;
            }
        } while (notOk);


        assertTrue( result == 2 );
        assertTrue( badCounter == 1 );
    }

    @Test
    public void intNumberBadBadThenGoodTest()
    {
        String badInput = "nope\nohno\n2";
        ExScanner scan = new ExScanner(badInput);
        boolean notOk = true;
        int result = 0;
        int badCounter = 0;

        do {
            try {
                result = scan.scanInteger();
                notOk = false;
            }
            catch (NumberFormatException e)
            {
                badCounter++;
            }
        } while (notOk);

        assertTrue( result == 2 );
        assertTrue( badCounter == 2 );
    }
}
