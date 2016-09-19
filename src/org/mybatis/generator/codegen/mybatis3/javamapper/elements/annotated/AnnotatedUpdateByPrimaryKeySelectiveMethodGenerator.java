/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated;
/*    */ 
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByPrimaryKeySelectiveMethodGenerator;
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
/*    */ public class AnnotatedUpdateByPrimaryKeySelectiveMethodGenerator
/*    */   extends UpdateByPrimaryKeySelectiveMethodGenerator
/*    */ {
/*    */   public void addMapperAnnotations(Interface interfaze, Method method)
/*    */   {
/* 36 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3SqlProviderType());
/* 37 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.UpdateProvider"));
/* 38 */     StringBuilder sb = new StringBuilder();
/* 39 */     sb.append("@UpdateProvider(type=");
/* 40 */     sb.append(fqjt.getShortName());
/* 41 */     sb.append(".class, method=\"");
/* 42 */     sb.append(this.introspectedTable.getUpdateByPrimaryKeySelectiveStatementId());
/* 43 */     sb.append("\")");
/*    */     
/* 45 */     method.addAnnotation(sb.toString());
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedUpdateByPrimaryKeySelectiveMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */