/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.InsertMethodGenerator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotatedInsertMethodGenerator
/*     */   extends InsertMethodGenerator
/*     */ {
/*     */   public void addMapperAnnotations(Interface interfaze, Method method)
/*     */   {
/*  47 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Insert"));
/*     */     
/*  49 */     GeneratedKey gk = this.introspectedTable.getGeneratedKey();
/*     */     
/*  51 */     method.addAnnotation("@Insert({");
/*  52 */     StringBuilder insertClause = new StringBuilder();
/*  53 */     StringBuilder valuesClause = new StringBuilder();
/*     */     
/*  55 */     OutputUtilities.javaIndent(insertClause, 1);
/*  56 */     OutputUtilities.javaIndent(valuesClause, 1);
/*     */     
/*  58 */     insertClause.append("\"insert into ");
/*  59 */     insertClause.append(StringUtility.escapeStringForJava(
/*  60 */       this.introspectedTable.getFullyQualifiedTableNameAtRuntime()));
/*  61 */     insertClause.append(" (");
/*     */     
/*  63 */     valuesClause.append("\"values (");
/*     */     
/*  65 */     List<String> valuesClauses = new ArrayList();
/*  66 */     Iterator<IntrospectedColumn> iter = this.introspectedTable.getAllColumns()
/*  67 */       .iterator();
/*  68 */     boolean hasFields = false;
/*  69 */     while (iter.hasNext()) {
/*  70 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*  71 */       if (!introspectedColumn.isIdentity())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  76 */         insertClause.append(StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)));
/*  77 */         valuesClause.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*  78 */         hasFields = true;
/*  79 */         if (iter.hasNext()) {
/*  80 */           insertClause.append(", ");
/*  81 */           valuesClause.append(", ");
/*     */         }
/*     */         
/*  84 */         if (valuesClause.length() > 60) {
/*  85 */           if (!iter.hasNext()) {
/*  86 */             insertClause.append(')');
/*  87 */             valuesClause.append(')');
/*     */           }
/*  89 */           insertClause.append("\",");
/*  90 */           valuesClause.append('"');
/*  91 */           if (iter.hasNext()) {
/*  92 */             valuesClause.append(',');
/*     */           }
/*     */           
/*  95 */           method.addAnnotation(insertClause.toString());
/*  96 */           insertClause.setLength(0);
/*  97 */           OutputUtilities.javaIndent(insertClause, 1);
/*  98 */           insertClause.append('"');
/*     */           
/* 100 */           valuesClauses.add(valuesClause.toString());
/* 101 */           valuesClause.setLength(0);
/* 102 */           OutputUtilities.javaIndent(valuesClause, 1);
/* 103 */           valuesClause.append('"');
/* 104 */           hasFields = false;
/*     */         }
/*     */       }
/*     */     }
/* 108 */     if (hasFields) {
/* 109 */       insertClause.append(")\",");
/* 110 */       method.addAnnotation(insertClause.toString());
/*     */       
/* 112 */       valuesClause.append(")\"");
/* 113 */       valuesClauses.add(valuesClause.toString());
/*     */     }
/*     */     
/* 116 */     for (String clause : valuesClauses) {
/* 117 */       method.addAnnotation(clause);
/*     */     }
/*     */     
/* 120 */     method.addAnnotation("})");
/*     */     
/* 122 */     if (gk != null) {
/* 123 */       addGeneratedKeyAnnotation(interfaze, method, gk);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedInsertMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */