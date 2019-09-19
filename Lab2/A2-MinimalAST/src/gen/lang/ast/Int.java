/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:7
 * @astdecl Int : ASTNode ::= <INT:String>;
 * @production Int : {@link ASTNode} ::= <span class="component">&lt;INT:String&gt;</span>;

 */
public class Int extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Int() {
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
    name = {"INT"},
    type = {"String"},
    kind = {"Token"}
  )
  public Int(String p0) {
    setINT(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public Int(beaver.Symbol p0) {
    setINT(p0);
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
  public Int clone() throws CloneNotSupportedException {
    Int node = (Int) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Int copy() {
    try {
      Int node = (Int) clone();
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
  public Int fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public Int treeCopyNoTransform() {
    Int tree = (Int) copy();
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
  public Int treeCopy() {
    Int tree = (Int) copy();
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
    return super.is$Equal(node) && (tokenString_INT == ((Int) node).tokenString_INT);    
  }
  /**
   * Replaces the lexeme INT.
   * @param value The new value for the lexeme INT.
   * @apilevel high-level
   */
  public void setINT(String value) {
    tokenString_INT = value;
  }
  /** @apilevel internal 
   */
  protected String tokenString_INT;
  /**
   */
  public int INTstart;
  /**
   */
  public int INTend;
  /**
   * JastAdd-internal setter for lexeme INT using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme INT
   * @apilevel internal
   */
  public void setINT(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setINT is only valid for String lexemes");
    tokenString_INT = (String)symbol.value;
    INTstart = symbol.getStart();
    INTend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme INT.
   * @return The value for the lexeme INT.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="INT")
  public String getINT() {
    return tokenString_INT != null ? tokenString_INT : "";
  }
}
