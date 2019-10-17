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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/lang.ast:26
 * @astdecl ElseIfStmts : ASTNode ::= ElseIfStmt*;
 * @production ElseIfStmts : {@link ASTNode} ::= <span class="component">{@link ElseIfStmt}*</span>;

 */
public class ElseIfStmts extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public ElseIfStmts() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"ElseIfStmt"},
    type = {"List<ElseIfStmt>"},
    kind = {"List"}
  )
  public ElseIfStmts(List<ElseIfStmt> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
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
  public ElseIfStmts clone() throws CloneNotSupportedException {
    ElseIfStmts node = (ElseIfStmts) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public ElseIfStmts copy() {
    try {
      ElseIfStmts node = (ElseIfStmts) clone();
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
  public ElseIfStmts fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public ElseIfStmts treeCopyNoTransform() {
    ElseIfStmts tree = (ElseIfStmts) copy();
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
  public ElseIfStmts treeCopy() {
    ElseIfStmts tree = (ElseIfStmts) copy();
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
   * Replaces the ElseIfStmt list.
   * @param list The new list node to be used as the ElseIfStmt list.
   * @apilevel high-level
   */
  public void setElseIfStmtList(List<ElseIfStmt> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the ElseIfStmt list.
   * @return Number of children in the ElseIfStmt list.
   * @apilevel high-level
   */
  public int getNumElseIfStmt() {
    return getElseIfStmtList().getNumChild();
  }
  /**
   * Retrieves the number of children in the ElseIfStmt list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the ElseIfStmt list.
   * @apilevel low-level
   */
  public int getNumElseIfStmtNoTransform() {
    return getElseIfStmtListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the ElseIfStmt list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the ElseIfStmt list.
   * @apilevel high-level
   */
  public ElseIfStmt getElseIfStmt(int i) {
    return (ElseIfStmt) getElseIfStmtList().getChild(i);
  }
  /**
   * Check whether the ElseIfStmt list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasElseIfStmt() {
    return getElseIfStmtList().getNumChild() != 0;
  }
  /**
   * Append an element to the ElseIfStmt list.
   * @param node The element to append to the ElseIfStmt list.
   * @apilevel high-level
   */
  public void addElseIfStmt(ElseIfStmt node) {
    List<ElseIfStmt> list = (parent == null) ? getElseIfStmtListNoTransform() : getElseIfStmtList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addElseIfStmtNoTransform(ElseIfStmt node) {
    List<ElseIfStmt> list = getElseIfStmtListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the ElseIfStmt list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setElseIfStmt(ElseIfStmt node, int i) {
    List<ElseIfStmt> list = getElseIfStmtList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the ElseIfStmt list.
   * @return The node representing the ElseIfStmt list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="ElseIfStmt")
  public List<ElseIfStmt> getElseIfStmtList() {
    List<ElseIfStmt> list = (List<ElseIfStmt>) getChild(0);
    return list;
  }
  /**
   * Retrieves the ElseIfStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ElseIfStmt list.
   * @apilevel low-level
   */
  public List<ElseIfStmt> getElseIfStmtListNoTransform() {
    return (List<ElseIfStmt>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the ElseIfStmt list without
   * triggering rewrites.
   */
  public ElseIfStmt getElseIfStmtNoTransform(int i) {
    return (ElseIfStmt) getElseIfStmtListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the ElseIfStmt list.
   * @return The node representing the ElseIfStmt list.
   * @apilevel high-level
   */
  public List<ElseIfStmt> getElseIfStmts() {
    return getElseIfStmtList();
  }
  /**
   * Retrieves the ElseIfStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ElseIfStmt list.
   * @apilevel low-level
   */
  public List<ElseIfStmt> getElseIfStmtsNoTransform() {
    return getElseIfStmtListNoTransform();
  }
}
