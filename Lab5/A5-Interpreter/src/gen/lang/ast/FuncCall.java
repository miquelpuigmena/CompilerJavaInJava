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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/lang.ast:17
 * @astdecl FuncCall : Call ::= ID:IdUse Args:FuncCallArgs;
 * @production FuncCall : {@link Call} ::= <span class="component">ID:{@link IdUse}</span> <span class="component">Args:{@link FuncCallArgs}</span>;

 */
public class FuncCall extends Call implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/PrettyPrint.jrag:164
   */
  public void prettyPrint(PrintStream out, String ind) {
	    out.print(ind);
		getID().prettyPrint(out, ind);
		out.print("(");
		getArgs().getExprs().printLoop(out, ind, Optional.of(", "));
		out.print(")");
	}
  /**
   * @aspect Interpreter
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/Interpreter.jrag:68
   */
  public int eval(ActivationRecord actrec) {
        System.out.println("in FuncCall");
        IdDecl decl = lookup(getID().getID());
        Func func = (Func) decl.getParent();
        int i = 0;
        for(Expr e : getArgs().getExprs()) {
            actrec.store(func.getArgs().getIdDecl(i).getID(), e.eval(actrec));
            i++;
        }
        return 1;
    }
  /**
   * @declaredat ASTNode:1
   */
  public FuncCall() {
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
    name = {"ID", "Args"},
    type = {"IdUse", "FuncCallArgs"},
    kind = {"Child", "Child"}
  )
  public FuncCall(IdUse p0, FuncCallArgs p1) {
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
    areArgsIncorrect_reset();
    type_reset();
    lookup_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public FuncCall clone() throws CloneNotSupportedException {
    FuncCall node = (FuncCall) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public FuncCall copy() {
    try {
      FuncCall node = (FuncCall) clone();
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
   * @declaredat ASTNode:62
   */
  @Deprecated
  public FuncCall fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public FuncCall treeCopyNoTransform() {
    FuncCall tree = (FuncCall) copy();
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
   * @declaredat ASTNode:92
   */
  public FuncCall treeCopy() {
    FuncCall tree = (FuncCall) copy();
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
   * @declaredat ASTNode:106
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the ID child.
   * @param node The new node to replace the ID child.
   * @apilevel high-level
   */
  public void setID(IdUse node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the ID child.
   * @return The current node used as the ID child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="ID")
  public IdUse getID() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the ID child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ID child.
   * @apilevel low-level
   */
  public IdUse getIDNoTransform() {
    return (IdUse) getChildNoTransform(0);
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
/** @apilevel internal */
protected boolean areArgsIncorrect_visited = false;
  /** @apilevel internal */
  private void areArgsIncorrect_reset() {
    areArgsIncorrect_computed = false;
    areArgsIncorrect_visited = false;
  }
  /** @apilevel internal */
  protected boolean areArgsIncorrect_computed = false;

  /** @apilevel internal */
  protected boolean areArgsIncorrect_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:16
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:16")
  public boolean areArgsIncorrect() {
    ASTState state = state();
    if (areArgsIncorrect_computed) {
      return areArgsIncorrect_value;
    }
    if (areArgsIncorrect_visited) {
      throw new RuntimeException("Circular definition of attribute FuncCall.areArgsIncorrect().");
    }
    areArgsIncorrect_visited = true;
    state().enterLazyAttribute();
    areArgsIncorrect_value = areArgsIncorrect_compute();
    areArgsIncorrect_computed = true;
    state().leaveLazyAttribute();
    areArgsIncorrect_visited = false;
    return areArgsIncorrect_value;
  }
  /** @apilevel internal */
  private boolean areArgsIncorrect_compute() {
  	    if(!Program.class.isInstance(getID().decl().getParent())) {
  	        Func f_decl = (Func) getID().decl().getParent();
  	        int num_args_func_call = getArgs().getExprs().getNumChild();
  	        int num_args_func_decl = f_decl.getArgs().getIdDeclList().getNumChild();
  	        return (num_args_func_call != num_args_func_decl);
  	    }
  	    Program p_decl = (Program) getID().decl().getParent();
  	    for(Func f : p_decl.PreDefFuncs()) {
  	        if(f.getDecl().getID().equals(getID().getID())) {
                  int num_args_func_call = getArgs().getExprs().getNumChild();
                  int num_args_func_def_decl = f.getArgs().getIdDeclList().getNumChild();
                  return !(num_args_func_call != num_args_func_def_decl);
  	        }
  	    }
  	    return false;
  	}
/** @apilevel internal */
protected boolean type_visited = false;
  /** @apilevel internal */
  private void type_reset() {
    type_computed = false;
    
    type_value = null;
    type_visited = false;
  }
  /** @apilevel internal */
  protected boolean type_computed = false;

  /** @apilevel internal */
  protected Type type_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/TypeAnalysis.jrag:14
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/TypeAnalysis.jrag:3")
  public Type type() {
    ASTState state = state();
    if (type_computed) {
      return type_value;
    }
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.type().");
    }
    type_visited = true;
    state().enterLazyAttribute();
    type_value = getID().type();
    type_computed = true;
    state().leaveLazyAttribute();
    type_visited = false;
    return type_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:41
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/NameAnalysis.jrag:41")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute FuncCall.lookup(String).");
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

  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/miquel/Documents/LTH/compilers/Lab5/A5-Interpreter/src/jastadd/Errors.jrag:46
    if (areArgsIncorrect()) {
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
    if (areArgsIncorrect()) {
      collection.add(error("Wrong number of arguments. Found '" + getArgs().getExprs().getNumChild() + "' arguments but expected number was '" + ((Func)getID().decl().getParent()).getArgs().getIdDeclList().getNumChild() + "'"));
    }
  }
}
