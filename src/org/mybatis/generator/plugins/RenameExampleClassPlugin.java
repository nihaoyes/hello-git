/*    */ package org.mybatis.generator.plugins;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Properties;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.PluginAdapter;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
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
/*    */ 
/*    */ public class RenameExampleClassPlugin
/*    */   extends PluginAdapter
/*    */ {
/*    */   private String searchString;
/*    */   private String replaceString;
/*    */   private Pattern pattern;
/*    */   
/*    */   public boolean validate(List<String> warnings)
/*    */   {
/* 68 */     this.searchString = this.properties.getProperty("searchString");
/* 69 */     this.replaceString = this.properties.getProperty("replaceString");
/*    */     
/* 71 */     boolean valid = (StringUtility.stringHasValue(this.searchString)) && 
/* 72 */       (StringUtility.stringHasValue(this.replaceString));
/*    */     
/* 74 */     if (valid) {
/* 75 */       this.pattern = Pattern.compile(this.searchString);
/*    */     } else {
/* 77 */       if (!StringUtility.stringHasValue(this.searchString)) {
/* 78 */         warnings.add(
/*    */         
/* 80 */           Messages.getString("ValidationError.18", "RenameExampleClassPlugin", "searchString"));
/*    */       }
/* 82 */       if (!StringUtility.stringHasValue(this.replaceString)) {
/* 83 */         warnings.add(
/*    */         
/* 85 */           Messages.getString("ValidationError.18", "RenameExampleClassPlugin", "replaceString"));
/*    */       }
/*    */     }
/*    */     
/* 89 */     return valid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initialized(IntrospectedTable introspectedTable)
/*    */   {
/* 95 */     String oldType = introspectedTable.getExampleType();
/* 96 */     Matcher matcher = this.pattern.matcher(oldType);
/* 97 */     oldType = matcher.replaceAll(this.replaceString);
/*    */     
/* 99 */     introspectedTable.setExampleType(oldType);
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\plugins\RenameExampleClassPlugin.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */