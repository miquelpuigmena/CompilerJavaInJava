package lang;

import lang.ast.LangParser;
import lang.ast.LangScanner;
import static lang.ast.LangParser.Terminals.*;


/**
 * Abstract base class for recursive decent parsers.
 * You should implement the parseProgram() method to parse a MiniS program.
 */
public abstract class RecursiveDescentCompiler {
    private LangScanner scanner;
    private beaver.Symbol currentToken;

    /** Initialize the parser and start parsing via the parseProgram() method. */
    public void parse(LangScanner scanner) throws RuntimeException {
        this.scanner = scanner;
        parseProgram();
        accept(EOF);
    }

    protected abstract void parseProgram() throws RuntimeException;


    protected void expr() throws RuntimeException {
        switch (peek()) {
            case ID:
                accept(ID);
                break;
            case NUMERAL:
                accept(NUMERAL);
                break;
            case NOT:
                accept(NOT);
                expr();
                break;
            default:
                error("ERROR: Expresion not recognized.");
        }
    }

    /** Returns the current token without proceeding to the next. */
    protected int peek() {
        if (currentToken == null) accept();
        return currentToken.getId();
    }

    /** Read the next token from the scanner. */
    protected void accept() {
        try {
            currentToken = scanner.nextToken();
        } catch (Exception e) {
            error(e.getMessage());
        }
    }

    /** Ensure the current token is of a certain type; then read the next. */
    protected void accept(int expectedToken) {
        if (peek() != expectedToken) {
            error("expected token " +
                    LangParser.Terminals.NAMES[expectedToken] +
                    " got token " +
                    LangParser.Terminals.NAMES[currentToken.getId()]);
        }
        accept();
    }

    protected static void error(String message) {
        throw new RuntimeException(message);
    }
}
