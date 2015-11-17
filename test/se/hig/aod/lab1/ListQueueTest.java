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
public class ListQueueTest
{
    ListQueue<Character> testQueue;
    char[] fixture = { 'a', 'b', 'c', 'd' };

    @Before
    public void setUp() throws Exception
    {
        testQueue = new ListQueue<Character>();
    }

    @After
    public void tearDown() throws Exception
    {
        testQueue = null;
    }

    @Test
    public void testNewQueueIsEmpty()
    {
        assertTrue("A new instance cannot contain any item!", testQueue.isEmpty());
    }

    @Test
    public void testQueueWithItemNotEmpty()
    {
        testQueue.enqueue('a');
        assertFalse("Containing an item but empty!", testQueue.isEmpty());
    }

    @Test(expected = QueueEmptyException.class)
    public void testDequeueOnEmptyQueue()
    {
        testQueue.dequeue();
    }

    @Test
    public void testQueueIsEmptyAfterDequeue()
    {
        testQueue.enqueue('a');
        testQueue.dequeue();
        assertTrue("Not empty after dequeue!", testQueue.isEmpty());
    }

    @Test(expected = QueueEmptyException.class)
    public void testFrontOnEmptyQueue()
    {
        testQueue.getFront();
    }

    @Test
    public void testFront()
    {
        testQueue.enqueue('a');
        assertEquals("Incorrect front!", new Character('a'), testQueue.getFront());
        testQueue.enqueue('b');
        assertEquals("Incorrect front!", new Character('a'), testQueue.getFront());
        testQueue.enqueue('c');
        assertEquals("Incorrect front!", new Character('a'), testQueue.getFront());
        testQueue.dequeue();
        assertEquals("Incorrect front after dequeue!", new Character('b'), testQueue.getFront());
    }

    @Test
    public void testDequeueOrder()
    {
        for (int i = 0; i < fixture.length; i++)
            testQueue.enqueue(fixture[i]);

        for (Character c : fixture)
            assertEquals("Incorrect dequeue order!", c, testQueue.dequeue());

        assertTrue("Not empty after dequeues!", testQueue.isEmpty());
    }

    @Test
    public void testClearEmptyQueue()
    {
        testQueue.clear();
        assertTrue("Clear seems to be inversed?", testQueue.isEmpty());
    }

    @Test
    public void testClearDequeueulatedQueue()
    {
        for (Character c : fixture)
            testQueue.enqueue(c);

        testQueue.clear();

        assertTrue("Not empty after clear!", testQueue.isEmpty());
    }
}
