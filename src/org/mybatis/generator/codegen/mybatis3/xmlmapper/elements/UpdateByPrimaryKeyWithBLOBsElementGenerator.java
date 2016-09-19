/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
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
/*     */ public class UpdateByPrimaryKeyWithBLOBsElementGenerator
/*     */   extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  41 */     XmlElement answer = new XmlElement("update");
/*     */     
/*  43 */     answer
/*  44 */       .addAttribute(new Attribute(
/*  45 */       "id", this.introspectedTable.getUpdateByPrimaryKeyWithBLOBsStatementId()));
/*     */     String parameterType;
/*     */   //  String parameterType;
/*  48 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  49 */       parameterType = this.introspectedTable.getRecordWithBLOBsType();
/*     */     } else {
/*  51 */       parameterType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */     
/*  54 */     answer.addAttribute(new Attribute("parameterType", 
/*  55 */       parameterType));
/*     */     
/*  57 */     this.context.getCommentGenerator().addComment(answer);
/*     */     
/*  59 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  61 */     sb.append("update ");
/*  62 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  63 */     answer.addElement(new TextElement(sb.toString()));
/*     */     
/*     */ 
/*  66 */     sb.setLength(0);
/*  67 */     sb.append("set ");
/*     */     
/*  69 */     Iterator<IntrospectedColumn> iter = this.introspectedTable
/*  70 */       .getNonPrimaryKeyColumns().iterator();
/*  71 */     while (iter.hasNext()) {
/*  72 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */       
/*  74 */       sb.append(
/*  75 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*  76 */       sb.append(" = ");
/*  77 */       sb.append(
/*  78 */         MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */       
/*  80 */       if (iter.hasNext()) {
/*  81 */         sb.append(',');
/*     */       }
/*     */       
/*  84 */       answer.addElement(new TextElement(sb.toString()));
/*     */       
/*     */ 
/*  87 */       if (iter.hasNext()) {
/*  88 */         sb.setLength(0);
/*  89 */         OutputUtilities.xmlIndent(sb, 1);
/*     */       }
/*     */     }
/*     */     
/*  93 */     boolean and = false;
/*     */     
/*  95 */     Iterator localIterator = this.introspectedTable.getPrimaryKeyColumns().iterator();
/*  94 */     while (localIterator.hasNext()) {
/*  95 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/*  96 */       sb.setLength(0);
/*  97 */       if (and) {
/*  98 */         sb.append("  and ");
/*     */       } else {
/* 100 */         sb.append("where ");
/* 101 */         and = true;
/*     */       }
/*     */       
/* 104 */       sb.append(
/* 105 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/* 106 */       sb.append(" = ");
/* 107 */       sb.append(
/* 108 */         MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/* 109 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */     
/*     */ 
/* 113 */     if (this.context.getPlugins().sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(answer, 
/* 114 */       this.introspectedTable)) {
/* 115 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\UpdateByPrimaryKeyWithBLOBsElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */