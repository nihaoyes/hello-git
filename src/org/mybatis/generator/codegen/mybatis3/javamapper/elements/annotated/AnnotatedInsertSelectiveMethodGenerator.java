/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated;
/*    */ 
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.InsertSelectiveMethodGenerator;
/*    */ import org.mybatis.generator.config.GeneratedKey;
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
/*    */ 
/*    */ public class AnnotatedInsertSelectiveMethodGenerator
/*    */   extends InsertSelectiveMethodGenerator
/*    */ {
/*    */   public void addMapperAnnotations(Interface interfaze, Method method)
/*    */   {
/* 37 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3SqlProviderType());
/* 38 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.InsertProvider"));
/* 39 */     StringBuilder sb = new StringBuilder();
/* 40 */     sb.append("@InsertProvider(type=");
/* 41 */     sb.append(fqjt.getShortName());
/* 42 */     sb.append(".class, method=\"");
/* 43 */     sb.append(this.introspectedTable.getInsertSelectiveStatementId());
/* 44 */     sb.append("\")");
/*    */     
/* 46 */     method.addAnnotation(sb.toString());
/*    */     
/* 48 */     GeneratedKey gk = this.introspectedTable.getGeneratedKey();
/* 49 */     if (gk != null) {
/* 50 */       addGeneratedKeyAnnotation(interfaze, method, gk);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedInsertSelectiveMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */