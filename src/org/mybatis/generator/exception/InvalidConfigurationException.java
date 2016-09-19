/*    */ package org.mybatis.generator.exception;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public class InvalidConfigurationException
/*    */   extends Exception
/*    */ {
/*    */   static final long serialVersionUID = 4902307610148543411L;
/*    */   private List<String> errors;
/*    */   
/*    */   public InvalidConfigurationException(List<String> errors)
/*    */   {
/* 33 */     this.errors = errors;
/*    */   }
/*    */   
/*    */   public List<String> getErrors() {
/* 37 */     return this.errors;
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\exception\InvalidConfigurationException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */