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
/*     */ public class ProviderInsertSelectiveMethodGenerator
/*     */   extends AbstractJavaProviderMethodGenerator
/*     */ {
/*     */   public void addClassElements(TopLevelClass topLevelClass)
/*     */   {
/*  47 */     Set<String> staticImports = new TreeSet();
/*  48 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*     */     
/*  50 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.BEGIN");
/*  51 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO");
/*  52 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SQL");
/*  53 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.VALUES");
/*     */     
/*  55 */     FullyQualifiedJavaType fqjt = this.introspectedTable.getRules()
/*  56 */       .calculateAllFieldsClass();
/*  57 */     importedTypes.add(fqjt);
/*     */     
/*  59 */     Method method = new Method(
/*  60 */       this.introspectedTable.getInsertSelectiveStatementId());
/*  61 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  62 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/*  63 */     method.addParameter(new Parameter(fqjt, "record"));
/*     */     
/*  65 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/*  66 */       this.introspectedTable);
/*     */     
/*  68 */     method.addBodyLine("BEGIN();");
/*  69 */     method.addBodyLine(
/*  70 */       String.format("INSERT_INTO(\"%s\");", new Object[] {StringUtility.escapeStringForJava(this.introspectedTable.getFullyQualifiedTableNameAtRuntime()) }));
/*     */     
/*  72 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getAllColumns()) {
/*  73 */       if (!introspectedColumn.isIdentity())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  78 */         method.addBodyLine("");
/*  79 */         if ((!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) && 
/*  80 */           (!introspectedColumn.isSequenceColumn())) {
/*  81 */           method.addBodyLine(
/*  82 */             String.format("if (record.%s() != null) {", new Object[] {JavaBeansUtil.getGetterMethodName(introspectedColumn.getJavaProperty(), 
/*  83 */             introspectedColumn.getFullyQualifiedJavaType()) }));
/*     */         }
/*  85 */         method.addBodyLine(
/*     */         
/*  87 */           String.format("VALUES(\"%s\", \"%s\");", new Object[] {StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)), MyBatis3FormattingUtilities.getParameterClause(introspectedColumn) }));
/*  88 */         if ((!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) && 
/*  89 */           (!introspectedColumn.isSequenceColumn())) {
/*  90 */           method.addBodyLine("}");
/*     */         }
/*     */       }
/*     */     }
/*  94 */     method.addBodyLine("");
/*  95 */     method.addBodyLine("return SQL();");
/*     */     
/*  97 */     if (this.context.getPlugins().providerInsertSelectiveMethodGenerated(method, topLevelClass, 
/*  98 */       this.introspectedTable)) {
/*  99 */       topLevelClass.addStaticImports(staticImports);
/* 100 */       topLevelClass.addImportedTypes(importedTypes);
/* 101 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderInsertSelectiveMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */