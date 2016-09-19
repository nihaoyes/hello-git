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
/*    */ 
/*    */ public class InsertSelectiveMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 42 */     Method method = new Method();
/*    */     
/* 44 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 45 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 46 */     method.setName(this.introspectedTable.getInsertSelectiveStatementId());
/*    */     
/* 48 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules()
/* 49 */       .calculateAllFieldsClass();
/*    */     
/* 51 */     importedTypes.add(parameterType);
/* 52 */     method.addParameter(new Parameter(parameterType, "record"));
/*    */     
/* 54 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 55 */       this.introspectedTable);
/*    */     
/* 57 */     addMapperAnnotations(interfaze, method);
/*    */     
/* 59 */     if (this.context.getPlugins().clientInsertSelectiveMethodGenerated(
/* 60 */       method, interfaze, this.introspectedTable)) {
/* 61 */       interfaze.addImportedTypes(importedTypes);
/* 62 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\InsertSelectiveMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */