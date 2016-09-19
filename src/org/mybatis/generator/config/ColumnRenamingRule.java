/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ColumnRenamingRule
/*    */ {
/*    */   private String searchString;
/*    */   private String replaceString;
/*    */   
/*    */   public String getReplaceString()
/*    */   {
/* 62 */     return this.replaceString;
/*    */   }
/*    */   
/*    */   public void setReplaceString(String replaceString) {
/* 66 */     this.replaceString = replaceString;
/*    */   }
/*    */   
/*    */   public String getSearchString() {
/* 70 */     return this.searchString;
/*    */   }
/*    */   
/*    */   public void setSearchString(String searchString) {
/* 74 */     this.searchString = searchString;
/*    */   }
/*    */   
/*    */   public void validate(List<String> errors, String tableName) {
/* 78 */     if (!StringUtility.stringHasValue(this.searchString)) {
/* 79 */       errors.add(Messages.getString("ValidationError.14", tableName));
/*    */     }
/*    */   }
/*    */   
/*    */   public XmlElement toXmlElement() {
/* 84 */     XmlElement xmlElement = new XmlElement("columnRenamingRule");
/* 85 */     xmlElement.addAttribute(new Attribute("searchString", this.searchString));
/*    */     
/* 87 */     if (this.replaceString != null) {
/* 88 */       xmlElement.addAttribute(new Attribute(
/* 89 */         "replaceString", this.replaceString));
/*    */     }
/*    */     
/* 92 */     return xmlElement;
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\ColumnRenamingRule.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */