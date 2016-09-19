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
/*    */ public class SelectByExampleWithBLOBsElementGenerator2
/*    */   extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 38 */     String fqjt = this.introspectedTable.getExampleType();
/*    */     
/* 40 */     XmlElement answer = new XmlElement("select");
/* 41 */     answer
/* 42 */       .addAttribute(new Attribute(
/* 43 */       "id", this.introspectedTable.getSelectByExampleWithBLOBsStatementId() + "AndPage"));
/* 44 */     answer.addAttribute(new Attribute(
/* 45 */       "resultMap", this.introspectedTable.getResultMapWithBLOBsId()));
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
/*    */     
/* 65 */     answer.addElement(getBaseColumnListElement());
/* 66 */     answer.addElement(new TextElement(","));
/* 67 */     answer.addElement(getBlobColumnListElement());
/*    */     
/* 69 */     sb.setLength(0);
/* 70 */     sb.append("from ");
/* 71 */     sb.append(
/* 72 */       this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/* 73 */     answer.addElement(new TextElement(sb.toString()));
/* 74 */     answer.addElement(getExampleIncludeElement());
/*    */     
/* 76 */     ifElement = new XmlElement("if");
/* 77 */     ifElement.addAttribute(new Attribute("test", "orderByClause != null"));
/* 78 */     ifElement.addElement(new TextElement("order by ${orderByClause}"));
/* 79 */     answer.addElement(ifElement);
/*    */     
/*    */ 
/* 82 */     if (this.context.getPlugins().sqlMapSelectByExampleWithBLOBsElementGenerated(answer, 
/* 83 */       this.introspectedTable)) {
/* 84 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\SelectByExampleWithBLOBsElementGenerator2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */