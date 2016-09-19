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
/*     */ public class UpdateByPrimaryKeyWithoutBLOBsElementGenerator
/*     */   extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  41 */     XmlElement answer = new XmlElement("update");
/*     */     
/*  43 */     answer.addAttribute(new Attribute(
/*  44 */       "id", this.introspectedTable.getUpdateByPrimaryKeyStatementId()));
/*  45 */     answer.addAttribute(new Attribute("parameterType", 
/*  46 */       this.introspectedTable.getBaseRecordType()));
/*     */     
/*  48 */     this.context.getCommentGenerator().addComment(answer);
/*     */     
/*  50 */     StringBuilder sb = new StringBuilder();
/*  51 */     sb.append("update ");
/*  52 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  53 */     answer.addElement(new TextElement(sb.toString()));
/*     */     
/*     */ 
/*  56 */     sb.setLength(0);
/*  57 */     sb.append("set ");
/*     */     
/*  59 */     Iterator<IntrospectedColumn> iter = this.introspectedTable.getBaseColumns()
/*  60 */       .iterator();
/*  61 */     while (iter.hasNext()) {
/*  62 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */       
/*  64 */       sb.append(
/*  65 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*  66 */       sb.append(" = ");
/*  67 */       sb.append(
/*  68 */         MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */       
/*  70 */       if (iter.hasNext()) {
/*  71 */         sb.append(',');
/*     */       }
/*     */       
/*  74 */       answer.addElement(new TextElement(sb.toString()));
/*     */       
/*     */ 
/*  77 */       if (iter.hasNext()) {
/*  78 */         sb.setLength(0);
/*  79 */         OutputUtilities.xmlIndent(sb, 1);
/*     */       }
/*     */     }
/*     */     
/*  83 */     boolean and = false;
/*     */     
/*  85 */     Iterator localIterator = this.introspectedTable.getPrimaryKeyColumns().iterator();
/*  84 */     while (localIterator.hasNext()) {
/*  85 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/*  86 */       sb.setLength(0);
/*  87 */       if (and) {
/*  88 */         sb.append("  and ");
/*     */       } else {
/*  90 */         sb.append("where ");
/*  91 */         and = true;
/*     */       }
/*     */       
/*  94 */       sb.append(
/*  95 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*  96 */       sb.append(" = ");
/*  97 */       sb.append(
/*  98 */         MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*  99 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */     
/*     */ 
/* 103 */     if (this.context.getPlugins().sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(answer, 
/* 104 */       this.introspectedTable)) {
/* 105 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\UpdateByPrimaryKeyWithoutBLOBsElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */