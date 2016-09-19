/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.dom.OutputUtilities;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByExampleWithoutBLOBsMethodGenerator;
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
/*    */ 
/*    */ public class AnnotatedSelectByExampleWithoutBLOBsMethodGenerator
/*    */   extends SelectByExampleWithoutBLOBsMethodGenerator
/*    */ {
/*    */   public void addMapperAnnotations(Interface interfaze, Method method)
/*    */   {
/* 41 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3SqlProviderType());
/* 42 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.SelectProvider"));
/* 43 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.type.JdbcType"));
/*    */     
/* 45 */     if (this.introspectedTable.isConstructorBased()) {
/* 46 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Arg"));
/* 47 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.ConstructorArgs"));
/*    */     } else {
/* 49 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Result"));
/* 50 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Results"));
/*    */     }
/*    */     
/* 53 */     StringBuilder sb = new StringBuilder();
/* 54 */     sb.append("@SelectProvider(type=");
/* 55 */     sb.append(fqjt.getShortName());
/* 56 */     sb.append(".class, method=\"");
/* 57 */     sb.append(this.introspectedTable.getSelectByExampleStatementId());
/* 58 */     sb.append("\")");
/*    */     
/* 60 */     method.addAnnotation(sb.toString());
/*    */     
/* 62 */     if (this.introspectedTable.isConstructorBased()) {
/* 63 */       method.addAnnotation("@ConstructorArgs({");
/*    */     } else {
/* 65 */       method.addAnnotation("@Results({");
/*    */     }
/*    */     
/* 68 */     Iterator<IntrospectedColumn> iterPk = this.introspectedTable.getPrimaryKeyColumns().iterator();
/* 69 */     Iterator<IntrospectedColumn> iterNonPk = this.introspectedTable.getBaseColumns().iterator();
/* 70 */     while (iterPk.hasNext()) {
/* 71 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterPk.next();
/* 72 */       sb.setLength(0);
/* 73 */       OutputUtilities.javaIndent(sb, 1);
/* 74 */       sb.append(
/* 75 */         getResultAnnotation(interfaze, introspectedColumn, true, this.introspectedTable.isConstructorBased()));
/*    */       
/* 77 */       if ((iterPk.hasNext()) || (iterNonPk.hasNext())) {
/* 78 */         sb.append(',');
/*    */       }
/*    */       
/* 81 */       method.addAnnotation(sb.toString());
/*    */     }
/*    */     
/* 84 */     while (iterNonPk.hasNext()) {
/* 85 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterNonPk.next();
/* 86 */       sb.setLength(0);
/* 87 */       OutputUtilities.javaIndent(sb, 1);
/* 88 */       sb.append(
/* 89 */         getResultAnnotation(interfaze, introspectedColumn, false, this.introspectedTable.isConstructorBased()));
/*    */       
/* 91 */       if (iterNonPk.hasNext()) {
/* 92 */         sb.append(',');
/*    */       }
/*    */       
/* 95 */       method.addAnnotation(sb.toString());
/*    */     }
/*    */     
/* 98 */     method.addAnnotation("})");
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedSelectByExampleWithoutBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */