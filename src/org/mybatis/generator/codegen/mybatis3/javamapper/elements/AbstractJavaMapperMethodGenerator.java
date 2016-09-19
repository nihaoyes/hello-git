/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.codegen.AbstractGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.GeneratedKey;
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
/*     */ public abstract class AbstractJavaMapperMethodGenerator
/*     */   extends AbstractGenerator
/*     */ {
/*     */   public abstract void addInterfaceElements(Interface paramInterface);
/*     */   
/*     */   protected String getResultAnnotation(Interface interfaze, IntrospectedColumn introspectedColumn, boolean idColumn, boolean constructorBased)
/*     */   {
/*  42 */     StringBuilder sb = new StringBuilder();
/*  43 */     if (constructorBased) {
/*  44 */       interfaze.addImportedType(introspectedColumn.getFullyQualifiedJavaType());
/*  45 */       sb.append("@Arg(column=\"");
/*  46 */       sb.append(MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn));
/*  47 */       sb.append("\", javaType=");
/*  48 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getShortName());
/*  49 */       sb.append(".class");
/*     */     } else {
/*  51 */       sb.append("@Result(column=\"");
/*  52 */       sb.append(MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn));
/*  53 */       sb.append("\", property=\"");
/*  54 */       sb.append(introspectedColumn.getJavaProperty());
/*  55 */       sb.append('"');
/*     */     }
/*     */     
/*  58 */     if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler())) {
/*  59 */       FullyQualifiedJavaType fqjt = 
/*  60 */         new FullyQualifiedJavaType(introspectedColumn.getTypeHandler());
/*  61 */       interfaze.addImportedType(fqjt);
/*  62 */       sb.append(", typeHandler=");
/*  63 */       sb.append(fqjt.getShortName());
/*  64 */       sb.append(".class");
/*     */     }
/*     */     
/*  67 */     sb.append(", jdbcType=JdbcType.");
/*  68 */     sb.append(introspectedColumn.getJdbcTypeName());
/*  69 */     if (idColumn) {
/*  70 */       sb.append(", id=true");
/*     */     }
/*  72 */     sb.append(')');
/*     */     
/*  74 */     return sb.toString();
/*     */   }
/*     */   
/*     */   protected void addGeneratedKeyAnnotation(Interface interfaze, Method method, GeneratedKey gk)
/*     */   {
/*  79 */     StringBuilder sb = new StringBuilder();
/*  80 */     IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(gk.getColumn());
/*  81 */     if (introspectedColumn != null) {
/*  82 */       if (gk.isJdbcStandard()) {
/*  83 */         interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Options"));
/*  84 */         sb.append("@Options(useGeneratedKeys=true,keyProperty=\"");
/*  85 */         sb.append(introspectedColumn.getJavaProperty());
/*  86 */         sb.append("\")");
/*  87 */         method.addAnnotation(sb.toString());
/*     */       } else {
/*  89 */         interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.SelectKey"));
/*  90 */         FullyQualifiedJavaType fqjt = introspectedColumn.getFullyQualifiedJavaType();
/*  91 */         interfaze.addImportedType(fqjt);
/*  92 */         sb.append("@SelectKey(statement=\"");
/*  93 */         sb.append(gk.getRuntimeSqlStatement());
/*  94 */         sb.append("\", keyProperty=\"");
/*  95 */         sb.append(introspectedColumn.getJavaProperty());
/*  96 */         sb.append("\", before=");
/*  97 */         sb.append(gk.isIdentity() ? "false" : "true");
/*  98 */         sb.append(", resultType=");
/*  99 */         sb.append(fqjt.getShortName());
/* 100 */         sb.append(".class)");
/* 101 */         method.addAnnotation(sb.toString());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\AbstractJavaMapperMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */