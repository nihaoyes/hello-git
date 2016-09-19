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
/*    */ public class UpdateByPrimaryKeyWithBLOBsMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*    */     FullyQualifiedJavaType parameterType;
/*    */
/* 44 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 45 */       parameterType = new FullyQualifiedJavaType(
/* 46 */         this.introspectedTable.getRecordWithBLOBsType());
/*    */     } else {
/* 48 */       parameterType = new FullyQualifiedJavaType(
/* 49 */         this.introspectedTable.getBaseRecordType());
/*    */     }
/*    */     
/* 52 */     importedTypes.add(parameterType);
/*    */     
/* 54 */     Method method = new Method();
/* 55 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 56 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 57 */     method.setName(
/* 58 */       this.introspectedTable.getUpdateByPrimaryKeyWithBLOBsStatementId());
/* 59 */     method.addParameter(new Parameter(parameterType, "record"));
/*    */     
/* 61 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 62 */       this.introspectedTable);
/*    */     
/* 64 */     addMapperAnnotations(interfaze, method);
/*    */     
/*    */ 
/* 67 */     if (this.context.getPlugins().clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, 
/* 68 */       interfaze, this.introspectedTable)) {
/* 69 */       interfaze.addImportedTypes(importedTypes);
/* 70 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\UpdateByPrimaryKeyWithBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */