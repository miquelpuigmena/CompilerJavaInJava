/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:35
 * @astdecl GE : BinaryExpr ::= left:Expr right:Expr;
 * @production GE : {@link BinaryExpr};

 */
public class GE extends BinaryExpr implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public GE() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"left", "right"},
    type = {"Expr", "Expr"},
    kind = {"Child", "Child"}
  )
  public GE(Expr p0, Expr p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public GE clone() throws CloneNotSupportedException {
    GE node = (GE) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public GE copy() {
    try {
      GE node = (GE) clone();
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
   * @declaredat ASTNode:59
   */
  @Deprecated
  public GE fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public GE treeCopyNoTransform() {
    GE tree = (GE) copy();
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
   * @declaredat ASTNode:89
   */
  public GE treeCopy() {
    GE tree = (GE) copy();
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
   * @declaredat ASTNode:103
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the left child.
   * @param node The new node to replace the left child.
   * @apilevel high-level
   */
  public void setleft(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the left child.
   * @return The current node used as the left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="left")
  public Expr getleft() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the left child.
   * @apilevel low-level
   */
  public Expr getleftNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the right child.
   * @param node The new node to replace the right child.
   * @apilevel high-level
   */
  public void setright(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the right child.
   * @return The current node used as the right child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="right")
  public Expr getright() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the right child.
   * @apilevel low-level
   */
  public Expr getrightNoTransform() {
    return (Expr) getChildNoTransform(1);
  }
}
