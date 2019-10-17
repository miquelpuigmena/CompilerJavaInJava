package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/parser");

	@Test public void example() {
		Util.testValidSyntax(TEST_DIRECTORY, "step1.in");
		Util.testValidSyntax(TEST_DIRECTORY, "step2.in");
	}

	@Test
	public void error() {
		Util.testSyntaxError(TEST_DIRECTORY, "step1error.in");
		Util.testSyntaxError(TEST_DIRECTORY, "step2error.in");
	}

}
