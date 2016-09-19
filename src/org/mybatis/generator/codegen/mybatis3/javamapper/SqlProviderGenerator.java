/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper;
/*     */ 
/*     */ import ibator.Globar;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.AbstractJavaProviderMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderApplyWhereMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderCountByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderDeleteByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderInsertSelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderSelectByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderSelectByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderUpdateByExampleSelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderUpdateByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderUpdateByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderUpdateByPrimaryKeySelectiveMethodGenerator;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SqlProviderGenerator
/*     */   extends AbstractJavaGenerator
/*     */ {
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  56 */     this.progressCallback.startTask(
/*  57 */       Messages.getString("Progress.18", this.introspectedTable.getFullyQualifiedTable().toString()));
/*  58 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */     
/*  60 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(
/*  61 */       this.introspectedTable.getMyBatis3SqlProviderType());
/*  62 */     TopLevelClass topLevelClass = new TopLevelClass(type);
/*  63 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*  64 */     commentGenerator.addJavaFileComment(topLevelClass);
/*     */     
/*  66 */     boolean addApplyWhereMethod = false;
/*  67 */     addApplyWhereMethod |= ((!Globar.ISSIMPLE) && (addCountByExampleMethod(topLevelClass)));
/*  68 */     addApplyWhereMethod |= ((!Globar.ISSIMPLE) && (addDeleteByExampleMethod(topLevelClass)));
/*  69 */     addInsertSelectiveMethod(topLevelClass);
/*  70 */     addApplyWhereMethod |= ((!Globar.ISSIMPLE) && (addSelectByExampleWithBLOBsMethod(topLevelClass)));
/*  71 */     addApplyWhereMethod |= ((!Globar.ISSIMPLE) && (addSelectByExampleWithoutBLOBsMethod(topLevelClass)));
/*  72 */     addApplyWhereMethod |= ((!Globar.ISSIMPLE) && (addUpdateByExampleSelectiveMethod(topLevelClass)));
/*  73 */     addApplyWhereMethod |= ((!Globar.ISSIMPLE) && (addUpdateByExampleWithBLOBsMethod(topLevelClass)));
/*  74 */     addApplyWhereMethod |= ((!Globar.ISSIMPLE) && (addUpdateByExampleWithoutBLOBsMethod(topLevelClass)));
/*  75 */     addUpdateByPrimaryKeySelectiveMethod(topLevelClass);
/*     */     
/*  77 */     if (addApplyWhereMethod) {
/*  78 */       addApplyWhereMethod(topLevelClass);
/*     */     }
/*     */     
/*  81 */     List<CompilationUnit> answer = new ArrayList();
/*     */     
/*  83 */     if ((topLevelClass.getMethods().size() > 0) && 
/*  84 */       (this.context.getPlugins().providerGenerated(topLevelClass, 
/*  85 */       this.introspectedTable))) {
/*  86 */       answer.add(topLevelClass);
/*     */     }
/*     */     
/*     */ 
/*  90 */     return answer;
/*     */   }
/*     */   
/*     */   protected boolean addCountByExampleMethod(TopLevelClass topLevelClass) {
/*  94 */     boolean rc = false;
/*  95 */     if (this.introspectedTable.getRules().generateCountByExample()) {
/*  96 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderCountByExampleMethodGenerator();
/*  97 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/*  98 */       rc = true;
/*     */     }
/*     */     
/* 101 */     return rc;
/*     */   }
/*     */   
/*     */   protected boolean addDeleteByExampleMethod(TopLevelClass topLevelClass) {
/* 105 */     boolean rc = false;
/* 106 */     if (this.introspectedTable.getRules().generateDeleteByExample()) {
/* 107 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderDeleteByExampleMethodGenerator();
/* 108 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/* 109 */       rc = true;
/*     */     }
/*     */     
/* 112 */     return rc;
/*     */   }
/*     */   
/*     */   protected void addInsertSelectiveMethod(TopLevelClass topLevelClass) {
/* 116 */     if (this.introspectedTable.getRules().generateInsertSelective()) {
/* 117 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderInsertSelectiveMethodGenerator();
/* 118 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean addSelectByExampleWithBLOBsMethod(TopLevelClass topLevelClass)
/*     */   {
/* 124 */     boolean rc = false;
/* 125 */     if (this.introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
/* 126 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderSelectByExampleWithBLOBsMethodGenerator();
/* 127 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/* 128 */       rc = true;
/*     */     }
/*     */     
/* 131 */     return rc;
/*     */   }
/*     */   
/*     */   protected boolean addSelectByExampleWithoutBLOBsMethod(TopLevelClass topLevelClass)
/*     */   {
/* 136 */     boolean rc = false;
/* 137 */     if (this.introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
/* 138 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderSelectByExampleWithoutBLOBsMethodGenerator();
/* 139 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/* 140 */       rc = true;
/*     */     }
/*     */     
/* 143 */     return rc;
/*     */   }
/*     */   
/*     */   protected boolean addUpdateByExampleSelectiveMethod(TopLevelClass topLevelClass)
/*     */   {
/* 148 */     boolean rc = false;
/* 149 */     if (this.introspectedTable.getRules().generateUpdateByExampleSelective()) {
/* 150 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderUpdateByExampleSelectiveMethodGenerator();
/* 151 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/* 152 */       rc = true;
/*     */     }
/*     */     
/* 155 */     return rc;
/*     */   }
/*     */   
/*     */   protected boolean addUpdateByExampleWithBLOBsMethod(TopLevelClass topLevelClass)
/*     */   {
/* 160 */     boolean rc = false;
/* 161 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
/* 162 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderUpdateByExampleWithBLOBsMethodGenerator();
/* 163 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/* 164 */       rc = true;
/*     */     }
/*     */     
/* 167 */     return rc;
/*     */   }
/*     */   
/*     */   protected boolean addUpdateByExampleWithoutBLOBsMethod(TopLevelClass topLevelClass)
/*     */   {
/* 172 */     boolean rc = false;
/* 173 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
/* 174 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderUpdateByExampleWithoutBLOBsMethodGenerator();
/* 175 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/* 176 */       rc = true;
/*     */     }
/*     */     
/* 179 */     return rc;
/*     */   }
/*     */   
/*     */   protected void addUpdateByPrimaryKeySelectiveMethod(TopLevelClass topLevelClass)
/*     */   {
/* 184 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
/* 185 */       AbstractJavaProviderMethodGenerator methodGenerator = new ProviderUpdateByPrimaryKeySelectiveMethodGenerator();
/* 186 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addApplyWhereMethod(TopLevelClass topLevelClass) {
/* 191 */     AbstractJavaProviderMethodGenerator methodGenerator = new ProviderApplyWhereMethodGenerator();
/* 192 */     initializeAndExecuteGenerator(methodGenerator, topLevelClass);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void initializeAndExecuteGenerator(AbstractJavaProviderMethodGenerator methodGenerator, TopLevelClass topLevelClass)
/*     */   {
/* 198 */     methodGenerator.setContext(this.context);
/* 199 */     methodGenerator.setIntrospectedTable(this.introspectedTable);
/* 200 */     methodGenerator.setProgressCallback(this.progressCallback);
/* 201 */     methodGenerator.setWarnings(this.warnings);
/* 202 */     methodGenerator.addClassElements(topLevelClass);
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\SqlProviderGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */