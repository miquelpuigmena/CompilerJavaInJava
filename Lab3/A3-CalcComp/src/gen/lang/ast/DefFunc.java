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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/lang.ast:26
 * @astdecl DefFunc : Atomic ::= <DEF_FUNC:String>;
 * @production DefFunc : {@link Atomic} ::= <span class="component">&lt;DEF_FUNC:String&gt;</span>;

 */
public class DefFunc extends Atomic implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/PrettyPrint.jrag:180
   */
  public void prettyPrint(PrintStream out, String ind) {
	    out.print(getDEF_FUNC());
	}
  /**
   * @declaredat ASTNode:1
   */
  public DefFunc() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"DEF_FUNC"},
    type = {"String"},
    kind = {"Token"}
  )
  public DefFunc(String p0) {
    setDEF_FUNC(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public DefFunc(beaver.Symbol p0) {
    setDEF_FUNC(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
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
  public DefFunc clone() throws CloneNotSupportedException {
    DefFunc node = (DefFunc) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public DefFunc copy() {
    try {
      DefFunc node = (DefFunc) clone();
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
  public DefFunc fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public DefFunc treeCopyNoTransform() {
    DefFunc tree = (DefFunc) copy();
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
  public DefFunc treeCopy() {
    DefFunc tree = (DefFunc) copy();
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
    return super.is$Equal(node) && (tokenString_DEF_FUNC == ((DefFunc) node).tokenString_DEF_FUNC);    
  }
  /**
   * Replaces the lexeme DEF_FUNC.
   * @param value The new value for the lexeme DEF_FUNC.
   * @apilevel high-level
   */
  public void setDEF_FUNC(String value) {
    tokenString_DEF_FUNC = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_DEF_FUNC;
  /**
   */
  public int DEF_FUNCstart;
  /**
   */
  public int DEF_FUNCend;
  /**
   * JastAdd-internal setter for lexeme DEF_FUNC using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme DEF_FUNC
   * @apilevel internal
   */
  public void setDEF_FUNC(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setDEF_FUNC is only valid for String lexemes");
    tokenString_DEF_FUNC = (String)symbol.value;
    DEF_FUNCstart = symbol.getStart();
    DEF_FUNCend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme DEF_FUNC.
   * @return The value for the lexeme DEF_FUNC.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="DEF_FUNC")
  public String getDEF_FUNC() {
    return tokenString_DEF_FUNC != null ? tokenString_DEF_FUNC : "";
  }
}
