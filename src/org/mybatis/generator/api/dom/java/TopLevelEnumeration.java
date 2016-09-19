/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
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
/*     */ 
/*     */ public class TopLevelEnumeration
/*     */   extends InnerEnum
/*     */   implements CompilationUnit
/*     */ {
/*     */   private Set<FullyQualifiedJavaType> importedTypes;
/*     */   private Set<String> staticImports;
/*     */   private List<String> fileCommentLines;
/*     */   
/*     */   public TopLevelEnumeration(FullyQualifiedJavaType type)
/*     */   {
/*  44 */     super(type);
/*  45 */     this.importedTypes = new TreeSet();
/*  46 */     this.fileCommentLines = new ArrayList();
/*  47 */     this.staticImports = new TreeSet();
/*     */   }
/*     */   
/*     */   public String getFormattedContent() {
/*  51 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  53 */     for (String fileCommentLine : this.fileCommentLines) {
/*  54 */       sb.append(fileCommentLine);
/*  55 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/*  58 */     if ((getType().getPackageName() != null) && 
/*  59 */       (getType().getPackageName().length() > 0)) {
/*  60 */       sb.append("package ");
/*  61 */       sb.append(getType().getPackageName());
/*  62 */       sb.append(';');
/*  63 */       OutputUtilities.newLine(sb);
/*  64 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/*  67 */     for (String staticImport : this.staticImports) {
/*  68 */       sb.append("import static ");
/*  69 */       sb.append(staticImport);
/*  70 */       sb.append(';');
/*  71 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/*  74 */     if (this.staticImports.size() > 0) {
/*  75 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/*  78 */     Set<String> importStrings = OutputUtilities.calculateImports(this.importedTypes);
/*  79 */     for (String importString : importStrings) {
/*  80 */       sb.append(importString);
/*  81 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/*  84 */     if (importStrings.size() > 0) {
/*  85 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/*  88 */     sb.append(super.getFormattedContent(0));
/*     */     
/*  90 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public Set<FullyQualifiedJavaType> getImportedTypes() {
/*  94 */     return Collections.unmodifiableSet(this.importedTypes);
/*     */   }
/*     */   
/*     */   public FullyQualifiedJavaType getSuperClass() {
/*  98 */     throw new UnsupportedOperationException(Messages.getString("RuntimeError.11"));
/*     */   }
/*     */   
/*     */   public boolean isJavaInterface() {
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isJavaEnumeration() {
/* 106 */     return true;
/*     */   }
/*     */   
/*     */   public void addImportedType(FullyQualifiedJavaType importedType) {
/* 110 */     if ((importedType.isExplicitlyImported()) && 
/* 111 */       (!importedType.getPackageName().equals(
/* 112 */       getType().getPackageName()))) {
/* 113 */       this.importedTypes.add(importedType);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addFileCommentLine(String commentLine) {
/* 118 */     this.fileCommentLines.add(commentLine);
/*     */   }
/*     */   
/*     */   public List<String> getFileCommentLines() {
/* 122 */     return this.fileCommentLines;
/*     */   }
/*     */   
/*     */   public void addImportedTypes(Set<FullyQualifiedJavaType> importedTypes) {
/* 126 */     this.importedTypes.addAll(importedTypes);
/*     */   }
/*     */   
/*     */   public Set<String> getStaticImports() {
/* 130 */     return this.staticImports;
/*     */   }
/*     */   
/*     */   public void addStaticImport(String staticImport) {
/* 134 */     this.staticImports.add(staticImport);
/*     */   }
/*     */   
/*     */   public void addStaticImports(Set<String> staticImports) {
/* 138 */     this.staticImports.addAll(staticImports);
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\api\dom\java\TopLevelEnumeration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */