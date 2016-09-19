/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
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
/*     */ public class InitializationBlock
/*     */ {
/*     */   private boolean isStatic;
/*     */   private List<String> bodyLines;
/*     */   private List<String> javaDocLines;
/*     */   
/*     */   public InitializationBlock()
/*     */   {
/*  32 */     this(false);
/*     */   }
/*     */   
/*     */   public InitializationBlock(boolean isStatic) {
/*  36 */     this.isStatic = isStatic;
/*  37 */     this.bodyLines = new ArrayList();
/*  38 */     this.javaDocLines = new ArrayList();
/*     */   }
/*     */   
/*     */   public boolean isStatic() {
/*  42 */     return this.isStatic;
/*     */   }
/*     */   
/*     */   public void setStatic(boolean isStatic) {
/*  46 */     this.isStatic = isStatic;
/*     */   }
/*     */   
/*     */   public List<String> getBodyLines() {
/*  50 */     return this.bodyLines;
/*     */   }
/*     */   
/*     */   public void addBodyLine(String line) {
/*  54 */     this.bodyLines.add(line);
/*     */   }
/*     */   
/*     */   public void addBodyLine(int index, String line) {
/*  58 */     this.bodyLines.add(index, line);
/*     */   }
/*     */   
/*     */   public void addBodyLines(Collection<String> lines) {
/*  62 */     this.bodyLines.addAll(lines);
/*     */   }
/*     */   
/*     */   public void addBodyLines(int index, Collection<String> lines) {
/*  66 */     this.bodyLines.addAll(index, lines);
/*     */   }
/*     */   
/*     */   public List<String> getJavaDocLines() {
/*  70 */     return this.javaDocLines;
/*     */   }
/*     */   
/*     */   public void addJavaDocLine(String javaDocLine) {
/*  74 */     this.javaDocLines.add(javaDocLine);
/*     */   }
/*     */   
/*     */   public String getFormattedContent(int indentLevel) {
/*  78 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  80 */     for (String javaDocLine : this.javaDocLines) {
/*  81 */       OutputUtilities.javaIndent(sb, indentLevel);
/*  82 */       sb.append(javaDocLine);
/*  83 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/*  86 */     OutputUtilities.javaIndent(sb, indentLevel);
/*     */     
/*  88 */     if (this.isStatic) {
/*  89 */       sb.append("static ");
/*     */     }
/*     */     
/*  92 */     sb.append('{');
/*  93 */     indentLevel++;
/*     */     
/*  95 */     ListIterator<String> listIter = this.bodyLines.listIterator();
/*  96 */     while (listIter.hasNext()) {
/*  97 */       String line = (String)listIter.next();
/*  98 */       if (line.startsWith("}")) {
/*  99 */         indentLevel--;
/*     */       }
/*     */       
/* 102 */       OutputUtilities.newLine(sb);
/* 103 */       OutputUtilities.javaIndent(sb, indentLevel);
/* 104 */       sb.append(line);
/*     */       
/* 106 */       if (((line.endsWith("{")) && (!line.startsWith("switch"))) || 
/* 107 */         (line.endsWith(":"))) {
/* 108 */         indentLevel++;
/*     */       }
/*     */       
/* 111 */       if (line.startsWith("break"))
/*     */       {
/* 113 */         if (listIter.hasNext()) {
/* 114 */           String nextLine = (String)listIter.next();
/* 115 */           if (nextLine.startsWith("}")) {
/* 116 */             indentLevel++;
/*     */           }
/*     */           
/*     */ 
/* 120 */           listIter.previous();
/*     */         }
/* 122 */         indentLevel--;
/*     */       }
/*     */     }
/*     */     
/* 126 */     indentLevel--;
/* 127 */     OutputUtilities.newLine(sb);
/* 128 */     OutputUtilities.javaIndent(sb, indentLevel);
/* 129 */     sb.append('}');
/*     */     
/* 131 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\api\dom\java\InitializationBlock.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */