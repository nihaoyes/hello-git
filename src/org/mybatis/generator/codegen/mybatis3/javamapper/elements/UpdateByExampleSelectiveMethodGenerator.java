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
/*    */ public class UpdateByExampleSelectiveMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 37 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 38 */     Method method = new Method();
/* 39 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 40 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 41 */     method.setName(
/* 42 */       this.introspectedTable.getUpdateByExampleSelectiveStatementId());
/*    */     
/* 44 */     FullyQualifiedJavaType parameterType = 
/* 45 */       this.introspectedTable.getRules().calculateAllFieldsClass();
/* 46 */     method.addParameter(new Parameter(parameterType, 
/* 47 */       "record", "@Param(\"record\")"));
/* 48 */     importedTypes.add(parameterType);
/*    */     
/* 50 */     FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(
/* 51 */       this.introspectedTable.getExampleType());
/* 52 */     method.addParameter(new Parameter(exampleType, 
/* 53 */       "example", "@Param(\"example\")"));
/* 54 */     importedTypes.add(exampleType);
/*    */     
/* 56 */     importedTypes.add(new FullyQualifiedJavaType(
/* 57 */       "org.apache.ibatis.annotations.Param"));
/*    */     
/* 59 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 60 */       this.introspectedTable);
/*    */     
/* 62 */     addMapperAnnotations(interfaze, method);
/*    */     
/*    */ 
/* 65 */     if (this.context.getPlugins().clientUpdateByExampleSelectiveMethodGenerated(method, interfaze, 
/* 66 */       this.introspectedTable)) {
/* 67 */       interfaze.addImportedTypes(importedTypes);
/* 68 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\UpdateByExampleSelectiveMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */