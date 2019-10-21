/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.lang.Math;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/lang.ast:19
 * @astdecl UnknownFunc : Func ::= Decl:IdDecl Args:FuncArgs Block:Block;
 * @production UnknownFunc : {@link Func};

 */
public class UnknownFunc extends Func implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public UnknownFunc() {
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
    name = {"Decl", "Args", "Block"},
    type = {"IdDecl", "FuncArgs", "Block"},
    kind = {"Child", "Child", "Child"}
  )
  public UnknownFunc(IdDecl p0, FuncArgs p1, Block p2) {
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
    isUnknown_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public UnknownFunc clone() throws CloneNotSupportedException {
    UnknownFunc node = (UnknownFunc) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public UnknownFunc copy() {
    try {
      UnknownFunc node = (UnknownFunc) clone();
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
   * @declaredat ASTNode:61
   */
  @Deprecated
  public UnknownFunc fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public UnknownFunc treeCopyNoTransform() {
    UnknownFunc tree = (UnknownFunc) copy();
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
   * @declaredat ASTNode:91
   */
  public UnknownFunc treeCopy() {
    UnknownFunc tree = (UnknownFunc) copy();
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
   * @declaredat ASTNode:105
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Decl child.
   * @param node The new node to replace the Decl child.
   * @apilevel high-level
   */
  public void setDecl(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Decl child.
   * @return The current node used as the Decl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Decl")
  public IdDecl getDecl() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the Decl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Decl child.
   * @apilevel low-level
   */
  public IdDecl getDeclNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the Args child.
   * @param node The new node to replace the Args child.
   * @apilevel high-level
   */
  public void setArgs(FuncArgs node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Args child.
   * @return The current node used as the Args child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Args")
  public FuncArgs getArgs() {
    return (FuncArgs) getChild(1);
  }
  /**
   * Retrieves the Args child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Args child.
   * @apilevel low-level
   */
  public FuncArgs getArgsNoTransform() {
    return (FuncArgs) getChildNoTransform(1);
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(2);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(2);
  }
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /** @apilevel internal */
  private void isUnknown_reset() {
    isUnknown_computed = false;
    isUnknown_visited = false;
  }
  /** @apilevel internal */
  protected boolean isUnknown_computed = false;

  /** @apilevel internal */
  protected boolean isUnknown_value;

  /**
   * @attribute syn
   * @aspect UnknownFunc
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownFunc.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownFunc.jrag:7")
  public boolean isUnknown() {
    ASTState state = state();
    if (isUnknown_computed) {
      return isUnknown_value;
    }
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute Func.isUnknown().");
    }
    isUnknown_visited = true;
    state().enterLazyAttribute();
    isUnknown_value = true;
    isUnknown_computed = true;
    state().leaveLazyAttribute();
    isUnknown_visited = false;
    return isUnknown_value;
  }
}
