package lang.ast;
import beaver.*;
import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.zip.DeflaterOutputStream;

// This is a parser generated by NeoBeaver.
public class LangParser extends beaver.Parser {
  
	static public class SyntaxError extends RuntimeException { public SyntaxError(String msg) {super(msg);}}
	// Disable syntax error recovery
	protected void recoverFromError(Symbol token, TokenStream in) {
		throw new SyntaxError("Cannot recover from the syntax error");
	}

  public static class Terminals {
    public static final short EOF = 0;
    public static final short FI = 1;
    public static final short OD = 2;
    public static final short ID = 3;
    public static final short NOT = 4;
    public static final short NUMERAL = 5;
    public static final short DO = 6;
    public static final short UNTIL = 7;
    public static final short THEN = 8;
    public static final short FOR = 9;
    public static final short IF = 10;
    public static final short ASSIGN = 11;

    public static final String[] NAMES = {
        "EOF",
        "FI",
        "OD",
        "ID",
        "NOT",
        "NUMERAL",
        "DO",
        "UNTIL",
        "THEN",
        "FOR",
        "IF",
        "ASSIGN",
    };
  }

  private final Action[] actions = {
    Action.RETURN, // [0] stmt =  assignment (default action: return symbol 1)
    Action.RETURN, // [1] program =  stmt (default action: return symbol 1)
    Action.RETURN, // [2] expr =  ID (default action: return symbol 1)
    new Action() { // [3] GOAL =  program EOF
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol program = _symbols[offset + 1];
        final Symbol sym2 = _symbols[offset + 2];
        return program;
      }
    },
    RETURN3, // [4] assignment =  ID ASSIGN expr (default action: return symbol 3)
    RETURN2, // [5] expr =  NOT expr (default action: return symbol 2)
    RETURN5, // [6] ifStmt =  IF expr THEN stmt FI (default action: return symbol 5)
    RETURN9, // [7] forStmt =  FOR ID ASSIGN expr UNTIL expr DO stmt OD (default action: return symbol 9)
  };

      static final Action RETURN2 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 2];
        }
      };
      static final Action RETURN3 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 3];
        }
      };
      static final Action RETURN5 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 5];
        }
      };
      static final Action RETURN9 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 9];
        }
      };
  static final ParsingTables PARSING_TABLES = new ParsingTables(
    "U9ojbKrIma0GXTyavaz0GV1VTcvOk7NbaYezW0Tmwy8poCA5L$067i03kFK0ti2D1r10XF5" +
    "DQg8nJ1T9LQRhepfDLtTFPXu0wXmUMkYWXstimqU0DOH8i8DrwqLwZDZwXm0QS2wTBiSNJM" +
    "nWito#NhZherrFNsm9TUR6bdrqXNcaVGbrzBVGTsQimlnUpZVdbTNvChRiOrUOVq#8I$kQ6" +
    "dFa7mXrX3bnv4xN4sFCRFvQmZlOIgTfyzPbNeSdQ7sUkw#TYmKLF4VSvqqEAkH3gbzJtyRg" +
    "EbHUXDZwiP1VOb$$wjGrV#xzc$DQsJSI#YeXNlMyGgcECAUZnbzzVlP7ID$LF8s0lvB0CJa" +
    "XP#I2N98hSarko1sv9m$aaJoHP$92NiaRUITKlQ8kL8zGHMf0JibmP3LnoyOPN1$vPnlxB3" +
    "oF2yyJCYl4ffdF5c7ExmjABhTYQbDHcuhALLIf#LynQlQer81wJT3z0GyicHa=");

  public LangParser() {
    super(PARSING_TABLES);
  }

  protected Symbol invokeReduceAction(int rule_num, int offset) {
    return actions[rule_num].reduce(_symbols, offset);
  }
}