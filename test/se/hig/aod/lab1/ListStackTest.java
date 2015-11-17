package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the ListStack
 * 
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se) <br>
 * <br>
 *         Based on work by: Peter Jenke
 */
public class ListStackTest
{
    /**
     * The stack we are testing
     */
    ListStack<Character> testStack;
    /**
     * Characters to test
     */
    char[] fixture = { 'a', 'b', 'c', 'd' };

    /**
     * Set up a empty stack
     * 
     * @throws Exception
     *             on error
     */
    @Before
    public void setUp() throws Exception
    {
        testStack = new ListStack<Character>();
    }

    /**
     * Some "clean up" (not really needed)
     * 
     * @throws Exception
     *             on error
     */
    @After
    public void tearDown() throws Exception
    {
        testStack = null;
    }

    /**
     * A stack should be empty when created, lets check
     */
    @Test
    public void testNewStackIsEmpty()
    {
        assertTrue("A new instance cannot contain any item!", testStack.isEmpty());
    }

    /**
     * A stack should not be empty after we put something in it, lets check
     */
    @Test
    public void testStackWithItemNotEmpty()
    {
        testStack.push('a');
        assertFalse("Containing an item but empty!", testStack.isEmpty());
    }

    /**
     * The stack should throw StackEmptyException if you try to destack from a
     * empty stack, lets check
     */
    @Test(expected = StackEmptyException.class)
    public void testPopOnEmptyStack()
    {
        testStack.pop();
    }

    /**
     * The stack should be empty if you remove stuff you put in, lets check
     */
    @Test
    public void testStackIsEmptyAfterPop()
    {
        testStack.push('a');
        testStack.pop();
        assertTrue("Not empty after pop!", testStack.isEmpty());
    }

    /**
     * The stack should throw StackEmptyException if you try to peek on a empty
     * stack, lets check
     */
    @Test(expected = StackEmptyException.class)
    public void testTopOnEmptyStack()
    {
        testStack.top();
    }

    /**
     * The stack's 'front' method should give us a peek on the first element,
     * lets check
     */
    @Test
    public void testTop()
    {
        testStack.push('a');
        assertEquals("Incorrect top!", new Character('a'), testStack.top());
        testStack.push('b');
        assertEquals("Incorrect top!", new Character('b'), testStack.top());
        testStack.push('c');
        assertEquals("Incorrect top!", new Character('c'), testStack.top());
        testStack.pop();
        assertEquals("Incorrect top after pop!", new Character('b'), testStack.top());
    }

    /**
     * The stack should be First-In Last-Out, lets check
     */
    @Test
    public void testPopOrder()
    {
        Character[] expected = new Character[fixture.length];

        for (int i = 0; i < fixture.length; i++)
        {
            char c = fixture[i];

            testStack.push(c);
            expected[fixture.length - (i + 1)] = c;
        }

        for (Character c : expected)
            assertEquals("Incorrect pop order!", c, testStack.pop());

        assertTrue("Not empty after pops!", testStack.isEmpty());
    }

    /**
     * The stack should be empty when cleared (even if it already was empty),
     * lets check
     */
    @Test
    public void testClearEmptyStack()
    {
        testStack.clear();
        assertTrue("Clear seems to be inversed?", testStack.isEmpty());
    }

    /**
     * The stack should be empty when cleared, lets check
     */
    @Test
    public void testClearPopulatedStack()
    {
        for (Character c : fixture)
            testStack.push(c);

        testStack.clear();

        assertTrue("Not empty after clear!", testStack.isEmpty());
    }
}
