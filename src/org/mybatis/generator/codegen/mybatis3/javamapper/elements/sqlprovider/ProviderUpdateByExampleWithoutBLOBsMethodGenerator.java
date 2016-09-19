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
/*     */ 
/*     */ public class ProviderUpdateByExampleWithoutBLOBsMethodGenerator
/*     */   extends AbstractJavaProviderMethodGenerator
/*     */ {
/*     */   public void addClassElements(TopLevelClass topLevelClass)
/*     */   {
/*  47 */     Set<String> staticImports = new TreeSet();
/*  48 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*     */     
/*  50 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.BEGIN");
/*  51 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.UPDATE");
/*  52 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SET");
/*  53 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SQL");
/*     */     
/*  55 */     importedTypes.add(new FullyQualifiedJavaType("java.util.Map"));
/*     */     
/*  57 */     Method method = new Method(getMethodName());
/*  58 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/*  59 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  60 */     method.addParameter(new Parameter(new FullyQualifiedJavaType("java.util.Map<java.lang.String, java.lang.Object>"), 
/*  61 */       "parameter"));
/*     */     
/*  63 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/*  64 */       this.introspectedTable);
/*     */     
/*  66 */     method.addBodyLine("BEGIN();");
/*     */     
/*  68 */     method.addBodyLine(
/*  69 */       String.format("UPDATE(\"%s\");", new Object[] {StringUtility.escapeStringForJava(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()) }));
/*  70 */     method.addBodyLine("");
/*     */     
/*  72 */     for (IntrospectedColumn introspectedColumn : getColumns()) {
/*  73 */       StringBuilder sb = new StringBuilder();
/*  74 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*  75 */       sb.insert(2, "record.");
/*     */       
/*  77 */       method.addBodyLine(
/*     */       
/*  79 */         String.format("SET(\"%s = %s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn)), sb.toString() }));
/*     */     }
/*     */     
/*  82 */     method.addBodyLine("");
/*     */     
/*  84 */     FullyQualifiedJavaType example = 
/*  85 */       new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*  86 */     importedTypes.add(example);
/*  87 */     method.addBodyLine(
/*  88 */       String.format("%s example = (%s) parameter.get(\"example\");", new Object[] {example.getShortName(), example.getShortName() }));
/*     */     
/*  90 */     method.addBodyLine("applyWhere(example, true);");
/*  91 */     method.addBodyLine("return SQL();");
/*     */     
/*  93 */     if (callPlugins(method, topLevelClass)) {
/*  94 */       topLevelClass.addStaticImports(staticImports);
/*  95 */       topLevelClass.addImportedTypes(importedTypes);
/*  96 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMethodName() {
/* 101 */     return this.introspectedTable.getUpdateByExampleStatementId();
/*     */   }
/*     */   
/*     */   public List<IntrospectedColumn> getColumns() {
/* 105 */     return this.introspectedTable.getNonBLOBColumns();
/*     */   }
/*     */   
/*     */   public boolean callPlugins(Method method, TopLevelClass topLevelClass) {
/* 109 */     return this.context.getPlugins().providerUpdateByExampleWithoutBLOBsMethodGenerated(method, topLevelClass, 
/* 110 */       this.introspectedTable);
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderUpdateByExampleWithoutBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */