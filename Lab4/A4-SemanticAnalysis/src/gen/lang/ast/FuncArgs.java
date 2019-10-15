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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab4/A4-SemanticAnalysis/src/jastadd/lang.ast:16
 * @astdecl FuncArgs : ASTNode ::= IdDecl*;
 * @production FuncArgs : {@link ASTNode} ::= <span class="component">{@link IdDecl}*</span>;

 */
public class FuncArgs extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public FuncArgs() {
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
    name = {"IdDecl"},
    type = {"List<IdDecl>"},
    kind = {"List"}
  )
  public FuncArgs(List<IdDecl> p0) {
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
    lookup_String_reset();
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
  public FuncArgs clone() throws CloneNotSupportedException {
    FuncArgs node = (FuncArgs) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public FuncArgs copy() {
    try {
      FuncArgs node = (FuncArgs) clone();
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
  public FuncArgs fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public FuncArgs treeCopyNoTransform() {
    FuncArgs tree = (FuncArgs) copy();
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
  public FuncArgs treeCopy() {
    FuncArgs tree = (FuncArgs) copy();
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
   * Replaces the IdDecl list.
   * @param list The new list node to be used as the IdDecl list.
   * @apilevel high-level
   */
  public void setIdDeclList(List<IdDecl> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the IdDecl list.
   * @return Number of children in the IdDecl list.
   * @apilevel high-level
   */
  public int getNumIdDecl() {
    return getIdDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the IdDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the IdDecl list.
   * @apilevel low-level
   */
  public int getNumIdDeclNoTransform() {
    return getIdDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the IdDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the IdDecl list.
   * @apilevel high-level
   */
  public IdDecl getIdDecl(int i) {
    return (IdDecl) getIdDeclList().getChild(i);
  }
  /**
   * Check whether the IdDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasIdDecl() {
    return getIdDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the IdDecl list.
   * @param node The element to append to the IdDecl list.
   * @apilevel high-level
   */
  public void addIdDecl(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getIdDeclListNoTransform() : getIdDeclList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addIdDeclNoTransform(IdDecl node) {
    List<IdDecl> list = getIdDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the IdDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setIdDecl(IdDecl node, int i) {
    List<IdDecl> list = getIdDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the IdDecl list.
   * @return The node representing the IdDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="IdDecl")
  public List<IdDecl> getIdDeclList() {
    List<IdDecl> list = (List<IdDecl>) getChild(0);
    return list;
  }
  /**
   * Retrieves the IdDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdDecl list.
   * @apilevel low-level
   */
  public List<IdDecl> getIdDeclListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the IdDecl list without
   * triggering rewrites.
   */
  public IdDecl getIdDeclNoTransform(int i) {
    return (IdDecl) getIdDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the IdDecl list.
   * @return The node representing the IdDecl list.
   * @apilevel high-level
   */
  public List<IdDecl> getIdDecls() {
    return getIdDeclList();
  }
  /**
   * Retrieves the IdDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdDecl list.
   * @apilevel low-level
   */
  public List<IdDecl> getIdDeclsNoTransform() {
    return getIdDeclListNoTransform();
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab4/A4-SemanticAnalysis/src/jastadd/NameAnalysis.jrag:43
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab4/A4-SemanticAnalysis/src/jastadd/NameAnalysis.jrag:43")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute FuncArgs.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_values.put(_parameters, lookup_String_value);
    state().leaveLazyAttribute();
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /** @apilevel internal */
  private void lookup_String_reset() {
    lookup_String_values = null;
    lookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map lookup_String_values;

  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab4/A4-SemanticAnalysis/src/jastadd/NameAnalysis.jrag:14
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getIdDeclListNoTransform()) {
      // @declaredat /home/miquel/Documents/LTH/compilers/Lab4/A4-SemanticAnalysis/src/jastadd/NameAnalysis.jrag:55
      int index = _callerNode.getIndexOfChild(_childNode);
      {
      		for(int i = 0; i <= index; i++){
      			if(getIdDecl(i).getID().equals(name)){
      				return getIdDecl(i);
      			}
      		}
      		return lookup(name);
      	}
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab4/A4-SemanticAnalysis/src/jastadd/NameAnalysis.jrag:14
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
}
