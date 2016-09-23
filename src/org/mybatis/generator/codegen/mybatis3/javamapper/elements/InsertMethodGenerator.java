 package org.mybatis.generator.codegen.mybatis3.javamapper.elements;
 
 import java.util.Set;
 import java.util.TreeSet;
 import org.mybatis.generator.api.CommentGenerator;
 import org.mybatis.generator.api.IntrospectedTable;
 import org.mybatis.generator.api.Plugin;
 import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
 import org.mybatis.generator.api.dom.java.Interface;
 import org.mybatis.generator.api.dom.java.JavaVisibility;
 import org.mybatis.generator.api.dom.java.Method;
 import org.mybatis.generator.api.dom.java.Parameter;
 import org.mybatis.generator.config.Context;
 import org.mybatis.generator.internal.rules.Rules;
 
 
 
 public class InsertMethodGenerator
   extends AbstractJavaMapperMethodGenerator
 {
   public void addInterfaceElements(Interface interfaze)
   {
     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
     Method method = new Method();
     
     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
     method.setVisibility(JavaVisibility.PUBLIC);
     method.setName(this.introspectedTable.getInsertStatementId());
     
     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules().calculateAllFieldsClass();
     
     importedTypes.add(parameterType);
     method.addParameter(new Parameter(parameterType, "record"));
     
     this.context.getCommentGenerator().addGeneralMethodComment(method,this.introspectedTable);
     
     addMapperAnnotations(interfaze, method);
     
     if (this.context.getPlugins().clientInsertMethodGenerated(method, 
       interfaze, this.introspectedTable)) {
       interfaze.addImportedTypes(importedTypes);
       interfaze.addMethod(method);
     }
   }
   
   public void addMapperAnnotations(Interface interfaze, Method method) {}
 }


