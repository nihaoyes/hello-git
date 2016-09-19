/*     */ package org.mybatis.generator.codegen.mybatis3.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.Plugin.ModelClassType;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.RootClassInfo;
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
/*     */ public class RecordWithBLOBsGenerator
/*     */   extends AbstractJavaGenerator
/*     */ {
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  49 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  50 */     this.progressCallback.startTask(Messages.getString(
/*  51 */       "Progress.9", table.toString()));
/*  52 */     Plugin plugins = this.context.getPlugins();
/*  53 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */     
/*  55 */     TopLevelClass topLevelClass = new TopLevelClass(
/*  56 */       this.introspectedTable.getRecordWithBLOBsType());
/*  57 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*  58 */     commentGenerator.addJavaFileComment(topLevelClass);
/*     */     
/*  60 */     String rootClass = getRootClass();
/*  61 */     if (this.introspectedTable.getRules().generateBaseRecordClass()) {
/*  62 */       topLevelClass.setSuperClass(this.introspectedTable.getBaseRecordType());
/*     */     } else {
/*  64 */       topLevelClass.setSuperClass(this.introspectedTable.getPrimaryKeyType());
/*     */     }
/*     */     
/*  67 */     if (this.introspectedTable.isConstructorBased()) {
/*  68 */       addParameterizedConstructor(topLevelClass);
/*     */       
/*  70 */       if (!this.introspectedTable.isImmutable()) {
/*  71 */         addDefaultConstructor(topLevelClass);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  76 */     Iterator localIterator = this.introspectedTable.getBLOBColumns().iterator();
/*  75 */     while (localIterator.hasNext()) {
/*  76 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/*     */       
/*  78 */       if (!RootClassInfo.getInstance(rootClass, this.warnings).containsProperty(introspectedColumn))
/*     */       {
/*     */ 
/*     */ 
/*  82 */         Field field = getJavaBeansField(introspectedColumn);
/*  83 */         if (plugins.modelFieldGenerated(field, topLevelClass, 
/*  84 */           introspectedColumn, this.introspectedTable, 
/*  85 */           Plugin.ModelClassType.RECORD_WITH_BLOBS)) {
/*  86 */           topLevelClass.addField(field);
/*  87 */           topLevelClass.addImportedType(field.getType());
/*     */         }
/*     */         
/*  90 */         Method method = getJavaBeansGetter(introspectedColumn);
/*  91 */         if (plugins.modelGetterMethodGenerated(method, topLevelClass, 
/*  92 */           introspectedColumn, this.introspectedTable, 
/*  93 */           Plugin.ModelClassType.RECORD_WITH_BLOBS)) {
/*  94 */           topLevelClass.addMethod(method);
/*     */         }
/*     */         
/*  97 */         if (!this.introspectedTable.isImmutable()) {
/*  98 */           method = getJavaBeansSetter(introspectedColumn);
/*  99 */           if (plugins.modelSetterMethodGenerated(method, topLevelClass, 
/* 100 */             introspectedColumn, this.introspectedTable, 
/* 101 */             Plugin.ModelClassType.RECORD_WITH_BLOBS)) {
/* 102 */             topLevelClass.addMethod(method);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 107 */     List<CompilationUnit> answer = new ArrayList();
/* 108 */     if (this.context.getPlugins().modelRecordWithBLOBsClassGenerated(
/* 109 */       topLevelClass, this.introspectedTable)) {
/* 110 */       answer.add(topLevelClass);
/*     */     }
/* 112 */     return answer;
/*     */   }
/*     */   
/*     */   private void addParameterizedConstructor(TopLevelClass topLevelClass) {
/* 116 */     Method method = new Method();
/* 117 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 118 */     method.setConstructor(true);
/* 119 */     method.setName(topLevelClass.getType().getShortName());
/*     */     
/*     */ 
/* 122 */     Iterator localIterator1 = this.introspectedTable.getAllColumns().iterator();
/* 121 */     while (localIterator1.hasNext()) {
/* 122 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator1.next();
/* 123 */       method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), 
/* 124 */         introspectedColumn.getJavaProperty()));
/*     */     }
/*     */     
/* 127 */     boolean comma = false;
/* 128 */     StringBuilder sb = new StringBuilder();
/* 129 */     sb.append("super(");
/*     */     
/* 131 */     Iterator localIterator2 = this.introspectedTable.getNonBLOBColumns().iterator();
/* 130 */     while (localIterator2.hasNext()) {
/* 131 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator2.next();
/* 132 */       if (comma) {
/* 133 */         sb.append(", ");
/*     */       } else {
/* 135 */         comma = true;
/*     */       }
/* 137 */       sb.append(introspectedColumn.getJavaProperty());
/*     */     }
/* 139 */     sb.append(");");
/* 140 */     method.addBodyLine(sb.toString());
/*     */     
/*     */ 
/* 143 */     localIterator2 = this.introspectedTable.getBLOBColumns().iterator();
/* 142 */     while (localIterator2.hasNext()) {
/* 143 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator2.next();
/* 144 */       sb.setLength(0);
/* 145 */       sb.append("this.");
/* 146 */       sb.append(introspectedColumn.getJavaProperty());
/* 147 */       sb.append(" = ");
/* 148 */       sb.append(introspectedColumn.getJavaProperty());
/* 149 */       sb.append(';');
/* 150 */       method.addBodyLine(sb.toString());
/*     */     }
/*     */     
/* 153 */     topLevelClass.addMethod(method);
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\model\RecordWithBLOBsGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */