import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class VectorTest {
	public Vector v;

	@Before
    public void setUp() {
        v = new Vector();
    }

    @Test
	public void testSimplePush() {
		/* Push an element. */
		v.push(1);
		assertEquals("[1, 0, 0, 0, 0, 0, 0, 0]", v.view());
	}

	@Test
	public void testMultiplePushes() {
		/* Push an element. */
		v.push(1);
		v.push(2);
		v.push(3);
		assertEquals("[1, 2, 3, 0, 0, 0, 0, 0]", v.view());
	}

	@Test
	public void testOverflowPushes() {
		/* Push an element. */
		for (int i = 0; i < 10; i++) {
			v.push(i);
		}
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0]", v.view());
	}

	@Test
	public void testSize() {
		for (int i = 0; i < 6; i++) {
			v.push(i);
		}
		assertEquals(6, v.size());
		v.pop();
		assertEquals(5, v.size());
		v.delete(2);
		assertEquals(4, v.size());
	}

	@Test
	public void testCapacity() {
		for (int i = 0; i < 10; i++) {
			v.push(i);
		}
		assertEquals(16, v.capacity());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, v.isEmpty());
		v.push(1);
		assertEquals(false, v.isEmpty());
		v.pop();
		assertEquals(true, v.isEmpty());
	}

	@Test
	public void testAt() {
		/* Push an element. */
		v.push(1);
		assertEquals(1, v.at(0));
	}

	@Test
	public void testFind() {
		/* Expect to return first index of value 2. */
		v.push(1);
		v.push(2);
		v.push(1);
		v.push(2);
		assertEquals(1, v.find(2));
	}

	@Test
	public void testPrepend() {
		/* Expect to return first index of value 2. */
		v.push(1);
		v.push(2);
		v.prepend(3);
		assertEquals("[3, 1, 2, 0, 0, 0, 0, 0]", v.view());
	}

	@Test
	public void testInsert() {
		v.push(1);

		/* Insert 10 at index 5, should be pushed back to index 1. */
		v.insert(5, 10);
		assertEquals(0, v.at(5));
		assertEquals(10, v.at(1));
	}

	@Test
	public void testPop() {
		v.push(10);
		v.push(20);
		assertEquals(20, v.pop());
		assertEquals(10, v.pop());
		assertEquals(-1, v.pop());
	}

	@Test
	public void testDelete() {
		for (int i = 0; i < 6; i++) {
			v.push(i);
		}
		v.delete(0);
		assertEquals("[1, 2, 3, 4, 5, 0, 0, 0]", v.view());
		v.delete(2);
		assertEquals("[1, 2, 4, 5, 0, 0, 0, 0]", v.view());
	}

	@Test
	public void testRemove() {
		for (int i = 0; i < 6; i++) {
			v.push(2);
		}
		v.remove(1);
		assertEquals("[2, 2, 2, 2, 2, 2, 0, 0]", v.view());
		v.remove(2);
		assertEquals("[0, 0, 0, 0, 0, 0, 0, 0]", v.view());
	}

	public static void main(String[] args) {
    	Result result = JUnitCore.runClasses(VectorTest.class);

    	for (Failure failure : result.getFailures()) {
    		System.out.println(failure.toString());
    	}	
    	if (result.wasSuccessful()) {
    		System.out.println("All tests passed!");
    	}
   }
}