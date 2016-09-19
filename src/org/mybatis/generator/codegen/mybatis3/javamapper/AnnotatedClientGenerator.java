/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.codegen.AbstractXmlGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedCountByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedDeleteByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedDeleteByPrimaryKeyMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedInsertMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedInsertSelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedSelectByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedSelectByExampleWithBLOBsMethodGenerator2;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedSelectByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedSelectByExampleWithoutBLOBsMethodGenerator2;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedSelectByPrimaryKeyMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByPrimaryKeySelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByPrimaryKeyWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByPrimaryKeyWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class AnnotatedClientGenerator extends JavaMapperGenerator
/*     */ {
/*     */   public AnnotatedClientGenerator()
/*     */   {
/*  29 */     super(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void addCountByExampleMethod(Interface interfaze)
/*     */   {
/*  36 */     if (this.introspectedTable.getRules().generateCountByExample()) {
/*  37 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedCountByExampleMethodGenerator();
/*  38 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addDeleteByExampleMethod(Interface interfaze)
/*     */   {
/*  44 */     if (this.introspectedTable.getRules().generateDeleteByExample()) {
/*  45 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedDeleteByExampleMethodGenerator();
/*  46 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addDeleteByPrimaryKeyMethod(Interface interfaze)
/*     */   {
/*  52 */     if (this.introspectedTable.getRules().generateDeleteByPrimaryKey()) {
/*  53 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedDeleteByPrimaryKeyMethodGenerator();
/*  54 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addInsertMethod(Interface interfaze)
/*     */   {
/*  60 */     if (this.introspectedTable.getRules().generateInsert()) {
/*  61 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedInsertMethodGenerator();
/*  62 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addInsertSelectiveMethod(Interface interfaze)
/*     */   {
/*  68 */     if (this.introspectedTable.getRules().generateInsertSelective()) {
/*  69 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedInsertSelectiveMethodGenerator();
/*  70 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addSelectByExampleWithBLOBsMethod(Interface interfaze)
/*     */   {
/*  76 */     if (this.introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
/*  77 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedSelectByExampleWithBLOBsMethodGenerator();
/*  78 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addSelectByExampleWithoutBLOBsMethod(Interface interfaze)
/*     */   {
/*  84 */     if (this.introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
/*  85 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedSelectByExampleWithoutBLOBsMethodGenerator();
/*  86 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addSelectByExampleWithBLOBsMethod2(Interface interfaze)
/*     */   {
/*  92 */     if (this.introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
/*  93 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedSelectByExampleWithBLOBsMethodGenerator2();
/*  94 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addSelectByExampleWithoutBLOBsMethod2(Interface interfaze)
/*     */   {
/* 100 */     if (this.introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
/* 101 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedSelectByExampleWithoutBLOBsMethodGenerator2();
/* 102 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void addSelectByPrimaryKeyMethod(Interface interfaze)
/*     */   {
/* 110 */     if (this.introspectedTable.getRules().generateSelectByPrimaryKey()) {
/* 111 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedSelectByPrimaryKeyMethodGenerator(false);
/* 112 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addUpdateByExampleSelectiveMethod(Interface interfaze)
/*     */   {
/* 118 */     if (this.introspectedTable.getRules().generateUpdateByExampleSelective()) {
/* 119 */       AbstractJavaMapperMethodGenerator methodGenerator = new org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated.AnnotatedUpdateByExampleSelectiveMethodGenerator();
/* 120 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addUpdateByExampleWithBLOBsMethod(Interface interfaze)
/*     */   {
/* 126 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
/* 127 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedUpdateByExampleWithBLOBsMethodGenerator();
/* 128 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addUpdateByExampleWithoutBLOBsMethod(Interface interfaze)
/*     */   {
/* 134 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
/* 135 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedUpdateByExampleWithoutBLOBsMethodGenerator();
/* 136 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addUpdateByPrimaryKeySelectiveMethod(Interface interfaze)
/*     */   {
/* 142 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
/* 143 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedUpdateByPrimaryKeySelectiveMethodGenerator();
/* 144 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addUpdateByPrimaryKeyWithBLOBsMethod(Interface interfaze)
/*     */   {
/* 150 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
/* 151 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedUpdateByPrimaryKeyWithBLOBsMethodGenerator();
/* 152 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithoutBLOBsMethod(Interface interfaze)
/*     */   {
/* 159 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithoutBLOBs()) {
/* 160 */       AbstractJavaMapperMethodGenerator methodGenerator = new AnnotatedUpdateByPrimaryKeyWithoutBLOBsMethodGenerator();
/* 161 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.List<CompilationUnit> getExtraCompilationUnits()
/*     */   {
/* 167 */     SqlProviderGenerator sqlProviderGenerator = new SqlProviderGenerator();
/* 168 */     sqlProviderGenerator.setContext(this.context);
/* 169 */     sqlProviderGenerator.setIntrospectedTable(this.introspectedTable);
/* 170 */     sqlProviderGenerator.setProgressCallback(this.progressCallback);
/* 171 */     sqlProviderGenerator.setWarnings(this.warnings);
/* 172 */     return sqlProviderGenerator.getCompilationUnits();
/*     */   }
/*     */   
/*     */ 
/*     */   public AbstractXmlGenerator getMatchedXMLGenerator()
/*     */   {
/* 178 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\AnnotatedClientGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */