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
/*     */ public class ProviderUpdateByExampleSelectiveMethodGenerator
/*     */   extends AbstractJavaProviderMethodGenerator
/*     */ {
/*     */   public void addClassElements(TopLevelClass topLevelClass)
/*     */   {
/*  43 */     Set<String> staticImports = new TreeSet();
/*  44 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*     */     
/*  46 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.BEGIN");
/*  47 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.UPDATE");
/*  48 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SET");
/*  49 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SQL");
/*     */     
/*  51 */     importedTypes.add(new FullyQualifiedJavaType("java.util.Map"));
/*     */     
/*  53 */     Method method = new Method(this.introspectedTable.getUpdateByExampleSelectiveStatementId());
/*  54 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/*  55 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  56 */     method.addParameter(new Parameter(new FullyQualifiedJavaType("java.util.Map<java.lang.String, java.lang.Object>"), 
/*  57 */       "parameter"));
/*     */     
/*  59 */     FullyQualifiedJavaType record = 
/*  60 */       this.introspectedTable.getRules().calculateAllFieldsClass();
/*  61 */     importedTypes.add(record);
/*  62 */     method.addBodyLine(
/*  63 */       String.format("%s record = (%s) parameter.get(\"record\");", new Object[] {record.getShortName(), record.getShortName() }));
/*     */     
/*  65 */     FullyQualifiedJavaType example = 
/*  66 */       new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*  67 */     importedTypes.add(example);
/*  68 */     method.addBodyLine(
/*  69 */       String.format("%s example = (%s) parameter.get(\"example\");", new Object[] {example.getShortName(), example.getShortName() }));
/*     */     
/*  71 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/*  72 */       this.introspectedTable);
/*     */     
/*  74 */     method.addBodyLine("");
/*  75 */     method.addBodyLine("BEGIN();");
/*     */     
/*  77 */     method.addBodyLine(
/*  78 */       String.format("UPDATE(\"%s\");", new Object[] {StringUtility.escapeStringForJava(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()) }));
/*  79 */     method.addBodyLine("");
/*     */     
/*  81 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getAllColumns()) {
/*  82 */       if (!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/*  83 */         method.addBodyLine(
/*  84 */           String.format("if (record.%s() != null) {", new Object[] {JavaBeansUtil.getGetterMethodName(introspectedColumn.getJavaProperty(), 
/*  85 */           introspectedColumn.getFullyQualifiedJavaType()) }));
/*     */       }
/*     */       
/*  88 */       StringBuilder sb = new StringBuilder();
/*  89 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*  90 */       sb.insert(2, "record.");
/*     */       
/*  92 */       method.addBodyLine(
/*     */       
/*  94 */         String.format("SET(\"%s = %s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn)), sb.toString() }));
/*     */       
/*  96 */       if (!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/*  97 */         method.addBodyLine("}");
/*     */       }
/*     */       
/* 100 */       method.addBodyLine("");
/*     */     }
/*     */     
/* 103 */     method.addBodyLine("applyWhere(example, true);");
/* 104 */     method.addBodyLine("return SQL();");
/*     */     
/* 106 */     if (this.context.getPlugins().providerUpdateByExampleSelectiveMethodGenerated(method, topLevelClass, 
/* 107 */       this.introspectedTable)) {
/* 108 */       topLevelClass.addStaticImports(staticImports);
/* 109 */       topLevelClass.addImportedTypes(importedTypes);
/* 110 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderUpdateByExampleSelectiveMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */