/*    */ package org.mybatis.generator.logging;
/*    */ 
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.LogRecord;
/*    */ import java.util.logging.Logger;
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
/*    */ public class JdkLoggingImpl
/*    */   implements Log
/*    */ {
/*    */   private Logger log;
/*    */   
/*    */   public JdkLoggingImpl(Class<?> clazz)
/*    */   {
/* 33 */     this.log = Logger.getLogger(clazz.getName());
/*    */   }
/*    */   
/*    */   public boolean isDebugEnabled() {
/* 37 */     return this.log.isLoggable(Level.FINE);
/*    */   }
/*    */   
/*    */   public void error(String s, Throwable e) {
/* 41 */     LogRecord lr = new LogRecord(Level.SEVERE, s);
/* 42 */     lr.setSourceClassName(this.log.getName());
/* 43 */     lr.setThrown(e);
/*    */     
/* 45 */     this.log.log(lr);
/*    */   }
/*    */   
/*    */   public void error(String s) {
/* 49 */     LogRecord lr = new LogRecord(Level.SEVERE, s);
/* 50 */     lr.setSourceClassName(this.log.getName());
/*    */     
/* 52 */     this.log.log(lr);
/*    */   }
/*    */   
/*    */   public void debug(String s) {
/* 56 */     LogRecord lr = new LogRecord(Level.FINE, s);
/* 57 */     lr.setSourceClassName(this.log.getName());
/*    */     
/* 59 */     this.log.log(lr);
/*    */   }
/*    */   
/*    */   public void warn(String s) {
/* 63 */     LogRecord lr = new LogRecord(Level.WARNING, s);
/* 64 */     lr.setSourceClassName(this.log.getName());
/*    */     
/* 66 */     this.log.log(lr);
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\logging\JdkLoggingImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */