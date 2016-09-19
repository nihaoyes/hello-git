/*    */ package org.mybatis.generator.logging;
/*    */ 
/*    */ import org.mybatis.generator.internal.ObjectFactory;
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
/*    */ public class LogFactory
/*    */ {
/*    */   private static AbstractLogFactory logFactory;
/*    */   
/*    */   static
/*    */   {
/*    */     try
/*    */     {
/* 34 */       ObjectFactory.internalClassForName("org.apache.log4j.Logger");
/* 35 */       logFactory = new Log4jLoggingLogFactory();
/*    */     } catch (Exception e) {
/* 37 */       logFactory = new JdkLoggingLogFactory();
/*    */     }
/*    */   }
/*    */   
/*    */   public static Log getLog(Class<?> clazz) {
/*    */     try {
/* 43 */       return logFactory.getLog(clazz);
/*    */     } catch (Throwable t) {
/* 45 */       throw new RuntimeException(
/* 46 */         Messages.getString("RuntimeError.21", clazz.getName(), t.getMessage()), t);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static synchronized void forceJavaLogging()
/*    */   {
/* 59 */     logFactory = new JdkLoggingLogFactory();
/*    */   }
/*    */   
/*    */   private static class JdkLoggingLogFactory implements AbstractLogFactory {
/*    */     public Log getLog(Class<?> clazz) {
/* 64 */       return new JdkLoggingImpl(clazz);
/*    */     }
/*    */   }
/*    */   
/*    */   private static class Log4jLoggingLogFactory implements AbstractLogFactory {
/*    */     public Log getLog(Class<?> clazz) {
/* 70 */       return new Log4jImpl(clazz);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void setLogFactory(AbstractLogFactory logFactory) {
/* 75 */     logFactory = logFactory;
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\logging\LogFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */