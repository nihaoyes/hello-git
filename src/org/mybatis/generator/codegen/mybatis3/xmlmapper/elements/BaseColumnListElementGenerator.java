/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
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
/*    */ public class BaseColumnListElementGenerator
/*    */   extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 39 */     XmlElement answer = new XmlElement("sql");
/*    */     
/* 41 */     answer.addAttribute(new Attribute("id", 
/* 42 */       this.introspectedTable.getBaseColumnListId()));
/*    */     
/* 44 */     this.context.getCommentGenerator().addComment(answer);
/*    */     
/* 46 */     StringBuilder sb = new StringBuilder();
/* 47 */     Iterator<IntrospectedColumn> iter = this.introspectedTable
/* 48 */       .getNonBLOBColumns().iterator();
/* 49 */     while (iter.hasNext()) {
/* 50 */       sb.append(MyBatis3FormattingUtilities.getSelectListPhrase(
/* 51 */         (IntrospectedColumn)iter.next()));
/*    */       
/* 53 */       if (iter.hasNext()) {
/* 54 */         sb.append(", ");
/*    */       }
/*    */       
/* 57 */       if (sb.length() > 80) {
/* 58 */         answer.addElement(new TextElement(sb.toString()));
/* 59 */         sb.setLength(0);
/*    */       }
/*    */     }
/*    */     
/* 63 */     if (sb.length() > 0) {
/* 64 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */     
/* 67 */     if (this.context.getPlugins().sqlMapBaseColumnListElementGenerated(
/* 68 */       answer, this.introspectedTable)) {
/* 69 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\BaseColumnListElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */