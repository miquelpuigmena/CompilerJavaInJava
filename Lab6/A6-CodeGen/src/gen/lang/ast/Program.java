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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= Func*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Func}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/PrettyPrint.jrag:19
   */
  public void prettyPrint(PrintStream out, String ind){
	    getFuncs().printLoop(out, "", Optional.empty());
	}
  /**
   * @aspect CodeGen
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:6
   */
  public void genCode(PrintStream out) {
    out.println(".global _start");
    out.println(".data");
    out.println("buf: .skip 1024");
    out.println();
    out.println(".text");
    out.println("_start:");

    out.println("        pushq %rbp # From Program");
    out.println("        movq %rsp, %rbp # From Program");
    out.println("        call main");
    // Call sys-exit
    out.println("        movq %rax, %rdi");
    out.println("        movq $60, %rax");
    out.println("        syscall");
    for(Func f : getFuncs()) {
        f.genEval(out, 0);
    }
    writePrint(out);
    writeRead(out);
  }
  /**
   * @aspect CodeGen
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:275
   */
  public void writeRead(PrintStream out){
    // Helper procedures for input:
    out.println("# Procedure to read number from stdin.");
    out.println("# C signature: long long int read(void)");
    out.println("read:");
    out.println("        pushq %rbp");
    out.println("        movq %rsp, %rbp");
    out.println("        ### R9  = sign");
    out.println("        movq $1, %r9            # sign <- 1");
    out.println("        ### R10 = sum");
    out.println("        movq $0, %r10           # sum <- 0");
    out.println("skip_ws: # skip any leading whitespace");
    out.println("        movq $0, %rdi");
    out.println("        leaq buf(%rip), %rsi");
    out.println("        movq $1, %rdx");
    out.println("        movq $0, %rax");
    out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
    out.println("        cmpq $0, %rax");
    out.println("        jle atoi_done           # nchar <= 0");
    out.println("        movb (%rsi), %cl        # c <- current char");
    out.println("        cmp $32, %cl");
    out.println("        je skip_ws              # c == space");
    out.println("        cmp $13, %cl");
    out.println("        je skip_ws              # c == CR");
    out.println("        cmp $10, %cl");
    out.println("        je skip_ws              # c == NL");
    out.println("        cmp $9, %cl");
    out.println("        je skip_ws              # c == tab");
    out.println("        cmp $45, %cl            # check if negative");
    out.println("        jne atoi_loop");
    out.println("        movq $-1, %r9           # sign <- -1");
    out.println("        movq $0, %rdi");
    out.println("        leaq buf(%rip), %rsi");
    out.println("        movq $1, %rdx");
    out.println("        movq $0, %rax");
    out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
    out.println("atoi_loop:");
    out.println("        cmpq $0, %rax           # while (nchar > 0)");
    out.println("        jle atoi_done           # leave loop if nchar <= 0");
    out.println("        movzbq (%rsi), %rcx     # move byte, zero extend to quad-word");
    out.println("        cmpq $0x30, %rcx        # test if < '0'");
    out.println("        jl atoi_done            # character is not numeric");
    out.println("        cmpq $0x39, %rcx        # test if > '9'");
    out.println("        jg atoi_done            # character is not numeric");
    out.println("        imulq $10, %r10         # multiply sum by 10");
    out.println("        subq $0x30, %rcx        # value of character");
    out.println("        addq %rcx, %r10         # add to sum");
    out.println("        movq $0, %rdi");
    out.println("        leaq buf(%rip), %rsi");
    out.println("        movq $1, %rdx");
    out.println("        movq $0, %rax");
    out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
    out.println("        jmp atoi_loop           # loop back");
    out.println("atoi_done:");
    out.println("        imulq %r9, %r10         # sum *= sign");
    out.println("        movq %r10, %rax         # put result value in RAX");
    out.println("        popq %rbp");
    out.println("        ret");
    out.println();
    out.println("print_string:");
    out.println("        pushq %rbp");
    out.println("        movq %rsp, %rbp");
    out.println("        movq $1, %rdi");
    out.println("        movq 16(%rbp), %rsi");
    out.println("        movq 24(%rbp), %rdx");
    out.println("        movq $1, %rax");
    out.println("        syscall");
    out.println("        popq %rbp");
    out.println("        ret");
  }
  /**
   * @aspect CodeGen
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:345
   */
  public void writePrint(PrintStream out){
    // Helper procedures for output:
    out.println("# Procedure to print number to stdout.");
    out.println("# C signature: void print(long int)");
    out.println("print:");
    out.println("        pushq %rbp");
    out.println("        movq %rsp, %rbp");
    out.println("        ### Convert integer to string (itoa).");
    out.println("        movq 16(%rbp), %rax");
    out.println("        leaq buf(%rip), %rsi    # RSI = write pointer (starts at end of buffer)");
    out.println("        addq $1023, %rsi");
    out.println("        movb $0x0A, (%rsi)      # insert newline");
    out.println("        movq $1, %rcx           # RCX = string length");
    out.println("        cmpq $0, %rax");
    out.println("        jge itoa_loop");
    out.println("        negq %rax               # negate to make RAX positive");
    out.println("itoa_loop:                      # do.. while (at least one iteration)");
    out.println("        movq $10, %rdi");
    out.println("        movq $0, %rdx");
    out.println("        idivq %rdi              # divide RDX:RAX by 10");
    out.println("        addb $0x30, %dl         # remainder + '0'");
    out.println("        decq %rsi               # move string pointer");
    out.println("        movb %dl, (%rsi)");
    out.println("        incq %rcx               # increment string length");
    out.println("        cmpq $0, %rax");
    out.println("        jg itoa_loop            # produce more digits");
    out.println("itoa_done:");
    out.println("        movq 16(%rbp), %rax");
    out.println("        cmpq $0, %rax");
    out.println("        jge print_end");
    out.println("        decq %rsi");
    out.println("        incq %rcx");
    out.println("        movb $0x2D, (%rsi)");
    out.println("print_end:");
    out.println("        movq $1, %rdi");
    out.println("        movq %rcx, %rdx");
    out.println("        movq $1, %rax");
    out.println("        syscall");
    out.println("        popq %rbp");
    out.println("        ret");
    out.println("");
  }
  /**
   * @aspect Interpreter
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Interpreter.jrag:17
   */
  public void eval() {
        Func f_main = getFuncFromList(getFuncs(), "main");
        f_main.eval(new ActivationRecord(new HashMap<String, Integer>()));
    }
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    name = {"Func"},
    type = {"List<Func>"},
    kind = {"List"}
  )
  public Program(List<Func> p0) {
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
    PreDefFuncs_reset();
    UnknownDecl_reset();
    IntType_reset();
    UnknownType_reset();
    localIndex_reset();
    UnknownFunc_reset();
    BoolType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
    contributorMap_Func_functionCalls = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:48
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:53
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:72
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:82
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:102
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:116
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Func list.
   * @param list The new list node to be used as the Func list.
   * @apilevel high-level
   */
  public void setFuncList(List<Func> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Func list.
   * @return Number of children in the Func list.
   * @apilevel high-level
   */
  public int getNumFunc() {
    return getFuncList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Func list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Func list.
   * @apilevel low-level
   */
  public int getNumFuncNoTransform() {
    return getFuncListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Func list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Func list.
   * @apilevel high-level
   */
  public Func getFunc(int i) {
    return (Func) getFuncList().getChild(i);
  }
  /**
   * Check whether the Func list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunc() {
    return getFuncList().getNumChild() != 0;
  }
  /**
   * Append an element to the Func list.
   * @param node The element to append to the Func list.
   * @apilevel high-level
   */
  public void addFunc(Func node) {
    List<Func> list = (parent == null) ? getFuncListNoTransform() : getFuncList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncNoTransform(Func node) {
    List<Func> list = getFuncListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Func list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFunc(Func node, int i) {
    List<Func> list = getFuncList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Func list.
   * @return The node representing the Func list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Func")
  public List<Func> getFuncList() {
    List<Func> list = (List<Func>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Func list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Func list.
   * @apilevel low-level
   */
  public List<Func> getFuncListNoTransform() {
    return (List<Func>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Func list without
   * triggering rewrites.
   */
  public Func getFuncNoTransform(int i) {
    return (Func) getFuncListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Func list.
   * @return The node representing the Func list.
   * @apilevel high-level
   */
  public List<Func> getFuncs() {
    return getFuncList();
  }
  /**
   * Retrieves the Func list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Func list.
   * @apilevel low-level
   */
  public List<Func> getFuncsNoTransform() {
    return getFuncListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Errors.jrag:26
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  /** @apilevel internal */
  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/FuncCall.jrag:5
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Func_functionCalls = null;

  /** @apilevel internal */
  protected void survey_Func_functionCalls() {
    if (contributorMap_Func_functionCalls == null) {
      contributorMap_Func_functionCalls = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Func_functionCalls(this, contributorMap_Func_functionCalls);
    }
  }

/** @apilevel internal */
protected boolean PreDefFuncs_visited = false;
  /** @apilevel internal */
  private void PreDefFuncs_reset() {
    PreDefFuncs_computed = false;
    
    PreDefFuncs_value = null;
    PreDefFuncs_visited = false;
  }
  /** @apilevel internal */
  protected boolean PreDefFuncs_computed = false;

  /** @apilevel internal */
  protected List<Func> PreDefFuncs_value;

  /**
   * @attribute syn
   * @aspect PreDefFuncs
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/PreDefFuncs.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="PreDefFuncs", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/PreDefFuncs.jrag:2")
  public List<Func> PreDefFuncs() {
    ASTState state = state();
    if (PreDefFuncs_computed) {
      return PreDefFuncs_value;
    }
    if (PreDefFuncs_visited) {
      throw new RuntimeException("Circular definition of attribute Program.PreDefFuncs().");
    }
    PreDefFuncs_visited = true;
    state().enterLazyAttribute();
    PreDefFuncs_value = PreDefFuncs_compute();
    PreDefFuncs_value.setParent(this);
    PreDefFuncs_computed = true;
    state().leaveLazyAttribute();
    PreDefFuncs_visited = false;
    return PreDefFuncs_value;
  }
  /** @apilevel internal */
  private List<Func> PreDefFuncs_compute() {
  		List<Func> list = new List<Func>();
  		list.add(new Func(new IdDecl("read"), new FuncArgs(), new Block(new List())));
  		list.add(new Func(new IdDecl("print"), new FuncArgs(new List(new IdDecl("string"))), new Block(new List())));
  		return list;
  	}
/** @apilevel internal */
protected boolean UnknownDecl_visited = false;
  /** @apilevel internal */
  private void UnknownDecl_reset() {
    UnknownDecl_computed = false;
    
    UnknownDecl_value = null;
    UnknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean UnknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl UnknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl UnknownDecl() {
    ASTState state = state();
    if (UnknownDecl_computed) {
      return UnknownDecl_value;
    }
    if (UnknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.UnknownDecl().");
    }
    UnknownDecl_visited = true;
    state().enterLazyAttribute();
    UnknownDecl_value = new UnknownDecl("<unknown>");
    UnknownDecl_value.setParent(this);
    UnknownDecl_computed = true;
    state().leaveLazyAttribute();
    UnknownDecl_visited = false;
    return UnknownDecl_value;
  }
/** @apilevel internal */
protected boolean IntType_visited = false;
  /** @apilevel internal */
  private void IntType_reset() {
    IntType_computed = false;
    
    IntType_value = null;
    IntType_visited = false;
  }
  /** @apilevel internal */
  protected boolean IntType_computed = false;

  /** @apilevel internal */
  protected IntType IntType_value;

  /**
   * @attribute syn
   * @aspect IntType
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/IntType.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="IntType", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/IntType.jrag:2")
  public IntType IntType() {
    ASTState state = state();
    if (IntType_computed) {
      return IntType_value;
    }
    if (IntType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.IntType().");
    }
    IntType_visited = true;
    state().enterLazyAttribute();
    IntType_value = new IntType();
    IntType_value.setParent(this);
    IntType_computed = true;
    state().leaveLazyAttribute();
    IntType_visited = false;
    return IntType_value;
  }
/** @apilevel internal */
protected boolean UnknownType_visited = false;
  /** @apilevel internal */
  private void UnknownType_reset() {
    UnknownType_computed = false;
    
    UnknownType_value = null;
    UnknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean UnknownType_computed = false;

  /** @apilevel internal */
  protected UnknownType UnknownType_value;

  /**
   * @attribute syn
   * @aspect UnknownType
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownType.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownType", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownType.jrag:2")
  public UnknownType UnknownType() {
    ASTState state = state();
    if (UnknownType_computed) {
      return UnknownType_value;
    }
    if (UnknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.UnknownType().");
    }
    UnknownType_visited = true;
    state().enterLazyAttribute();
    UnknownType_value = new UnknownType();
    UnknownType_value.setParent(this);
    UnknownType_computed = true;
    state().leaveLazyAttribute();
    UnknownType_visited = false;
    return UnknownType_value;
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
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/CodeGen.jrag:404
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
protected boolean UnknownFunc_visited = false;
  /** @apilevel internal */
  private void UnknownFunc_reset() {
    UnknownFunc_computed = false;
    
    UnknownFunc_value = null;
    UnknownFunc_visited = false;
  }
  /** @apilevel internal */
  protected boolean UnknownFunc_computed = false;

  /** @apilevel internal */
  protected UnknownFunc UnknownFunc_value;

  /**
   * @attribute syn
   * @aspect UnknownFunc
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownFunc.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownFunc.jrag:2")
  public UnknownFunc UnknownFunc() {
    ASTState state = state();
    if (UnknownFunc_computed) {
      return UnknownFunc_value;
    }
    if (UnknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute Program.UnknownFunc().");
    }
    UnknownFunc_visited = true;
    state().enterLazyAttribute();
    UnknownFunc_value = new UnknownFunc();
    UnknownFunc_value.setParent(this);
    UnknownFunc_computed = true;
    state().leaveLazyAttribute();
    UnknownFunc_visited = false;
    return UnknownFunc_value;
  }
/** @apilevel internal */
protected boolean BoolType_visited = false;
  /** @apilevel internal */
  private void BoolType_reset() {
    BoolType_computed = false;
    
    BoolType_value = null;
    BoolType_visited = false;
  }
  /** @apilevel internal */
  protected boolean BoolType_computed = false;

  /** @apilevel internal */
  protected BoolType BoolType_value;

  /**
   * @attribute syn
   * @aspect BoolType
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/BoolType.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="BoolType", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/BoolType.jrag:2")
  public BoolType BoolType() {
    ASTState state = state();
    if (BoolType_computed) {
      return BoolType_value;
    }
    if (BoolType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.BoolType().");
    }
    BoolType_visited = true;
    state().enterLazyAttribute();
    BoolType_value = new BoolType();
    BoolType_value.setParent(this);
    BoolType_computed = true;
    state().leaveLazyAttribute();
    BoolType_visited = false;
    return BoolType_value;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Errors.jrag:28
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_UnknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return UnknownDecl();
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute UnknownDecl
   */
  protected boolean canDefine_UnknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/IntType.jrag:4
   * @apilevel internal
   */
  public IntType Define_IntType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return IntType();
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/IntType.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute IntType
   */
  protected boolean canDefine_IntType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:38
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFuncListNoTransform()) {
      // @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:4
      int index = _callerNode.getIndexOfChild(_childNode);
      {
              for(Func func : getFuncs()){
                  if(func.getDecl().getID().equals(name)) return func.getDecl();
              }
              for(Func func: PreDefFuncs()) {
                  if(func.getDecl().getID().equals(name)) return func.getDecl();
              }
              return UnknownDecl();
          }
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      return UnknownDecl();
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
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:109
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/NameAnalysis.jrag:109
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownType.jrag:4
   * @apilevel internal
   */
  public UnknownType Define_UnknownType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return UnknownType();
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownType.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute UnknownType
   */
  protected boolean canDefine_UnknownType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownFunc.jrag:4
   * @apilevel internal
   */
  public UnknownFunc Define_UnknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return UnknownFunc();
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/UnknownFunc.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute UnknownFunc
   */
  protected boolean canDefine_UnknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/FuncCall.jrag:7
   * @apilevel internal
   */
  public Func Define_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return UnknownFunc();
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/FuncCall.jrag:7
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingFunction
   */
  protected boolean canDefine_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/BoolType.jrag:4
   * @apilevel internal
   */
  public BoolType Define_BoolType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return BoolType();
  }
  /**
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/BoolType.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute BoolType
   */
  protected boolean canDefine_BoolType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/miquel/Documents/LTH/compilers/Lab6/A6-CodeGen/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTState state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;

}
