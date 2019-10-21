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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/lang.ast:4
 * @astdecl Expr : Stmt;
 * @production Expr : {@link Stmt};

 */
public abstract class Expr extends Stmt implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:247
   */
  abstract public void genEval(PrintStream out);
  /**
   * @aspect Interpreter
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Interpreter.jrag:23
   */
  abstract public int eval(ActivationRecord actrec);
  /**
   * @declaredat ASTNode:1
   */
  public Expr() {
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
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:17
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    compatibleType_reset();
    expectedType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public Expr clone() throws CloneNotSupportedException {
    Expr node = (Expr) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:38
   */
  @Deprecated
  public abstract Expr fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:46
   */
  public abstract Expr treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:54
   */
  public abstract Expr treeCopy();
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:3")
  public abstract Type type();
/** @apilevel internal */
protected boolean compatibleType_visited = false;
  /** @apilevel internal */
  private void compatibleType_reset() {
    compatibleType_computed = false;
    
    compatibleType_value = null;
    compatibleType_visited = false;
  }
  /** @apilevel internal */
  protected boolean compatibleType_computed = false;

  /** @apilevel internal */
  protected Boolean compatibleType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:4")
  public Boolean compatibleType() {
    ASTState state = state();
    if (compatibleType_computed) {
      return compatibleType_value;
    }
    if (compatibleType_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.compatibleType().");
    }
    compatibleType_visited = true;
    state().enterLazyAttribute();
    compatibleType_value = type() != expectedType() && type() != UnknownType();
    compatibleType_computed = true;
    state().leaveLazyAttribute();
    compatibleType_visited = false;
    return compatibleType_value;
  }
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/TypeAnalysis.jrag:5")
  public Type expectedType() {
    ASTState state = state();
    if (expectedType_computed) {
      return expectedType_value;
    }
    if (expectedType_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.expectedType().");
    }
    expectedType_visited = true;
    state().enterLazyAttribute();
    expectedType_value = getParent().Define_expectedType(this, null);
    expectedType_computed = true;
    state().leaveLazyAttribute();
    expectedType_visited = false;
    return expectedType_value;
  }
/** @apilevel internal */
protected boolean expectedType_visited = false;
  /** @apilevel internal */
  private void expectedType_reset() {
    expectedType_computed = false;
    
    expectedType_value = null;
    expectedType_visited = false;
  }
  /** @apilevel internal */
  protected boolean expectedType_computed = false;

  /** @apilevel internal */
  protected Type expectedType_value;

  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Errors.jrag:50
    if (compatibleType()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (compatibleType()) {
      collection.add(error("Expected type: " + expectedType() + ". Received type: " + type()));
    }
  }
}
