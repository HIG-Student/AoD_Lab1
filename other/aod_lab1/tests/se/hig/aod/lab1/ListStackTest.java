package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListStackTest
{
	ListStack<Character> testStack;
	char[] fixture = {'a', 'b', 'c', 'd'};

	@Before
	public void setUp () throws Exception
	{
		testStack = new ListStack<Character> ();
	}

	@After
	public void tearDown () throws Exception
	{
		testStack = null;
	}

	@Test
	public void testNewStackIsEmpty ()
	{
		assertTrue ("A new instance cannot contain any item!", testStack.isEmpty ());
	}

	@Test
	public void testStackWithItemNotEmpty ()
	{
		testStack.push ('a');
		assertFalse ("Containing an item but empty!", testStack.isEmpty ());
	}

	@Test
	public void testPopOnEmptyStack ()
	{
		try
		{
			testStack.pop ();
			fail ("Expected: StackEmptyException!");
		} catch (StackEmptyException e)
		{
			assertNotNull ("Expected: StackEmptyException!", e);
		}
	}

	@Test
	public void testStackIsEmptyAfterPop ()
	{
		fail ("Not yet implemented"); // TODO
	}

	@Test
	public void testPopOrder ()
	{
		fail ("Not yet implemented"); // TODO
	}

	@Test
	public void testClearEmptyStack ()
	{
		fail ("Not yet implemented"); // TODO
	}

	@Test
	public void testClearPopulatedStack ()
	{
		fail ("Not yet implemented"); // TODO
	}
}
