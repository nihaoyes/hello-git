/*     */ package org.apache.ibatis.ibator.eclipse.core.merge;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.eclipse.jdt.core.dom.ASTNode;
/*     */ import org.eclipse.jdt.core.dom.ASTVisitor;
/*     */ import org.eclipse.jdt.core.dom.BodyDeclaration;
/*     */ import org.eclipse.jdt.core.dom.FieldDeclaration;
/*     */ import org.eclipse.jdt.core.dom.Javadoc;
/*     */ import org.eclipse.jdt.core.dom.MethodDeclaration;
/*     */ import org.eclipse.jdt.core.dom.TagElement;
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
/*     */ public class ExistingJavaFileVisitor
/*     */   extends ASTVisitor
/*     */ {
/*     */   private TypeDeclaration typeDeclaration;
/*     */   private String[] javadocTags;
/*     */   
/*     */   public ExistingJavaFileVisitor(String[] javadocTags)
/*     */   {
/*  43 */     this.javadocTags = javadocTags;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean visit(FieldDeclaration node)
/*     */   {
/*  51 */     if (isIbatorGenerated(node)) {
/*  52 */       node.delete();
/*     */     }
/*     */     
/*  55 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean visit(MethodDeclaration node)
/*     */   {
/*  63 */     if (isIbatorGenerated(node)) {
/*  64 */       node.delete();
/*     */     }
/*     */     
/*  67 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean visit(TypeDeclaration node)
/*     */   {
/*  76 */     if (node.getParent().getNodeType() == 15) {
/*  77 */       this.typeDeclaration = node;
/*  78 */       return true;
/*     */     }
/*     */     
/*  81 */     if (isIbatorGenerated(node)) {
/*  82 */       node.delete();
/*     */     }
/*     */     
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public TypeDeclaration getTypeDeclaration()
/*     */   {
/*  90 */     return this.typeDeclaration;
/*     */   }
/*     */   
/*     */   private boolean isIbatorGenerated(BodyDeclaration node)
/*     */   {
/*  95 */     boolean rc = false;
/*  96 */     Javadoc jd = node.getJavadoc();
/*  97 */     if (jd != null) {
/*  98 */       List<TagElement> tags = jd.tags();
/*  99 */       for (TagElement tag : tags) {
/* 100 */         String tagName = tag.getTagName();
/* 101 */         if (tagName != null)
/*     */         {
/*     */           String[] arrayOfString;
/* 104 */           int j = (arrayOfString = this.javadocTags).length; for (int i = 0; i < j; i++) { String javadocTag = arrayOfString[i];
/* 105 */             if (tagName.equals(javadocTag)) {
/* 106 */               rc = true;
/* 107 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 113 */     return rc;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\apache\ibatis\ibator\eclipse\core\merge\ExistingJavaFileVisitor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */