package lang;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.fail;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles");

	@Test public void AllSyntaxValid() {
		Util.testValidSyntax(TEST_DIRECTORY, "AllSyntaxValid.in");
	}

	@Test public void ParsingError() {
		Util.testSyntaxError(TEST_DIRECTORY, "ParsingError.in");
	}

	@Test public void ScanningError() {
		Util.testSyntaxError(TEST_DIRECTORY, "ScanningError.in");
	}

	@Test public void ShortestValid() {
		Util.testValidSyntax(TEST_DIRECTORY, "ShortestValid.in");
	}

}

