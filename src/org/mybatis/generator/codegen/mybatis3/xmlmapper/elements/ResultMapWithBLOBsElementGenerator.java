/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
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
/*     */ public class ResultMapWithBLOBsElementGenerator
/*     */   extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  39 */     XmlElement answer = new XmlElement("resultMap");
/*     */     
/*  41 */     answer.addAttribute(new Attribute("id", 
/*  42 */       this.introspectedTable.getResultMapWithBLOBsId()));
/*     */     String returnType;
/*     */    // String returnType;
/*  45 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  46 */       returnType = this.introspectedTable.getRecordWithBLOBsType();
/*     */     }
/*     */     else
/*     */     {
/*  50 */       returnType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */     
/*  53 */     answer.addAttribute(new Attribute("type", 
/*  54 */       returnType));
/*     */     
/*  56 */     if (!this.introspectedTable.isConstructorBased()) {
/*  57 */       answer.addAttribute(new Attribute("extends", 
/*  58 */         this.introspectedTable.getBaseResultMapId()));
/*     */     }
/*     */     
/*  61 */     this.context.getCommentGenerator().addComment(answer);
/*     */     
/*  63 */     if (this.introspectedTable.isConstructorBased()) {
/*  64 */       addResultMapConstructorElements(answer);
/*     */     } else {
/*  66 */       addResultMapElements(answer);
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (this.context.getPlugins().sqlMapResultMapWithBLOBsElementGenerated(answer, 
/*  71 */       this.introspectedTable)) {
/*  72 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addResultMapElements(XmlElement answer)
/*     */   {
/*  78 */     Iterator localIterator = this.introspectedTable.getBLOBColumns().iterator();
/*  77 */     while (localIterator.hasNext()) {
/*  78 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/*  79 */       XmlElement resultElement = new XmlElement("result");
/*     */       
/*  81 */       resultElement
/*  82 */         .addAttribute(new Attribute(
/*  83 */         "column", MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/*  84 */       resultElement.addAttribute(new Attribute(
/*  85 */         "property", introspectedColumn.getJavaProperty()));
/*  86 */       resultElement.addAttribute(new Attribute(
/*  87 */         "jdbcType", introspectedColumn.getJdbcTypeName()));
/*     */       
/*  89 */       if (StringUtility.stringHasValue(introspectedColumn
/*  90 */         .getTypeHandler())) {
/*  91 */         resultElement.addAttribute(new Attribute(
/*  92 */           "typeHandler", introspectedColumn.getTypeHandler()));
/*     */       }
/*     */       
/*  95 */       answer.addElement(resultElement);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addResultMapConstructorElements(XmlElement answer) {
/* 100 */     XmlElement constructor = new XmlElement("constructor");
/*     */     
/*     */ 
/* 103 */     Iterator localIterator = this.introspectedTable.getPrimaryKeyColumns().iterator();
/* 102 */     while (localIterator.hasNext()) {
/* 103 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/* 104 */       XmlElement resultElement = new XmlElement("idArg");
/*     */       
/* 106 */       resultElement
/* 107 */         .addAttribute(new Attribute(
/* 108 */         "column", MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/* 109 */       resultElement.addAttribute(new Attribute(
/* 110 */         "jdbcType", introspectedColumn.getJdbcTypeName()));
/* 111 */       resultElement.addAttribute(new Attribute("javaType", 
/* 112 */         introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName()));
/*     */       
/* 114 */       if (StringUtility.stringHasValue(introspectedColumn
/* 115 */         .getTypeHandler())) {
/* 116 */         resultElement.addAttribute(new Attribute(
/* 117 */           "typeHandler", introspectedColumn.getTypeHandler()));
/*     */       }
/*     */       
/* 120 */       constructor.addElement(resultElement);
/*     */     }
/*     */     
/*     */ 
/* 124 */     localIterator = this.introspectedTable.getNonPrimaryKeyColumns().iterator();
/* 123 */     while (localIterator.hasNext()) {
/* 124 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/* 125 */       XmlElement resultElement = new XmlElement("arg");
/*     */       
/* 127 */       resultElement
/* 128 */         .addAttribute(new Attribute(
/* 129 */         "column", MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/* 130 */       resultElement.addAttribute(new Attribute(
/* 131 */         "jdbcType", introspectedColumn.getJdbcTypeName()));
/*     */       
/* 133 */       if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive())
/*     */       {
/* 135 */         StringBuilder sb = new StringBuilder();
/* 136 */         sb.append('_');
/* 137 */         sb.append(introspectedColumn.getFullyQualifiedJavaType().getShortName());
/* 138 */         resultElement.addAttribute(new Attribute("javaType", 
/* 139 */           sb.toString()));
/*     */       }
/* 141 */       else if ("byte[]".equals(
/* 142 */         introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName()))
/*     */       {
/* 144 */         resultElement.addAttribute(new Attribute("javaType", 
/* 145 */           "_byte[]"));
/*     */       } else {
/* 147 */         resultElement.addAttribute(new Attribute("javaType", 
/* 148 */           introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName()));
/*     */       }
/*     */       
/* 151 */       if (StringUtility.stringHasValue(introspectedColumn
/* 152 */         .getTypeHandler())) {
/* 153 */         resultElement.addAttribute(new Attribute(
/* 154 */           "typeHandler", introspectedColumn.getTypeHandler()));
/*     */       }
/*     */       
/* 157 */       constructor.addElement(resultElement);
/*     */     }
/*     */     
/* 160 */     answer.addElement(constructor);
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\ResultMapWithBLOBsElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */