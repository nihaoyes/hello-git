/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
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
/*     */ public class ProviderSelectByExampleWithoutBLOBsMethodGenerator
/*     */   extends AbstractJavaProviderMethodGenerator
/*     */ {
/*     */   public void addClassElements(TopLevelClass topLevelClass)
/*     */   {
/*  46 */     Set<String> staticImports = new TreeSet();
/*  47 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*     */     
/*  49 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.BEGIN");
/*  50 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SELECT");
/*  51 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT");
/*  52 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.FROM");
/*  53 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY");
/*  54 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SQL");
/*     */     
/*  56 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*  57 */     importedTypes.add(fqjt);
/*     */     
/*  59 */     Method method = new Method(getMethodName());
/*  60 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  61 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/*  62 */     method.addParameter(new Parameter(fqjt, "example"));
/*     */     
/*  64 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/*  65 */       this.introspectedTable);
/*     */     
/*  67 */     method.addBodyLine("BEGIN();");
/*     */     
/*  69 */     boolean distinctCheck = true;
/*  70 */     for (IntrospectedColumn introspectedColumn : getColumns()) {
/*  71 */       if (distinctCheck) {
/*  72 */         method.addBodyLine("if (example != null && example.isDistinct()) {");
/*  73 */         method.addBodyLine(
/*  74 */           String.format("SELECT_DISTINCT(\"%s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getSelectListPhrase(introspectedColumn)) }));
/*  75 */         method.addBodyLine("} else {");
/*  76 */         method.addBodyLine(
/*  77 */           String.format("SELECT(\"%s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getSelectListPhrase(introspectedColumn)) }));
/*  78 */         method.addBodyLine("}");
/*     */       } else {
/*  80 */         method.addBodyLine(
/*  81 */           String.format("SELECT(\"%s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getSelectListPhrase(introspectedColumn)) }));
/*     */       }
/*     */       
/*  84 */       distinctCheck = false;
/*     */     }
/*     */     
/*  87 */     method.addBodyLine(
/*  88 */       String.format("FROM(\"%s\");", new Object[] {StringUtility.escapeStringForJava(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()) }));
/*  89 */     method.addBodyLine("applyWhere(example, false);");
/*     */     
/*  91 */     method.addBodyLine("");
/*  92 */     method.addBodyLine("if (example != null && example.getOrderByClause() != null) {");
/*  93 */     method.addBodyLine("ORDER_BY(example.getOrderByClause());");
/*  94 */     method.addBodyLine("}");
/*     */     
/*  96 */     method.addBodyLine("");
/*  97 */     method.addBodyLine("return SQL();");
/*     */     
/*  99 */     if (callPlugins(method, topLevelClass)) {
/* 100 */       topLevelClass.addStaticImports(staticImports);
/* 101 */       topLevelClass.addImportedTypes(importedTypes);
/* 102 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */   
/*     */   public List<IntrospectedColumn> getColumns() {
/* 107 */     return this.introspectedTable.getNonBLOBColumns();
/*     */   }
/*     */   
/*     */   public String getMethodName() {
/* 111 */     return this.introspectedTable.getSelectByExampleStatementId();
/*     */   }
/*     */   
/*     */   public boolean callPlugins(Method method, TopLevelClass topLevelClass) {
/* 115 */     return this.context.getPlugins().providerSelectByExampleWithoutBLOBsMethodGenerated(method, topLevelClass, 
/* 116 */       this.introspectedTable);
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderSelectByExampleWithoutBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */