/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*    */ import org.mybatis.generator.config.Context;
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
/*    */ public class ProviderUpdateByExampleWithBLOBsMethodGenerator
/*    */   extends ProviderUpdateByExampleWithoutBLOBsMethodGenerator
/*    */ {
/*    */   public String getMethodName()
/*    */   {
/* 38 */     return this.introspectedTable.getUpdateByExampleWithBLOBsStatementId();
/*    */   }
/*    */   
/*    */   public List<IntrospectedColumn> getColumns()
/*    */   {
/* 43 */     return this.introspectedTable.getAllColumns();
/*    */   }
/*    */   
/*    */   public boolean callPlugins(Method method, TopLevelClass topLevelClass)
/*    */   {
/* 48 */     return this.context.getPlugins().providerUpdateByExampleWithBLOBsMethodGenerated(method, topLevelClass, 
/* 49 */       this.introspectedTable);
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderUpdateByExampleWithBLOBsMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */