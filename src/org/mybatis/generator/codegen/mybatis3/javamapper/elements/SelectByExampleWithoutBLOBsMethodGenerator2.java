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
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
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
/*    */ public class SelectByExampleWithoutBLOBsMethodGenerator2
/*    */   extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 43 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/* 44 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(
/* 45 */       this.introspectedTable.getExampleType());
/* 46 */     importedTypes.add(type);
/*    */     
/* 48 */     String type2 = "org.apache.ibatis.session.RowBounds";
/* 49 */     FullyQualifiedJavaType type22 = new FullyQualifiedJavaType(
/* 50 */       type2);
/*    */     
/* 52 */     importedTypes.add(type22);
/* 53 */     importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
/*    */     
/*    */ 
/* 56 */     Method method = new Method();
/* 57 */     method.setVisibility(JavaVisibility.PUBLIC);
/*    */     
/* 59 */     FullyQualifiedJavaType returnType = 
/* 60 */       FullyQualifiedJavaType.getNewListInstance();
/*    */     FullyQualifiedJavaType listType;
/* 62 */     if (this.introspectedTable.getRules().generateBaseRecordClass()) {
/* 63 */       listType = new FullyQualifiedJavaType(
/* 64 */         this.introspectedTable.getBaseRecordType()); } else { 
/* 65 */       if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 66 */         listType = new FullyQualifiedJavaType(
/* 67 */           this.introspectedTable.getPrimaryKeyType());
/*    */       } else
/* 69 */         throw new RuntimeException(Messages.getString("RuntimeError.12"));
/*    */     }
/*    */
/* 72 */     importedTypes.add(listType);
/* 73 */     returnType.addTypeArgument(listType);
/* 74 */     method.setReturnType(returnType);
/*    */     
/* 76 */     method.setName(this.introspectedTable.getSelectByExampleStatementId() + "AndPage");
/* 77 */     method.addParameter(new Parameter(type, "example"));
/* 78 */     method.addParameter(new Parameter(type22, "rowBound"));
/*    */     
/* 80 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 81 */       this.introspectedTable);
/*    */     
/* 83 */     addMapperAnnotations(interfaze, method);
/*    */     
/*    */ 
/* 86 */     if (this.context.getPlugins().clientSelectByExampleWithoutBLOBsMethodGenerated(method, 
/* 87 */       interfaze, this.introspectedTable)) {
/* 88 */       interfaze.addImportedTypes(importedTypes);
/* 89 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addMapperAnnotations(Interface interfaze, Method method) {}
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\SelectByExampleWithoutBLOBsMethodGenerator2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */