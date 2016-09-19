/*     */ package org.mybatis.generator.plugins;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.PluginAdapter;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
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
/*     */ 
/*     */ public class EqualsHashCodePlugin
/*     */   extends PluginAdapter
/*     */ {
/*     */   public boolean validate(List<String> warnings)
/*     */   {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*     */     List<IntrospectedColumn> columns;
/*     */    // List<IntrospectedColumn> columns;
/*  64 */     if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  65 */       columns = introspectedTable.getNonBLOBColumns();
/*     */     } else {
/*  67 */       columns = introspectedTable.getAllColumns();
/*     */     }
/*     */     
/*  70 */     generateEquals(topLevelClass, columns, introspectedTable);
/*  71 */     generateHashCode(topLevelClass, columns, introspectedTable);
/*     */     
/*  73 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  79 */     generateEquals(topLevelClass, introspectedTable.getPrimaryKeyColumns(), 
/*  80 */       introspectedTable);
/*  81 */     generateHashCode(topLevelClass, 
/*  82 */       introspectedTable.getPrimaryKeyColumns(), introspectedTable);
/*     */     
/*  84 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  90 */     generateEquals(topLevelClass, introspectedTable.getAllColumns(), 
/*  91 */       introspectedTable);
/*  92 */     generateHashCode(topLevelClass, introspectedTable.getAllColumns(), 
/*  93 */       introspectedTable);
/*     */     
/*  95 */     return true;
/*     */   }
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
/*     */   protected void generateEquals(TopLevelClass topLevelClass, List<IntrospectedColumn> introspectedColumns, IntrospectedTable introspectedTable)
/*     */   {
/* 118 */     Method method = new Method();
/* 119 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 120 */     method.setReturnType(
/* 121 */       FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/* 122 */     method.setName("equals");
/* 123 */     method.addParameter(new Parameter(
/* 124 */       FullyQualifiedJavaType.getObjectInstance(), "that"));
/* 125 */     if (introspectedTable.isJava5Targeted()) {
/* 126 */       method.addAnnotation("@Override");
/*     */     }
/*     */     
/* 129 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 130 */       introspectedTable);
/*     */     
/* 132 */     method.addBodyLine("if (this == that) {");
/* 133 */     method.addBodyLine("return true;");
/* 134 */     method.addBodyLine("}");
/*     */     
/* 136 */     method.addBodyLine("if (that == null) {");
/* 137 */     method.addBodyLine("return false;");
/* 138 */     method.addBodyLine("}");
/*     */     
/* 140 */     method.addBodyLine("if (getClass() != that.getClass()) {");
/* 141 */     method.addBodyLine("return false;");
/* 142 */     method.addBodyLine("}");
/*     */     
/* 144 */     StringBuilder sb = new StringBuilder();
/* 145 */     sb.append(topLevelClass.getType().getShortName());
/* 146 */     sb.append(" other = (");
/* 147 */     sb.append(topLevelClass.getType().getShortName());
/* 148 */     sb.append(") that;");
/* 149 */     method.addBodyLine(sb.toString());
/*     */     
/* 151 */     boolean first = true;
/* 152 */     Iterator<IntrospectedColumn> iter = introspectedColumns.iterator();
/* 153 */     while (iter.hasNext()) {
/* 154 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */       
/* 156 */       sb.setLength(0);
/*     */       
/* 158 */       if (first) {
/* 159 */         sb.append("return (");
/* 160 */         first = false;
/*     */       } else {
/* 162 */         OutputUtilities.javaIndent(sb, 1);
/* 163 */         sb.append("&& (");
/*     */       }
/*     */       
/* 166 */       String getterMethod = JavaBeansUtil.getGetterMethodName(
/* 167 */         introspectedColumn.getJavaProperty(), 
/* 168 */         introspectedColumn.getFullyQualifiedJavaType());
/*     */       
/* 170 */       if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 171 */         sb.append("this.");
/* 172 */         sb.append(getterMethod);
/* 173 */         sb.append("() == ");
/* 174 */         sb.append("other.");
/* 175 */         sb.append(getterMethod);
/* 176 */         sb.append("())");
/*     */       } else {
/* 178 */         sb.append("this.");
/* 179 */         sb.append(getterMethod);
/* 180 */         sb.append("() == null ? other.");
/* 181 */         sb.append(getterMethod);
/* 182 */         sb.append("() == null : this.");
/* 183 */         sb.append(getterMethod);
/* 184 */         sb.append("().equals(other.");
/* 185 */         sb.append(getterMethod);
/* 186 */         sb.append("()))");
/*     */       }
/*     */       
/* 189 */       if (!iter.hasNext()) {
/* 190 */         sb.append(';');
/*     */       }
/*     */       
/* 193 */       method.addBodyLine(sb.toString());
/*     */     }
/*     */     
/* 196 */     topLevelClass.addMethod(method);
/*     */   }
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
/*     */   protected void generateHashCode(TopLevelClass topLevelClass, List<IntrospectedColumn> introspectedColumns, IntrospectedTable introspectedTable)
/*     */   {
/* 216 */     Method method = new Method();
/* 217 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 218 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 219 */     method.setName("hashCode");
/* 220 */     if (introspectedTable.isJava5Targeted()) {
/* 221 */       method.addAnnotation("@Override");
/*     */     }
/*     */     
/* 224 */     this.context.getCommentGenerator().addGeneralMethodComment(method, 
/* 225 */       introspectedTable);
/*     */     
/* 227 */     method.addBodyLine("final int prime = 31;");
/* 228 */     method.addBodyLine("int result = 1;");
/*     */     
/* 230 */     StringBuilder sb = new StringBuilder();
/* 231 */     boolean hasTemp = false;
/* 232 */     Iterator<IntrospectedColumn> iter = introspectedColumns.iterator();
/* 233 */     while (iter.hasNext()) {
/* 234 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */       
/* 236 */       FullyQualifiedJavaType fqjt = introspectedColumn
/* 237 */         .getFullyQualifiedJavaType();
/*     */       
/* 239 */       String getterMethod = JavaBeansUtil.getGetterMethodName(
/* 240 */         introspectedColumn.getJavaProperty(), fqjt);
/*     */       
/* 242 */       sb.setLength(0);
/* 243 */       if (fqjt.isPrimitive()) {
/* 244 */         if ("boolean".equals(fqjt.getFullyQualifiedName())) {
/* 245 */           sb.append("result = prime * result + (");
/* 246 */           sb.append(getterMethod);
/* 247 */           sb.append("() ? 1231 : 1237);");
/* 248 */           method.addBodyLine(sb.toString());
/* 249 */         } else if ("byte".equals(fqjt.getFullyQualifiedName())) {
/* 250 */           sb.append("result = prime * result + ");
/* 251 */           sb.append(getterMethod);
/* 252 */           sb.append("();");
/* 253 */           method.addBodyLine(sb.toString());
/* 254 */         } else if ("char".equals(fqjt.getFullyQualifiedName())) {
/* 255 */           sb.append("result = prime * result + ");
/* 256 */           sb.append(getterMethod);
/* 257 */           sb.append("();");
/* 258 */           method.addBodyLine(sb.toString());
/* 259 */         } else if ("double".equals(fqjt.getFullyQualifiedName())) {
/* 260 */           if (!hasTemp) {
/* 261 */             method.addBodyLine("long temp;");
/* 262 */             hasTemp = true;
/*     */           }
/* 264 */           sb.append("temp = Double.doubleToLongBits(");
/* 265 */           sb.append(getterMethod);
/* 266 */           sb.append("());");
/* 267 */           method.addBodyLine(sb.toString());
/* 268 */           method
/* 269 */             .addBodyLine("result = prime * result + (int) (temp ^ (temp >>> 32));");
/* 270 */         } else if ("float".equals(fqjt.getFullyQualifiedName()))
/*     */         {
/* 272 */           sb.append("result = prime * result + Float.floatToIntBits(");
/* 273 */           sb.append(getterMethod);
/* 274 */           sb.append("());");
/* 275 */           method.addBodyLine(sb.toString());
/* 276 */         } else if ("int".equals(fqjt.getFullyQualifiedName())) {
/* 277 */           sb.append("result = prime * result + ");
/* 278 */           sb.append(getterMethod);
/* 279 */           sb.append("();");
/* 280 */           method.addBodyLine(sb.toString());
/* 281 */         } else if ("long".equals(fqjt.getFullyQualifiedName())) {
/* 282 */           sb.append("result = prime * result + (int) (");
/* 283 */           sb.append(getterMethod);
/* 284 */           sb.append("() ^ (");
/* 285 */           sb.append(getterMethod);
/* 286 */           sb.append("() >>> 32));");
/* 287 */           method.addBodyLine(sb.toString());
/* 288 */         } else if ("short".equals(fqjt.getFullyQualifiedName())) {
/* 289 */           sb.append("result = prime * result + ");
/* 290 */           sb.append(getterMethod);
/* 291 */           sb.append("();");
/* 292 */           method.addBodyLine(sb.toString());
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 298 */         sb.append("result = prime * result + ((");
/* 299 */         sb.append(getterMethod);
/* 300 */         sb.append("() == null) ? 0 : ");
/* 301 */         sb.append(getterMethod);
/* 302 */         sb.append("().hashCode());");
/* 303 */         method.addBodyLine(sb.toString());
/*     */       }
/*     */     }
/*     */     
/* 307 */     method.addBodyLine("return result;");
/*     */     
/* 309 */     topLevelClass.addMethod(method);
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\plugins\EqualsHashCodePlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */