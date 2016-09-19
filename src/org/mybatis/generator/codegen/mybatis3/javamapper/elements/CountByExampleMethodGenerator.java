/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ import org.mybatis.generator.config.Context;
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
/*    */ public class CountByExampleMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
/* 42 */       this.introspectedTable.getExampleType());
/*    */     
/* 44 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 45 */     importedTypes.add(fqjt);
/*    */     
/* 47 */     Method method = new Method();
/* 48 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 49 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 50 */     method.setName(this.introspectedTable.getCountByExampleStatementId());
/* 51 */     method.addParameter(new Parameter(fqjt, "example"));
/* 52 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 53 */       this.introspectedTable);
/*    */     
/* 55 */     addMapperAnnotations(interfaze, method);
/*    */     
/* 57 */     if (this.context.getPlugins().clientCountByExampleMethodGenerated(method, 
/* 58 */       interfaze, this.introspectedTable)) {
/* 59 */       interfaze.addImportedTypes(importedTypes);
/* 60 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\CountByExampleMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */