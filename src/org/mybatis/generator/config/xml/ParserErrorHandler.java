/*    */ package org.mybatis.generator.config.xml;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ import org.xml.sax.ErrorHandler;
/*    */ import org.xml.sax.SAXException;
/*    */ import org.xml.sax.SAXParseException;
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
/*    */ public class ParserErrorHandler
/*    */   implements ErrorHandler
/*    */ {
/*    */   private List<String> warnings;
/*    */   private List<String> errors;
/*    */   
/*    */   public ParserErrorHandler(List<String> warnings, List<String> errors)
/*    */   {
/* 39 */     this.warnings = warnings;
/* 40 */     this.errors = errors;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void warning(SAXParseException exception)
/*    */     throws SAXException
/*    */   {
/* 49 */     this.warnings.add(
/*    */     
/* 51 */       Messages.getString("Warning.7", Integer.toString(exception.getLineNumber()), exception.getMessage()));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void error(SAXParseException exception)
/*    */     throws SAXException
/*    */   {
/* 60 */     this.errors.add(
/*    */     
/* 62 */       Messages.getString("RuntimeError.4", Integer.toString(exception.getLineNumber()), exception.getMessage()));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void fatalError(SAXParseException exception)
/*    */     throws SAXException
/*    */   {
/* 71 */     this.errors.add(
/*    */     
/* 73 */       Messages.getString("RuntimeError.4", Integer.toString(exception.getLineNumber()), exception.getMessage()));
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\xml\ParserErrorHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */