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
/*    */ public class ProviderCountByExampleMethodGenerator
/*    */   extends AbstractJavaProviderMethodGenerator
/*    */ {
/*    */   public void addClassElements(TopLevelClass topLevelClass)
/*    */   {
/* 43 */     Set<String> staticImports = new TreeSet();
/* 44 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*    */     
/* 46 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.BEGIN");
/* 47 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.FROM");
/* 48 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SELECT");
/* 49 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.SQL");
/*    */     
/* 51 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/* 52 */     importedTypes.add(fqjt);
/*    */     
/* 54 */     Method method = new Method(
/* 55 */       this.introspectedTable.getCountByExampleStatementId());
/* 56 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 57 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/* 58 */     method.addParameter(new Parameter(fqjt, "example"));
/*    */     
/* 60 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 61 */       this.introspectedTable);
/*    */     
/* 63 */     method.addBodyLine("BEGIN();");
/* 64 */     method.addBodyLine("SELECT(\"count (*)\");");
/* 65 */     method.addBodyLine(
/* 66 */       String.format("FROM(\"%s\");", new Object[] {StringUtility.escapeStringForJava(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()) }));
/* 67 */     method.addBodyLine("applyWhere(example, false);");
/* 68 */     method.addBodyLine("return SQL();");
/*    */     
/* 70 */     if (this.context.getPlugins().providerCountByExampleMethodGenerated(method, topLevelClass, 
/* 71 */       this.introspectedTable)) {
/* 72 */       topLevelClass.addStaticImports(staticImports);
/* 73 */       topLevelClass.addImportedTypes(importedTypes);
/* 74 */       topLevelClass.addMethod(method);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderCountByExampleMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */