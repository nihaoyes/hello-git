/*    */ package org.mybatis.generator.codegen;
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
/*    */ public abstract class AbstractJavaClientGenerator
/*    */   extends AbstractJavaGenerator
/*    */ {
/*    */   private boolean requiresXMLGenerator;
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
/*    */   public AbstractJavaClientGenerator(boolean requiresXMLGenerator)
/*    */   {
/* 33 */     this.requiresXMLGenerator = requiresXMLGenerator;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean requiresXMLGenerator()
/*    */   {
/* 40 */     return this.requiresXMLGenerator;
/*    */   }
/*    */   
/*    */   public abstract AbstractXmlGenerator getMatchedXMLGenerator();
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\AbstractJavaClientGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */