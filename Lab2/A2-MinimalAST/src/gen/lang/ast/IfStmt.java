/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
package lang.ast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/miquel/Documents/LTH/compilers/Lab2/A2-MinimalAST/src/jastadd/lang.ast:18
 * @astdecl IfStmt : Stmt ::= condition:Expr block:Block elif:ElseIfStmts [else:ElseStmt];
 * @production IfStmt : {@link Stmt} ::= <span class="component">condition:{@link Expr}</span> <span class="component">block:{@link Block}</span> <span class="component">elif:{@link ElseIfStmts}</span> <span class="component">[else:{@link ElseStmt}]</span>;

 */
public class IfStmt extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public IfStmt() {
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
    children = new ASTNode[4];
    setChild(new Opt(), 3);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"condition", "block", "elif", "else"},
    type = {"Expr", "Block", "ElseIfStmts", "Opt<ElseStmt>"},
    kind = {"Child", "Child", "Child", "Opt"}
  )
  public IfStmt(Expr p0, Block p1, ElseIfStmts p2, Opt<ElseStmt> p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 4;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();
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
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public IfStmt copy() {
    try {
      IfStmt node = (IfStmt) clone();
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
  public IfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public IfStmt treeCopyNoTransform() {
    IfStmt tree = (IfStmt) copy();
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
  public IfStmt treeCopy() {
    IfStmt tree = (IfStmt) copy();
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
   * Replaces the condition child.
   * @param node The new node to replace the condition child.
   * @apilevel high-level
   */
  public void setcondition(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the condition child.
   * @return The current node used as the condition child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="condition")
  public Expr getcondition() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the condition child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the condition child.
   * @apilevel low-level
   */
  public Expr getconditionNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the block child.
   * @param node The new node to replace the block child.
   * @apilevel high-level
   */
  public void setblock(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the block child.
   * @return The current node used as the block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="block")
  public Block getblock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the block child.
   * @apilevel low-level
   */
  public Block getblockNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * Replaces the elif child.
   * @param node The new node to replace the elif child.
   * @apilevel high-level
   */
  public void setelif(ElseIfStmts node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the elif child.
   * @return The current node used as the elif child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="elif")
  public ElseIfStmts getelif() {
    return (ElseIfStmts) getChild(2);
  }
  /**
   * Retrieves the elif child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the elif child.
   * @apilevel low-level
   */
  public ElseIfStmts getelifNoTransform() {
    return (ElseIfStmts) getChildNoTransform(2);
  }
  /**
   * Replaces the optional node for the else child. This is the <code>Opt</code>
   * node containing the child else, not the actual child!
   * @param opt The new node to be used as the optional node for the else child.
   * @apilevel low-level
   */
  public void setelseOpt(Opt<ElseStmt> opt) {
    setChild(opt, 3);
  }
  /**
   * Replaces the (optional) else child.
   * @param node The new node to be used as the else child.
   * @apilevel high-level
   */
  public void setelse(ElseStmt node) {
    getelseOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional else child exists.
   * @return {@code true} if the optional else child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean haselse() {
    return getelseOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) else child.
   * @return The else child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ElseStmt getelse() {
    return (ElseStmt) getelseOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the else child. This is the <code>Opt</code> node containing the child else, not the actual child!
   * @return The optional node for child the else child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="else")
  public Opt<ElseStmt> getelseOpt() {
    return (Opt<ElseStmt>) getChild(3);
  }
  /**
   * Retrieves the optional node for child else. This is the <code>Opt</code> node containing the child else, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child else.
   * @apilevel low-level
   */
  public Opt<ElseStmt> getelseOptNoTransform() {
    return (Opt<ElseStmt>) getChildNoTransform(3);
  }
}
