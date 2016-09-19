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
/*    */ public class SelectByExampleWithBLOBsMethodGenerator2
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 42 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(
/* 43 */       this.introspectedTable.getExampleType());
/*    */     
/* 45 */     String type2 = "org.apache.ibatis.session.RowBounds";
/* 46 */     FullyQualifiedJavaType type22 = new FullyQualifiedJavaType(
/* 47 */       type2);
/*    */     
/* 49 */     importedTypes.add(type);
/* 50 */     importedTypes.add(type22);
/* 51 */     importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
/*    */     
/* 53 */     Method method = new Method();
/* 54 */     method.setVisibility(JavaVisibility.PUBLIC);
/*    */     
/* 56 */     FullyQualifiedJavaType returnType = 
/* 57 */       FullyQualifiedJavaType.getNewListInstance();
/*    */     FullyQualifiedJavaType listType;
/* 59 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 60 */       listType = new FullyQualifiedJavaType(
/* 61 */         this.introspectedTable.getRecordWithBLOBsType());
/*    */     }
/*    */     else {
/* 64 */       listType = new FullyQualifiedJavaType(
/* 65 */         this.introspectedTable.getBaseRecordType());
/*    */     }
/*    */     
/* 68 */     importedTypes.add(listType);
/* 69 */     returnType.addTypeArgument(listType);
/* 70 */     method.setReturnType(returnType);
/* 71 */     method.setName(
/* 72 */       this.introspectedTable.getSelectByExampleWithBLOBsStatementId() + "AndPage");
/* 73 */     method.addParameter(new Parameter(type, "example"));
/*    */     
/*    */ 
/*    */ 
/* 77 */     method.addParameter(new Parameter(type22, "rowBound"));
/*    */     
/* 79 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 80 */       this.introspectedTable);
/*    */     
/* 82 */     addMapperAnnotations(interfaze, method);
/*    */     
/*    */ 
/* 85 */     if (this.context.getPlugins().clientSelectByExampleWithBLOBsMethodGenerated(method, interfaze, 
/* 86 */       this.introspectedTable)) {
/* 87 */       interfaze.addImportedTypes(importedTypes);
/* 88 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\SelectByExampleWithBLOBsMethodGenerator2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */