package lang;

import lang.ast.*;

public class MSNCountVisitor extends TraversingVisitor {
	public static int result(ASTNode n) {
		MSNCountVisitor v = new MSNCountVisitor();
		n.accept(v, null);
		return v.maxDepth;
	}
	
	private int maxDepth = 0;
	private int currentDepth = 0;
	
/* --- any statements that result in increasing depth --- */

	public Object visit(Func node, Object data) {
		if(++currentDepth > maxDepth)
			maxDepth = currentDepth;
		super.visitChildren(node, data);
		currentDepth--;
		return data;
	}
	
	public Object visit(IfStmt node, Object data) {
		if(++currentDepth > maxDepth)
			maxDepth = currentDepth;
		super.visitChildren(node, data);
		currentDepth--;
		return data;
	}

	public Object visit(ElseIfStmt node, Object data) {
		if(++currentDepth > maxDepth)
			maxDepth = currentDepth;
		super.visitChildren(node, data);
		currentDepth--;
		return data;
	}
	
	public Object visit(ElseStmt node, Object data) {
		if(++currentDepth > maxDepth)
			maxDepth = currentDepth;
		super.visitChildren(node, data);
		currentDepth--;
		return data;
	}

	public Object visit(WhileStmt node, Object data) {
		if(++currentDepth > maxDepth)
			maxDepth = currentDepth;
		super.visitChildren(node, data);
		currentDepth--;
		return data;
	}
	
	public Object visit(ReturnStmt node, Object data) {
		if(++currentDepth > maxDepth)
			maxDepth = currentDepth;
		super.visitChildren(node, data);
		currentDepth--;
		return data;
	}
}
