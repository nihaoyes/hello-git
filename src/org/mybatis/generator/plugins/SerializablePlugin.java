/*    */ package org.mybatis.generator.plugins;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.PluginAdapter;
/*    */ import org.mybatis.generator.api.dom.java.Field;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SerializablePlugin
/*    */   extends PluginAdapter
/*    */ {
/*    */   private FullyQualifiedJavaType serializable;
/*    */   
/*    */   public SerializablePlugin()
/*    */   {
/* 46 */     this.serializable = new FullyQualifiedJavaType("java.io.Serializable");
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean validate(List<String> warnings)
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*    */   {
/* 58 */     makeSerializable(topLevelClass, introspectedTable);
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*    */   {
/* 65 */     makeSerializable(topLevelClass, introspectedTable);
/* 66 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*    */   {
/* 72 */     makeSerializable(topLevelClass, introspectedTable);
/* 73 */     return true;
/*    */   }
/*    */   
/*    */   protected void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*    */   {
/* 78 */     topLevelClass.addImportedType(this.serializable);
/* 79 */     topLevelClass.addSuperInterface(this.serializable);
/*    */     
/* 81 */     Field field = new Field();
/* 82 */     field.setFinal(true);
/* 83 */     field.setInitializationString("1L");
/* 84 */     field.setName("serialVersionUID");
/* 85 */     field.setStatic(true);
/* 86 */     field.setType(new FullyQualifiedJavaType("long"));
/* 87 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 88 */     this.context.getCommentGenerator().addFieldComment(field, introspectedTable);
/*    */     
/* 90 */     topLevelClass.addField(field);
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\plugins\SerializablePlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */