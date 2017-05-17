package com.internship.assignment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class to test whether App prints
 * the appropriate results based on input
 */
public class AppTest 
{
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	PrintStream stdout = System.out;
	PrintStream stderr = System.err;

	/**
	 * Setting custom streams instead of standard input and output streams
	 */
	@Before
	public void customStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	/**
	 * Revert back to standard input and output streams
	 */
	@After
	public void revertStreams() {
	    System.setOut(stdout);
	    System.setErr(stderr);
	}

	/**
	 * Constructs sample input for App's main method and verify
	 * the results printed to System.out
	 */
	@Test
	public void testMain() throws Exception {
		
		/* Tweaking System.in with sample data input, rather than reading it from standard System.in */
		String data = "1\r\ny\r\n2\r\ny\r\n3\r\nn\r\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		App.main(new String[0]);
		
		//TODO change the character sequence inside .contains() to match with expected output
		Assert.assertEquals(true, outContent.toString().contains("executed"));
	}

}
	

