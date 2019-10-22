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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/lang.ast:26
 * @astdecl ElseIfStmt : Stmt ::= Condition:Expr Then:Block;
 * @production ElseIfStmt : {@link Stmt} ::= <span class="component">Condition:{@link Expr}</span> <span class="component">Then:{@link Block}</span>;

 */
public class ElseIfStmt extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:106
   */
  public void genEval(PrintStream out, int j){
  }
  /**
   * @aspect Interpreter
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Interpreter.jrag:65
   */
  public int eval(ActivationRecord actrec) throws Exception{
        if(getCondition().eval(actrec) == 1){
            getThen().eval(actrec);
        } else{
            return 0;
        }
        return 1;
    }
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
    name = {"Condition", "Then"},
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
   * Replaces the Condition child.
   * @param node The new node to replace the Condition child.
   * @apilevel high-level
   */
  public void setCondition(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Condition child.
   * @return The current node used as the Condition child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Condition")
  public Expr getCondition() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Condition child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Condition child.
   * @apilevel low-level
   */
  public Expr getConditionNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Then child.
   * @param node The new node to replace the Then child.
   * @apilevel high-level
   */
  public void setThen(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Then child.
   * @return The current node used as the Then child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Then")
  public Block getThen() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Then child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Then child.
   * @apilevel low-level
   */
  public Block getThenNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:5
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getConditionNoTransform()) {
      // @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:18
      return BoolType();
    }
    else {
      return super.Define_expectedType(_callerNode, _childNode);
    }
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
}
