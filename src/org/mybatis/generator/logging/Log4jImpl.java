/*    */ package org.mybatis.generator.logging;
/*    */ 
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class Log4jImpl
/*    */   implements Log
/*    */ {
/*    */   private Logger log;
/*    */   
/*    */   public Log4jImpl(Class<?> clazz)
/*    */   {
/* 30 */     this.log = Logger.getLogger(clazz);
/*    */   }
/*    */   
/*    */   public boolean isDebugEnabled() {
/* 34 */     return this.log.isDebugEnabled();
/*    */   }
/*    */   
/*    */   public void error(String s, Throwable e) {
/* 38 */     this.log.error(s, e);
/*    */   }
/*    */   
/*    */   public void error(String s) {
/* 42 */     this.log.error(s);
/*    */   }
/*    */   
/*    */   public void debug(String s) {
/* 46 */     this.log.debug(s);
/*    */   }
/*    */   
/*    */   public void warn(String s) {
/* 50 */     this.log.warn(s);
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\logging\Log4jImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */