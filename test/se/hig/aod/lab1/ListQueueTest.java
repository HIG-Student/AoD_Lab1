package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the ListQueue
 * 
 * @author Viktor Hanstorp (ndi14vhp@student.hig.se) <br>
 * <br>
 *         Based on work by: Peter Jenke
 */
public class ListQueueTest
{
    /**
     * The queue we are testing
     */
    ListQueue<Character> testQueue;
    /**
     * Characters to test
     */
    char[] fixture = { 'a', 'b', 'c', 'd' };

    /**
     * Set up a empty queue
     * 
     * @throws Exception
     *             on error
     */
    @Before
    public void setUp() throws Exception
    {
        testQueue = new ListQueue<Character>();
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
        testQueue = null;
    }

    /**
     * A queue should be empty when created, lets check
     */
    @Test
    public void testNewQueueIsEmpty()
    {
        assertTrue("A new instance cannot contain any item!", testQueue.isEmpty());
    }

    /**
     * A queue should not be empty after we put something in it, lets check
     */
    @Test
    public void testQueueWithItemNotEmpty()
    {
        testQueue.enqueue('a');
        assertFalse("Containing an item but empty!", testQueue.isEmpty());
    }

    /**
     * The queue should throw QueueEmptyException if you try to dequeue from a
     * empty queue, lets check
     */
    @Test(expected = QueueEmptyException.class)
    public void testDequeueOnEmptyQueue()
    {
        testQueue.dequeue();
    }

    /**
     * The queue should be empty if you remove stuff you put in, lets check
     */
    @Test
    public void testQueueIsEmptyAfterDequeue()
    {
        testQueue.enqueue('a');
        testQueue.dequeue();
        assertTrue("Not empty after dequeue!", testQueue.isEmpty());
    }

    /**
     * The queue should throw QueueEmptyException if you try to peek on a empty
     * queue, lets check
     */
    @Test(expected = QueueEmptyException.class)
    public void testFrontOnEmptyQueue()
    {
        testQueue.getFront();
    }

    /**
     * The queue's 'front' method should give us a peek on the first element,
     * lets check
     */
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

    /**
     * The queue should be First-In First-Out, lets check
     */
    @Test
    public void testDequeueOrder()
    {
        for (int i = 0; i < fixture.length; i++)
            testQueue.enqueue(fixture[i]);

        for (Character c : fixture)
            assertEquals("Incorrect dequeue order!", c, testQueue.dequeue());

        assertTrue("Not empty after dequeues!", testQueue.isEmpty());
    }

    /**
     * The queue should be empty when cleared (even if it already was empty),
     * lets check
     */
    @Test
    public void testClearEmptyQueue()
    {
        testQueue.clear();
        assertTrue("Clear seems to be inversed?", testQueue.isEmpty());
    }

    /**
     * The queue should be empty when cleared, lets check
     */
    @Test
    public void testClearDequeueulatedQueue()
    {
        for (Character c : fixture)
            testQueue.enqueue(c);

        testQueue.clear();

        assertTrue("Not empty after clear!", testQueue.isEmpty());
    }
}
