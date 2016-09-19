/*     */ package org.mybatis.generator.config;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
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
/*     */ public class ColumnOverride
/*     */   extends PropertyHolder
/*     */ {
/*     */   private String columnName;
/*     */   private String javaProperty;
/*     */   private String jdbcType;
/*     */   private String javaType;
/*     */   private String typeHandler;
/*     */   private boolean isColumnNameDelimited;
/*     */   private String configuredDelimitedColumnName;
/*     */   
/*     */   public ColumnOverride(String columnName)
/*     */   {
/*  52 */     this.columnName = columnName;
/*  53 */     this.isColumnNameDelimited = StringUtility.stringContainsSpace(columnName);
/*     */   }
/*     */   
/*     */   public String getColumnName() {
/*  57 */     return this.columnName;
/*     */   }
/*     */   
/*     */   public String getJavaProperty() {
/*  61 */     return this.javaProperty;
/*     */   }
/*     */   
/*     */   public void setJavaProperty(String javaProperty) {
/*  65 */     this.javaProperty = javaProperty;
/*     */   }
/*     */   
/*     */   public String getJavaType() {
/*  69 */     return this.javaType;
/*     */   }
/*     */   
/*     */   public void setJavaType(String javaType) {
/*  73 */     this.javaType = javaType;
/*     */   }
/*     */   
/*     */   public String getJdbcType() {
/*  77 */     return this.jdbcType;
/*     */   }
/*     */   
/*     */   public void setJdbcType(String jdbcType) {
/*  81 */     this.jdbcType = jdbcType;
/*     */   }
/*     */   
/*     */   public String getTypeHandler() {
/*  85 */     return this.typeHandler;
/*     */   }
/*     */   
/*     */   public void setTypeHandler(String typeHandler) {
/*  89 */     this.typeHandler = typeHandler;
/*     */   }
/*     */   
/*     */   public XmlElement toXmlElement() {
/*  93 */     XmlElement xmlElement = new XmlElement("columnOverride");
/*  94 */     xmlElement.addAttribute(new Attribute("column", this.columnName));
/*     */     
/*  96 */     if (StringUtility.stringHasValue(this.javaProperty)) {
/*  97 */       xmlElement.addAttribute(new Attribute("property", this.javaProperty));
/*     */     }
/*     */     
/* 100 */     if (StringUtility.stringHasValue(this.javaType)) {
/* 101 */       xmlElement.addAttribute(new Attribute("javaType", this.javaType));
/*     */     }
/*     */     
/* 104 */     if (StringUtility.stringHasValue(this.jdbcType)) {
/* 105 */       xmlElement.addAttribute(new Attribute("jdbcType", this.jdbcType));
/*     */     }
/*     */     
/* 108 */     if (StringUtility.stringHasValue(this.typeHandler)) {
/* 109 */       xmlElement.addAttribute(new Attribute("typeHandler", this.typeHandler));
/*     */     }
/*     */     
/* 112 */     if (StringUtility.stringHasValue(this.configuredDelimitedColumnName)) {
/* 113 */       xmlElement.addAttribute(new Attribute(
/* 114 */         "delimitedColumnName", this.configuredDelimitedColumnName));
/*     */     }
/*     */     
/* 117 */     addPropertyXmlElements(xmlElement);
/*     */     
/* 119 */     return xmlElement;
/*     */   }
/*     */   
/*     */   public boolean isColumnNameDelimited() {
/* 123 */     return this.isColumnNameDelimited;
/*     */   }
/*     */   
/*     */   public void setColumnNameDelimited(boolean isColumnNameDelimited) {
/* 127 */     this.isColumnNameDelimited = isColumnNameDelimited;
/*     */     
/* 129 */     this.configuredDelimitedColumnName = (isColumnNameDelimited ? "true" : "false");
/*     */   }
/*     */   
/*     */   public void validate(List<String> errors, String tableName) {
/* 133 */     if (!StringUtility.stringHasValue(this.columnName)) {
/* 134 */       errors.add(
/* 135 */         Messages.getString("ValidationError.22", tableName));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\ColumnOverride.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */