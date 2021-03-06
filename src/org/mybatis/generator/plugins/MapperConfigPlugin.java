 package org.mybatis.generator.plugins;
 
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;
 import java.util.Properties;
 import org.mybatis.generator.api.GeneratedXmlFile;
 import org.mybatis.generator.api.IntrospectedTable;
 import org.mybatis.generator.api.PluginAdapter;
 import org.mybatis.generator.api.dom.xml.Attribute;
 import org.mybatis.generator.api.dom.xml.Document;
 import org.mybatis.generator.api.dom.xml.TextElement;
 import org.mybatis.generator.api.dom.xml.XmlElement;
 import org.mybatis.generator.internal.util.StringUtility;
 import org.mybatis.generator.internal.util.messages.Messages;
 
 
 public class MapperConfigPlugin
   extends PluginAdapter
 {
   private List<String> mapperFiles;
   
   public MapperConfigPlugin()
   {
     this.mapperFiles = new ArrayList();
   }
   
   public boolean validate(List<String> warnings) {
     boolean valid = true;
     
     if (!StringUtility.stringHasValue(this.properties
       .getProperty("targetProject"))) {
       warnings.add(
       
         Messages.getString("ValidationError.18", "MapperConfigPlugin", "targetProject"));
       valid = false;
     }
     
     if (!StringUtility.stringHasValue(this.properties
       .getProperty("targetPackage"))) {
       warnings.add(
       
         Messages.getString("ValidationError.18", "MapperConfigPlugin", "targetPackage"));
       valid = false;
     }
     
     return valid;
   }
   
   public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles()
   {
     Document document = new Document(
       "-//mybatis.org//DTD Config 3.0//EN", 
       "mybatis-3-config.dtd");
     
     XmlElement root = new XmlElement("configuration");
     document.setRootElement(root);
     
     root.addElement(new TextElement("<!--"));
     root.addElement(new TextElement(
       "  This file is generated by MyBatis Generator."));
     root
       .addElement(new TextElement(
       "  This file is the shell of a Mapper Config file - in many cases you will need to add"));
     root.addElement(new TextElement(
       "    to this file before it is usable by MyBatis."));
     
     StringBuilder sb = new StringBuilder();
     sb.append("  This file was generated on ");
     sb.append(new Date());
     sb.append('.');
     root.addElement(new TextElement(sb.toString()));
     
     root.addElement(new TextElement("-->"));
     
     XmlElement mappers = new XmlElement("mappers");
     root.addElement(mappers);
     
 
     for (String mapperFile : this.mapperFiles) {
       XmlElement mapper = new XmlElement("mapper");
       mapper.addAttribute(new Attribute("resource", mapperFile));
       mappers.addElement(mapper);
     }
     
     GeneratedXmlFile gxf = new GeneratedXmlFile(document, 
       this.properties.getProperty("fileName", "MapperConfig.xml"), 
       this.properties.getProperty("targetPackage"), 
       this.properties.getProperty("targetProject"), 
       false);
     
     Object answer = new ArrayList(1);
     ((List)answer).add(gxf);
     
     return (List<GeneratedXmlFile>)answer;
   }
   
 
 
 
 
 
   public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable)
   {
     StringBuilder sb = new StringBuilder();
     sb.append(sqlMap.getTargetPackage());
     sb.append('.');
     String temp = sb.toString();
     sb.setLength(0);
     sb.append(temp.replace('.', '/'));
     sb.append(sqlMap.getFileName());
     this.mapperFiles.add(sb.toString());
     
     return true;
   }
 }

