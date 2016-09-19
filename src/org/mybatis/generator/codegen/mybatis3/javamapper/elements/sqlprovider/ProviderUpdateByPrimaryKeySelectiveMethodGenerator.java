/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider;
/*     */ 
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
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
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
/*     */ public class ProviderUpdateByPrimaryKeySelectiveMethodGenerator
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
/*  54 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.WHERE");
/*     */     
/*  56 */     FullyQualifiedJavaType fqjt = this.introspectedTable.getRules().calculateAllFieldsClass();
/*  57 */     importedTypes.add(fqjt);
/*     */     
/*  59 */     Method method = new Method(this.introspectedTable.getUpdateByPrimaryKeySelectiveStatementId());
/*  60 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/*  61 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  62 */     method.addParameter(new Parameter(fqjt, "record"));
/*     */     
/*  64 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/*  65 */       this.introspectedTable);
/*     */     
/*  67 */     method.addBodyLine("BEGIN();");
/*     */     
/*  69 */     method.addBodyLine(
/*  70 */       String.format("UPDATE(\"%s\");", new Object[] {StringUtility.escapeStringForJava(this.introspectedTable.getFullyQualifiedTableNameAtRuntime()) }));
/*  71 */     method.addBodyLine("");
/*     */     
/*  73 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonPrimaryKeyColumns()) {
/*  74 */       if (!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/*  75 */         method.addBodyLine(
/*  76 */           String.format("if (record.%s() != null) {", new Object[] {JavaBeansUtil.getGetterMethodName(introspectedColumn.getJavaProperty(), 
/*  77 */           introspectedColumn.getFullyQualifiedJavaType()) }));
/*     */       }
/*     */       
/*  80 */       method.addBodyLine(
/*     */       
/*  82 */         String.format("SET(\"%s = %s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)), MyBatis3FormattingUtilities.getParameterClause(introspectedColumn) }));
/*     */       
/*  84 */       if (!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/*  85 */         method.addBodyLine("}");
/*     */       }
/*     */       
/*  88 */       method.addBodyLine("");
/*     */     }
/*     */     
/*  91 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns()) {
/*  92 */       method.addBodyLine(
/*     */       
/*  94 */         String.format("WHERE(\"%s = %s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)), MyBatis3FormattingUtilities.getParameterClause(introspectedColumn) }));
/*     */     }
/*     */     
/*  97 */     method.addBodyLine("");
/*  98 */     method.addBodyLine("return SQL();");
/*     */     
/* 100 */     if (this.context.getPlugins().providerUpdateByPrimaryKeySelectiveMethodGenerated(method, topLevelClass, 
/* 101 */       this.introspectedTable)) {
/* 102 */       topLevelClass.addStaticImports(staticImports);
/* 103 */       topLevelClass.addImportedTypes(importedTypes);
/* 104 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderUpdateByPrimaryKeySelectiveMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */