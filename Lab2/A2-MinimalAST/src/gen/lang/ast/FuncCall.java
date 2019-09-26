/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:11
 * @astdecl FuncCall : Expr ::= name:IdDecl args:FuncCallArgs;
 * @production FuncCall : {@link Expr} ::= <span class="component">name:{@link IdDecl}</span> <span class="component">args:{@link FuncCallArgs}</span>;

 */
public class FuncCall extends Expr implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public FuncCall() {
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
    name = {"name", "args"},
    type = {"IdDecl", "FuncCallArgs"},
    kind = {"Child", "Child"}
  )
  public FuncCall(IdDecl p0, FuncCallArgs p1) {
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
  public FuncCall clone() throws CloneNotSupportedException {
    FuncCall node = (FuncCall) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public FuncCall copy() {
    try {
      FuncCall node = (FuncCall) clone();
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
  public FuncCall fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public FuncCall treeCopyNoTransform() {
    FuncCall tree = (FuncCall) copy();
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
  public FuncCall treeCopy() {
    FuncCall tree = (FuncCall) copy();
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
   * Replaces the name child.
   * @param node The new node to replace the name child.
   * @apilevel high-level
   */
  public void setname(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the name child.
   * @return The current node used as the name child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="name")
  public IdDecl getname() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the name child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the name child.
   * @apilevel low-level
   */
  public IdDecl getnameNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the args child.
   * @param node The new node to replace the args child.
   * @apilevel high-level
   */
  public void setargs(FuncCallArgs node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the args child.
   * @return The current node used as the args child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="args")
  public FuncCallArgs getargs() {
    return (FuncCallArgs) getChild(1);
  }
  /**
   * Retrieves the args child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the args child.
   * @apilevel low-level
   */
  public FuncCallArgs getargsNoTransform() {
    return (FuncCallArgs) getChildNoTransform(1);
  }
}
