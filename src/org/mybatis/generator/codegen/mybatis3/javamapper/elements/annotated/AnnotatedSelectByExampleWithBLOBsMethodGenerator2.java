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
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByExampleWithBLOBsMethodGenerator2;
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
/*    */ public class AnnotatedSelectByExampleWithBLOBsMethodGenerator2
/*    */   extends SelectByExampleWithBLOBsMethodGenerator2
/*    */ {
/*    */   public void addMapperAnnotations(Interface interfaze, Method method)
/*    */   {
/* 41 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3SqlProviderType());
/* 42 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.SelectProvider"));
/* 43 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.type.JdbcType"));
/* 44 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.session.RowBounds"));
/*    */     
/* 46 */     if (this.introspectedTable.isConstructorBased()) {
/* 47 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Arg"));
/* 48 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.ConstructorArgs"));
/*    */     } else {
/* 50 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Result"));
/* 51 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Results"));
/*    */     }
/*    */     
/* 54 */     StringBuilder sb = new StringBuilder();
/* 55 */     sb.append("@SelectProvider(type=");
/* 56 */     sb.append(fqjt.getShortName());
/* 57 */     sb.append(".class, method=\"");
/* 58 */     sb.append(this.introspectedTable.getSelectByExampleWithBLOBsStatementId());
/* 59 */     sb.append("\")");
/*    */     
/* 61 */     method.addAnnotation(sb.toString());
/*    */     
/* 63 */     if (this.introspectedTable.isConstructorBased()) {
/* 64 */       method.addAnnotation("@ConstructorArgs({");
/*    */     } else {
/* 66 */       method.addAnnotation("@Results({");
/*    */     }
/*    */     
/* 69 */     Iterator<IntrospectedColumn> iterPk = this.introspectedTable.getPrimaryKeyColumns().iterator();
/* 70 */     Iterator<IntrospectedColumn> iterNonPk = this.introspectedTable.getNonPrimaryKeyColumns().iterator();
/* 71 */     while (iterPk.hasNext()) {
/* 72 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterPk.next();
/* 73 */       sb.setLength(0);
/* 74 */       OutputUtilities.javaIndent(sb, 1);
/* 75 */       sb.append(
/* 76 */         getResultAnnotation(interfaze, introspectedColumn, true, this.introspectedTable.isConstructorBased()));
/*    */       
/* 78 */       if ((iterPk.hasNext()) || (iterNonPk.hasNext())) {
/* 79 */         sb.append(',');
/*    */       }
/*    */       
/* 82 */       method.addAnnotation(sb.toString());
/*    */     }
/*    */     
/* 85 */     while (iterNonPk.hasNext()) {
/* 86 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterNonPk.next();
/* 87 */       sb.setLength(0);
/* 88 */       OutputUtilities.javaIndent(sb, 1);
/* 89 */       sb.append(
/* 90 */         getResultAnnotation(interfaze, introspectedColumn, false, this.introspectedTable.isConstructorBased()));
/*    */       
/* 92 */       if (iterNonPk.hasNext()) {
/* 93 */         sb.append(',');
/*    */       }
/*    */       
/* 96 */       method.addAnnotation(sb.toString());
/*    */     }
/*    */     
/* 99 */     method.addAnnotation("})");
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedSelectByExampleWithBLOBsMethodGenerator2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */