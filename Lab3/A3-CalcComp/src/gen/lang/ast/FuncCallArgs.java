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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/lang.ast:14
 * @astdecl FuncCallArgs : ASTNode ::= IdUse*;
 * @production FuncCallArgs : {@link ASTNode} ::= <span class="component">{@link IdUse}*</span>;

 */
public class FuncCallArgs extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/Visitor.jrag:90
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/NameAnalysis.jrag:92
   */
  public void checkNames(PrintStream err, SymbolTable symbols) {
        getIdUses().checkNamesLoop(err, symbols);
    }
  /**
   * @declaredat ASTNode:1
   */
  public FuncCallArgs() {
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
    name = {"IdUse"},
    type = {"List<IdUse>"},
    kind = {"List"}
  )
  public FuncCallArgs(List<IdUse> p0) {
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
  public FuncCallArgs clone() throws CloneNotSupportedException {
    FuncCallArgs node = (FuncCallArgs) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public FuncCallArgs copy() {
    try {
      FuncCallArgs node = (FuncCallArgs) clone();
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
  public FuncCallArgs fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public FuncCallArgs treeCopyNoTransform() {
    FuncCallArgs tree = (FuncCallArgs) copy();
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
  public FuncCallArgs treeCopy() {
    FuncCallArgs tree = (FuncCallArgs) copy();
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
   * Replaces the IdUse list.
   * @param list The new list node to be used as the IdUse list.
   * @apilevel high-level
   */
  public void setIdUseList(List<IdUse> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the IdUse list.
   * @return Number of children in the IdUse list.
   * @apilevel high-level
   */
  public int getNumIdUse() {
    return getIdUseList().getNumChild();
  }
  /**
   * Retrieves the number of children in the IdUse list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the IdUse list.
   * @apilevel low-level
   */
  public int getNumIdUseNoTransform() {
    return getIdUseListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the IdUse list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the IdUse list.
   * @apilevel high-level
   */
  public IdUse getIdUse(int i) {
    return (IdUse) getIdUseList().getChild(i);
  }
  /**
   * Check whether the IdUse list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasIdUse() {
    return getIdUseList().getNumChild() != 0;
  }
  /**
   * Append an element to the IdUse list.
   * @param node The element to append to the IdUse list.
   * @apilevel high-level
   */
  public void addIdUse(IdUse node) {
    List<IdUse> list = (parent == null) ? getIdUseListNoTransform() : getIdUseList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addIdUseNoTransform(IdUse node) {
    List<IdUse> list = getIdUseListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the IdUse list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setIdUse(IdUse node, int i) {
    List<IdUse> list = getIdUseList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the IdUse list.
   * @return The node representing the IdUse list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="IdUse")
  public List<IdUse> getIdUseList() {
    List<IdUse> list = (List<IdUse>) getChild(0);
    return list;
  }
  /**
   * Retrieves the IdUse list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdUse list.
   * @apilevel low-level
   */
  public List<IdUse> getIdUseListNoTransform() {
    return (List<IdUse>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the IdUse list without
   * triggering rewrites.
   */
  public IdUse getIdUseNoTransform(int i) {
    return (IdUse) getIdUseListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the IdUse list.
   * @return The node representing the IdUse list.
   * @apilevel high-level
   */
  public List<IdUse> getIdUses() {
    return getIdUseList();
  }
  /**
   * Retrieves the IdUse list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdUse list.
   * @apilevel low-level
   */
  public List<IdUse> getIdUsesNoTransform() {
    return getIdUseListNoTransform();
  }
}
