/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.internal.rules.Rules;
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
/*    */ public class DeleteByPrimaryKeyElementGenerator
/*    */   extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 38 */     XmlElement answer = new XmlElement("delete");
/*    */     
/* 40 */     answer.addAttribute(new Attribute(
/* 41 */       "id", this.introspectedTable.getDeleteByPrimaryKeyStatementId()));
/*    */     String parameterClass;
/* 43 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 44 */       parameterClass = this.introspectedTable.getPrimaryKeyType();
/*    */     }
/*    */     else {
/*    */     
/* 48 */       if (this.introspectedTable.getPrimaryKeyColumns().size() > 1) {
/* 49 */         parameterClass = "map";
/*    */       } else {
/* 51 */         parameterClass = 
/* 52 */           ((IntrospectedColumn)this.introspectedTable.getPrimaryKeyColumns().get(0)).getFullyQualifiedJavaType().toString();
/*    */       }
/*    */     }
/* 55 */     answer.addAttribute(new Attribute("parameterType", 
/* 56 */       parameterClass));
/*    */     
/* 58 */     this.context.getCommentGenerator().addComment(answer);
/*    */     
/* 60 */     StringBuilder sb = new StringBuilder();
/* 61 */     sb.append("delete from ");
/* 62 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/* 63 */     answer.addElement(new TextElement(sb.toString()));
/*    */     
/* 65 */     boolean and = false;
/*    */     
/* 67 */     Iterator localIterator = this.introspectedTable.getPrimaryKeyColumns().iterator();
/* 66 */     while (localIterator.hasNext()) {
/* 67 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/* 68 */       sb.setLength(0);
/* 69 */       if (and) {
/* 70 */         sb.append("  and ");
/*    */       } else {
/* 72 */         sb.append("where ");
/* 73 */         and = true;
/*    */       }
/*    */       
/* 76 */       sb.append(
/* 77 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/* 78 */       sb.append(" = ");
/* 79 */       sb.append(
/* 80 */         MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/* 81 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */     
/*    */ 
/* 85 */     if (this.context.getPlugins().sqlMapDeleteByPrimaryKeyElementGenerated(answer, 
/* 86 */       this.introspectedTable)) {
/* 87 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\DeleteByPrimaryKeyElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */