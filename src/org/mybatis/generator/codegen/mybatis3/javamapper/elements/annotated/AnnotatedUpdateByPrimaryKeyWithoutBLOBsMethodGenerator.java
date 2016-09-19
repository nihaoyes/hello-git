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
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByPrimaryKeyWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
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
/*     */ public class AnnotatedUpdateByPrimaryKeyWithoutBLOBsMethodGenerator
/*     */   extends UpdateByPrimaryKeyWithoutBLOBsMethodGenerator
/*     */ {
/*     */   public void addMapperAnnotations(Interface interfaze, Method method)
/*     */   {
/*  44 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Update"));
/*     */     
/*  46 */     method.addAnnotation("@Update({");
/*     */     
/*  48 */     StringBuilder sb = new StringBuilder();
/*  49 */     OutputUtilities.javaIndent(sb, 1);
/*  50 */     sb.append("\"update ");
/*  51 */     sb.append(StringUtility.escapeStringForJava(this.introspectedTable.getFullyQualifiedTableNameAtRuntime()));
/*  52 */     sb.append("\",");
/*  53 */     method.addAnnotation(sb.toString());
/*     */     
/*     */ 
/*  56 */     sb.setLength(0);
/*  57 */     OutputUtilities.javaIndent(sb, 1);
/*  58 */     sb.append("\"set ");
/*     */     
/*  60 */     Iterator<IntrospectedColumn> iter = this.introspectedTable
/*  61 */       .getBaseColumns().iterator();
/*  62 */     while (iter.hasNext()) {
/*  63 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */       
/*  65 */       sb.append(StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)));
/*  66 */       sb.append(" = ");
/*  67 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */       
/*  69 */       if (iter.hasNext()) {
/*  70 */         sb.append(',');
/*     */       }
/*     */       
/*  73 */       sb.append("\",");
/*  74 */       method.addAnnotation(sb.toString());
/*     */       
/*     */ 
/*  77 */       if (iter.hasNext()) {
/*  78 */         sb.setLength(0);
/*  79 */         OutputUtilities.javaIndent(sb, 1);
/*  80 */         sb.append("  \"");
/*     */       }
/*     */     }
/*     */     
/*  84 */     boolean and = false;
/*  85 */     iter = this.introspectedTable.getPrimaryKeyColumns().iterator();
/*  86 */     while (iter.hasNext()) {
/*  87 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*  88 */       sb.setLength(0);
/*  89 */       OutputUtilities.javaIndent(sb, 1);
/*  90 */       if (and) {
/*  91 */         sb.append("  \"and ");
/*     */       } else {
/*  93 */         sb.append("\"where ");
/*  94 */         and = true;
/*     */       }
/*     */       
/*  97 */       sb.append(StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)));
/*  98 */       sb.append(" = ");
/*  99 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/* 100 */       sb.append('"');
/* 101 */       if (iter.hasNext()) {
/* 102 */         sb.append(',');
/*     */       }
/* 104 */       method.addAnnotation(sb.toString());
/*     */     }
/*     */     
/* 107 */     method.addAnnotation("})");
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedUpdateByPrimaryKeyWithoutBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */