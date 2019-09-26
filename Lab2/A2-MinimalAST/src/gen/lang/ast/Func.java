/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:9
 * @astdecl Func : Stmt ::= decl:IdDecl args:FuncArgs block:Block;
 * @production Func : {@link Stmt} ::= <span class="component">decl:{@link IdDecl}</span> <span class="component">args:{@link FuncArgs}</span> <span class="component">block:{@link Block}</span>;

 */
public class Func extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Func() {
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
    children = new ASTNode[3];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"decl", "args", "block"},
    type = {"IdDecl", "FuncArgs", "Block"},
    kind = {"Child", "Child", "Child"}
  )
  public Func(IdDecl p0, FuncArgs p1, Block p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 3;
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
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Func copy() {
    try {
      Func node = (Func) clone();
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
  public Func fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public Func treeCopyNoTransform() {
    Func tree = (Func) copy();
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
  public Func treeCopy() {
    Func tree = (Func) copy();
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
   * Replaces the decl child.
   * @param node The new node to replace the decl child.
   * @apilevel high-level
   */
  public void setdecl(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the decl child.
   * @return The current node used as the decl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="decl")
  public IdDecl getdecl() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the decl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the decl child.
   * @apilevel low-level
   */
  public IdDecl getdeclNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the args child.
   * @param node The new node to replace the args child.
   * @apilevel high-level
   */
  public void setargs(FuncArgs node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the args child.
   * @return The current node used as the args child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="args")
  public FuncArgs getargs() {
    return (FuncArgs) getChild(1);
  }
  /**
   * Retrieves the args child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the args child.
   * @apilevel low-level
   */
  public FuncArgs getargsNoTransform() {
    return (FuncArgs) getChildNoTransform(1);
  }
  /**
   * Replaces the block child.
   * @param node The new node to replace the block child.
   * @apilevel high-level
   */
  public void setblock(Block node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the block child.
   * @return The current node used as the block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="block")
  public Block getblock() {
    return (Block) getChild(2);
  }
  /**
   * Retrieves the block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the block child.
   * @apilevel low-level
   */
  public Block getblockNoTransform() {
    return (Block) getChildNoTransform(2);
  }
}
