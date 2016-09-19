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
/*    */ public class PluginConfiguration
/*    */   extends TypedPropertyHolder
/*    */ {
/*    */   public XmlElement toXmlElement()
/*    */   {
/* 36 */     XmlElement answer = new XmlElement("plugin");
/* 37 */     if (getConfigurationType() != null) {
/* 38 */       answer.addAttribute(new Attribute("type", getConfigurationType()));
/*    */     }
/*    */     
/* 41 */     addPropertyXmlElements(answer);
/*    */     
/* 43 */     return answer;
/*    */   }
/*    */   
/*    */   public void validate(List<String> errors, String contextId) {
/* 47 */     if (!StringUtility.stringHasValue(getConfigurationType())) {
/* 48 */       errors.add(
/* 49 */         Messages.getString("ValidationError.17", contextId));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\PluginConfiguration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */