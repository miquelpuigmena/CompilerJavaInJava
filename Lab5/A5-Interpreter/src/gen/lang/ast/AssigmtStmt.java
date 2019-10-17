/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/lang.ast:20
 * @astdecl AssigmtStmt : Stmt ::= Left:IdDecl [Right:Expr];
 * @production AssigmtStmt : {@link Stmt} ::= <span class="component">Left:{@link IdDecl}</span> <span class="component">[Right:{@link Expr}]</span>;

 */
public class AssigmtStmt extends Stmt implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/PrettyPrint.jrag:38
   */
  public void prettyPrint(PrintStream out, String ind){
		out.print(ind);
		getLeft().prettyPrint(out, ind);
		if(hasRight()){
		    Expr right = getRight();
            out.print(" = ");
            if(FuncCall.class.isInstance(right)){
                ind = "";
            }
            getRight().prettyPrint(out, ind);
		}
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/Interpreter.jrag:60
   */
  public int eval(ActivationRecord actrec) {
        System.out.println("In assigmt stmt");
        if(hasRight()) {
            actrec.store(getLeft().getID(), getRight().eval(actrec));
        }
        return 1;
    }
  /**
   * @declaredat ASTNode:1
   */
  public AssigmtStmt() {
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
    children = new ASTNode[2];
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Left", "Right"},
    type = {"IdDecl", "Opt<Expr>"},
    kind = {"Child", "Opt"}
  )
  public AssigmtStmt(IdDecl p0, Opt<Expr> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    localLookup_String_reset();
    inExprOf_IdDecl_reset();
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
  public AssigmtStmt clone() throws CloneNotSupportedException {
    AssigmtStmt node = (AssigmtStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public AssigmtStmt copy() {
    try {
      AssigmtStmt node = (AssigmtStmt) clone();
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
  public AssigmtStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public AssigmtStmt treeCopyNoTransform() {
    AssigmtStmt tree = (AssigmtStmt) copy();
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
  public AssigmtStmt treeCopy() {
    AssigmtStmt tree = (AssigmtStmt) copy();
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
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   */
  public void setLeft(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public IdDecl getLeft() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public IdDecl getLeftNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the Right child. This is the <code>Opt</code>
   * node containing the child Right, not the actual child!
   * @param opt The new node to be used as the optional node for the Right child.
   * @apilevel low-level
   */
  public void setRightOpt(Opt<Expr> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) Right child.
   * @param node The new node to be used as the Right child.
   * @apilevel high-level
   */
  public void setRight(Expr node) {
    getRightOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Right child exists.
   * @return {@code true} if the optional Right child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasRight() {
    return getRightOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Right child.
   * @return The Right child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getRight() {
    return (Expr) getRightOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Right child. This is the <code>Opt</code> node containing the child Right, not the actual child!
   * @return The optional node for child the Right child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Right")
  public Opt<Expr> getRightOpt() {
    return (Opt<Expr>) getChild(1);
  }
  /**
   * Retrieves the optional node for child Right. This is the <code>Opt</code> node containing the child Right, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Right.
   * @apilevel low-level
   */
  public Opt<Expr> getRightOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(1);
  }
/** @apilevel internal */
protected java.util.Set localLookup_String_visited;
  /** @apilevel internal */
  private void localLookup_String_reset() {
    localLookup_String_values = null;
    localLookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map localLookup_String_values;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:37
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:37")
  public IdDecl localLookup(String name) {
    Object _parameters = name;
    if (localLookup_String_visited == null) localLookup_String_visited = new java.util.HashSet(4);
    if (localLookup_String_values == null) localLookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (localLookup_String_values.containsKey(_parameters)) {
      return (IdDecl) localLookup_String_values.get(_parameters);
    }
    if (localLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute AssigmtStmt.localLookup(String).");
    }
    localLookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl localLookup_String_value = localLookup_compute(name);
    localLookup_String_values.put(_parameters, localLookup_String_value);
    state().leaveLazyAttribute();
    localLookup_String_visited.remove(_parameters);
    return localLookup_String_value;
  }
  /** @apilevel internal */
  private IdDecl localLookup_compute(String name) {
      	return getLeft().getID().equals(name) ? getLeft() : UnknownDecl();
    	}
  /**
   * @attribute inh
   * @aspect CircularDefinitions
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:86
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CircularDefinitions", declaredAt="/home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:86")
  public boolean inExprOf(IdDecl decl) {
    Object _parameters = decl;
    if (inExprOf_IdDecl_visited == null) inExprOf_IdDecl_visited = new java.util.HashSet(4);
    if (inExprOf_IdDecl_values == null) inExprOf_IdDecl_values = new java.util.HashMap(4);
    ASTState state = state();
    if (inExprOf_IdDecl_values.containsKey(_parameters)) {
      return (Boolean) inExprOf_IdDecl_values.get(_parameters);
    }
    if (inExprOf_IdDecl_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute AssigmtStmt.inExprOf(IdDecl).");
    }
    inExprOf_IdDecl_visited.add(_parameters);
    state().enterLazyAttribute();
    boolean inExprOf_IdDecl_value = getParent().Define_inExprOf(this, null, decl);
    inExprOf_IdDecl_values.put(_parameters, inExprOf_IdDecl_value);
    state().leaveLazyAttribute();
    inExprOf_IdDecl_visited.remove(_parameters);
    return inExprOf_IdDecl_value;
  }
/** @apilevel internal */
protected java.util.Set inExprOf_IdDecl_visited;
  /** @apilevel internal */
  private void inExprOf_IdDecl_reset() {
    inExprOf_IdDecl_values = null;
    inExprOf_IdDecl_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map inExprOf_IdDecl_values;

  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:85
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    if (_callerNode == getRightOptNoTransform()) {
      // @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:87
      return getLeft() == decl || inExprOf(decl);
    }
    else {
      return getParent().Define_inExprOf(this, _callerNode, decl);
    }
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:85
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
}
