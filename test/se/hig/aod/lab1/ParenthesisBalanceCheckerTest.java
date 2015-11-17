package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the ParenthesisBalanceChecker
 * 
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se)
 */
public class ParenthesisBalanceCheckerTest
{
    void assertBalanced(String toTest)
    {
        assertTrue("'" + toTest + "' is not true!", ParenthesisBalanceChecker.checkBalance(toTest).balanced);
    }

    void assertUnbalanced(String toTest)
    {
        assertFalse("'" + toTest + "' is not false!", ParenthesisBalanceChecker.checkBalance(toTest).balanced);
    }

    /**
     * Test some correctly formatted parenthesis strings
     */
    @Test
    public void testCorrectPure()
    {
        assertBalanced("()");
        assertBalanced("(())");
        assertBalanced("(()())");
        assertBalanced("((()()))");
        assertBalanced("");
    }

    /**
     * Test some correctly formatted parenthesis strings with characters inside
     */
    @Test
    public void testCorrectMess()
    {
        assertBalanced("a(a)a");
        assertBalanced("b(bb(b)bbb)b");
        assertBalanced("((c)cc()c)");
        assertBalanced("dd(d(()dd(d)))d");
        assertBalanced("eee");
    }

    /**
     * Test some incorrectly formatted parenthesis strings
     */
    @Test
    public void testIncorrectPure()
    {
        assertUnbalanced(")(");
        assertUnbalanced("())");
        assertUnbalanced("(()");
        assertUnbalanced("((((");
        assertUnbalanced("))))");
    }

    /**
     * Test some incorrectly formatted parenthesis strings with characters
     * inside
     */
    @Test
    public void testIncorrectMess()
    {
        assertUnbalanced("aa)(");
        assertUnbalanced("b(bbbbb))");
        assertUnbalanced("cccc(c(c)cc");
        assertUnbalanced("d(d(d((");
        assertUnbalanced("eee)))e)eeeeee");
    }
}
