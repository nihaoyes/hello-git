/*     */ package org.mybatis.generator.config.xml;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.config.ColumnOverride;
/*     */ import org.mybatis.generator.config.ColumnRenamingRule;
/*     */ import org.mybatis.generator.config.CommentGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.GeneratedKey;
/*     */ import org.mybatis.generator.config.IgnoredColumn;
/*     */ import org.mybatis.generator.config.JDBCConnectionConfiguration;
/*     */ import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.JavaTypeResolverConfiguration;
/*     */ import org.mybatis.generator.config.ModelType;
/*     */ import org.mybatis.generator.config.PluginConfiguration;
/*     */ import org.mybatis.generator.config.PropertyHolder;
/*     */ import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.TableConfiguration;
/*     */ import org.mybatis.generator.exception.XMLParserException;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ public class MyBatisGeneratorConfigurationParser
/*     */ {
/*     */   private Properties properties;
/*     */   
/*     */   public MyBatisGeneratorConfigurationParser(Properties properties)
/*     */   {
/*  57 */     if (properties == null) {
/*  58 */       this.properties = System.getProperties();
/*     */     } else {
/*  60 */       this.properties = properties;
/*     */     }
/*     */   }
/*     */   
/*     */   public Configuration parseConfiguration(Element rootNode)
/*     */     throws XMLParserException
/*     */   {
/*  67 */     Configuration configuration = new Configuration();
/*     */     
/*  69 */     NodeList nodeList = rootNode.getChildNodes();
/*  70 */     for (int i = 0; i < nodeList.getLength(); i++) {
/*  71 */       Node childNode = nodeList.item(i);
/*     */       
/*  73 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/*  77 */         if ("properties".equals(childNode.getNodeName())) {
/*  78 */           parseProperties(configuration, childNode);
/*  79 */         } else if ("classPathEntry".equals(childNode.getNodeName())) {
/*  80 */           parseClassPathEntry(configuration, childNode);
/*  81 */         } else if ("context".equals(childNode.getNodeName())) {
/*  82 */           parseContext(configuration, childNode);
/*     */         }
/*     */       }
/*     */     }
/*  86 */     return configuration;
/*     */   }
/*     */   
/*     */   private void parseProperties(Configuration configuration, Node node) throws XMLParserException
/*     */   {
/*  91 */     Properties attributes = parseAttributes(node);
/*  92 */     String resource = attributes.getProperty("resource");
/*  93 */     String url = attributes.getProperty("url");
/*     */     
/*  95 */     if ((!StringUtility.stringHasValue(resource)) && 
/*  96 */       (!StringUtility.stringHasValue(url))) {
/*  97 */       throw new XMLParserException(Messages.getString("RuntimeError.14"));
/*     */     }
/*     */     
/* 100 */     if ((StringUtility.stringHasValue(resource)) && 
/* 101 */       (StringUtility.stringHasValue(url))) {
/* 102 */       throw new XMLParserException(Messages.getString("RuntimeError.14"));
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*     */       URL resourceUrl;
/* 108 */       if (StringUtility.stringHasValue(resource)) {
/* 109 */          resourceUrl = Thread.currentThread().getContextClassLoader()
/* 110 */           .getResource(resource);
/* 111 */         if (resourceUrl == null) {
/* 112 */           throw new XMLParserException(Messages.getString(
/* 113 */             "RuntimeError.15", resource));
/*     */         }
/*     */       } else {
/* 116 */         resourceUrl = new URL(url);
/*     */       }
/*     */       
/* 119 */       InputStream inputStream = resourceUrl.openConnection()
/* 120 */         .getInputStream();
/*     */       
/* 122 */       this.properties.load(inputStream);
/* 123 */       inputStream.close();
/*     */     } catch (IOException e) {
/* 125 */       if (StringUtility.stringHasValue(resource)) {
/* 126 */         throw new XMLParserException(Messages.getString(
/* 127 */           "RuntimeError.16", resource));
/*     */       }
/* 129 */       throw new XMLParserException(Messages.getString(
/* 130 */         "RuntimeError.17", url));
/*     */     }
/*     */     URL resourceUrl;
/*     */   }
/*     */   
/*     */   private void parseContext(Configuration configuration, Node node)
/*     */   {
/* 137 */     Properties attributes = parseAttributes(node);
/* 138 */     String defaultModelType = attributes.getProperty("defaultModelType");
/* 139 */     String targetRuntime = attributes.getProperty("targetRuntime");
/* 140 */     String introspectedColumnImpl = attributes
/* 141 */       .getProperty("introspectedColumnImpl");
/* 142 */     String id = attributes.getProperty("id");
/*     */     
/* 144 */     ModelType mt = defaultModelType == null ? null : 
/* 145 */       ModelType.getModelType(defaultModelType);
/*     */     
/* 147 */     Context context = new Context(mt);
/* 148 */     context.setId(id);
/* 149 */     if (StringUtility.stringHasValue(introspectedColumnImpl)) {
/* 150 */       context.setIntrospectedColumnImpl(introspectedColumnImpl);
/*     */     }
/* 152 */     if (StringUtility.stringHasValue(targetRuntime)) {
/* 153 */       context.setTargetRuntime(targetRuntime);
/*     */     }
/*     */     
/* 156 */     configuration.addContext(context);
/*     */     
/* 158 */     NodeList nodeList = node.getChildNodes();
/* 159 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 160 */       Node childNode = nodeList.item(i);
/*     */       
/* 162 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 166 */         if ("property".equals(childNode.getNodeName())) {
/* 167 */           parseProperty(context, childNode);
/* 168 */         } else if ("plugin".equals(childNode.getNodeName())) {
/* 169 */           parsePlugin(context, childNode);
/* 170 */         } else if ("commentGenerator".equals(childNode.getNodeName())) {
/* 171 */           parseCommentGenerator(context, childNode);
/* 172 */         } else if ("jdbcConnection".equals(childNode.getNodeName())) {
/* 173 */           parseJdbcConnection(context, childNode);
/* 174 */         } else if ("javaModelGenerator".equals(childNode.getNodeName())) {
/* 175 */           parseJavaModelGenerator(context, childNode);
/* 176 */         } else if ("javaTypeResolver".equals(childNode.getNodeName())) {
/* 177 */           parseJavaTypeResolver(context, childNode);
/* 178 */         } else if ("sqlMapGenerator".equals(childNode.getNodeName())) {
/* 179 */           parseSqlMapGenerator(context, childNode);
/* 180 */         } else if ("javaClientGenerator".equals(childNode.getNodeName())) {
/* 181 */           parseJavaClientGenerator(context, childNode);
/* 182 */         } else if ("table".equals(childNode.getNodeName()))
/* 183 */           parseTable(context, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseSqlMapGenerator(Context context, Node node) {
/* 189 */     SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
/*     */     
/* 191 */     context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
/*     */     
/* 193 */     Properties attributes = parseAttributes(node);
/* 194 */     String targetPackage = attributes.getProperty("targetPackage");
/* 195 */     String targetProject = attributes.getProperty("targetProject");
/*     */     
/* 197 */     sqlMapGeneratorConfiguration.setTargetPackage(targetPackage);
/* 198 */     sqlMapGeneratorConfiguration.setTargetProject(targetProject);
/*     */     
/* 200 */     NodeList nodeList = node.getChildNodes();
/* 201 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 202 */       Node childNode = nodeList.item(i);
/*     */       
/* 204 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 208 */         if ("property".equals(childNode.getNodeName()))
/* 209 */           parseProperty(sqlMapGeneratorConfiguration, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseTable(Context context, Node node) {
/* 215 */     TableConfiguration tc = new TableConfiguration(context);
/* 216 */     context.addTableConfiguration(tc);
/*     */     
/* 218 */     Properties attributes = parseAttributes(node);
/* 219 */     String catalog = attributes.getProperty("catalog");
/* 220 */     String schema = attributes.getProperty("schema");
/* 221 */     String tableName = attributes.getProperty("tableName");
/* 222 */     String domainObjectName = attributes.getProperty("domainObjectName");
/* 223 */     String alias = attributes.getProperty("alias");
/* 224 */     String enableInsert = attributes.getProperty("enableInsert");
/* 225 */     String enableSelectByPrimaryKey = attributes
/* 226 */       .getProperty("enableSelectByPrimaryKey");
/* 227 */     String enableSelectByExample = attributes
/* 228 */       .getProperty("enableSelectByExample");
/* 229 */     String enableUpdateByPrimaryKey = attributes
/* 230 */       .getProperty("enableUpdateByPrimaryKey");
/* 231 */     String enableDeleteByPrimaryKey = attributes
/* 232 */       .getProperty("enableDeleteByPrimaryKey");
/* 233 */     String enableDeleteByExample = attributes
/* 234 */       .getProperty("enableDeleteByExample");
/* 235 */     String enableCountByExample = attributes
/* 236 */       .getProperty("enableCountByExample");
/* 237 */     String enableUpdateByExample = attributes
/* 238 */       .getProperty("enableUpdateByExample");
/* 239 */     String selectByPrimaryKeyQueryId = attributes
/* 240 */       .getProperty("selectByPrimaryKeyQueryId");
/* 241 */     String selectByExampleQueryId = attributes
/* 242 */       .getProperty("selectByExampleQueryId");
/* 243 */     String modelType = attributes.getProperty("modelType");
/* 244 */     String escapeWildcards = attributes.getProperty("escapeWildcards");
/* 245 */     String delimitIdentifiers = attributes
/* 246 */       .getProperty("delimitIdentifiers");
/* 247 */     String delimitAllColumns = attributes.getProperty("delimitAllColumns");
/*     */     
/* 249 */     if (StringUtility.stringHasValue(catalog)) {
/* 250 */       tc.setCatalog(catalog);
/*     */     }
/*     */     
/* 253 */     if (StringUtility.stringHasValue(schema)) {
/* 254 */       tc.setSchema(schema);
/*     */     }
/*     */     
/* 257 */     if (StringUtility.stringHasValue(tableName)) {
/* 258 */       tc.setTableName(tableName);
/*     */     }
/*     */     
/* 261 */     if (StringUtility.stringHasValue(domainObjectName)) {
/* 262 */       tc.setDomainObjectName(domainObjectName);
/*     */     }
/*     */     
/* 265 */     if (StringUtility.stringHasValue(alias)) {
/* 266 */       tc.setAlias(alias);
/*     */     }
/*     */     
/* 269 */     if (StringUtility.stringHasValue(enableInsert)) {
/* 270 */       tc.setInsertStatementEnabled(StringUtility.isTrue(enableInsert));
/*     */     }
/*     */     
/* 273 */     if (StringUtility.stringHasValue(enableSelectByPrimaryKey)) {
/* 274 */       tc.setSelectByPrimaryKeyStatementEnabled(
/* 275 */         StringUtility.isTrue(enableSelectByPrimaryKey));
/*     */     }
/*     */     
/* 278 */     if (StringUtility.stringHasValue(enableSelectByExample)) {
/* 279 */       tc.setSelectByExampleStatementEnabled(
/* 280 */         StringUtility.isTrue(enableSelectByExample));
/*     */     }
/*     */     
/* 283 */     if (StringUtility.stringHasValue(enableUpdateByPrimaryKey)) {
/* 284 */       tc.setUpdateByPrimaryKeyStatementEnabled(
/* 285 */         StringUtility.isTrue(enableUpdateByPrimaryKey));
/*     */     }
/*     */     
/* 288 */     if (StringUtility.stringHasValue(enableDeleteByPrimaryKey)) {
/* 289 */       tc.setDeleteByPrimaryKeyStatementEnabled(
/* 290 */         StringUtility.isTrue(enableDeleteByPrimaryKey));
/*     */     }
/*     */     
/* 293 */     if (StringUtility.stringHasValue(enableDeleteByExample)) {
/* 294 */       tc.setDeleteByExampleStatementEnabled(
/* 295 */         StringUtility.isTrue(enableDeleteByExample));
/*     */     }
/*     */     
/* 298 */     if (StringUtility.stringHasValue(enableCountByExample)) {
/* 299 */       tc.setCountByExampleStatementEnabled(
/* 300 */         StringUtility.isTrue(enableCountByExample));
/*     */     }
/*     */     
/* 303 */     if (StringUtility.stringHasValue(enableUpdateByExample)) {
/* 304 */       tc.setUpdateByExampleStatementEnabled(
/* 305 */         StringUtility.isTrue(enableUpdateByExample));
/*     */     }
/*     */     
/* 308 */     if (StringUtility.stringHasValue(selectByPrimaryKeyQueryId)) {
/* 309 */       tc.setSelectByPrimaryKeyQueryId(selectByPrimaryKeyQueryId);
/*     */     }
/*     */     
/* 312 */     if (StringUtility.stringHasValue(selectByExampleQueryId)) {
/* 313 */       tc.setSelectByExampleQueryId(selectByExampleQueryId);
/*     */     }
/*     */     
/* 316 */     if (StringUtility.stringHasValue(modelType)) {
/* 317 */       tc.setConfiguredModelType(modelType);
/*     */     }
/*     */     
/* 320 */     if (StringUtility.stringHasValue(escapeWildcards)) {
/* 321 */       tc.setWildcardEscapingEnabled(StringUtility.isTrue(escapeWildcards));
/*     */     }
/*     */     
/* 324 */     if (StringUtility.stringHasValue(delimitIdentifiers)) {
/* 325 */       tc.setDelimitIdentifiers(StringUtility.isTrue(delimitIdentifiers));
/*     */     }
/*     */     
/* 328 */     if (StringUtility.stringHasValue(delimitAllColumns)) {
/* 329 */       tc.setAllColumnDelimitingEnabled(StringUtility.isTrue(delimitAllColumns));
/*     */     }
/*     */     
/* 332 */     NodeList nodeList = node.getChildNodes();
/* 333 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 334 */       Node childNode = nodeList.item(i);
/*     */       
/* 336 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 340 */         if ("property".equals(childNode.getNodeName())) {
/* 341 */           parseProperty(tc, childNode);
/* 342 */         } else if ("columnOverride".equals(childNode.getNodeName())) {
/* 343 */           parseColumnOverride(tc, childNode);
/* 344 */         } else if ("ignoreColumn".equals(childNode.getNodeName())) {
/* 345 */           parseIgnoreColumn(tc, childNode);
/* 346 */         } else if ("generatedKey".equals(childNode.getNodeName())) {
/* 347 */           parseGeneratedKey(tc, childNode);
/* 348 */         } else if ("columnRenamingRule".equals(childNode.getNodeName()))
/* 349 */           parseColumnRenamingRule(tc, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseColumnOverride(TableConfiguration tc, Node node) {
/* 355 */     Properties attributes = parseAttributes(node);
/* 356 */     String column = attributes.getProperty("column");
/* 357 */     String property = attributes.getProperty("property");
/* 358 */     String javaType = attributes.getProperty("javaType");
/* 359 */     String jdbcType = attributes.getProperty("jdbcType");
/* 360 */     String typeHandler = attributes.getProperty("typeHandler");
/* 361 */     String delimitedColumnName = attributes
/* 362 */       .getProperty("delimitedColumnName");
/*     */     
/* 364 */     ColumnOverride co = new ColumnOverride(column);
/*     */     
/* 366 */     if (StringUtility.stringHasValue(property)) {
/* 367 */       co.setJavaProperty(property);
/*     */     }
/*     */     
/* 370 */     if (StringUtility.stringHasValue(javaType)) {
/* 371 */       co.setJavaType(javaType);
/*     */     }
/*     */     
/* 374 */     if (StringUtility.stringHasValue(jdbcType)) {
/* 375 */       co.setJdbcType(jdbcType);
/*     */     }
/*     */     
/* 378 */     if (StringUtility.stringHasValue(typeHandler)) {
/* 379 */       co.setTypeHandler(typeHandler);
/*     */     }
/*     */     
/* 382 */     if (StringUtility.stringHasValue(delimitedColumnName)) {
/* 383 */       co.setColumnNameDelimited(StringUtility.isTrue(delimitedColumnName));
/*     */     }
/*     */     
/* 386 */     NodeList nodeList = node.getChildNodes();
/* 387 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 388 */       Node childNode = nodeList.item(i);
/*     */       
/* 390 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 394 */         if ("property".equals(childNode.getNodeName())) {
/* 395 */           parseProperty(co, childNode);
/*     */         }
/*     */       }
/*     */     }
/* 399 */     tc.addColumnOverride(co);
/*     */   }
/*     */   
/*     */   private void parseGeneratedKey(TableConfiguration tc, Node node) {
/* 403 */     Properties attributes = parseAttributes(node);
/*     */     
/* 405 */     String column = attributes.getProperty("column");
/* 406 */     boolean identity = StringUtility.isTrue(attributes
/* 407 */       .getProperty("identity"));
/* 408 */     String sqlStatement = attributes.getProperty("sqlStatement");
/* 409 */     String type = attributes.getProperty("type");
/*     */     
/* 411 */     GeneratedKey gk = new GeneratedKey(column, sqlStatement, identity, type);
/*     */     
/* 413 */     tc.setGeneratedKey(gk);
/*     */   }
/*     */   
/*     */   private void parseIgnoreColumn(TableConfiguration tc, Node node) {
/* 417 */     Properties attributes = parseAttributes(node);
/* 418 */     String column = attributes.getProperty("column");
/* 419 */     String delimitedColumnName = attributes
/* 420 */       .getProperty("delimitedColumnName");
/*     */     
/* 422 */     IgnoredColumn ic = new IgnoredColumn(column);
/*     */     
/* 424 */     if (StringUtility.stringHasValue(delimitedColumnName)) {
/* 425 */       ic.setColumnNameDelimited(StringUtility.isTrue(delimitedColumnName));
/*     */     }
/*     */     
/* 428 */     tc.addIgnoredColumn(ic);
/*     */   }
/*     */   
/*     */   private void parseColumnRenamingRule(TableConfiguration tc, Node node) {
/* 432 */     Properties attributes = parseAttributes(node);
/* 433 */     String searchString = attributes.getProperty("searchString");
/* 434 */     String replaceString = attributes.getProperty("replaceString");
/*     */     
/* 436 */     ColumnRenamingRule crr = new ColumnRenamingRule();
/*     */     
/* 438 */     crr.setSearchString(searchString);
/*     */     
/* 440 */     if (StringUtility.stringHasValue(replaceString)) {
/* 441 */       crr.setReplaceString(replaceString);
/*     */     }
/*     */     
/* 444 */     tc.setColumnRenamingRule(crr);
/*     */   }
/*     */   
/*     */   private void parseJavaTypeResolver(Context context, Node node) {
/* 448 */     JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
/*     */     
/* 450 */     context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
/*     */     
/* 452 */     Properties attributes = parseAttributes(node);
/* 453 */     String type = attributes.getProperty("type");
/*     */     
/* 455 */     if (StringUtility.stringHasValue(type)) {
/* 456 */       javaTypeResolverConfiguration.setConfigurationType(type);
/*     */     }
/*     */     
/* 459 */     NodeList nodeList = node.getChildNodes();
/* 460 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 461 */       Node childNode = nodeList.item(i);
/*     */       
/* 463 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 467 */         if ("property".equals(childNode.getNodeName()))
/* 468 */           parseProperty(javaTypeResolverConfiguration, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parsePlugin(Context context, Node node) {
/* 474 */     PluginConfiguration pluginConfiguration = new PluginConfiguration();
/*     */     
/* 476 */     context.addPluginConfiguration(pluginConfiguration);
/*     */     
/* 478 */     Properties attributes = parseAttributes(node);
/* 479 */     String type = attributes.getProperty("type");
/*     */     
/* 481 */     pluginConfiguration.setConfigurationType(type);
/*     */     
/* 483 */     NodeList nodeList = node.getChildNodes();
/* 484 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 485 */       Node childNode = nodeList.item(i);
/*     */       
/* 487 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 491 */         if ("property".equals(childNode.getNodeName()))
/* 492 */           parseProperty(pluginConfiguration, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseJavaModelGenerator(Context context, Node node) {
/* 498 */     JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
/*     */     
/* 500 */     context
/* 501 */       .setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
/*     */     
/* 503 */     Properties attributes = parseAttributes(node);
/* 504 */     String targetPackage = attributes.getProperty("targetPackage");
/* 505 */     String targetProject = attributes.getProperty("targetProject");
/*     */     
/* 507 */     javaModelGeneratorConfiguration.setTargetPackage(targetPackage);
/* 508 */     javaModelGeneratorConfiguration.setTargetProject(targetProject);
/*     */     
/* 510 */     NodeList nodeList = node.getChildNodes();
/* 511 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 512 */       Node childNode = nodeList.item(i);
/*     */       
/* 514 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 518 */         if ("property".equals(childNode.getNodeName()))
/* 519 */           parseProperty(javaModelGeneratorConfiguration, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseJavaClientGenerator(Context context, Node node) {
/* 525 */     JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
/*     */     
/* 527 */     context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
/*     */     
/* 529 */     Properties attributes = parseAttributes(node);
/* 530 */     String type = attributes.getProperty("type");
/* 531 */     String targetPackage = attributes.getProperty("targetPackage");
/* 532 */     String targetProject = attributes.getProperty("targetProject");
/* 533 */     String implementationPackage = attributes
/* 534 */       .getProperty("implementationPackage");
/*     */     
/* 536 */     javaClientGeneratorConfiguration.setConfigurationType(type);
/* 537 */     javaClientGeneratorConfiguration.setTargetPackage(targetPackage);
/* 538 */     javaClientGeneratorConfiguration.setTargetProject(targetProject);
/* 539 */     javaClientGeneratorConfiguration
/* 540 */       .setImplementationPackage(implementationPackage);
/*     */     
/* 542 */     NodeList nodeList = node.getChildNodes();
/* 543 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 544 */       Node childNode = nodeList.item(i);
/*     */       
/* 546 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 550 */         if ("property".equals(childNode.getNodeName()))
/* 551 */           parseProperty(javaClientGeneratorConfiguration, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseJdbcConnection(Context context, Node node) {
/* 557 */     JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
/*     */     
/* 559 */     context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
/*     */     
/* 561 */     Properties attributes = parseAttributes(node);
/* 562 */     String driverClass = attributes.getProperty("driverClass");
/* 563 */     String connectionURL = attributes.getProperty("connectionURL");
/* 564 */     String userId = attributes.getProperty("userId");
/* 565 */     String password = attributes.getProperty("password");
/*     */     
/* 567 */     jdbcConnectionConfiguration.setDriverClass(driverClass);
/* 568 */     jdbcConnectionConfiguration.setConnectionURL(connectionURL);
/*     */     
/* 570 */     if (StringUtility.stringHasValue(userId)) {
/* 571 */       jdbcConnectionConfiguration.setUserId(userId);
/*     */     }
/*     */     
/* 574 */     if (StringUtility.stringHasValue(password)) {
/* 575 */       jdbcConnectionConfiguration.setPassword(password);
/*     */     }
/*     */     
/* 578 */     NodeList nodeList = node.getChildNodes();
/* 579 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 580 */       Node childNode = nodeList.item(i);
/*     */       
/* 582 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 586 */         if ("property".equals(childNode.getNodeName()))
/* 587 */           parseProperty(jdbcConnectionConfiguration, childNode);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseClassPathEntry(Configuration configuration, Node node) {
/* 593 */     Properties attributes = parseAttributes(node);
/*     */     
/* 595 */     configuration.addClasspathEntry(attributes.getProperty("location"));
/*     */   }
/*     */   
/*     */   private void parseProperty(PropertyHolder propertyHolder, Node node) {
/* 599 */     Properties attributes = parseAttributes(node);
/*     */     
/* 601 */     String name = attributes.getProperty("name");
/* 602 */     String value = attributes.getProperty("value");
/*     */     
/* 604 */     propertyHolder.addProperty(name, value);
/*     */   }
/*     */   
/*     */   private Properties parseAttributes(Node node) {
/* 608 */     Properties attributes = new Properties();
/* 609 */     NamedNodeMap nnm = node.getAttributes();
/* 610 */     for (int i = 0; i < nnm.getLength(); i++) {
/* 611 */       Node attribute = nnm.item(i);
/* 612 */       String value = parsePropertyTokens(attribute.getNodeValue());
/* 613 */       attributes.put(attribute.getNodeName(), value);
/*     */     }
/*     */     
/* 616 */     return attributes;
/*     */   }
/*     */   
/*     */   private String parsePropertyTokens(String string) {
/* 620 */     String OPEN = "${";
/* 621 */     String CLOSE = "}";
/*     */     
/* 623 */     String newString = string;
/* 624 */     if (newString != null) {
/* 625 */       int start = newString.indexOf("${");
/* 626 */       int end = newString.indexOf("}");
/*     */       
/* 628 */       while ((start > -1) && (end > start)) {
/* 629 */         String prepend = newString.substring(0, start);
/* 630 */         String append = newString.substring(end + "}".length());
/* 631 */         String propName = newString.substring(start + "${".length(), 
/* 632 */           end);
/* 633 */         String propValue = this.properties.getProperty(propName);
/* 634 */         if (propValue != null) {
/* 635 */           newString = prepend + propValue + append;
/*     */         }
/*     */         
/* 638 */         start = newString.indexOf("${", end);
/* 639 */         end = newString.indexOf("}", end);
/*     */       }
/*     */     }
/*     */     
/* 643 */     return newString;
/*     */   }
/*     */   
/*     */   private void parseCommentGenerator(Context context, Node node) {
/* 647 */     CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
/*     */     
/* 649 */     context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
/*     */     
/* 651 */     Properties attributes = parseAttributes(node);
/* 652 */     String type = attributes.getProperty("type");
/*     */     
/* 654 */     if (StringUtility.stringHasValue(type)) {
/* 655 */       commentGeneratorConfiguration.setConfigurationType(type);
/*     */     }
/*     */     
/* 658 */     NodeList nodeList = node.getChildNodes();
/* 659 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 660 */       Node childNode = nodeList.item(i);
/*     */       
/* 662 */       if (childNode.getNodeType() == 1)
/*     */       {
/*     */ 
/*     */ 
/* 666 */         if ("property".equals(childNode.getNodeName())) {
/* 667 */           parseProperty(commentGeneratorConfiguration, childNode);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\config\xml\MyBatisGeneratorConfigurationParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */