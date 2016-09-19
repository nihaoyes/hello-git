/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
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
/*     */ public class UpdateByPrimaryKeySelectiveElementGenerator
/*     */   extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  38 */     XmlElement answer = new XmlElement("update");
/*     */     
/*  40 */     answer
/*  41 */       .addAttribute(new Attribute(
/*  42 */       "id", this.introspectedTable.getUpdateByPrimaryKeySelectiveStatementId()));
/*     */     
/*     */     String parameterType;
/*     */     //String parameterType;
/*  46 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  47 */       parameterType = this.introspectedTable.getRecordWithBLOBsType();
/*     */     } else {
/*  49 */       parameterType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */     
/*  52 */     answer.addAttribute(new Attribute("parameterType", 
/*  53 */       parameterType));
/*     */     
/*  55 */     this.context.getCommentGenerator().addComment(answer);
/*     */     
/*  57 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  59 */     sb.append("update ");
/*  60 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  61 */     answer.addElement(new TextElement(sb.toString()));
/*     */     
/*  63 */     XmlElement dynamicElement = new XmlElement("set");
/*  64 */     answer.addElement(dynamicElement);
/*     */     
/*     */ 
/*  67 */     Iterator localIterator = this.introspectedTable.getNonPrimaryKeyColumns().iterator();
/*  66 */     while (localIterator.hasNext()) {
/*  67 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/*  68 */       XmlElement isNotNullElement = new XmlElement("if");
/*  69 */       sb.setLength(0);
/*  70 */       sb.append(introspectedColumn.getJavaProperty());
/*  71 */       sb.append(" != null");
/*  72 */       isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
/*  73 */       dynamicElement.addElement(isNotNullElement);
/*     */       
/*  75 */       sb.setLength(0);
/*  76 */       sb.append(
/*  77 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*  78 */       sb.append(" = ");
/*  79 */       sb.append(
/*  80 */         MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*  81 */       sb.append(',');
/*     */       
/*  83 */       isNotNullElement.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */     
/*  86 */     boolean and = false;
/*     */     
/*  88 */     Iterator<IntrospectedColumn> isNotNullElement = this.introspectedTable.getPrimaryKeyColumns().iterator();
/*  87 */     while (isNotNullElement.hasNext()) {
/*  88 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)isNotNullElement.next();
/*  89 */       sb.setLength(0);
/*  90 */       if (and) {
/*  91 */         sb.append("  and ");
/*     */       } else {
/*  93 */         sb.append("where ");
/*  94 */         and = true;
/*     */       }
/*     */       
/*  97 */       sb.append(
/*  98 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*  99 */       sb.append(" = ");
/* 100 */       sb.append(
/* 101 */         MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/* 102 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */     
/*     */ 
/* 106 */     if (this.context.getPlugins().sqlMapUpdateByPrimaryKeySelectiveElementGenerated(answer, 
/* 107 */       this.introspectedTable)) {
/* 108 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\UpdateByPrimaryKeySelectiveElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */