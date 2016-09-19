/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.config.Context;
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
/*    */ public class CountByExampleElementGenerator
/*    */   extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 35 */     XmlElement answer = new XmlElement("select");
/*    */     
/* 37 */     String fqjt = this.introspectedTable.getExampleType();
/*    */     
/* 39 */     answer.addAttribute(new Attribute(
/* 40 */       "id", this.introspectedTable.getCountByExampleStatementId()));
/* 41 */     answer.addAttribute(new Attribute("parameterType", fqjt));
/* 42 */     answer.addAttribute(new Attribute("resultType", "java.lang.Integer"));
/*    */     
/* 44 */     this.context.getCommentGenerator().addComment(answer);
/*    */     
/* 46 */     StringBuilder sb = new StringBuilder();
/* 47 */     sb.append("select count(*) from ");
/* 48 */     sb.append(
/* 49 */       this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/* 50 */     answer.addElement(new TextElement(sb.toString()));
/* 51 */     answer.addElement(getExampleIncludeElement());
/*    */     
/* 53 */     if (this.context.getPlugins().sqlMapCountByExampleElementGenerated(
/* 54 */       answer, this.introspectedTable)) {
/* 55 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\CountByExampleElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */