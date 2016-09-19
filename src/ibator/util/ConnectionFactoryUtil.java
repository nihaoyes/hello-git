/*    */ package ibator.util;
/*    */ 
/*    */ import ibator.Globar;
/*    */ import ibator.vo.ConfigVO;
/*    */ import java.io.InputStream;
/*    */ import org.eclipse.core.resources.IFile;
/*    */ import org.eclipse.core.resources.IProject;
/*    */ import org.eclipse.core.runtime.CoreException;
/*    */ import org.mybatis.generator.api.dom.java.Field;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.InitializationBlock;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*    */ 
/*    */ public class ConnectionFactoryUtil
/*    */ {
/*    */   public static boolean createFile(IProject project, String filename)
/*    */   {
/* 21 */     StringBuffer sb = new StringBuffer();
/*    */     
/* 23 */     TopLevelClass topLevelClass = new TopLevelClass(
/* 24 */       new FullyQualifiedJavaType("com.db.ConnectionFactory"));
/* 25 */     topLevelClass.addImportedType("java.io.IOException");
/* 26 */     topLevelClass.addImportedType("org.apache.ibatis.io.Resources");
/* 27 */     topLevelClass.addImportedType("org.apache.ibatis.session.SqlSession");
/* 28 */     topLevelClass
/* 29 */       .addImportedType("org.apache.ibatis.session.SqlSessionFactory");
/* 30 */     topLevelClass
/* 31 */       .addImportedType("org.apache.ibatis.session.SqlSessionFactoryBuilder");
/* 32 */     topLevelClass.addImportedType("java.io.Reader");
/* 33 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/* 34 */     Field field = new Field();
/* 35 */     field.setName("factory");
/* 36 */     field.setStatic(true);
/* 37 */     field.setType(new FullyQualifiedJavaType(
/* 38 */       "org.apache.ibatis.session.SqlSessionFactory"));
/* 39 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 40 */     topLevelClass.addField(field);
/*    */     
/* 42 */     InitializationBlock block = new InitializationBlock(true);
/* 43 */     block.addBodyLine("try {");
/* 44 */     block
/* 45 */       .addBodyLine("Reader reader = Resources.getResourceAsReader(\"sqlMapConfig.xml\");");
/* 46 */     block
/* 47 */       .addBodyLine("factory = new SqlSessionFactoryBuilder().build(reader, \"" + 
/* 48 */       Globar.global.getDbVo().getDname() + "\");");
/* 49 */     block.addBodyLine("} catch (IOException e) {");
/* 50 */     block.addBodyLine("e.printStackTrace();");
/* 51 */     block.addBodyLine("}");
/* 52 */     topLevelClass.addInitializationBlock(block);
/*    */     
/* 54 */     Method method = new Method();
/* 55 */     method.setName("getSession");
/* 56 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 57 */     method.setReturnType(new FullyQualifiedJavaType(
/* 58 */       "org.apache.ibatis.session.SqlSession"));
/* 59 */     method.setStatic(true);
/* 60 */     method.addBodyLine("return factory.openSession();");
/* 61 */     topLevelClass.addMethod(method);
/*    */     
/* 63 */     method = new Method();
/* 64 */     method.setName("T getMapper");
/* 65 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 66 */     method.setReturnType(new FullyQualifiedJavaType("<T>"));
/* 67 */     method.setStatic(true);
/* 68 */     method.addParameter(new Parameter(new FullyQualifiedJavaType(
/* 69 */       "java.lang.Class"), "mapper"));
/* 70 */     method.addBodyLine("SqlSession session = getSession();");
/* 71 */     if (Globar.global.getDaoType().equals("annotation")) {
/* 72 */       method.addBodyLine("session.getConfiguration().addMapper(mapper);");
/*    */     }
/* 74 */     method.addBodyLine("return (T) session.getMapper(mapper);");
/* 75 */     topLevelClass.addMethod(method);
/*    */     
/* 77 */     IFile ifile = project.getFile(filename);
/*    */     try
/*    */     {
/* 80 */       if (ifile.exists())
/* 81 */         ifile.delete(true, null);
/* 82 */       InputStream is = new java.io.StringBufferInputStream(
/* 83 */         topLevelClass.getFormattedContent());
/* 84 */       ifile.create(is, true, null);
/*    */       
/* 86 */       return true;
/*    */     } catch (CoreException e) {
/* 88 */       e.printStackTrace();
/*    */     }
/*    */     
/* 91 */     return false;
/*    */   }
/*    */ }

