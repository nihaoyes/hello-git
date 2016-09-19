/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
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
/*     */ public abstract class JavaElement
/*     */ {
/*     */   private List<String> javaDocLines;
/*  29 */   private JavaVisibility visibility = JavaVisibility.DEFAULT;
/*     */   
/*     */ 
/*     */   private boolean isStatic;
/*     */   
/*     */ 
/*     */   private boolean isFinal;
/*     */   
/*     */   private List<String> annotations;
/*     */   
/*     */ 
/*     */   public JavaElement()
/*     */   {
/*  42 */     this.javaDocLines = new ArrayList();
/*  43 */     this.annotations = new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getJavaDocLines()
/*     */   {
/*  50 */     return this.javaDocLines;
/*     */   }
/*     */   
/*     */   public void addJavaDocLine(String javaDocLine) {
/*  54 */     this.javaDocLines.add(javaDocLine);
/*     */   }
/*     */   
/*     */   public List<String> getAnnotations() {
/*  58 */     return this.annotations;
/*     */   }
/*     */   
/*     */   public void addAnnotation(String annotation) {
/*  62 */     this.annotations.add(annotation);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public JavaVisibility getVisibility()
/*     */   {
/*  69 */     return this.visibility;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setVisibility(JavaVisibility visibility)
/*     */   {
/*  77 */     this.visibility = visibility;
/*     */   }
/*     */   
/*     */   public void addSuppressTypeWarningsAnnotation() {
/*  81 */     addAnnotation("@SuppressWarnings(\"unchecked\")");
/*     */   }
/*     */   
/*     */   public void addFormattedJavadoc(StringBuilder sb, int indentLevel) {
/*  85 */     for (String javaDocLine : this.javaDocLines) {
/*  86 */       OutputUtilities.javaIndent(sb, indentLevel);
/*  87 */       sb.append(javaDocLine);
/*  88 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addFormattedAnnotations(StringBuilder sb, int indentLevel) {
/*  93 */     for (String annotation : this.annotations) {
/*  94 */       OutputUtilities.javaIndent(sb, indentLevel);
/*  95 */       sb.append(annotation);
/*  96 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isFinal() {
/* 101 */     return this.isFinal;
/*     */   }
/*     */   
/*     */   public void setFinal(boolean isFinal) {
/* 105 */     this.isFinal = isFinal;
/*     */   }
/*     */   
/*     */   public boolean isStatic() {
/* 109 */     return this.isStatic;
/*     */   }
/*     */   
/*     */   public void setStatic(boolean isStatic) {
/* 113 */     this.isStatic = isStatic;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\api\dom\java\JavaElement.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */