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
/*    */ public class UpdateByExampleWithoutBLOBsMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 42 */     Method method = new Method();
/* 43 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 44 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 45 */     method.setName(this.introspectedTable.getUpdateByExampleStatementId());
/*    */     FullyQualifiedJavaType parameterType;
/*    */  
/* 48 */     if (this.introspectedTable.getRules().generateBaseRecordClass()) {
/* 49 */       parameterType = new FullyQualifiedJavaType(
/* 50 */         this.introspectedTable.getBaseRecordType());
/*    */     } else {
/* 52 */       parameterType = new FullyQualifiedJavaType(
/* 53 */         this.introspectedTable.getPrimaryKeyType());
/*    */     }
/* 55 */     method.addParameter(new Parameter(parameterType, 
/* 56 */       "record", "@Param(\"record\")"));
/* 57 */     importedTypes.add(parameterType);
/*    */     
/* 59 */     FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(
/* 60 */       this.introspectedTable.getExampleType());
/* 61 */     method.addParameter(new Parameter(exampleType, 
/* 62 */       "example", "@Param(\"example\")"));
/* 63 */     importedTypes.add(exampleType);
/*    */     
/* 65 */     importedTypes.add(new FullyQualifiedJavaType(
/* 66 */       "org.apache.ibatis.annotations.Param"));
/*    */     
/* 68 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 69 */       this.introspectedTable);
/*    */     
/* 71 */     addMapperAnnotations(interfaze, method);
/*    */     
/*    */ 
/* 74 */     if (this.context.getPlugins().clientUpdateByExampleWithoutBLOBsMethodGenerated(method, 
/* 75 */       interfaze, this.introspectedTable)) {
/* 76 */       interfaze.addImportedTypes(importedTypes);
/* 77 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\UpdateByExampleWithoutBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */