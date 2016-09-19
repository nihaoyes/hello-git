/*     */ package org.mybatis.generator.codegen.mybatis3;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.config.Context;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyBatis3FormattingUtilities
/*     */ {
/*     */   public static String getParameterClause(IntrospectedColumn introspectedColumn)
/*     */   {
/*  42 */     return getParameterClause(introspectedColumn, null);
/*     */   }
/*     */   
/*     */   public static String getParameterClause(IntrospectedColumn introspectedColumn, String prefix)
/*     */   {
/*  47 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  49 */     sb.append("#{");
/*  50 */     sb.append(introspectedColumn.getJavaProperty(prefix));
/*  51 */     sb.append(",jdbcType=");
/*  52 */     sb.append(introspectedColumn.getJdbcTypeName());
/*     */     
/*  54 */     if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler())) {
/*  55 */       sb.append(",typeHandler=");
/*  56 */       sb.append(introspectedColumn.getTypeHandler());
/*     */     }
/*     */     
/*  59 */     sb.append('}');
/*     */     
/*  61 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getSelectListPhrase(IntrospectedColumn introspectedColumn)
/*     */   {
/*  72 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/*  73 */       StringBuilder sb = new StringBuilder();
/*     */       
/*  75 */       sb.append(getAliasedEscapedColumnName(introspectedColumn));
/*  76 */       sb.append(" as ");
/*  77 */       if (introspectedColumn.isColumnNameDelimited()) {
/*  78 */         sb.append(
/*  79 */           introspectedColumn.getContext().getBeginningDelimiter());
/*     */       }
/*  81 */       sb.append(introspectedColumn.getTableAlias());
/*  82 */       sb.append('_');
/*  83 */       sb.append(escapeStringForMyBatis3(
/*  84 */         introspectedColumn.getActualColumnName()));
/*  85 */       if (introspectedColumn.isColumnNameDelimited()) {
/*  86 */         sb.append(introspectedColumn.getContext().getEndingDelimiter());
/*     */       }
/*  88 */       return sb.toString();
/*     */     }
/*  90 */     return getEscapedColumnName(introspectedColumn);
/*     */   }
/*     */   
/*     */ 
/*     */   public static String getEscapedColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/*  96 */     StringBuilder sb = new StringBuilder();
/*  97 */     sb.append(escapeStringForMyBatis3(
/*  98 */       introspectedColumn.getActualColumnName()));
/*     */     
/* 100 */     if (introspectedColumn.isColumnNameDelimited()) {
/* 101 */       sb.insert(0, 
/* 102 */         introspectedColumn.getContext().getBeginningDelimiter());
/* 103 */       sb.append(introspectedColumn.getContext().getEndingDelimiter());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getAliasedEscapedColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/* 120 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 121 */       StringBuilder sb = new StringBuilder();
/*     */       
/* 123 */       sb.append(introspectedColumn.getTableAlias());
/* 124 */       sb.append('.');
/* 125 */       sb.append(getEscapedColumnName(introspectedColumn));
/* 126 */       return sb.toString();
/*     */     }
/* 128 */     return getEscapedColumnName(introspectedColumn);
/*     */   }
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
/*     */   public static String getAliasedActualColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/* 146 */     StringBuilder sb = new StringBuilder();
/* 147 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 148 */       sb.append(introspectedColumn.getTableAlias());
/* 149 */       sb.append('.');
/*     */     }
/*     */     
/* 152 */     if (introspectedColumn.isColumnNameDelimited()) {
/* 153 */       sb.append(StringUtility.escapeStringForJava(
/* 154 */         introspectedColumn.getContext().getBeginningDelimiter()));
/*     */     }
/*     */     
/* 157 */     sb.append(introspectedColumn.getActualColumnName());
/*     */     
/* 159 */     if (introspectedColumn.isColumnNameDelimited()) {
/* 160 */       sb.append(StringUtility.escapeStringForJava(
/* 161 */         introspectedColumn.getContext().getEndingDelimiter()));
/*     */     }
/*     */     
/* 164 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getRenamedColumnNameForResultMap(IntrospectedColumn introspectedColumn)
/*     */   {
/* 176 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 177 */       StringBuilder sb = new StringBuilder();
/*     */       
/* 179 */       sb.append(introspectedColumn.getTableAlias());
/* 180 */       sb.append('_');
/* 181 */       sb.append(introspectedColumn.getActualColumnName());
/* 182 */       return sb.toString();
/*     */     }
/* 184 */     return introspectedColumn.getActualColumnName();
/*     */   }
/*     */   
/*     */ 
/*     */   public static String escapeStringForMyBatis3(String s)
/*     */   {
/* 190 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\MyBatis3FormattingUtilities.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */