/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SelectByExampleWithoutBLOBsElementGenerator
/*    */   extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 38 */     String fqjt = this.introspectedTable.getExampleType();
/*    */     
/* 40 */     XmlElement answer = new XmlElement("select");
/*    */     
/* 42 */     answer.addAttribute(new Attribute("id", 
/* 43 */       this.introspectedTable.getSelectByExampleStatementId()));
/* 44 */     answer.addAttribute(new Attribute(
/* 45 */       "resultMap", this.introspectedTable.getBaseResultMapId()));
/* 46 */     answer.addAttribute(new Attribute("parameterType", fqjt));
/*    */     
/* 48 */     this.context.getCommentGenerator().addComment(answer);
/*    */     
/* 50 */     answer.addElement(new TextElement("select"));
/* 51 */     XmlElement ifElement = new XmlElement("if");
/* 52 */     ifElement.addAttribute(new Attribute("test", "distinct"));
/* 53 */     ifElement.addElement(new TextElement("distinct"));
/* 54 */     answer.addElement(ifElement);
/*    */     
/* 56 */     StringBuilder sb = new StringBuilder();
/* 57 */     if (StringUtility.stringHasValue(this.introspectedTable
/* 58 */       .getSelectByExampleQueryId())) {
/* 59 */       sb.append('\'');
/* 60 */       sb.append(this.introspectedTable.getSelectByExampleQueryId());
/* 61 */       sb.append("' as QUERYID,");
/* 62 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/* 64 */     answer.addElement(getBaseColumnListElement());
/*    */     
/* 66 */     sb.setLength(0);
/* 67 */     sb.append("from ");
/* 68 */     sb.append(
/* 69 */       this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/* 70 */     answer.addElement(new TextElement(sb.toString()));
/* 71 */     answer.addElement(getExampleIncludeElement());
/*    */     
/* 73 */     ifElement = new XmlElement("if");
/* 74 */     ifElement.addAttribute(new Attribute("test", "orderByClause != null"));
/* 75 */     ifElement.addElement(new TextElement("order by ${orderByClause}"));
/* 76 */     answer.addElement(ifElement);
/*    */     
/*    */ 
/* 79 */     if (this.context.getPlugins().sqlMapSelectByExampleWithoutBLOBsElementGenerated(answer, 
/* 80 */       this.introspectedTable)) {
/* 81 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\SelectByExampleWithoutBLOBsElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */