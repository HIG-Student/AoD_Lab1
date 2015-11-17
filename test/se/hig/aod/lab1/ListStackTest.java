package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se) <br>
 * <br>
 *         Based on work by: Peter Jenke
 */
public class ListStackTest
{
    ListStack<Character> testStack;
    char[] fixture = { 'a', 'b', 'c', 'd' };

    @Before
    public void setUp() throws Exception
    {
        testStack = new ListStack<Character>();
    }

    @After
    public void tearDown() throws Exception
    {
        testStack = null;
    }

    @Test
    public void testNewStackIsEmpty()
    {
        assertTrue("A new instance cannot contain any item!", testStack.isEmpty());
    }

    @Test
    public void testStackWithItemNotEmpty()
    {
        testStack.push('a');
        assertFalse("Containing an item but empty!", testStack.isEmpty());
    }

    @Test(expected = StackEmptyException.class)
    public void testPopOnEmptyStack()
    {
        testStack.pop();
    }

    @Test
    public void testStackIsEmptyAfterPop()
    {
        testStack.push('a');
        testStack.pop();
        assertTrue("Not empty after pop!", testStack.isEmpty());
    }
    
    @Test(expected = StackEmptyException.class)
    public void testTopOnEmptyStack()
    {
        testStack.top();
    }
    
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

    @Test
    public void testClearEmptyStack()
    {
        testStack.clear();
        assertTrue("Clear seems to be inversed?", testStack.isEmpty());
    }

    @Test
    public void testClearPopulatedStack()
    {
        for (Character c : fixture)
            testStack.push(c);
        
        testStack.clear();
        
        assertTrue("Not empty after clear!", testStack.isEmpty());
    }
}
