/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements.annotated;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.dom.OutputUtilities;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*    */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.DeleteByPrimaryKeyMethodGenerator;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
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
/*    */ public class AnnotatedDeleteByPrimaryKeyMethodGenerator
/*    */   extends DeleteByPrimaryKeyMethodGenerator
/*    */ {
/*    */   public void addMapperAnnotations(Interface interfaze, Method method)
/*    */   {
/* 44 */     interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Delete"));
/*    */     
/* 46 */     method.addAnnotation("@Delete({");
/*    */     
/* 48 */     StringBuilder sb = new StringBuilder();
/* 49 */     OutputUtilities.javaIndent(sb, 1);
/* 50 */     sb.append("\"delete from ");
/* 51 */     sb.append(StringUtility.escapeStringForJava(
/* 52 */       this.introspectedTable.getFullyQualifiedTableNameAtRuntime()));
/* 53 */     sb.append("\",");
/* 54 */     method.addAnnotation(sb.toString());
/*    */     
/* 56 */     boolean and = false;
/* 57 */     Iterator<IntrospectedColumn> iter = this.introspectedTable.getPrimaryKeyColumns().iterator();
/* 58 */     while (iter.hasNext()) {
/* 59 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/* 60 */       sb.setLength(0);
/* 61 */       OutputUtilities.javaIndent(sb, 1);
/* 62 */       if (and) {
/* 63 */         sb.append("  \"and ");
/*    */       } else {
/* 65 */         sb.append("\"where ");
/* 66 */         and = true;
/*    */       }
/*    */       
/* 69 */       sb.append(StringUtility.escapeStringForJava(
/* 70 */         MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)));
/* 71 */       sb.append(" = ");
/* 72 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/* 73 */       sb.append('"');
/* 74 */       if (iter.hasNext()) {
/* 75 */         sb.append(',');
/*    */       }
/*    */       
/* 78 */       method.addAnnotation(sb.toString());
/*    */     }
/*    */     
/* 81 */     method.addAnnotation("})");
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\javamapper\elements\annotated\AnnotatedDeleteByPrimaryKeyMethodGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */