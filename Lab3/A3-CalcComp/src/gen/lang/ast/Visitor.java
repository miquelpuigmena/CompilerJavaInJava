package lang.ast;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * Visitor interface for SimpliC language. Each concrete node type must
 * have a visit method.
 * @ast interface
 * @aspect Visitor
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(Block node, Object data);

		 
		public Object visit(Condition node, Object data);


		 

		public Object visit(IdDecl node, Object data);

		 
		public Object visit(IdUse node, Object data);


		 

		public Object visit(Func node, Object data);

		 
		public Object visit(FuncArgs node, Object data);

		 
		public Object visit(FuncCall node, Object data);

		 
		public Object visit(FuncCallArgs node, Object data);


			/* ------- statements ------- */

		 

			/* ------- statements ------- */

		public Object visit(AssigmtStmt node, Object data);

		 
		public Object visit(ReturnStmt node, Object data);

		 
		public Object visit(WhileStmt node, Object data);

		 
		public Object visit(IfStmt node, Object data);

		 
		public Object visit(ElseIfStmt node, Object data);

		 
		public Object visit(ElseIfStmts node, Object data);

		 
		public Object visit(ElseStmt node, Object data);


			/* ----- binary expressions ----- */	

		 

			/* ----- binary expressions ----- */	

		public Object visit(Numeral node, Object data);


		 

		public Object visit(Mul node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Mod node, Object data);


		 

		public Object visit(Add node, Object data);

		 
		public Object visit(Sub node, Object data);


		 

		public Object visit(GT node, Object data);

		 
		public Object visit(LT node, Object data);

		 
		public Object visit(GE node, Object data);

		 
		public Object visit(LE node, Object data);

		 
		public Object visit(EQ node, Object data);

		 
		public Object visit(NE node, Object data);
}
