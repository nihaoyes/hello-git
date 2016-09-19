/*    */ package org.mybatis.generator.config;
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
/*    */ public abstract class TypedPropertyHolder
/*    */   extends PropertyHolder
/*    */ {
/*    */   private String configurationType;
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
/*    */   public String getConfigurationType()
/*    */   {
/* 33 */     return this.configurationType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setConfigurationType(String configurationType)
/*    */   {
/* 44 */     if (!"DEFAULT".equalsIgnoreCase(configurationType)) {
/* 45 */       this.configurationType = configurationType;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\TypedPropertyHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */