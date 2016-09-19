/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.InnerClass;
/*     */ import org.mybatis.generator.api.dom.java.InnerEnum;
/*     */ import org.mybatis.generator.api.dom.java.JavaElement;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
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
/*     */ public class DefaultCommentGenerator
/*     */   implements CommentGenerator
/*     */ {
/*     */   private Properties properties;
/*     */   private boolean suppressDate;
/*  48 */   public static boolean suppressAllComments = false;
/*     */   
/*     */   public DefaultCommentGenerator()
/*     */   {
/*  52 */     this.properties = new Properties();
/*  53 */     this.suppressDate = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addJavaFileComment(CompilationUnit compilationUnit) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addComment(XmlElement xmlElement)
/*     */   {
/*  68 */     if (suppressAllComments) {}
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
/*     */   public void addRootComment(XmlElement rootElement) {}
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
/*     */   public void addConfigurationProperties(Properties properties)
/*     */   {
/*  97 */     this.properties.putAll(properties);
/*     */     
/*  99 */     this.suppressDate = StringUtility.isTrue(
/* 100 */       properties.getProperty("suppressDate"));
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
/*     */   protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete)
/*     */   {
/* 118 */     StringBuilder sb = new StringBuilder();
/* 119 */     sb.append(" * ");
/* 120 */     sb.append("@ibatorgenerated");
/* 121 */     if (markAsDoNotDelete) {
/* 122 */       sb.append(" do_not_delete_during_merge");
/*     */     }
/* 124 */     String s = getDateString();
/* 125 */     if (s != null) {
/* 126 */       sb.append(' ');
/* 127 */       sb.append(s);
/*     */     }
/* 129 */     javaElement.addJavaDocLine(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String getDateString()
/*     */   {
/* 140 */     if (this.suppressDate) {
/* 141 */       return null;
/*     */     }
/* 143 */     return 
/* 144 */       new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
/*     */   }
/*     */   
/*     */ 
/*     */   public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable)
/*     */   {
/* 150 */     if (suppressAllComments) {
/* 151 */       return;
/*     */     }
/*     */     
/* 154 */     innerClass.addJavaDocLine("/**");
/* 155 */     innerClass.addJavaDocLine(" * ");
/* 156 */     innerClass.addJavaDocLine(" * 内类部，系统内部调用1");
/*     */     
/* 158 */     addJavadocTag(innerClass, false);
/*     */     
/* 160 */     innerClass.addJavaDocLine(" */");
/*     */   }
/*     */   
/*     */ 
/*     */   public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable)
/*     */   {
/* 166 */     if (suppressAllComments) {
/* 167 */       return;
/*     */     }
/*     */     
/* 170 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 172 */     innerEnum.addJavaDocLine("/**");
/* 173 */     innerEnum.addJavaDocLine(" * ");
/* 174 */     innerEnum.addJavaDocLine(" * 内类部，系统内部调用2");
/*     */     
/* 176 */     addJavadocTag(innerEnum, false);
/*     */     
/* 178 */     innerEnum.addJavaDocLine(" */");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
/*     */   {
/* 185 */     if (suppressAllComments) {
/* 186 */       return;
/*     */     }
/*     */     
/* 189 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 191 */     field.addJavaDocLine("/**");
/* 192 */     sb.append(" * ");
/* 193 */     String remarks = introspectedColumn.getRemarks();
/*     */     
/* 195 */     sb.append("").append(
/* 196 */       introspectedTable.getFullyQualifiedTableNameAtRuntime())
/* 197 */       .append(".").append(introspectedColumn.getActualColumnName());
/*     */     
/* 199 */     if ((remarks != null) && (remarks.length() > 0)) {
/* 200 */       sb.append(" (").append(remarks).append(")");
/*     */     }
/* 202 */     field.addJavaDocLine(sb.toString());
/* 203 */     addJavadocTag(field, false);
/* 204 */     field.addJavaDocLine(" */");
/*     */   }
/*     */   
/*     */   public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
/* 208 */     if (suppressAllComments) {
/* 209 */       return;
/*     */     }
/*     */     
/* 212 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 214 */     sb.append(" * ");
/* 215 */     if (field.getName().equals("pk_name")) {
/* 216 */       sb.append("主键字段");
/* 217 */     } else if (field.getName().equals("orderByClause")) {
/* 218 */       sb.append("排序字段");
/* 219 */     } else if (field.getName().equals("distinct")) {
/* 220 */       sb.append("去重复");
/* 221 */     } else if (field.getName().equals("oredCriteria")) {
/* 222 */       sb.append("条件集");
/*     */     }
/*     */     
/* 225 */     if (sb.length() == 3)
/* 226 */       return;
/* 227 */     field.addJavaDocLine("/**");
/* 228 */     field.addJavaDocLine(sb.toString());
/* 229 */     addJavadocTag(field, false);
/* 230 */     field.addJavaDocLine(" */");
/*     */   }
/*     */   
/*     */ 
/*     */   public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable)
/*     */   {
/* 236 */     if (suppressAllComments) {
/* 237 */       return;
/*     */     }
/*     */     
/* 240 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 242 */     sb.append(" * ");
/*     */     
/* 244 */     String name = method.getName();
/* 245 */     if (name.equals("setOrderByClause")) {
/* 246 */       sb.append("排序字段");
/* 247 */     } else if (name.equals("setDistinct")) {
/* 248 */       sb.append("设置去重复");
/* 249 */     } else if (name.equals("createCriteria")) {
/* 250 */       sb.append("条件查询要先创建Criteria");
/* 251 */     } else if (name.equals("countByExample")) {
/* 252 */       sb.append("条件统计\r\n");
/* 253 */       sb.append("     * 参数:查询条件,null为整张表\r\n");
/* 254 */       sb.append("     * 返回:查询个数");
/* 255 */     } else if (name.equals("deleteByExample")) {
/* 256 */       sb.append("批量条件删除\r\n");
/* 257 */       sb.append("     * 参数:删除条件,null为整张表\r\n");
/* 258 */       sb.append("     * 返回:删除个数");
/* 259 */     } else if (name.equals("deleteByPrimaryKey")) {
/* 260 */       sb.append("根据主键删除\r\n");
/* 261 */       sb.append("     * 参数:主键\r\n");
/* 262 */       sb.append("     * 返回:删除个数");
/* 263 */     } else if (name.equals("insert")) {
/* 264 */       sb.append("插入，空属性也会插入\r\n");
/* 265 */       sb.append("     * 参数:pojo对象\r\n");
/* 266 */       sb.append("     * 返回:删除个数");
/* 267 */     } else if (name.equals("insertSelective")) {
/* 268 */       sb.append("插入，空属性不会插入\r\n");
/* 269 */       sb.append("     * 参数:pojo对象\r\n");
/* 270 */       sb.append("     * 返回:删除个数");
/* 271 */     } else if (name.equals("selectByExample")) {
/* 272 */       sb.append("批量条件查询\r\n");
/* 273 */       sb.append("     * 参数:查询条件,null查整张表\r\n");
/* 274 */       sb.append("     * 返回:对象集合");
/* 275 */     } else if (name.equals("selectByPrimaryKey")) {
/* 276 */       sb.append("根据主键查询\r\n");
/* 277 */       sb.append("     * 参数:查询条件,主键值\r\n");
/* 278 */       sb.append("     * 返回:对象");
/* 279 */     } else if (name.equals("updateByExampleSelective")) {
/* 280 */       sb.append("批量条件修改，空值条件不修改\r\n");
/* 281 */       sb.append("     * 参数:1.要修改成的值，2.要修改条件\r\n");
/* 282 */       sb.append("     * 返回:成功修改个数");
/* 283 */     } else if (name.equals("updateByExample")) {
/* 284 */       sb.append("批量条件修改，空值条件会修改成null\r\n");
/* 285 */       sb.append("     * 参数:1.要修改成的值，2.要修改条件\r\n");
/* 286 */       sb.append("     * 返回:成功修改个数");
/* 287 */     } else if (name.equals("updateByPrimaryKeySelective")) {
/* 288 */       sb.append("根据主键修改，空值条件不会修改成null\r\n");
/* 289 */       sb.append("     * 参数:1.要修改成的值\r\n");
/* 290 */       sb.append("     * 返回:成功修改个数");
/* 291 */     } else if (name.equals("updateByPrimaryKey")) {
/* 292 */       sb.append("根据主键修改，空值条件会修改成null\r\n");
/* 293 */       sb.append("     * 参数:1.要修改成的值\r\n");
/* 294 */       sb.append("     * 返回:成功修改个数");
/* 295 */     } else if (name.equals("selectByExampleAndPage")) {
/* 296 */       sb.append("物理分页条件查询\r\n");
/* 297 */       sb.append("     * 参数:1.查询条件 2.分页条件 new RowBounds(2,3) \r\n");
/* 298 */       sb.append("            从第2条开始显示，显示3条(从0开始编号)\r\n");
/* 299 */       sb.append("     * 返回:成功修改个数");
/* 300 */     } else if (name.equals("selectByExampleWithBLOBs")) {
/* 301 */       sb.append("批量条件查询,支持大字段类型\r\n");
/* 302 */       sb.append("     * 参数:查询条件,null查整张表\r\n");
/* 303 */       sb.append("     * 返回:对象集合");
/*     */ 
/*     */     }
/* 306 */     else if (name.equals("selectByExampleWithBLOBs")) {
/* 307 */       sb.append("批量条件查询,支持大字段类型\r\n");
/* 308 */       sb.append("     * 参数:查询条件,null查整张表\r\n");
/* 309 */       sb.append("     * 返回:对象集合");
/*     */     }
/* 311 */     else if (name.equals("updateByExampleWithBLOBs")) {
/* 312 */       sb.append("批量条件修改，空值条件会修改成null,支持大字段类型\r\n");
/* 313 */       sb.append("     * 参数:1.要修改成的值，2.要修改条件\r\n");
/* 314 */       sb.append("     * 返回:成功修改个数");
/*     */ 
/*     */     }
/* 317 */     else if (name.equals("updateByPrimaryKeyWithBLOBs")) {
/* 318 */       sb.append("根据主键修改，空值条件会修改成null,支持大字段类型\r\n");
/* 319 */       sb.append("     * 参数:1.要修改成的值\r\n");
/* 320 */       sb.append("     * 返回:成功修改个数");
/*     */     }
/* 322 */     else if (name.equals("selectByExampleWithBLOBsAndPage")) {
/* 323 */       sb.append("物理分页条件查询,支持大字段\r\n");
/* 324 */       sb.append("     * 参数:1.查询条件 2.分页条件 new RowBounds(2,3) \r\n");
/* 325 */       sb.append("            从第2条开始显示，显示3条(从0开始编号)\r\n");
/* 326 */       sb.append("     * 返回:成功修改个数");
/*     */     }
/*     */     
/* 329 */     if (sb.length() == 3)
/* 330 */       return;
/* 331 */     method.addJavaDocLine("/**");
/* 332 */     method.addJavaDocLine(sb.toString());
/*     */     
/* 334 */     addJavadocTag(method, false);
/*     */     
/* 336 */     method.addJavaDocLine(" */");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
/*     */   {
/* 343 */     if (suppressAllComments) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
/*     */   {
/* 353 */     if (suppressAllComments) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete)
/*     */   {
/* 361 */     if (suppressAllComments) {
/* 362 */       return;
/*     */     }
/*     */     
/* 365 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 367 */     innerClass.addJavaDocLine("/**");
/* 368 */     sb.append(" * ");
/* 369 */     sb.append(introspectedTable.getFullyQualifiedTable());
/* 370 */     innerClass.addJavaDocLine(sb.toString());
/*     */     
/* 372 */     addJavadocTag(innerClass, markAsDoNotDelete);
/*     */     
/* 374 */     innerClass.addJavaDocLine(" */");
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\internal\DefaultCommentGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */