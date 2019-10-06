/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/lang.ast:16
 * @astdecl AssigmtStmt : Stmt ::= Left:IdDecl [Right:Expr];
 * @production AssigmtStmt : {@link Stmt} ::= <span class="component">Left:{@link IdDecl}</span> <span class="component">[Right:{@link Expr}]</span>;

 */
public class AssigmtStmt extends Stmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/Visitor.jrag:96
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/PrettyPrint.jrag:38
   */
  public void prettyPrint(PrintStream out, String ind){
		out.print(ind);
		getLeft().prettyPrint(out, ind);
		if(hasRight()){
		    Expr right = getRight();
            out.print(" = ");
            if(FuncDefault.class.isInstance(right) || FuncCall.class.isInstance(right)){
                ind = "";
            }
            getRight().prettyPrint(out, ind);
		}
	}
  /**
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/NameAnalysis.jrag:96
   */
  public void checkNames(PrintStream err, SymbolTable symbols) {
        getLeft().checkNames(err, symbols);
        if(hasRight()) {
            getRight().checkNames(err, symbols);
        }
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
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public AssigmtStmt clone() throws CloneNotSupportedException {
    AssigmtStmt node = (AssigmtStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
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
   * @declaredat ASTNode:60
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
   * @declaredat ASTNode:70
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
   * @declaredat ASTNode:90
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
   * @declaredat ASTNode:104
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
}
