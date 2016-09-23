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
 
 
 
 public class CountByExampleMethodGenerator
   extends AbstractJavaMapperMethodGenerator
 {
   public void addInterfaceElements(Interface interfaze)
   {
     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
       this.introspectedTable.getExampleType());
     
     Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
     importedTypes.add(fqjt);
     
     Method method = new Method();
     method.setVisibility(JavaVisibility.PUBLIC);
     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
     method.setName(this.introspectedTable.getCountByExampleStatementId());
     method.addParameter(new Parameter(fqjt, "example"));
     this.context.getCommentGenerator().addGeneralMethodComment(method, 
       this.introspectedTable);
     
     addMapperAnnotations(interfaze, method);
     
     if (this.context.getPlugins().clientCountByExampleMethodGenerated(method, 
       interfaze, this.introspectedTable)) {
       interfaze.addImportedTypes(importedTypes);
       interfaze.addMethod(method);
     }
   }
   
   public void addMapperAnnotations(Interface interfaze, Method method) {}
 }

