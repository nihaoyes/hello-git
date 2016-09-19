/*     */ package ibator.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentHelper;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.Node;
/*     */ import org.dom4j.io.OutputFormat;
/*     */ import org.dom4j.io.SAXReader;
/*     */ import org.dom4j.io.XMLWriter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Dom4jUtil
/*     */ {
/*     */   public static Document readDocument(String file)
/*     */   {
/*  26 */     return readDocument(new File(file));
/*     */   }
/*     */   
/*     */ 
/*     */   public static Document readDocument(File file)
/*     */   {
/*  32 */     SAXReader saxReader = new SAXReader();
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  37 */       return saxReader.read(file);
/*     */     }
/*     */     catch (Exception e) {}
/*  40 */     return null;
/*     */   }
/*     */   
/*     */   public static void writeDocument(Document document, File file)
/*     */   {
/*     */     try
/*     */     {
/*  47 */       OutputFormat format = new OutputFormat("  ", true);
/*  48 */       format.setLineSeparator("\n\r");
/*     */       
/*  50 */       OutputFormat outputFormat = OutputFormat.createPrettyPrint();
/*  51 */       Writer os = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
/*  52 */       outputFormat.setNewlines(true);
/*  53 */       outputFormat.setIndent(true);
/*  54 */       outputFormat.setIndentSize(4);
/*     */       
/*     */ 
/*  57 */       XMLWriter xmlWriter = new XMLWriter(os, outputFormat);
/*  58 */       xmlWriter.write(document);
/*  59 */       xmlWriter.flush();
/*  60 */       os.close();
/*  61 */       xmlWriter.close();
/*     */     } catch (Exception e) {
/*  63 */       throw new RuntimeException("写xml出错了:" + e.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void writeDocument(Document document, String file) {
/*  68 */     writeDocument(document, new File(file));
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
/*     */   public static String getDialect3(Document document)
/*     */   {
/* 164 */     Element dialectProperty = (Element)document.selectSingleNode("/configuration/properties/property[@name='dialect']");
/* 165 */     if (dialectProperty == null)
/* 166 */       throw new RuntimeException("方言获取失败，请重新配置");
/* 167 */     return dialectProperty.getTextTrim();
/*     */   }
/*     */   
/*     */   public static Map getConnectionProperty3(Document document)
/*     */   {
/* 172 */     Element username = (Element)document.selectSingleNode("/configuration/environments/environment/property[@name='username']");
/* 173 */     Element password = (Element)document.selectSingleNode("/configuration/environments/environment/property[@name='password']");
/* 174 */     Element url = (Element)document.selectSingleNode("/configuration/environments/environment/property[@name='url']");
/* 175 */     Element driver = (Element)document.selectSingleNode("/configuration/environments/environment/property[@name='driver']");
/* 176 */     if ((username == null) || (password == null) || (url == null) || (driver == null)) {
/* 177 */       throw new RuntimeException("配置文件没有:用户名，密码，连接字符串，驱动类一个或多个");
/*     */     }
/* 179 */     Map map = new HashMap();
/* 180 */     map.put("username", username.attributeValue("value"));
/* 181 */     map.put("password", password.attributeValue("value"));
/* 182 */     map.put("url", url.attributeValue("value"));
/* 183 */     map.put("driver", driver.attributeValue("value"));
/*     */     
/* 185 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static Element getDom(Document document, String path, Element... parent)
/*     */   {
/* 192 */     Node node = document.selectSingleNode(path);
/* 193 */     if (node == null) {
/* 194 */       int end = path.indexOf('[');
/* 195 */       if (end == -1) {
/* 196 */         path = path.substring(path.lastIndexOf("/") + 1);
/*     */       } else
/* 198 */         path = path.substring(path.lastIndexOf("/") + 1, end);
/* 199 */       if ((parent == null) || (parent.length == 0)) {
/* 200 */         node = document.addElement(path);
/*     */       } else {
/* 202 */         node = parent[0].addElement(path);
/*     */       }
/*     */     }
/* 205 */     return (Element)node;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void createDOCTYPE(Document document, String name, String namespace, String url)
/*     */   {
/* 213 */     if (document.getDocType() == null)
/* 214 */       document.addDocType(name, namespace, url);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 218 */     Dom4jUtil obj = new Dom4jUtil();
/* 219 */     Document doc = DocumentHelper.createDocument();
/*     */   }
/*     */ }

