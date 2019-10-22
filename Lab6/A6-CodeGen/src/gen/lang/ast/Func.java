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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/lang.ast:15
 * @astdecl Func : Stmt ::= Decl:IdDecl Args:FuncArgs Block:Block;
 * @production Func : {@link Stmt} ::= <span class="component">Decl:{@link IdDecl}</span> <span class="component">Args:{@link FuncArgs}</span> <span class="component">Block:{@link Block}</span>;

 */
public class Func extends Stmt implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/PrettyPrint.jrag:25
   */
  public void prettyPrint(PrintStream out, String ind){
	    out.print(ind);
		getDecl().prettyPrint(out, ind);
		out.print(" (");
		if(getArgs().hasIdDecl()) {
		    getArgs().getIdDecls().printLoop(out, "", Optional.of(", "));
        }
		out.println(") {");
		getBlock().getStmts().printLoop(out, ind+TAB, Optional.of(";\n"));
		out.println(ind+"}");
		out.println();
	}
  /**
   * @aspect CodeGen
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:28
   */
  public void genEval(PrintStream out, int j) {

    out.println(getDecl().getID()+":");
    out.println("        pushq %rbp # From Func");
    out.println("        movq %rsp, %rbp # From Func");
    out.println("        subq $" + ((numLocals())*8) + ", %rsp # From Func");
    for(int i = 0; i < getArgs().getNumIdDecl(); i++) {
      out.println("        movq "+ ((numLocals() + 2 + i)*8) +"(%rsp), %rax # From Func");
      getArgs().getIdDecl(getArgs().getNumIdDecl()-i-1).genEval(out, j);
    }
    getBlock().genEval(out, j);
    // De-Allocate local variables
    out.println("        "+getDecl().getID()+"_end:");
    out.println("        movq %rbp, %rsp");
    out.println("        popq %rbp");
    out.println("        ret");
  }
  /**
   * @aspect Interpreter
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Interpreter.jrag:25
   */
  public int eval(ActivationRecord actrec) {
        try{
            getBlock().eval(actrec);
        }catch(Exception e){
            return Integer.valueOf(e.getMessage());
        }
        if(getDecl().getID().equals("print")){
            // System.out.println(actrec.get(getArgs().getIdDecl(0).uniqueName()));
        } else if (getDecl().getID().equals("read")){
            // return Integer.valueOf(this.scan.nextInt());
        } //else {
            //throw new RuntimeException("Return statement missing");
        //}
        return 0;
    }
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
    name = {"Decl", "Args", "Block"},
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
    localLookup_String_reset();
    localIndex_reset();
    isUnknown_reset();
    lookup_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Func_functionCalls_visited = false;
    Func_functionCalls_computed = false;
    
    Func_functionCalls_value = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:49
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
   * @declaredat ASTNode:68
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
   * @declaredat ASTNode:78
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
   * @declaredat ASTNode:98
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
   * @declaredat ASTNode:112
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
protected java.util.Set localLookup_String_visited;
  /** @apilevel internal */
  private void localLookup_String_reset() {
    localLookup_String_values = null;
    localLookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map localLookup_String_values;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:66
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:66")
  public IdDecl localLookup(String name) {
    Object _parameters = name;
    if (localLookup_String_visited == null) localLookup_String_visited = new java.util.HashSet(4);
    if (localLookup_String_values == null) localLookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (localLookup_String_values.containsKey(_parameters)) {
      return (IdDecl) localLookup_String_values.get(_parameters);
    }
    if (localLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.localLookup(String).");
    }
    localLookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl localLookup_String_value = UnknownDecl();
    localLookup_String_values.put(_parameters, localLookup_String_value);
    state().leaveLazyAttribute();
    localLookup_String_visited.remove(_parameters);
    return localLookup_String_value;
  }
/** @apilevel internal */
protected boolean localIndex_visited = false;
  /** @apilevel internal */
  private void localIndex_reset() {
    localIndex_computed = false;
    localIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean localIndex_computed = false;

  /** @apilevel internal */
  protected int localIndex_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:405
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:403")
  public int localIndex() {
    ASTState state = state();
    if (localIndex_computed) {
      return localIndex_value;
    }
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    state().enterLazyAttribute();
    localIndex_value = 0;
    localIndex_computed = true;
    state().leaveLazyAttribute();
    localIndex_visited = false;
    return localIndex_value;
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
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownFunc.jrag:7
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
    isUnknown_value = false;
    isUnknown_computed = true;
    state().leaveLazyAttribute();
    isUnknown_visited = false;
    return isUnknown_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:68
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:68")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.lookup(String).");
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
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:38
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getBlockNoTransform()) {
      // @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:70
      {
      		for(IdDecl idDecl : getArgs().getIdDecls()){
      			if(idDecl.getID().equals(name)){
      				return idDecl;
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
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:38
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/FuncCall.jrag:7
   * @apilevel internal
   */
  public Func Define_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/FuncCall.jrag:7
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingFunction
   */
  protected boolean canDefine_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Func_functionCalls_visited = false;
  /**
   * @attribute coll
   * @aspect FunctionCalls
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/FuncCall.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="FunctionCalls", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/FuncCall.jrag:5")
  public HashSet<Func> functionCalls() {
    ASTState state = state();
    if (Func_functionCalls_computed) {
      return Func_functionCalls_value;
    }
    if (Func_functionCalls_visited) {
      throw new RuntimeException("Circular definition of attribute Func.functionCalls().");
    }
    Func_functionCalls_visited = true;
    state().enterLazyAttribute();
    Func_functionCalls_value = functionCalls_compute();
    Func_functionCalls_computed = true;
    state().leaveLazyAttribute();
    Func_functionCalls_visited = false;
    return Func_functionCalls_value;
  }
  /** @apilevel internal */
  private HashSet<Func> functionCalls_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Func_functionCalls();
    HashSet<Func> _computedValue = new HashSet<Func>();
    if (root.contributorMap_Func_functionCalls.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Func_functionCalls.get(this)) {
        contributor.contributeTo_Func_functionCalls(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Func_functionCalls_computed = false;

  /** @apilevel internal */
  protected HashSet<Func> Func_functionCalls_value;

}
