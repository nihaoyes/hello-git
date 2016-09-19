/*     */ package ibator.util;
/*     */ 
/*     */ import ibator.Globar;
/*     */ import ibator.vo.ConfigVO;
/*     */ import ibator.vo.DBVO;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.List;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentHelper;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SqlConfigUtil
/*     */ {
/*     */   public static void createIbatsConfig3(ConfigVO vo, File file, List<String> map)
/*     */   {
/*  24 */     Document document = null;
/*     */     try {
/*  26 */       document = new SAXReader().read(new InputStreamReader(new FileInputStream(file), "utf-8"));
/*     */     }
/*     */     catch (Exception localException) {}
/*  29 */     if (document == null) {
/*  30 */       document = DocumentHelper.createDocument();
/*     */       
/*  32 */       document.addDocType("configuration", 
/*  33 */         "-//mybatis.org//DTD Config 3.0//EN", 
/*  34 */         "mybatis-3-config.dtd");
/*     */     }
/*  36 */     Element root = document.getRootElement();
/*  37 */     if (root == null) {
/*  38 */       root = document.addElement("configuration");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  43 */     Element settings = (Element)root.selectSingleNode("/configuration/settings");
/*  44 */     if (settings == null) {
/*  45 */       root.addComment(" - - - - - - 懒加载和缓存 - - - - - - - - - - ");
/*  46 */       settings = root.addElement("settings");
/*     */     }
/*     */     
/*  49 */     Element setting3 = (Element)settings.selectSingleNode("setting[@name='cacheEnabled']");
/*  50 */     if (setting3 == null) {
/*  51 */       setting3 = settings.addElement("setting");
/*  52 */       setting3.addAttribute("name", "cacheEnabled");
/*  53 */       setting3.addAttribute("value", "true");
/*     */     }
/*     */     
/*  56 */     Element setting1 = (Element)settings.selectSingleNode("setting[@name='lazyLoadingEnabled']");
/*  57 */     if (setting1 == null) {
/*  58 */       setting1 = settings.addElement("setting");
/*  59 */       setting1.addAttribute("name", "lazyLoadingEnabled");
/*  60 */       setting1.addAttribute("value", "true");
/*     */     }
/*     */     
/*  63 */     Element setting2 = (Element)settings.selectSingleNode("setting[@name='aggressiveLazyLoading']");
/*  64 */     if (setting2 == null) {
/*  65 */       setting2 = settings.addElement("setting");
/*  66 */       setting2.addAttribute("name", "aggressiveLazyLoading");
/*  67 */       setting2.addAttribute("value", "false");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  73 */     String dialectClass = DBUtil.getDialect(vo.getDbVo());
/*  74 */     if (dialectClass != null) {
/*  75 */       Element plugins = (Element)root.selectSingleNode("plugins");
/*  76 */       if (plugins == null)
/*     */       {
/*     */ 
/*  79 */         root.addComment(" - - - - - - - 物理分页拦截器 - - - - - - - ");
/*  80 */         plugins = root.addElement("plugins");
/*     */       }
/*     */       
/*  83 */       Element plugin1 = (Element)plugins
/*  84 */         .selectSingleNode("plugin[@interceptor='ibator.dialect.tool.ResultSetInterceptor']");
/*  85 */       if (plugin1 == null) {
/*  86 */         plugin1 = plugins.addElement("plugin");
/*  87 */         plugin1.addAttribute("interceptor", 
/*  88 */           "ibator.dialect.tool.ResultSetInterceptor");
/*     */       }
/*     */       
/*  91 */       Element plugin2 = (Element)plugins
/*  92 */         .selectSingleNode("plugin[@interceptor='ibator.dialect.tool.StatementInterceptor']");
/*  93 */       if (plugin2 == null) {
/*  94 */         plugin2 = plugins.addElement("plugin");
/*  95 */         plugin2.addAttribute("interceptor", 
/*  96 */           "ibator.dialect.tool.StatementInterceptor");
/*     */       }
/*     */       
/*  99 */       Element dialect = (Element)plugin2
/* 100 */         .selectSingleNode("property[@name='dialect']");
/* 101 */       if (dialect == null) {
/* 102 */         dialect = plugin2.addElement("property");
/* 103 */         dialect.addAttribute("name", "dialect");
/* 104 */         dialect.addAttribute("value", dialectClass);
/*     */       }
/*     */     }
/*     */     
/*     */     Element transactionManager;
/*     */     
/* 110 */     if (!Globar.spring)
/*     */     {
/*     */ 
/* 113 */       Element environments = (Element)root
/* 114 */         .selectSingleNode("environments");
/* 115 */       if (environments == null) {
/* 116 */         root.addComment(" - - - - - - 数据库环境配置- - - - - - - - - ");
/* 117 */         environments = root.addElement("environments");
/*     */       }
/* 119 */       environments.addAttribute("default", "environments");
/*     */       
/*     */ 
/* 122 */       Element environment = (Element)environments
/* 123 */         .selectSingleNode("environment");
/* 124 */       if (environment == null) {
/* 125 */         environment = environments.addElement("environment");
/*     */       }
/* 127 */       environment.addAttribute("id", vo.getDbVo().getDname());
/*     */       
/*     */ 
/* 130 */       transactionManager = (Element)environment
/* 131 */         .selectSingleNode("transactionManager");
/* 132 */       if (transactionManager == null)
/* 133 */         transactionManager = 
/* 134 */           environment.addElement("transactionManager");
/* 135 */       transactionManager.addAttribute("type", "JDBC");
/*     */       
/*     */ 
/* 138 */       Element datasource = (Element)environment
/* 139 */         .selectSingleNode("dataSource");
/* 140 */       if (datasource == null)
/* 141 */         datasource = environment.addElement("dataSource");
/* 142 */       datasource.addAttribute("type", "POOLED");
/*     */       
/*     */ 
/* 145 */       Element driver = (Element)datasource
/* 146 */         .selectSingleNode("property[@name='driver']");
/* 147 */       Element url = (Element)datasource
/* 148 */         .selectSingleNode("property[@name='url']");
/* 149 */       Element username = (Element)datasource
/* 150 */         .selectSingleNode("property[@name='username'");
/* 151 */       Element password = (Element)datasource
/* 152 */         .selectSingleNode("property[@name='password']");
/* 153 */       if (driver == null)
/* 154 */         driver = datasource.addElement("property");
/* 155 */       if (url == null)
/* 156 */         url = datasource.addElement("property");
/* 157 */       if (username == null)
/* 158 */         username = datasource.addElement("property");
/* 159 */       if (password == null)
/* 160 */         password = datasource.addElement("property");
/* 161 */       username.addAttribute("name", "username");
/* 162 */       username.addAttribute("value", vo.getDbVo().getUsername());
/* 163 */       password.addAttribute("name", "password");
/* 164 */       password.addAttribute("value", vo.getDbVo().getPassword());
/* 165 */       driver.addAttribute("name", "driver");
/* 166 */       driver.addAttribute("value", vo.getDbVo().getDriver());
/* 167 */       url.addAttribute("name", "url");
/* 168 */       url.addAttribute("value", vo.getDbVo().getUrl());
/*     */     }
/*     */     
/*     */ 
/* 172 */     if ((map != null) && 
/* 173 */       (!Globar.global.getDaoType().equalsIgnoreCase("annotation")))
/*     */     {
/* 175 */       Element mappers = (Element)root.selectSingleNode("mappers");
/* 176 */       if (mappers == null) {
/* 177 */         root.addComment(" - - - - - - -映射文件路径- - - - - - ");
/* 178 */         mappers = root.addElement("mappers");
/*     */       }
/*     */       
/* 181 */       for (String m : map)
/* 182 */         if (mappers.selectSingleNode("mapper[@resource='" + m + "']") == null)
/*     */         {
/* 184 */           Element mm = mappers.addElement("mapper");
/* 185 */           mm.addAttribute("resource", m);
/*     */         }
/*     */     }
/* 188 */     Dom4jUtil.writeDocument(document, file);
/*     */   }
/*     */ }

