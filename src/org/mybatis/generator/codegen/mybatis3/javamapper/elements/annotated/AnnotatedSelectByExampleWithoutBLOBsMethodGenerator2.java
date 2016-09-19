/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByExampleWithoutBLOBsMethodGenerator2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotatedSelectByExampleWithoutBLOBsMethodGenerator2
/*     */   extends SelectByExampleWithoutBLOBsMethodGenerator2
/*     */ {
/*     */   public void addMapperAnnotations(Interface interfaze, Method method)
/*     */   {
/*  42 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3SqlProviderType());
/*  43 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.SelectProvider"));
/*  44 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.type.JdbcType"));
/*  45 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.session.RowBounds"));
/*     */     
/*  47 */     if (this.introspectedTable.isConstructorBased()) {
/*  48 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Arg"));
/*  49 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.ConstructorArgs"));
/*     */     } else {
/*  51 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Result"));
/*  52 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Results"));
/*     */     }
/*     */     
/*     */ 
/*  56 */     StringBuilder sb = new StringBuilder();
/*  57 */     sb.append("@SelectProvider(type=");
/*  58 */     sb.append(fqjt.getShortName());
/*  59 */     sb.append(".class, method=\"");
/*  60 */     sb.append(this.introspectedTable.getSelectByExampleStatementId());
/*  61 */     sb.append("\")");
/*     */     
/*  63 */     method.addAnnotation(sb.toString());
/*     */     
/*  65 */     if (this.introspectedTable.isConstructorBased()) {
/*  66 */       method.addAnnotation("@ConstructorArgs({");
/*     */     } else {
/*  68 */       method.addAnnotation("@Results({");
/*     */     }
/*     */     
/*  71 */     Iterator<IntrospectedColumn> iterPk = this.introspectedTable.getPrimaryKeyColumns().iterator();
/*  72 */     Iterator<IntrospectedColumn> iterNonPk = this.introspectedTable.getBaseColumns().iterator();
/*  73 */     while (iterPk.hasNext()) {
/*  74 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterPk.next();
/*  75 */       sb.setLength(0);
/*  76 */       OutputUtilities.javaIndent(sb, 1);
/*  77 */       sb.append(
/*  78 */         getResultAnnotation(interfaze, introspectedColumn, true, this.introspectedTable.isConstructorBased()));
/*     */       
/*  80 */       if ((iterPk.hasNext()) || (iterNonPk.hasNext())) {
/*  81 */         sb.append(',');
/*     */       }
/*     */       
/*  84 */       method.addAnnotation(sb.toString());
/*     */     }
/*     */     
/*  87 */     while (iterNonPk.hasNext()) {
/*  88 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterNonPk.next();
/*  89 */       sb.setLength(0);
/*  90 */       OutputUtilities.javaIndent(sb, 1);
/*  91 */       sb.append(
/*  92 */         getResultAnnotation(interfaze, introspectedColumn, false, this.introspectedTable.isConstructorBased()));
/*     */       
/*  94 */       if (iterNonPk.hasNext()) {
/*  95 */         sb.append(',');
/*     */       }
/*     */       
/*  98 */       method.addAnnotation(sb.toString());
/*     */     }
/*     */     
/* 101 */     method.addAnnotation("})");
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedSelectByExampleWithoutBLOBsMethodGenerator2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */