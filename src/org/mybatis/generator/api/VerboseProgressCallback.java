/*    */ package org.mybatis.generator.api;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.mybatis.generator.internal.NullProgressCallback;
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
/*    */ public class VerboseProgressCallback
/*    */   extends NullProgressCallback
/*    */ {
/*    */   public void startTask(String taskName)
/*    */   {
/* 36 */     System.out.println(taskName);
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\api\VerboseProgressCallback.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */