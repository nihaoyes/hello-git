/*    */ package org.mybatis.generator.api;
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
/*    */ public abstract class GeneratedFile
/*    */ {
/*    */   private String targetProject;
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
/*    */   public GeneratedFile(String targetProject)
/*    */   {
/* 31 */     this.targetProject = targetProject;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getFormattedContent();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getFileName();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getTargetProject()
/*    */   {
/* 60 */     return this.targetProject;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract String getTargetPackage();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String toString()
/*    */   {
/* 73 */     return getFormattedContent();
/*    */   }
/*    */   
/*    */   public abstract boolean isMergeable();
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\api\GeneratedFile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */