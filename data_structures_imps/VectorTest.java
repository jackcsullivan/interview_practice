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