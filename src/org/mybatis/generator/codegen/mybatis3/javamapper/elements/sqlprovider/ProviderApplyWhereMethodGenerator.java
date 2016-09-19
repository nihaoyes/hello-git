/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.config.Context;
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
/*     */ public class ProviderApplyWhereMethodGenerator
/*     */   extends AbstractJavaProviderMethodGenerator
/*     */ {
/*  30 */   private static final String[] methodLines = {
/*  31 */     "if (example == null) {", 
/*  32 */     "return;", 
/*  33 */     "}", 
/*  34 */     "", 
/*  35 */     "String parmPhrase1;", 
/*  36 */     "String parmPhrase1_th;", 
/*  37 */     "String parmPhrase2;", 
/*  38 */     "String parmPhrase2_th;", 
/*  39 */     "String parmPhrase3;", 
/*  40 */     "String parmPhrase3_th;", 
/*  41 */     "if (includeExamplePhrase) {", 
/*  42 */     "parmPhrase1 = \"%s #{example.oredCriteria[%d].allCriteria[%d].value}\";", 
/*  43 */     "parmPhrase1_th = \"%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}\";", 
/*  44 */     "parmPhrase2 = \"%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}\";", 
/*  45 */     "parmPhrase2_th = \"%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}\";", 
/*  46 */     "parmPhrase3 = \"#{example.oredCriteria[%d].allCriteria[%d].value[%d]}\";", 
/*  47 */     "parmPhrase3_th = \"#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}\";", 
/*  48 */     "} else {", 
/*  49 */     "parmPhrase1 = \"%s #{oredCriteria[%d].allCriteria[%d].value}\";", 
/*  50 */     "parmPhrase1_th = \"%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}\";", 
/*  51 */     "parmPhrase2 = \"%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}\";", 
/*  52 */     "parmPhrase2_th = \"%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}\";", 
/*  53 */     "parmPhrase3 = \"#{oredCriteria[%d].allCriteria[%d].value[%d]}\";", 
/*  54 */     "parmPhrase3_th = \"#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}\";", 
/*  55 */     "}", 
/*  56 */     "", 
/*  57 */     "StringBuilder sb = new StringBuilder();", 
/*  58 */     "List<Criteria> oredCriteria = example.getOredCriteria();", 
/*  59 */     "boolean firstCriteria = true;", 
/*  60 */     "for (int i = 0; i < oredCriteria.size(); i++) {", 
/*  61 */     "Criteria criteria = oredCriteria.get(i);", 
/*  62 */     "if (criteria.isValid()) {", 
/*  63 */     "if (firstCriteria) {", 
/*  64 */     "firstCriteria = false;", 
/*  65 */     "} else {", 
/*  66 */     "sb.append(\" or \");", 
/*  67 */     "}", 
/*  68 */     "", 
/*  69 */     "sb.append('(');", 
/*  70 */     "List<Criterion> criterions = criteria.getAllCriteria();", 
/*  71 */     "boolean firstCriterion = true;", 
/*  72 */     "for (int j = 0; j < criterions.size(); j++) {", 
/*  73 */     "Criterion criterion = criterions.get(j);", 
/*  74 */     "if (firstCriterion) {", 
/*  75 */     "firstCriterion = false;", 
/*  76 */     "} else {", 
/*  77 */     "sb.append(\" and \");", 
/*  78 */     "}", 
/*  79 */     "", 
/*  80 */     "if (criterion.isNoValue()) {", 
/*  81 */     "sb.append(criterion.getCondition());", 
/*  82 */     "} else if (criterion.isSingleValue()) {", 
/*  83 */     "if (criterion.getTypeHandler() == null) {", 
/*  84 */     "sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));", 
/*  85 */     "} else {", 
/*  86 */     "sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));", 
/*  87 */     "}", 
/*  88 */     "} else if (criterion.isBetweenValue()) {", 
/*  89 */     "if (criterion.getTypeHandler() == null) {", 
/*  90 */     "sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));", 
/*  91 */     "} else {", 
/*  92 */     "sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));", 
/*  93 */     "}", 
/*  94 */     "} else if (criterion.isListValue()) {", 
/*  95 */     "sb.append(criterion.getCondition());", 
/*  96 */     "sb.append(\" (\");", 
/*  97 */     "List<?> listItems = (List<?>) criterion.getValue();", 
/*  98 */     "boolean comma = false;", 
/*  99 */     "for (int k = 0; k < listItems.size(); k++) {", 
/* 100 */     "if (comma) {", 
/* 101 */     "sb.append(\", \");", 
/* 102 */     "} else {", 
/* 103 */     "comma = true;", 
/* 104 */     "}", 
/* 105 */     "if (criterion.getTypeHandler() == null) {", 
/* 106 */     "sb.append(String.format(parmPhrase3, i, j, k));", 
/* 107 */     "} else {", 
/* 108 */     "sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));", 
/* 109 */     "}", 
/* 110 */     "}", 
/* 111 */     "sb.append(')');", 
/* 112 */     "}", 
/* 113 */     "}", 
/* 114 */     "sb.append(')');", 
/* 115 */     "}", 
/* 116 */     "}", 
/* 117 */     "", 
/* 118 */     "if (sb.length() > 0) {", 
/* 119 */     "WHERE(sb.toString());", 
/* 120 */     "}" };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addClassElements(TopLevelClass topLevelClass)
/*     */   {
/* 129 */     Set<String> staticImports = new TreeSet();
/* 130 */     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
/*     */     
/* 132 */     staticImports.add("org.apache.ibatis.jdbc.SqlBuilder.WHERE");
/* 133 */     importedTypes.add(new FullyQualifiedJavaType(
/* 134 */       "java.util.List"));
/*     */     
/* 136 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/* 137 */     importedTypes.add(fqjt);
/* 138 */     importedTypes.add(new FullyQualifiedJavaType(
/* 139 */       String.format("%s.Criteria", new Object[] { fqjt.getFullyQualifiedName() })));
/* 140 */     importedTypes.add(new FullyQualifiedJavaType(
/* 141 */       String.format("%s.Criterion", new Object[] { fqjt.getFullyQualifiedName() })));
/*     */     
/* 143 */     Method method = new Method("applyWhere");
/* 144 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 145 */     method.addParameter(new Parameter(fqjt, "example"));
/* 146 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getBooleanPrimitiveInstance(), "includeExamplePhrase"));
/*     */     
/* 148 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 149 */       this.introspectedTable);
/*     */     String[] arrayOfString;
/* 151 */     int j = (arrayOfString = methodLines).length; for (int i = 0; i < j; i++) { String methodLine = arrayOfString[i];
/* 152 */       method.addBodyLine(methodLine);
/*     */     }
/*     */     
/* 155 */     if (this.context.getPlugins().providerApplyWhereMethodGenerated(method, topLevelClass, 
/* 156 */       this.introspectedTable)) {
/* 157 */       topLevelClass.addStaticImports(staticImports);
/* 158 */       topLevelClass.addImportedTypes(importedTypes);
/* 159 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\sqlprovider\ProviderApplyWhereMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */