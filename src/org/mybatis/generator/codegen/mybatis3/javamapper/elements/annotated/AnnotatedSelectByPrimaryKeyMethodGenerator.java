/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByPrimaryKeyMethodGenerator;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
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
/*     */ public class AnnotatedSelectByPrimaryKeyMethodGenerator
/*     */   extends SelectByPrimaryKeyMethodGenerator
/*     */ {
/*     */   private boolean useResultMapIfAvailable;
/*     */   
/*     */   public AnnotatedSelectByPrimaryKeyMethodGenerator(boolean useResultMapIfAvailable)
/*     */   {
/*  43 */     this.useResultMapIfAvailable = useResultMapIfAvailable;
/*     */   }
/*     */   
/*     */   public void addMapperAnnotations(Interface interfaze, Method method)
/*     */   {
/*  48 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Select"));
/*     */     
/*  50 */     StringBuilder sb = new StringBuilder();
/*  51 */     method.addAnnotation("@Select({");
/*  52 */     OutputUtilities.javaIndent(sb, 1);
/*  53 */     sb.append("\"select\",");
/*  54 */     method.addAnnotation(sb.toString());
/*     */     
/*  56 */     Iterator<IntrospectedColumn> iter = this.introspectedTable
/*  57 */       .getAllColumns().iterator();
/*  58 */     sb.setLength(0);
/*  59 */     OutputUtilities.javaIndent(sb, 1);
/*  60 */     sb.append('"');
/*  61 */     boolean hasColumns = false;
/*  62 */     while (iter.hasNext()) {
/*  63 */       sb.append(StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getSelectListPhrase((IntrospectedColumn)iter.next())));
/*  64 */       hasColumns = true;
/*     */       
/*  66 */       if (iter.hasNext()) {
/*  67 */         sb.append(", ");
/*     */       }
/*     */       
/*  70 */       if (sb.length() > 80) {
/*  71 */         sb.append("\",");
/*  72 */         method.addAnnotation(sb.toString());
/*     */         
/*  74 */         sb.setLength(0);
/*  75 */         OutputUtilities.javaIndent(sb, 1);
/*  76 */         sb.append('"');
/*  77 */         hasColumns = false;
/*     */       }
/*     */     }
/*     */     
/*  81 */     if (hasColumns) {
/*  82 */       sb.append("\",");
/*  83 */       method.addAnnotation(sb.toString());
/*     */     }
/*     */     
/*  86 */     sb.setLength(0);
/*  87 */     OutputUtilities.javaIndent(sb, 1);
/*  88 */     sb.append("\"from ");
/*  89 */     sb.append(StringUtility.escapeStringForJava(
/*  90 */       this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
/*  91 */     sb.append("\",");
/*  92 */     method.addAnnotation(sb.toString());
/*     */     
/*  94 */     boolean and = false;
/*  95 */     iter = this.introspectedTable.getPrimaryKeyColumns().iterator();
/*  96 */     while (iter.hasNext()) {
/*  97 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */       
/*  99 */       sb.setLength(0);
/* 100 */       OutputUtilities.javaIndent(sb, 1);
/* 101 */       if (and) {
/* 102 */         sb.append("  \"and ");
/*     */       } else {
/* 104 */         sb.append("\"where ");
/* 105 */         and = true;
/*     */       }
/*     */       
/* 108 */       sb.append(StringUtility.escapeStringForJava(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn)));
/* 109 */       sb.append(" = ");
/* 110 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/* 111 */       sb.append('"');
/* 112 */       if (iter.hasNext()) {
/* 113 */         sb.append(',');
/*     */       }
/* 115 */       method.addAnnotation(sb.toString());
/*     */     }
/*     */     
/* 118 */     method.addAnnotation("})");
/*     */     
/* 120 */     if (this.useResultMapIfAvailable) {
/* 121 */       if ((this.introspectedTable.getRules().generateBaseResultMap()) || 
/* 122 */         (this.introspectedTable.getRules().generateResultMapWithBLOBs())) {
/* 123 */         addResultMapAnnotation(interfaze, method);
/*     */       } else {
/* 125 */         addAnnotatedResults(interfaze, method);
/*     */       }
/*     */     } else {
/* 128 */       addAnnotatedResults(interfaze, method);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addResultMapAnnotation(Interface interfaze, Method method) {
/* 133 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.ResultMap"));
/*     */     
/* 135 */     String annotation = String.format("@ResultMap(\"%s\")", new Object[] {
/* 136 */       this.introspectedTable.getRules().generateResultMapWithBLOBs() ? 
/* 137 */       this.introspectedTable.getResultMapWithBLOBsId() : this.introspectedTable.getBaseResultMapId() });
/* 138 */     method.addAnnotation(annotation);
/*     */   }
/*     */   
/*     */   private void addAnnotatedResults(Interface interfaze, Method method) {
/* 142 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.type.JdbcType"));
/*     */     
/* 144 */     if (this.introspectedTable.isConstructorBased()) {
/* 145 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Arg"));
/* 146 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.ConstructorArgs"));
/* 147 */       method.addAnnotation("@ConstructorArgs({");
/*     */     } else {
/* 149 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Result"));
/* 150 */       interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Results"));
/* 151 */       method.addAnnotation("@Results({");
/*     */     }
/*     */     
/* 154 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 156 */     Iterator<IntrospectedColumn> iterPk = this.introspectedTable.getPrimaryKeyColumns().iterator();
/* 157 */     Iterator<IntrospectedColumn> iterNonPk = this.introspectedTable.getNonPrimaryKeyColumns().iterator();
/* 158 */     while (iterPk.hasNext()) {
/* 159 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterPk.next();
/* 160 */       sb.setLength(0);
/* 161 */       OutputUtilities.javaIndent(sb, 1);
/* 162 */       sb.append(
/* 163 */         getResultAnnotation(interfaze, introspectedColumn, true, this.introspectedTable.isConstructorBased()));
/*     */       
/* 165 */       if ((iterPk.hasNext()) || (iterNonPk.hasNext())) {
/* 166 */         sb.append(',');
/*     */       }
/*     */       
/* 169 */       method.addAnnotation(sb.toString());
/*     */     }
/*     */     
/* 172 */     while (iterNonPk.hasNext()) {
/* 173 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iterNonPk.next();
/* 174 */       sb.setLength(0);
/* 175 */       OutputUtilities.javaIndent(sb, 1);
/* 176 */       sb.append(
/* 177 */         getResultAnnotation(interfaze, introspectedColumn, false, this.introspectedTable.isConstructorBased()));
/*     */       
/* 179 */       if (iterNonPk.hasNext()) {
/* 180 */         sb.append(',');
/*     */       }
/*     */       
/* 183 */       method.addAnnotation(sb.toString());
/*     */     }
/*     */     
/* 186 */     method.addAnnotation("})");
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedSelectByPrimaryKeyMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */