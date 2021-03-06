 package org.mybatis.generator.api;
 
 import ibator.Globar;
 import ibator.ui.EclipseUI;
 import ibator.util.ConnectionFactoryUtil;
 import ibator.util.PageBeanUtil;
 import ibator.util.ServiceFileCreate;
 import ibator.util.SpringConfigUtil;
 import ibator.util.SqlConfigUtil;
 import ibator.util.TestFileUtil;
 import ibator.util.Util;
 import ibator.vo.ConfigVO;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.OutputStream;
 import java.io.OutputStreamWriter;
 import java.io.Writer;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;
 import org.eclipse.core.resources.IFolder;
 import org.eclipse.core.resources.IProject;
 import org.mybatis.generator.config.Configuration;
 import org.mybatis.generator.config.Context;
 import org.mybatis.generator.config.MergeConstants;
 import org.mybatis.generator.exception.InvalidConfigurationException;
 import org.mybatis.generator.exception.ShellException;
 import org.mybatis.generator.internal.DefaultShellCallback;
 import org.mybatis.generator.internal.NullProgressCallback;
 import org.mybatis.generator.internal.ObjectFactory;
 import org.mybatis.generator.internal.XmlFileMergerJaxp;
 import org.mybatis.generator.internal.util.ClassloaderUtility;
 import org.mybatis.generator.internal.util.messages.Messages;
 

 
 
 public class MyBatisGenerator
 {
   private Configuration configuration;
   private ShellCallback shellCallback;
   private List<GeneratedJavaFile> generatedJavaFiles;
   private List<GeneratedXmlFile> generatedXmlFiles;
   private List<String> warnings;
   private Set<String> projects;
   
   public MyBatisGenerator(Configuration configuration, ShellCallback shellCallback, List<String> warnings)
     throws InvalidConfigurationException
   {
     if (configuration == null) {
       throw new IllegalArgumentException(Messages.getString("RuntimeError.2"));
     }
     this.configuration = configuration;
     
 
     if (shellCallback == null) {
       this.shellCallback = new DefaultShellCallback(false);
     } else {
       this.shellCallback = shellCallback;
     }
     
     if (warnings == null) {
       this.warnings = new ArrayList();
     } else {
       this.warnings = warnings;
     }
     this.generatedJavaFiles = new ArrayList();
     this.generatedXmlFiles = new ArrayList();
     this.projects = new HashSet();
   }
   
 
 
 
 
 
   public void generate(ProgressCallback callback)
     throws SQLException, IOException, InterruptedException
   {
     generate(callback, null, null);
   }
   
 
 
 
 
   public void generate(ProgressCallback callback, Set<String> contextIds)
     throws SQLException, IOException, InterruptedException
   {
     generate(callback, contextIds, null);
   }
   
 
 
   // 生成文件的 主要方法
   public void generate(ProgressCallback callback, Set<String> contextIds, Set<String> fullyQualifiedTableNames)
     throws SQLException, IOException, InterruptedException
   {
     if (callback == null) {
       callback = new NullProgressCallback();
     }
     
     this.generatedJavaFiles.clear();
     this.generatedXmlFiles.clear();
     
     List<Context> contextsToRun;
   //  获得需要运行的上下文 
     if ((contextIds == null) || (contextIds.size() == 0)) {
       contextsToRun = this.configuration.getContexts();
     } else {
       contextsToRun = new ArrayList();
       for (Context context : this.configuration.getContexts()) {
         if (contextIds.contains(context.getId())) {
           contextsToRun.add(context);
         }
       }
     }
     
 
     if (this.configuration.getClassPathEntries().size() > 0) {
       ClassLoader classLoader = ClassloaderUtility.getCustomClassloader(this.configuration.getClassPathEntries());
       ObjectFactory.setExternalClassLoader(classLoader);
     }
     
 
     int totalSteps = 0;
     for (Context context : contextsToRun) {
       totalSteps += context.getIntrospectionSteps();//上下文，需要跑的步骤
     }
     callback.introspectionStarted(totalSteps);
     
     for (Context context : contextsToRun) {
       context.introspectTables(callback, this.warnings, 
         fullyQualifiedTableNames);
     }//获得表的 描述
     
     totalSteps = 0;
     for (Context context : contextsToRun) {
       totalSteps += context.getGenerationSteps();
     }
     callback.generationStarted(totalSteps);
     
     for (Context context : contextsToRun) {
       context.generateFiles(callback, this.generatedJavaFiles, 
         this.generatedXmlFiles, this.warnings);
     }
     
 
     callback.saveStarted(this.generatedXmlFiles.size() + 
       this.generatedJavaFiles.size());
     
     Object list = new ArrayList();
     File dir = null;
     String source;
     //生成xml
     for (GeneratedXmlFile gxf : this.generatedXmlFiles) {
       this.projects.add(gxf.getTargetProject());
       
       File targetFile = null;
       try
       {
         File directory = this.shellCallback.getDirectory( gxf.getTargetProject(), gxf.getTargetPackage());
          targetFile = new File(directory, gxf.getFileName());
         String path = gxf.getTargetPackage();
         path = path.replaceAll("\\.", "/");
         path = path + "/" + gxf.getFileName();
         ((List)list).add(path);
         dir = this.shellCallback.getDirectory(gxf.getTargetProject(), "");
         
         if (targetFile.exists())
         {
           if (this.shellCallback.isOverwriteEnabled()) {
              source = gxf.getFormattedContent();
             this.warnings.add(
               Messages.getString("Warning.11", targetFile.getAbsolutePath()));
           } else { 
             if (this.shellCallback.isMergeSupported()) {
               source = XmlFileMergerJaxp.getMergedSource(gxf, 
                 targetFile);
             } else {
                source = gxf.getFormattedContent();
               targetFile = getUniqueFileName(directory, 
                 gxf.getFileName());
               this.warnings.add(Messages.getString(
                 "Warning.2", targetFile.getAbsolutePath()));
             }
           }
         } else 
        	 source = gxf.getFormattedContent();
       } catch (ShellException e) {
       
         this.warnings.add(e.getMessage());
         continue;
       }
 
       callback.checkCancel();
       callback.startTask(Messages.getString("Progress.15", targetFile.getName()));
       writeFile(targetFile, source);
     }
     String pojo = "";
     
     Object springDao = new ArrayList();
     for (GeneratedJavaFile gjf : this.generatedJavaFiles) {
       this.projects.add(gjf.getTargetProject());
       
 
       if (gjf.getFileName().endsWith(Globar.daoName + ".java")) {
         ((List)springDao).add(gjf.getFileName().replaceAll(".java", ""));
       }
       
 
 
       try
       {
         File directory = this.shellCallback.getDirectory(
           gjf.getTargetProject(), gjf.getTargetPackage());
         dir = this.shellCallback.getDirectory(
           gjf.getTargetProject(), "");
         
         File targetFile = new File(directory, gjf.getFileName());
        if (targetFile.exists()) {
           if (Globar.global.isOverride()) {
              source = gjf.getFormattedContent();
             this.warnings.add(
               Messages.getString("Warning.11", targetFile.getAbsolutePath()));
           } else { 
             if (!Globar.global.isOverride()) {
               source = this.shellCallback.mergeJavaFile(
                 gjf.getFormattedContent(), 
                 targetFile.getAbsolutePath(), 
                 MergeConstants.OLD_ELEMENT_TAGS);
             } else {
                source = gjf.getFormattedContent();
               targetFile = getUniqueFileName(directory, 
                 gjf.getFileName());
               this.warnings.add(Messages.getString(
                 "Warning.2", targetFile.getAbsolutePath()));
             }
           }
         } else { source = gjf.getFormattedContent();
         }
         
         callback.checkCancel();
         callback.startTask(Messages.getString(
           "Progress.15", targetFile.getName()));
         writeFile(targetFile, source);
         
 
         String filename = targetFile.getName();
         if ((!filename.endsWith(Globar.daoName + ".java")) && (!filename.endsWith("Example.java")) && (!filename.endsWith("Key.java")) && (!filename.endsWith("Provider.java"))) {
           pojo = filename.substring(0, filename.lastIndexOf(".java"));
         }
       }
       catch (ShellException e) {
         this.warnings.add(e.getMessage());
       }
     }
     
     IProject project = EclipseUI.project;
     
 
 
     if (dir != null)
     {
       callback.checkCancel();
       callback.startTask("Generator SqlMapConfig!");
       File file = new File(dir, "/sqlMapConfig.xml");
       
       SqlConfigUtil.createIbatsConfig3(Globar.global, file, (List)list);
     }
     
 
     if (Globar.spring) {
       callback.checkCancel();
       callback.startTask("Generator Spring Configuration!");
       SpringConfigUtil.writeSpring(dir, (List)springDao);
     }
     
     callback.startTask("Copy file...");
     
 
     String des = "WebRoot/WEB-INF/lib/";
     IFolder fold = project.getFolder("WebRoot/WEB-INF/lib");
     if (!fold.exists()) {
       fold = project.getFolder("WebContext/WEB-INF/lib");
       des = "WebContext/WEB-INF/lib/";
     }
     if (!fold.exists()) {
       fold = project.getFolder("lib/");
       des = "lib";
     }
     
 
     String des2 = "WebRoot/WEB-INF/";
     IFolder fold2 = project.getFolder("WebRoot/WEB-INF");
     if (!fold2.exists()) {
       fold2 = project.getFolder("WebContext/WEB-INF");
       des2 = "WebContext/WEB-INF/";
     }
     
 
 
     Util.createFolder(project, "src/com");
     
     if (!Globar.ISSIMPLE) {
       Util.createFolder(project, "src/com/test");
     }
     if ((Globar.spring) && (!Globar.ISSIMPLE)) {
       Util.createFolder(project, "src/com/service");
     }
     
 
     Util.copyFile("resource/lib/dtd1", "src", false, project);
     String dao = Globar.xmlPath;
     dao = dao.replaceAll("\\.", "/");
     Util.copyFile("resource/lib/dtd2", "src/" + dao, 
       false, project);
     
     Util.copyFile("resource/lib/log4j.properties", "src", false, project);
     
 
 
 
     if ((Globar.spring) && (!Globar.ISSIMPLE)) {
       TestFileUtil.createTestFileWithSpring(project, pojo, "src/com/test/TestDAOWithSpring.java");
       ServiceFileCreate.createServiceWithSpring(project, pojo, "src/com/service/" + pojo + "Service.java");
       
 
       PageBeanUtil.getPageBean(project);
 
     }
     else
     {
       Util.createFolder(project, "src/com/db");
       ConnectionFactoryUtil.createFile(project, "src/com/db/ConnectionFactory.java");
       if (!Globar.ISSIMPLE) {
         TestFileUtil.createTestFileWithoutSpring(project, pojo, "src/com/test/TestDAOWithoutSpring.java");
       }
     }
     
     Util.copyFile("resource/lib/spring", des, true, 
       project);
     
 
     if (Globar.isCache) {
       Util.copyFile("resource/lib/cache", des, true, 
         project);
     }
     
 
 
     Util.copyFile("resource/lib/ibatis", des, true, 
       project);
     Util.copyFile("resource/lib/jdbc", des, true, project);
     
 
 
 
     for (String pj : this.projects) {
       this.shellCallback.refreshProject(pj);
     }
     callback.startTask("done...");
     callback.done();
   }
   
 
 
   private void writeFile(File file, String content)
     throws IOException
   {
     OutputStream out = new FileOutputStream(file, false);
     Writer writer = new OutputStreamWriter(out, "utf-8");
     BufferedWriter bw = new BufferedWriter(writer);
     bw.write(content);
     bw.close();
     writer.close();
     out.close();
   }
   
   private File getUniqueFileName(File directory, String fileName) {
     File answer = null;
     
 
     StringBuilder sb = new StringBuilder();
     for (int i = 1; i < 1000; i++) {
       sb.setLength(0);
       sb.append(fileName);
       sb.append('.');
       sb.append(i);
       
       File testFile = new File(directory, sb.toString());
       if (!testFile.exists()) {
         answer = testFile;
         break;
       }
     }
     
     if (answer == null) {
       throw new RuntimeException(Messages.getString(
         "RuntimeError.3", directory.getAbsolutePath()));
     }
     
     return answer;
   }
 }


