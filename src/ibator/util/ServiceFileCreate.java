/*     */ package ibator.util;
/*     */ 
/*     */ import ibator.Globar;
/*     */ import java.io.InputStream;
/*     */ import java.io.StringBufferInputStream;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.runtime.CoreException;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ServiceFileCreate
/*     */ {
/*     */   public static boolean createServiceWithSpring(IProject project, String pojo, String filename)
/*     */   {
/*  22 */     String daoName = pojo + Globar.daoName;
/*  23 */     StringBuffer sb = new StringBuffer();
/*  24 */     TopLevelClass topLevelClass = new TopLevelClass("com.service." + pojo + "Service");
/*  25 */     topLevelClass.addAnnotation("@Service");
/*  26 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*     */     
/*     */ 
/*  29 */     topLevelClass.addImportedType("org.springframework.stereotype.Service");
/*  30 */     topLevelClass.addImportedType("org.springframework.beans.factory.annotation.Autowired");
/*  31 */     topLevelClass.addImportedType("java.util.Map");
/*  32 */     topLevelClass.addImportedType("java.util.HashMap");
/*  33 */     topLevelClass.addImportedType("java.util.List");
/*  34 */     topLevelClass.addImportedType("org.apache.ibatis.session.RowBounds");
/*     */     
/*     */ 
/*  37 */     sb.setLength(0);
/*  38 */     sb.append(Globar.daoPath).append(".").append(daoName);
/*  39 */     topLevelClass.addImportedType(sb.toString());
/*     */     
/*  41 */     sb.setLength(0);
/*  42 */     sb.append(Globar.pojoPath).append(".").append("PageBean");
/*  43 */     topLevelClass.addImportedType(sb.toString());
/*     */     
/*  45 */     sb.setLength(0);
/*  46 */     sb.append(Globar.pojoPath).append(".").append(pojo);
/*  47 */     topLevelClass.addImportedType(sb.toString());
/*  48 */     sb.append(Globar.exampleName);
/*  49 */     topLevelClass.addImportedType(sb.toString());
/*     */     
/*  51 */     Field field = new Field();
/*  52 */     field.setVisibility(JavaVisibility.PRIVATE);
/*  53 */     sb.setLength(0);
/*  54 */     sb.append(daoName);
/*  55 */     sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
/*  56 */     field.setName(sb.toString());
/*  57 */     sb.setLength(0);
/*  58 */     sb.append(Globar.daoPath).append(".").append(daoName);
/*  59 */     field.setType(new FullyQualifiedJavaType(sb.toString()));
/*  60 */     field.addAnnotation("@Autowired");
/*  61 */     topLevelClass.addField(field);
/*     */     
/*  63 */     Method method = new Method();
/*  64 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  65 */     sb.setLength(0);
/*  66 */     sb.append("add").append(pojo);
/*  67 */     method.setName(sb.toString());
/*  68 */     method.setReturnType(null);
/*  69 */     method.addParameter(new Parameter(new FullyQualifiedJavaType(pojo), "record"));
/*     */     
/*  71 */     sb.setLength(0);
/*  72 */     sb.append(daoName);
/*  73 */     sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
/*  74 */     sb.append(".insert(record);");
/*  75 */     method.addBodyLine(sb.toString());
/*  76 */     topLevelClass.addMethod(method);
/*     */     
/*     */ 
/*     */ 
/*  80 */     method = new Method();
/*  81 */     method.setName("queryByPage");
/*  82 */     method.setVisibility(JavaVisibility.PUBLIC);
/*     */     
/*  84 */     sb.setLength(0);
/*  85 */     sb.append(Globar.daoPath).append(".").append("PageBean");
/*     */     
/*  87 */     method.setReturnType(new FullyQualifiedJavaType(sb.toString()));
/*  88 */     method.addParameter(new Parameter(new FullyQualifiedJavaType("java.lang.Integer"), "page"));
/*  89 */     method.addParameter(new Parameter(new FullyQualifiedJavaType("java.lang.Integer"), "size"));
/*  90 */     sb.setLength(0);
/*  91 */     sb.append(Globar.pojoPath).append(".").append(pojo).append(Globar.exampleName);
/*  92 */     method.addParameter(new Parameter(new FullyQualifiedJavaType(sb.toString()), "example"));
/*  93 */     method.addBodyLine("//record sum");
/*  94 */     method.addBodyLine("int sum = " + field.getName() + ".countByExample(example);");
/*  95 */     method.addBodyLine("//page count");
/*  96 */     method.addBodyLine("int count = sum%size==0 ? sum/size : sum/size+1;");
/*  97 */     method.addBodyLine("//check page");
/*  98 */     method.addBodyLine("page = page<1 ? 1 : ((page>count)? count : page);");
/*  99 */     method.addBodyLine("//query");
/* 100 */     method.addBodyLine("List list = " + field.getName() + ".selectByExampleAndPage(example, new RowBounds((page-1)*size, size));");
/* 101 */     method.addBodyLine("//save to PageBean ");
/* 102 */     method.addBodyLine("PageBean pageBean = new PageBean();");
/* 103 */     method.addBodyLine("pageBean.setCurrentPage(page);");
/* 104 */     method.addBodyLine("pageBean.setPageCount(count);");
/* 105 */     method.addBodyLine("pageBean.setRecordCount(sum);");
/* 106 */     method.addBodyLine("pageBean.setResultList(list);");
/* 107 */     method.addBodyLine("pageBean.setCurrentPage(page);");
/* 108 */     method.addBodyLine("pageBean.setPageSize(size);");
/* 109 */     method.addBodyLine("return pageBean;");
/*     */     
/* 111 */     topLevelClass.addMethod(method);
/* 112 */     IFile ifile = project.getFile(filename);
/*     */     try
/*     */     {
/* 115 */       if (ifile.exists())
/* 116 */         ifile.delete(true, null);
/* 117 */       InputStream is = new StringBufferInputStream(topLevelClass.getFormattedContent());
/* 118 */       ifile.create(is, true, null);
/*     */       
/* 120 */       return true;
/*     */     } catch (CoreException e) {
/* 122 */       e.printStackTrace();
/*     */     }
/*     */     
/* 125 */     return false;
/*     */   }
/*     */ }


