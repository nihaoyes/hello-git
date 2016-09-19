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
/*    */ public class UpdateByExampleWithBLOBsMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 42 */     Method method = new Method();
/* 43 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 44 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 45 */     method.setName(
/* 46 */       this.introspectedTable.getUpdateByExampleWithBLOBsStatementId());
/*    */     FullyQualifiedJavaType parameterType;
/*    */ 
/* 49 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 50 */       parameterType = new FullyQualifiedJavaType(
/* 51 */         this.introspectedTable.getRecordWithBLOBsType());
/*    */     } else {
/* 53 */       parameterType = new FullyQualifiedJavaType(
/* 54 */         this.introspectedTable.getBaseRecordType());
/*    */     }
/* 56 */     method.addParameter(new Parameter(parameterType, 
/* 57 */       "record", "@Param(\"record\")"));
/* 58 */     importedTypes.add(parameterType);
/*    */     
/* 60 */     FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(
/* 61 */       this.introspectedTable.getExampleType());
/* 62 */     method.addParameter(new Parameter(exampleType, 
/* 63 */       "example", "@Param(\"example\")"));
/* 64 */     importedTypes.add(exampleType);
/*    */     
/* 66 */     importedTypes.add(new FullyQualifiedJavaType(
/* 67 */       "org.apache.ibatis.annotations.Param"));
/*    */     
/* 69 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 70 */       this.introspectedTable);
/*    */     
/* 72 */     addMapperAnnotations(interfaze, method);
/*    */     
/*    */ 
/* 75 */     if (this.context.getPlugins().clientUpdateByExampleWithBLOBsMethodGenerated(method, interfaze, 
/* 76 */       this.introspectedTable)) {
/* 77 */       interfaze.addImportedTypes(importedTypes);
/* 78 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\UpdateByExampleWithBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */