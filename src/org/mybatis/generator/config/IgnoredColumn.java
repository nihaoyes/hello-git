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
/*    */ public class IgnoredColumn
/*    */ {
/*    */   private String columnName;
/*    */   private boolean isColumnNameDelimited;
/*    */   private String configuredDelimitedColumnName;
/*    */   
/*    */   public IgnoredColumn(String columnName)
/*    */   {
/* 45 */     this.columnName = columnName;
/* 46 */     this.isColumnNameDelimited = StringUtility.stringContainsSpace(columnName);
/*    */   }
/*    */   
/*    */   public String getColumnName() {
/* 50 */     return this.columnName;
/*    */   }
/*    */   
/*    */   public boolean isColumnNameDelimited() {
/* 54 */     return this.isColumnNameDelimited;
/*    */   }
/*    */   
/*    */   public void setColumnNameDelimited(boolean isColumnNameDelimited) {
/* 58 */     this.isColumnNameDelimited = isColumnNameDelimited;
/* 59 */     this.configuredDelimitedColumnName = (isColumnNameDelimited ? "true" : "false");
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj) {
/* 63 */     if ((obj == null) || (!(obj instanceof IgnoredColumn))) {
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     return this.columnName.equals(((IgnoredColumn)obj).getColumnName());
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     return this.columnName.hashCode();
/*    */   }
/*    */   
/*    */   public XmlElement toXmlElement() {
/* 75 */     XmlElement xmlElement = new XmlElement("ignoreColumn");
/* 76 */     xmlElement.addAttribute(new Attribute("column", this.columnName));
/*    */     
/* 78 */     if (StringUtility.stringHasValue(this.configuredDelimitedColumnName)) {
/* 79 */       xmlElement.addAttribute(new Attribute(
/* 80 */         "delimitedColumnName", this.configuredDelimitedColumnName));
/*    */     }
/*    */     
/* 83 */     return xmlElement;
/*    */   }
/*    */   
/*    */   public void validate(List<String> errors, String tableName) {
/* 87 */     if (!StringUtility.stringHasValue(this.columnName)) {
/* 88 */       errors.add(
/* 89 */         Messages.getString("ValidationError.21", tableName));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\IgnoredColumn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */