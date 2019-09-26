/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:21
 * @astdecl ElseStmt : Stmt ::= block:Block;
 * @production ElseStmt : {@link Stmt} ::= <span class="component">block:{@link Block}</span>;

 */
public class ElseStmt extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public ElseStmt() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"block"},
    type = {"Block"},
    kind = {"Child"}
  )
  public ElseStmt(Block p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public ElseStmt clone() throws CloneNotSupportedException {
    ElseStmt node = (ElseStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public ElseStmt copy() {
    try {
      ElseStmt node = (ElseStmt) clone();
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
   * @declaredat ASTNode:58
   */
  @Deprecated
  public ElseStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:68
   */
  public ElseStmt treeCopyNoTransform() {
    ElseStmt tree = (ElseStmt) copy();
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
   * @declaredat ASTNode:88
   */
  public ElseStmt treeCopy() {
    ElseStmt tree = (ElseStmt) copy();
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
   * @declaredat ASTNode:102
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the block child.
   * @param node The new node to replace the block child.
   * @apilevel high-level
   */
  public void setblock(Block node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the block child.
   * @return The current node used as the block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="block")
  public Block getblock() {
    return (Block) getChild(0);
  }
  /**
   * Retrieves the block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the block child.
   * @apilevel low-level
   */
  public Block getblockNoTransform() {
    return (Block) getChildNoTransform(0);
  }
}
