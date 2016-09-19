/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper;
/*    */ 
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.codegen.AbstractXmlGenerator;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedDeleteByPrimaryKeyMethodGenerator;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedInsertMethodGenerator;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedSelectByPrimaryKeyMethodGenerator;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByPrimaryKeyWithBLOBsMethodGenerator;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByPrimaryKeyWithoutBLOBsMethodGenerator;
/*    */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.MixedMapperGenerator;
/*    */ import org.mybatis.generator.internal.rules.Rules;
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
/*    */ public class MixedClientGenerator
/*    */   extends JavaMapperGenerator
/*    */ {
/*    */   public MixedClientGenerator()
/*    */   {
/* 38 */     super(true);
/*    */   }
/*    */   
/*    */   protected void addDeleteByPrimaryKeyMethod(Interface interfaze)
/*    */   {
/* 43 */     if (this.introspectedTable.getRules().generateDeleteByPrimaryKey()) {
/* 44 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedDeleteByPrimaryKeyMethodGenerator();
/* 45 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void addInsertMethod(Interface interfaze)
/*    */   {
/* 51 */     if (this.introspectedTable.getRules().generateInsert()) {
/* 52 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedInsertMethodGenerator();
/* 53 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void addSelectByPrimaryKeyMethod(Interface interfaze)
/*    */   {
/* 59 */     if (this.introspectedTable.getRules().generateSelectByPrimaryKey()) {
/* 60 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedSelectByPrimaryKeyMethodGenerator(true);
/* 61 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void addUpdateByPrimaryKeyWithBLOBsMethod(Interface interfaze)
/*    */   {
/* 67 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
/* 68 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedUpdateByPrimaryKeyWithBLOBsMethodGenerator();
/* 69 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected void addUpdateByPrimaryKeyWithoutBLOBsMethod(Interface interfaze)
/*    */   {
/* 76 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithoutBLOBs()) {
/* 77 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedUpdateByPrimaryKeyWithoutBLOBsMethodGenerator();
/* 78 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractXmlGenerator getMatchedXMLGenerator()
/*    */   {
/* 84 */     return new MixedMapperGenerator();
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\MixedClientGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */