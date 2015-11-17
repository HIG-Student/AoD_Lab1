package se.hig.aod.grupp;

/**
 * This is free to use in courses at University of Gävle.
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import se.hig.aod.lab1.ListQueue;
import se.hig.aod.lab1.Queue;
import se.hig.aod.lab1.QueueIsEmptyException;

/**
 * A class that uses a {@link Queue}
 */

public class TestQueue
{
    Object a;
    Object b;
    Queue kon;

    @Before
    public void setUp()
    {
        kon = new ListQueue();
        assertTrue("Kon not empty!", kon.isEmpty());
    }

    @Test(expected = QueueIsEmptyException.class)
    public void testDequeOnEmpty()
    {
        kon.dequeue();
    }

    @Test
    public void testEnqueOnEmpty()
    {
        kon.enqueue(new Object());
        assertFalse("Onject not added!", kon.isEmpty());
    }

    @Test
    public void testEnque()
    {
        kon.enqueue(new Object());
        assertFalse("Onject not added!", kon.isEmpty());
        kon.enqueue(new Object());
        assertFalse("Kon is suddenly empty!", kon.isEmpty());
    }

    @Test
    public void testDeque()
    {
        kon.enqueue(a = new Object());
        assertFalse("Onject not added!", kon.isEmpty());
        kon.enqueue(b = new Object());
        assertFalse("Kon is suddenly empty!", kon.isEmpty());
        assertEquals("Entry is not same!", a, kon.dequeue());
        assertFalse("Kon is suddenly empty!", kon.isEmpty());
        assertEquals("Entry is not same!", b, kon.dequeue());
        assertTrue("Kon is not empty!", kon.isEmpty());
    }
}
