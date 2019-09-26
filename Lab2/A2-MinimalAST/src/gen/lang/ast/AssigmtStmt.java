/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:14
 * @astdecl AssigmtStmt : Stmt ::= left:IdDecl [right:Expr];
 * @production AssigmtStmt : {@link Stmt} ::= <span class="component">left:{@link IdDecl}</span> <span class="component">[right:{@link Expr}]</span>;

 */
public class AssigmtStmt extends Stmt implements Cloneable {
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
    name = {"left", "right"},
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
   * Replaces the left child.
   * @param node The new node to replace the left child.
   * @apilevel high-level
   */
  public void setleft(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the left child.
   * @return The current node used as the left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="left")
  public IdDecl getleft() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the left child.
   * @apilevel low-level
   */
  public IdDecl getleftNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the right child. This is the <code>Opt</code>
   * node containing the child right, not the actual child!
   * @param opt The new node to be used as the optional node for the right child.
   * @apilevel low-level
   */
  public void setrightOpt(Opt<Expr> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) right child.
   * @param node The new node to be used as the right child.
   * @apilevel high-level
   */
  public void setright(Expr node) {
    getrightOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional right child exists.
   * @return {@code true} if the optional right child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasright() {
    return getrightOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) right child.
   * @return The right child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getright() {
    return (Expr) getrightOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the right child. This is the <code>Opt</code> node containing the child right, not the actual child!
   * @return The optional node for child the right child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="right")
  public Opt<Expr> getrightOpt() {
    return (Opt<Expr>) getChild(1);
  }
  /**
   * Retrieves the optional node for child right. This is the <code>Opt</code> node containing the child right, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child right.
   * @apilevel low-level
   */
  public Opt<Expr> getrightOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(1);
  }
}
