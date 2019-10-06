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
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/lang.ast:10
 * @astdecl Func : Stmt ::= Decl:IdDecl Args:FuncArgs Block:Block;
 * @production Func : {@link Stmt} ::= <span class="component">Decl:{@link IdDecl}</span> <span class="component">Args:{@link FuncArgs}</span> <span class="component">Block:{@link Block}</span>;

 */
public class Func extends Stmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/Visitor.jrag:81
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/PrettyPrint.jrag:25
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
   * @aspect NameAnalysis
   * @declaredat /home/miquel/Documents/LTH/compilers/Lab3/A3-CalcComp/src/jastadd/NameAnalysis.jrag:71
   */
  public void checkNames(PrintStream err, SymbolTable program_symbols) {
        SymbolTable func_symbols = program_symbols.push();
        getDecl().checkNames(err, program_symbols);
        getArgs().checkNames(err, func_symbols);
        getBlock().checkNames(err, func_symbols);
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
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
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
   * @declaredat ASTNode:60
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
   * @declaredat ASTNode:70
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
   * @declaredat ASTNode:90
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
   * @declaredat ASTNode:104
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
}
