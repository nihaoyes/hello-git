/*    */ package org.mybatis.generator.config.xml;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.xml.sax.EntityResolver;
/*    */ import org.xml.sax.InputSource;
/*    */ import org.xml.sax.SAXException;
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
/*    */ public class ParserEntityResolver
/*    */   implements EntityResolver
/*    */ {
/*    */   public InputSource resolveEntity(String publicId, String systemId)
/*    */     throws SAXException, IOException
/*    */   {
/* 46 */     if ("-//Apache Software Foundation//DTD Apache iBATIS Ibator Configuration 1.0//EN".equalsIgnoreCase(publicId)) {
/* 47 */       InputStream is = getClass().getClassLoader().getResourceAsStream(
/* 48 */         "org/mybatis/generator/config/xml/ibator-config_1_0.dtd");
/* 49 */       InputSource ins = new InputSource(is);
/*    */       
/* 51 */       return ins;
/*    */     }
/* 53 */     if ("-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN".equalsIgnoreCase(publicId)) {
/* 54 */       InputStream is = getClass()
/* 55 */         .getClassLoader()
/* 56 */         .getResourceAsStream(
/* 57 */         "org/mybatis/generator/config/xml/mybatis-generator-config_1_0.dtd");
/* 58 */       InputSource ins = new InputSource(is);
/*    */       
/* 60 */       return ins;
/*    */     }
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\xml\ParserEntityResolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */