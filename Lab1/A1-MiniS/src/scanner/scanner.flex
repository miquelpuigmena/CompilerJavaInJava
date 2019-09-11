package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z]+
Numeral = [0-9]+ "." [0-9]+
// Extended from CalcParser
FOR = for
THEN = then
DO = do
OD = od
IF = if
FI = fi
NOT = not
UNTIL = until

%%

// discard whitespace information
{WhiteSpace}  { }

// token definitions

"="           { return sym(Terminals.ASSIGN); }
{FOR}         { return sym(Terminals.FOR); }
{THEN}        { return sym(Terminals.THEN); }
{DO}          { return sym(Terminals.DO); }
{OD}          { return sym(Terminals.OD); }
{IF}          { return sym(Terminals.IF); }
{FI}          { return sym(Terminals.FI); }
{UNTIL}       { return sym(Terminals.UNTIL); }
{NOT}         { return sym(Terminals.NOT); }
{ID}          { return sym(Terminals.ID); }
{Numeral}     { return sym(Terminals.NUMERAL); }
<<EOF>>       { return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
