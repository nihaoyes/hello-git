/*     */ package org.mybatis.generator.plugins;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.PluginAdapter;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.InnerClass;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
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
/*     */ public class CaseInsensitiveLikePlugin
/*     */   extends PluginAdapter
/*     */ {
/*     */   public boolean validate(List<String> warnings)
/*     */   {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  59 */     InnerClass criteria = null;
/*     */     
/*  61 */     for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
/*  62 */       if ("Criteria".equals(innerClass.getType().getShortName())) {
/*  63 */         criteria = innerClass;
/*  64 */         break;
/*     */       }
/*     */     }
/*     */     
/*  68 */     if (criteria == null)
/*     */     {
/*  70 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  74 */      Iterator iterator = introspectedTable.getNonBLOBColumns().iterator();
/*  73 */     while (iterator.hasNext()) {
/*  74 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterator.next();
/*  75 */       if ((introspectedColumn.isJdbcCharacterColumn()) && 
/*  76 */         (introspectedColumn.isStringColumn()))
/*     */       {
/*     */ 
/*     */ 
/*  80 */         Method method = new Method();
/*  81 */         method.setVisibility(JavaVisibility.PUBLIC);
/*  82 */         method.addParameter(new Parameter(
/*  83 */           introspectedColumn.getFullyQualifiedJavaType(), "value"));
/*     */         
/*  85 */         StringBuilder sb = new StringBuilder();
/*  86 */         sb.append(introspectedColumn.getJavaProperty());
/*  87 */         sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/*  88 */         sb.insert(0, "and");
/*  89 */         sb.append("LikeInsensitive");
/*  90 */         method.setName(sb.toString());
/*  91 */         method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/*     */         
/*  93 */         sb.setLength(0);
/*  94 */         sb.append("addCriterion(\"upper(");
/*     */         
/*     */ 
/*  97 */         sb.append(") like\", value.toUpperCase(), \"");
/*  98 */         sb.append(introspectedColumn.getJavaProperty());
/*  99 */         sb.append("\");");
/* 100 */         method.addBodyLine(sb.toString());
/* 101 */         method.addBodyLine("return this;");
/*     */         
/* 103 */         criteria.addMethod(method);
/*     */       }
/*     */     }
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\plugins\CaseInsensitiveLikePlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */