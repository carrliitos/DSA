import java.util.NoSuchElementException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Benzon Carlitos Salazar
 */
public class QueueTest
{
	private Queue instance  = new Queue();

	public QueueTest() {}

	@BeforeClass
	public static void setUpClass() {}

	@AfterClass
	public static void tearDownClass() {}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Test of isEmpty method of class Queue on empty Q.
	 */
	@Test
	public void testIsEmptyTrue()
	{
		System.out.println("isEmpty");
		assertTrue( instance.isEmpty() );
	}

	/**
	 * Test of isEmpty method of class Queue on non-empty Q.
	 */
	@Test
	public void testIsEmptyFalse()
	{
		System.out.println("isEmpty");
		instance.add( 1 );
		assertFalse( instance.isEmpty() );
	}

	/**
	 * Test of remove method of class Queue.
	 */
	@Test
	public void testRemove()
	{
		System.out.println("remove");
		instance.add( 1 );
		assertEquals( new Integer( 1 ), instance.remove() );
	}

	/**
	 * Test of remove method of class Stack.
	 */
	@Test
	public void testRemoveException()
	{
		System.out.println("remove");
		exception.expect( NoSuchElementException.class );
		Integer peek = instance.remove();
	}

	/**
	 * Test of add method of class Queue.
	 */
	@Test
	public void testAdd()
	{
		System.out.println("add");
		instance.add( -17 );
		assertEquals( instance.peek(), new Integer( -17 ) );
	}

	/**
	 * Test of peek method of class Queue.
	 */
	@Test
	public void testPeek()
	{
		System.out.println("peek");
		instance.add( 1 );
		assertEquals( new Integer( 1 ), instance.peek() );
	}
}