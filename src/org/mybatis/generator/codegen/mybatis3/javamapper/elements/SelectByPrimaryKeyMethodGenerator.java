/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
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
/*    */ public class SelectByPrimaryKeyMethodGenerator
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 43 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 44 */     Method method = new Method();
/* 45 */     method.setVisibility(JavaVisibility.PUBLIC);
/*    */     
/* 47 */     FullyQualifiedJavaType returnType = this.introspectedTable.getRules()
/* 48 */       .calculateAllFieldsClass();
/* 49 */     method.setReturnType(returnType);
/* 50 */     importedTypes.add(returnType);
/*    */     
/* 52 */     method.setName(this.introspectedTable.getSelectByPrimaryKeyStatementId());
/*    */     
/* 54 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 55 */       FullyQualifiedJavaType type = new FullyQualifiedJavaType(
/* 56 */         this.introspectedTable.getPrimaryKeyType());
/* 57 */       importedTypes.add(type);
/* 58 */       method.addParameter(new Parameter(type, "key"));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 64 */       List<IntrospectedColumn> introspectedColumns = this.introspectedTable
/* 65 */         .getPrimaryKeyColumns();
/* 66 */       boolean annotate = introspectedColumns.size() > 1;
/* 67 */       if (annotate) {
/* 68 */         importedTypes.add(new FullyQualifiedJavaType(
/* 69 */           "org.apache.ibatis.annotations.Param"));
/*    */       }
/* 71 */       StringBuilder sb = new StringBuilder();
/* 72 */       for (IntrospectedColumn introspectedColumn : introspectedColumns) {
/* 73 */         FullyQualifiedJavaType type = introspectedColumn
/* 74 */           .getFullyQualifiedJavaType();
/* 75 */         importedTypes.add(type);
/* 76 */         Parameter parameter = new Parameter(type, 
/* 77 */           introspectedColumn.getJavaProperty());
/* 78 */         if (annotate) {
/* 79 */           sb.setLength(0);
/* 80 */           sb.append("@Param(\"");
/* 81 */           sb.append(introspectedColumn.getJavaProperty());
/* 82 */           sb.append("\")");
/* 83 */           parameter.addAnnotation(sb.toString());
/*    */         }
/* 85 */         method.addParameter(parameter);
/*    */       }
/*    */     }
/*    */     
/* 89 */     addMapperAnnotations(interfaze, method);
/*    */     
/* 91 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 92 */       this.introspectedTable);
/*    */     
/* 94 */     if (this.context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(
/* 95 */       method, interfaze, this.introspectedTable)) {
/* 96 */       interfaze.addImportedTypes(importedTypes);
/* 97 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\SelectByPrimaryKeyMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */