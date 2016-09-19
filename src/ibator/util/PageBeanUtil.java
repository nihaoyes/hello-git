 package ibator.util;
 
 import ibator.Globar;
 import java.io.InputStream;
 import java.io.StringBufferInputStream;
 import org.eclipse.core.resources.IFile;
 import org.eclipse.core.resources.IProject;
 import org.eclipse.core.runtime.CoreException;
 import org.mybatis.generator.api.dom.java.Field;
 import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
 import org.mybatis.generator.api.dom.java.JavaVisibility;
 import org.mybatis.generator.api.dom.java.Method;
 import org.mybatis.generator.api.dom.java.Parameter;
 import org.mybatis.generator.api.dom.java.TopLevelClass;
 import org.mybatis.generator.internal.util.JavaBeansUtil;
 
 public class PageBeanUtil
 {
   private static void addProperty(TopLevelClass topLevelClass, String name, String type)
   {
     Field field = new Field();
     field.setName(name);
     field.setType(new FullyQualifiedJavaType(type));
     field.setVisibility(JavaVisibility.PRIVATE);
     topLevelClass.addField(field);
     
     Method method = new Method();
     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
     method.setVisibility(JavaVisibility.PUBLIC);
     method.addBodyLine("return " + field.getName() + ";");
     method.setReturnType(field.getType());
     topLevelClass.addMethod(method);
     
     method = new Method();
     method.setName(JavaBeansUtil.getSetterMethodName(field.getName()));
     method.setVisibility(JavaVisibility.PUBLIC);
     method.addBodyLine("this." + field.getName() + "=" + field.getName() + ";");
     method.addParameter(new Parameter(field.getType(), field.getName()));
     topLevelClass.addMethod(method);
   }
   
   public static void getPageBean(IProject project)
   {
     StringBuffer sb = new StringBuffer();
     
     sb.append(Globar.pojoPath).append(".PageBean");
     TopLevelClass topLevelClass = new TopLevelClass(sb.toString());
     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
     topLevelClass.addImportedType("java.util.List");
     Field field = null;
     Method method = null;
     
     addProperty(topLevelClass, "currentPage", "java.lang.Integer");
     addProperty(topLevelClass, "pageSize", "java.lang.Integer");
     addProperty(topLevelClass, "recordCount", "java.lang.Integer");
     addProperty(topLevelClass, "pageCount", "java.lang.Integer");
     addProperty(topLevelClass, "resultList", "java.util.List");     
 
     sb.setLength(0);
     sb.append("src/").append(Globar.pojoPath.replaceAll("\\.", "/")).append("/PageBean.java");
     IFile ifile = project.getFile(sb.toString());
     try
     {
       if (ifile.exists())
         ifile.delete(true, null);
       InputStream is = new StringBufferInputStream(topLevelClass.getFormattedContent());
       ifile.create(is, true, null);
     } catch (CoreException e) {
       e.printStackTrace();
     }
   }
 }


