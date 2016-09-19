/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Properties;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
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
/*    */ public abstract class PropertyHolder
/*    */ {
/*    */   private Properties properties;
/*    */   
/*    */   public PropertyHolder()
/*    */   {
/* 35 */     this.properties = new Properties();
/*    */   }
/*    */   
/*    */   public void addProperty(String name, String value) {
/* 39 */     this.properties.setProperty(name, value);
/*    */   }
/*    */   
/*    */   public String getProperty(String name) {
/* 43 */     return this.properties.getProperty(name);
/*    */   }
/*    */   
/*    */   public Properties getProperties() {
/* 47 */     return this.properties;
/*    */   }
/*    */   
/*    */   protected void addPropertyXmlElements(XmlElement xmlElement) {
/* 51 */     Enumeration<?> enumeration = this.properties.propertyNames();
/* 52 */     while (enumeration.hasMoreElements()) {
/* 53 */       String propertyName = (String)enumeration.nextElement();
/*    */       
/* 55 */       XmlElement propertyElement = new XmlElement("property");
/* 56 */       propertyElement.addAttribute(new Attribute("name", propertyName));
/* 57 */       propertyElement.addAttribute(new Attribute(
/* 58 */         "value", this.properties.getProperty(propertyName)));
/* 59 */       xmlElement.addElement(propertyElement);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\PropertyHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */