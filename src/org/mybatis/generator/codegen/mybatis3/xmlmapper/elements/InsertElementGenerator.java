/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import ibator.util.DBUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InsertElementGenerator
/*     */   extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  49 */     XmlElement answer = new XmlElement("insert");
/*     */     
/*  51 */     answer.addAttribute(new Attribute(
/*  52 */       "id", this.introspectedTable.getInsertStatementId()));
/*     */     
/*  54 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules()
/*  55 */       .calculateAllFieldsClass();
/*     */     
/*  57 */     answer.addAttribute(new Attribute("parameterType", 
/*  58 */       parameterType.getFullyQualifiedName()));
/*     */     
/*  60 */     this.context.getCommentGenerator().addComment(answer);
/*     */     
/*  62 */     List<String> list = DBUtil.getPrimarykey(this.introspectedTable
/*  63 */       .getFullyQualifiedTable()
/*  64 */       .getIntrospectedTableName());
/*  65 */     String gk = null;
/*  66 */     if ((list != null) && (list.size() == 1)) {
/*  67 */       gk = (String)list.get(0);
/*     */     }
/*  69 */     if (gk != null) {
/*  70 */       IntrospectedColumn introspectedColumn = this.introspectedTable
/*  71 */         .getColumn(gk);
/*     */       
/*     */ 
/*  74 */       if ((introspectedColumn != null) && 
/*  75 */         (introspectedColumn.getActualColumnName().equalsIgnoreCase(
/*  76 */         DBUtil.getIdentity(this.introspectedTable
/*  77 */         .getFullyQualifiedTable()
/*  78 */         .getIntrospectedTableName()))))
/*     */       {
/*  80 */         answer.addAttribute(new Attribute(
/*  81 */           "useGeneratedKeys", "true"));
/*  82 */         answer
/*  83 */           .addAttribute(new Attribute(
/*  84 */           "keyProperty", introspectedColumn.getJavaProperty()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  91 */     StringBuilder insertClause = new StringBuilder();
/*  92 */     StringBuilder valuesClause = new StringBuilder();
/*     */     
/*  94 */     insertClause.append("insert into ");
/*  95 */     insertClause.append(
/*  96 */       this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  97 */     insertClause.append(" (");
/*     */     
/*  99 */     valuesClause.append("values (");
/*     */     
/* 101 */     List<String> valuesClauses = new ArrayList();
/* 102 */     Iterator<IntrospectedColumn> iter = this.introspectedTable.getAllColumns()
/* 103 */       .iterator();
/*     */     
/* 105 */     while (iter.hasNext()) {
/* 106 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */       
/* 108 */       if (introspectedColumn.isIdentity()) {
/* 109 */         introspectedColumn.setIdentity(true);
/*     */       }
/*     */       else
/*     */       {
/* 113 */         insertClause.append(
/* 114 */           MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/* 115 */         valuesClause.append(
/* 116 */           MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */         
/* 118 */         if (iter.hasNext()) {
/* 119 */           insertClause.append(", ");
/* 120 */           valuesClause.append(", ");
/*     */         }
/*     */         
/* 123 */         if (valuesClause.length() > 80) {
/* 124 */           answer.addElement(new TextElement(insertClause.toString()));
/* 125 */           insertClause.setLength(0);
/* 126 */           OutputUtilities.xmlIndent(insertClause, 1);
/*     */           
/* 128 */           valuesClauses.add(valuesClause.toString());
/* 129 */           valuesClause.setLength(0);
/* 130 */           OutputUtilities.xmlIndent(valuesClause, 1);
/*     */         }
/*     */       }
/*     */     }
/* 134 */     insertClause.append(')');
/* 135 */     answer.addElement(new TextElement(insertClause.toString()));
/*     */     
/* 137 */     valuesClause.append(')');
/* 138 */     valuesClauses.add(valuesClause.toString());
/*     */     
/* 140 */     for (String clause : valuesClauses) {
/* 141 */       answer.addElement(new TextElement(clause));
/*     */     }
/*     */     
/* 144 */     if (this.context.getPlugins().sqlMapInsertElementGenerated(answer, 
/* 145 */       this.introspectedTable)) {
/* 146 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\InsertElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */