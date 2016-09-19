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
/*    */ public class DeleteByExampleMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 42 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(
/* 43 */       this.introspectedTable.getExampleType());
/* 44 */     importedTypes.add(type);
/*    */     
/* 46 */     Method method = new Method();
/* 47 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 48 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 49 */     method.setName(this.introspectedTable.getDeleteByExampleStatementId());
/* 50 */     method.addParameter(new Parameter(type, "example"));
/*    */     
/* 52 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 53 */       this.introspectedTable);
/*    */     
/* 55 */     addMapperAnnotations(interfaze, method);
/*    */     
/* 57 */     if (this.context.getPlugins().clientDeleteByExampleMethodGenerated(
/* 58 */       method, interfaze, this.introspectedTable)) {
/* 59 */       interfaze.addImportedTypes(importedTypes);
/* 60 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\DeleteByExampleMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */