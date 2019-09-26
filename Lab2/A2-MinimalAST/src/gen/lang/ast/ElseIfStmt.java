/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:19
 * @astdecl ElseIfStmt : Stmt ::= condition:Expr block:Block;
 * @production ElseIfStmt : {@link Stmt} ::= <span class="component">condition:{@link Expr}</span> <span class="component">block:{@link Block}</span>;

 */
public class ElseIfStmt extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public ElseIfStmt() {
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
    name = {"condition", "block"},
    type = {"Expr", "Block"},
    kind = {"Child", "Child"}
  )
  public ElseIfStmt(Expr p0, Block p1) {
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
  public ElseIfStmt clone() throws CloneNotSupportedException {
    ElseIfStmt node = (ElseIfStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public ElseIfStmt copy() {
    try {
      ElseIfStmt node = (ElseIfStmt) clone();
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
  public ElseIfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public ElseIfStmt treeCopyNoTransform() {
    ElseIfStmt tree = (ElseIfStmt) copy();
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
  public ElseIfStmt treeCopy() {
    ElseIfStmt tree = (ElseIfStmt) copy();
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
   * Replaces the condition child.
   * @param node The new node to replace the condition child.
   * @apilevel high-level
   */
  public void setcondition(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the condition child.
   * @return The current node used as the condition child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="condition")
  public Expr getcondition() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the condition child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the condition child.
   * @apilevel low-level
   */
  public Expr getconditionNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the block child.
   * @param node The new node to replace the block child.
   * @apilevel high-level
   */
  public void setblock(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the block child.
   * @return The current node used as the block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="block")
  public Block getblock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the block child.
   * @apilevel low-level
   */
  public Block getblockNoTransform() {
    return (Block) getChildNoTransform(1);
  }
}
