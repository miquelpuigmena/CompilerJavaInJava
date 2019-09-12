package lang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import lang.ast.LangParser;
import lang.ast.LangParser.SyntaxError;
import lang.ast.LangScanner;

import javax.xml.bind.annotation.XmlType;

import static lang.ast.LangParser.Terminals.*;

public class Compiler extends RecursiveDescentCompiler {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("You must specify a source file on the command line!");
			System.exit(1);
		}
		Compiler compiler = new Compiler();
		try {
			compiler.parse(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	private void parse(Reader reader) {
		LangScanner scanner = new LangScanner(reader);
		// LangParser parser = new LangParser();

		try {
			parse(scanner);
			System.out.println("Valid syntax");
		} catch (SyntaxError e) {
			System.err.println("Syntax error: " + e.getMessage());
			System.exit(1);
		}
	}

	@Override
	protected void parseProgram() throws RuntimeException {
		switch (peek()) {
			case(FOR):
				accept(FOR);
				accept(ID);
				accept(ASSIGN);
				expr();
				accept(UNTIL);
				expr();
				accept(DO);
				parseProgram();
				accept(OD);
				break;
			case(IF):
				accept(IF);
				expr();
				accept(THEN);
				parseProgram();
				accept(FI);
				break;
			case(ID):
				accept(ID);
				accept(ASSIGN);
				expr();
				break;
			default:
				error("ERROR: Unrecognized first token.");
		}
	}
}
