/*    */ package org.mybatis.generator.internal;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.StringTokenizer;
/*    */ import org.mybatis.generator.api.ShellCallback;
/*    */ import org.mybatis.generator.exception.ShellException;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
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
/*    */ public class DefaultShellCallback
/*    */   implements ShellCallback
/*    */ {
/*    */   private boolean overwrite;
/*    */   
/*    */   public DefaultShellCallback(boolean overwrite)
/*    */   {
/* 37 */     this.overwrite = overwrite;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public File getDirectory(String targetProject, String targetPackage)
/*    */     throws ShellException
/*    */   {
/* 49 */     File project = new File(targetProject);
/* 50 */     if (!project.isDirectory()) {
/* 51 */       throw new ShellException(
/* 52 */         Messages.getString("Warning.9", targetProject));
/*    */     }
/*    */     
/* 55 */     StringBuilder sb = new StringBuilder();
/* 56 */     StringTokenizer st = new StringTokenizer(targetPackage, ".");
/* 57 */     while (st.hasMoreTokens()) {
/* 58 */       sb.append(st.nextToken());
/* 59 */       sb.append(File.separatorChar);
/*    */     }
/*    */     
/* 62 */     File directory = new File(project, sb.toString());
/* 63 */     if (!directory.isDirectory()) {
/* 64 */       boolean rc = directory.mkdirs();
/* 65 */       if (!rc) {
/* 66 */         throw new ShellException(
/* 67 */           Messages.getString("Warning.10", directory.getAbsolutePath()));
/*    */       }
/*    */     }
/*    */     
/* 71 */     return directory;
/*    */   }
/*    */   
/*    */ 
/*    */   public void refreshProject(String project) {}
/*    */   
/*    */   public boolean isMergeSupported()
/*    */   {
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isOverwriteEnabled() {
/* 83 */     return this.overwrite;
/*    */   }
/*    */   
/*    */   public String mergeJavaFile(String newFileSource, String existingFileFullPath, String[] javadocTags)
/*    */     throws ShellException
/*    */   {
/* 89 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\internal\DefaultShellCallback.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */