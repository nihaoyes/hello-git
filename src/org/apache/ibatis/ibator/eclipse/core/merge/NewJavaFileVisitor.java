/*     */ package org.apache.ibatis.ibator.eclipse.core.merge;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.jdt.core.dom.ASTNode;
/*     */ import org.eclipse.jdt.core.dom.ASTVisitor;
/*     */ import org.eclipse.jdt.core.dom.CompilationUnit;
/*     */ import org.eclipse.jdt.core.dom.FieldDeclaration;
/*     */ import org.eclipse.jdt.core.dom.ImportDeclaration;
/*     */ import org.eclipse.jdt.core.dom.MethodDeclaration;
/*     */ import org.eclipse.jdt.core.dom.Type;
/*     */ import org.eclipse.jdt.core.dom.TypeDeclaration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NewJavaFileVisitor
/*     */   extends ASTVisitor
/*     */ {
/*     */   private List<ASTNode> newNodes;
/*     */   private List<ImportDeclaration> imports;
/*     */   private Type superclass;
/*     */   private boolean isInterface;
/*     */   private List<Type> superInterfaceTypes;
/*     */   
/*     */   public NewJavaFileVisitor()
/*     */   {
/*  47 */     this.newNodes = new ArrayList();
/*     */   }
/*     */   
/*     */   public boolean visit(FieldDeclaration node) {
/*  51 */     this.newNodes.add(node);
/*     */     
/*  53 */     return false;
/*     */   }
/*     */   
/*     */   public boolean visit(MethodDeclaration node) {
/*  57 */     this.newNodes.add(node);
/*     */     
/*  59 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean visit(TypeDeclaration node)
/*     */   {
/*  65 */     if (node.getParent().getNodeType() == 15) {
/*  66 */       this.isInterface = node.isInterface();
/*     */       
/*  68 */       this.superclass = node.getSuperclassType();
/*     */       
/*  70 */       this.superInterfaceTypes = node.superInterfaceTypes();
/*     */       
/*  72 */       return true;
/*     */     }
/*  74 */     this.newNodes.add(node);
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public List<ASTNode> getNewNodes()
/*     */   {
/*  80 */     return this.newNodes;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean visit(CompilationUnit node)
/*     */   {
/*  86 */     this.imports = node.imports();
/*     */     
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   public List<ImportDeclaration> getImports() {
/*  92 */     return this.imports;
/*     */   }
/*     */   
/*     */   public Type getSuperclass() {
/*  96 */     return this.superclass;
/*     */   }
/*     */   
/*     */   public boolean isInterface() {
/* 100 */     return this.isInterface;
/*     */   }
/*     */   
/*     */   public List<Type> getSuperInterfaceTypes() {
/* 104 */     return this.superInterfaceTypes;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\apache\ibatis\ibator\eclipse\core\merge\NewJavaFileVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */