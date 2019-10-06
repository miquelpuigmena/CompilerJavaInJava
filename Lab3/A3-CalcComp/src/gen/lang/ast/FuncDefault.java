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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/lang.ast:12
 * @astdecl FuncDefault : Call ::= Func:DefFunc Args:FuncCallArgs;
 * @production FuncDefault : {@link Call} ::= <span class="component">Func:{@link DefFunc}</span> <span class="component">Args:{@link FuncCallArgs}</span>;

 */
public class FuncDefault extends Call implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/PrettyPrint.jrag:172
   */
  public void prettyPrint(PrintStream out, String ind) {
	    out.print(ind);
	    getFunc().prettyPrint(out, ind);
	    out.print("(");
	    getArgs().getIdUses().printLoop(out, ind, Optional.of(", "));
	    out.print(")");
	}
  /**
   * @declaredat ASTNode:1
   */
  public FuncDefault() {
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
    name = {"Func", "Args"},
    type = {"DefFunc", "FuncCallArgs"},
    kind = {"Child", "Child"}
  )
  public FuncDefault(DefFunc p0, FuncCallArgs p1) {
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
  public FuncDefault clone() throws CloneNotSupportedException {
    FuncDefault node = (FuncDefault) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public FuncDefault copy() {
    try {
      FuncDefault node = (FuncDefault) clone();
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
  public FuncDefault fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public FuncDefault treeCopyNoTransform() {
    FuncDefault tree = (FuncDefault) copy();
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
  public FuncDefault treeCopy() {
    FuncDefault tree = (FuncDefault) copy();
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
   * Replaces the Func child.
   * @param node The new node to replace the Func child.
   * @apilevel high-level
   */
  public void setFunc(DefFunc node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Func child.
   * @return The current node used as the Func child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Func")
  public DefFunc getFunc() {
    return (DefFunc) getChild(0);
  }
  /**
   * Retrieves the Func child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Func child.
   * @apilevel low-level
   */
  public DefFunc getFuncNoTransform() {
    return (DefFunc) getChildNoTransform(0);
  }
  /**
   * Replaces the Args child.
   * @param node The new node to replace the Args child.
   * @apilevel high-level
   */
  public void setArgs(FuncCallArgs node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Args child.
   * @return The current node used as the Args child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Args")
  public FuncCallArgs getArgs() {
    return (FuncCallArgs) getChild(1);
  }
  /**
   * Retrieves the Args child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Args child.
   * @apilevel low-level
   */
  public FuncCallArgs getArgsNoTransform() {
    return (FuncCallArgs) getChildNoTransform(1);
  }
}
