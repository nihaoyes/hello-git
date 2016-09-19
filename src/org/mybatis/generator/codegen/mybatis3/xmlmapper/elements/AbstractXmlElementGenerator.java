/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.AbstractGenerator;
/*     */ import org.mybatis.generator.config.GeneratedKey;
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
/*     */ public abstract class AbstractXmlElementGenerator
/*     */   extends AbstractGenerator
/*     */ {
/*     */   public abstract void addElements(XmlElement paramXmlElement);
/*     */   
/*     */   protected XmlElement getSelectKey(IntrospectedColumn introspectedColumn, GeneratedKey generatedKey)
/*     */   {
/*  49 */     String identityColumnType = introspectedColumn
/*  50 */       .getFullyQualifiedJavaType().getFullyQualifiedName();
/*     */     
/*  52 */     XmlElement answer = new XmlElement("selectKey");
/*  53 */     answer.addAttribute(new Attribute("resultType", identityColumnType));
/*  54 */     answer.addAttribute(new Attribute(
/*  55 */       "keyProperty", introspectedColumn.getJavaProperty()));
/*  56 */     answer.addAttribute(new Attribute("order", 
/*  57 */       generatedKey.getMyBatis3Order()));
/*     */     
/*  59 */     answer.addElement(new TextElement(
/*  60 */       generatedKey.getRuntimeSqlStatement()));
/*     */     
/*  62 */     return answer;
/*     */   }
/*     */   
/*     */   protected XmlElement getBaseColumnListElement() {
/*  66 */     XmlElement answer = new XmlElement("include");
/*  67 */     answer.addAttribute(new Attribute("refid", 
/*  68 */       this.introspectedTable.getBaseColumnListId()));
/*  69 */     return answer;
/*     */   }
/*     */   
/*     */   protected XmlElement getBlobColumnListElement() {
/*  73 */     XmlElement answer = new XmlElement("include");
/*  74 */     answer.addAttribute(new Attribute("refid", 
/*  75 */       this.introspectedTable.getBlobColumnListId()));
/*  76 */     return answer;
/*     */   }
/*     */   
/*     */   protected XmlElement getExampleIncludeElement() {
/*  80 */     XmlElement ifElement = new XmlElement("if");
/*  81 */     ifElement.addAttribute(new Attribute("test", "_parameter != null"));
/*     */     
/*  83 */     XmlElement includeElement = new XmlElement("include");
/*  84 */     includeElement.addAttribute(new Attribute("refid", 
/*  85 */       this.introspectedTable.getExampleWhereClauseId()));
/*  86 */     ifElement.addElement(includeElement);
/*     */     
/*  88 */     return ifElement;
/*     */   }
/*     */   
/*     */   protected XmlElement getUpdateByExampleIncludeElement() {
/*  92 */     XmlElement ifElement = new XmlElement("if");
/*  93 */     ifElement.addAttribute(new Attribute("test", "_parameter != null"));
/*     */     
/*  95 */     XmlElement includeElement = new XmlElement("include");
/*  96 */     includeElement.addAttribute(new Attribute("refid", 
/*  97 */       this.introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
/*  98 */     ifElement.addElement(includeElement);
/*     */     
/* 100 */     return ifElement;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\AbstractXmlElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */