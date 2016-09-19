/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProviderDeleteByExampleMethodGenerator
/*    */   extends AbstractJavaProviderMethodGenerator
/*    */ {
/*    */   public void addClassElements(TopLevelClass topLevelClass)
/*    */   {
/* 43 */     Set<String> staticImports = new TreeSet();
/* 44 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*    */     
/* 46 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.BEGIN");
/* 47 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM");
/* 48 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SQL");
/*    */     
/* 50 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/* 51 */     importedTypes.add(fqjt);
/*    */     
/* 53 */     Method method = new Method(
/* 54 */       this.introspectedTable.getDeleteByExampleStatementId());
/* 55 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 56 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/* 57 */     method.addParameter(new Parameter(fqjt, "example"));
/*    */     
/* 59 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 60 */       this.introspectedTable);
/*    */     
/* 62 */     method.addBodyLine("BEGIN();");
/* 63 */     method.addBodyLine(
/* 64 */       String.format("DELETE_FROM(\"%s\");", new Object[] {StringUtility.escapeStringForJava(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()) }));
/* 65 */     method.addBodyLine("applyWhere(example, false);");
/* 66 */     method.addBodyLine("return SQL();");
/*    */     
/*    */ 
/* 69 */     if (this.context.getPlugins().providerDeleteByExampleMethodGenerated(method, topLevelClass, 
/* 70 */       this.introspectedTable)) {
/* 71 */       topLevelClass.addStaticImports(staticImports);
/* 72 */       topLevelClass.addImportedTypes(importedTypes);
/* 73 */       topLevelClass.addMethod(method);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderDeleteByExampleMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */