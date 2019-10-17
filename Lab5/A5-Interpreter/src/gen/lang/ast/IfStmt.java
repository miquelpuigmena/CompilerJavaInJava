/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/lang.ast:24
 * @astdecl IfStmt : Stmt ::= Condition:Expr Then:Block Elif:ElseIfStmts [Else:ElseStmt];
 * @production IfStmt : {@link Stmt} ::= <span class="component">Condition:{@link Expr}</span> <span class="component">Then:{@link Block}</span> <span class="component">Elif:{@link ElseIfStmts}</span> <span class="component">[Else:{@link ElseStmt}]</span>;

 */
public class IfStmt extends Stmt implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/PrettyPrint.jrag:64
   */
  public void prettyPrint(PrintStream out, String ind){
		out.print(ind+"if(");
		getCondition().prettyPrint(out, ind);
		out.println(") {");
		getThen().getStmts().printLoop(out, ind+TAB, Optional.empty());
        if(getElif().hasElseIfStmt()) {
            for(ElseIfStmt elseif: getElif().getElseIfStmts()) {
                out.print(ind+"} elseif (");
                elseif.getCondition().prettyPrint(out, ind);
                out.println(") {");
                elseif.getThen().getStmts().printLoop(out, ind+TAB, Optional.empty());
                out.println(ind+"}");
            }
		}
		if(hasElse()) {
			out.println(ind+"} else {");
			getElse().getBlock().getStmts().printLoop(out, ind+TAB, Optional.empty());
		}
		out.println(ind+"}");
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/Interpreter.jrag:40
   */
  public int eval(ActivationRecord actrec) {
        System.out.println("In IfStmt");
        return 1;
    }
  /**
   * @declaredat ASTNode:1
   */
  public IfStmt() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[4];
    setChild(new Opt(), 3);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Condition", "Then", "Elif", "Else"},
    type = {"Expr", "Block", "ElseIfStmts", "Opt<ElseStmt>"},
    kind = {"Child", "Child", "Child", "Opt"}
  )
  public IfStmt(Expr p0, Block p1, ElseIfStmts p2, Opt<ElseStmt> p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 4;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public IfStmt copy() {
    try {
      IfStmt node = (IfStmt) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:62
   */
  @Deprecated
  public IfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public IfStmt treeCopyNoTransform() {
    IfStmt tree = (IfStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:92
   */
  public IfStmt treeCopy() {
    IfStmt tree = (IfStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:106
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Condition child.
   * @param node The new node to replace the Condition child.
   * @apilevel high-level
   */
  public void setCondition(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Condition child.
   * @return The current node used as the Condition child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Condition")
  public Expr getCondition() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Condition child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Condition child.
   * @apilevel low-level
   */
  public Expr getConditionNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Then child.
   * @param node The new node to replace the Then child.
   * @apilevel high-level
   */
  public void setThen(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Then child.
   * @return The current node used as the Then child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Then")
  public Block getThen() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Then child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Then child.
   * @apilevel low-level
   */
  public Block getThenNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * Replaces the Elif child.
   * @param node The new node to replace the Elif child.
   * @apilevel high-level
   */
  public void setElif(ElseIfStmts node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the Elif child.
   * @return The current node used as the Elif child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Elif")
  public ElseIfStmts getElif() {
    return (ElseIfStmts) getChild(2);
  }
  /**
   * Retrieves the Elif child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Elif child.
   * @apilevel low-level
   */
  public ElseIfStmts getElifNoTransform() {
    return (ElseIfStmts) getChildNoTransform(2);
  }
  /**
   * Replaces the optional node for the Else child. This is the <code>Opt</code>
   * node containing the child Else, not the actual child!
   * @param opt The new node to be used as the optional node for the Else child.
   * @apilevel low-level
   */
  public void setElseOpt(Opt<ElseStmt> opt) {
    setChild(opt, 3);
  }
  /**
   * Replaces the (optional) Else child.
   * @param node The new node to be used as the Else child.
   * @apilevel high-level
   */
  public void setElse(ElseStmt node) {
    getElseOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Else child exists.
   * @return {@code true} if the optional Else child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasElse() {
    return getElseOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Else child.
   * @return The Else child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ElseStmt getElse() {
    return (ElseStmt) getElseOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Else child. This is the <code>Opt</code> node containing the child Else, not the actual child!
   * @return The optional node for child the Else child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Else")
  public Opt<ElseStmt> getElseOpt() {
    return (Opt<ElseStmt>) getChild(3);
  }
  /**
   * Retrieves the optional node for child Else. This is the <code>Opt</code> node containing the child Else, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Else.
   * @apilevel low-level
   */
  public Opt<ElseStmt> getElseOptNoTransform() {
    return (Opt<ElseStmt>) getChildNoTransform(3);
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/TypeAnalysis.jrag:5
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getConditionNoTransform()) {
      // @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/TypeAnalysis.jrag:17
      return BoolType();
    }
    else {
      return super.Define_expectedType(_callerNode, _childNode);
    }
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/TypeAnalysis.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
