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
/*    */ import org.mybatis.generator.internal.rules.Rules;
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
/*    */ public class InsertMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 40 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 41 */     Method method = new Method();
/*    */     
/* 43 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 44 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 45 */     method.setName(this.introspectedTable.getInsertStatementId());
/*    */     
/* 47 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules()
/* 48 */       .calculateAllFieldsClass();
/*    */     
/* 50 */     importedTypes.add(parameterType);
/* 51 */     method.addParameter(new Parameter(parameterType, "record"));
/*    */     
/* 53 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 54 */       this.introspectedTable);
/*    */     
/* 56 */     addMapperAnnotations(interfaze, method);
/*    */     
/* 58 */     if (this.context.getPlugins().clientInsertMethodGenerated(method, 
/* 59 */       interfaze, this.introspectedTable)) {
/* 60 */       interfaze.addImportedTypes(importedTypes);
/* 61 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\InsertMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */