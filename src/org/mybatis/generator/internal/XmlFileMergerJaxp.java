/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.mybatis.generator.api.GeneratedXmlFile;
/*     */ import org.mybatis.generator.config.MergeConstants;
/*     */ import org.mybatis.generator.exception.ShellException;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ import org.w3c.dom.Comment;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.DocumentType;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ import org.xml.sax.EntityResolver;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
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
/*     */ public class XmlFileMergerJaxp
/*     */ {
/*     */   private static class NullEntityResolver
/*     */     implements EntityResolver
/*     */   {
/*     */     public InputSource resolveEntity(String publicId, String systemId)
/*     */       throws SAXException, IOException
/*     */     {
/*  59 */       StringReader sr = new StringReader("");
/*     */       
/*  61 */       return new InputSource(sr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getMergedSource(GeneratedXmlFile generatedXmlFile, File existingFile)
/*     */     throws ShellException
/*     */   {
/*     */     try
/*     */     {
/*  75 */       DocumentBuilderFactory factory = 
/*  76 */         DocumentBuilderFactory.newInstance();
/*  77 */       factory.setExpandEntityReferences(false);
/*  78 */       DocumentBuilder builder = factory.newDocumentBuilder();
/*  79 */       builder.setEntityResolver(new NullEntityResolver());
/*     */       
/*  81 */       Document existingDocument = builder.parse(existingFile);
/*  82 */       StringReader sr = new StringReader(
/*  83 */         generatedXmlFile.getFormattedContent());
/*  84 */       Document newDocument = builder.parse(new InputSource(sr));
/*     */       
/*  86 */       DocumentType newDocType = newDocument.getDoctype();
/*  87 */       DocumentType existingDocType = existingDocument.getDoctype();
/*     */       
/*  89 */       if (!newDocType.getName().equals(existingDocType.getName())) {
/*  90 */         throw new ShellException(
/*  91 */           Messages.getString("Warning.12", existingFile.getName()));
/*     */       }
/*     */       
/*  94 */       Element existingRootElement = existingDocument.getDocumentElement();
/*  95 */       Element newRootElement = newDocument.getDocumentElement();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */       NamedNodeMap attributes = existingRootElement.getAttributes();
/* 103 */       int attributeCount = attributes.getLength();
/* 104 */       for (int i = attributeCount - 1; i >= 0; i--) {
/* 105 */         Node node = attributes.item(i);
/* 106 */         existingRootElement.removeAttribute(node.getNodeName());
/*     */       }
/*     */       
/*     */ 
/* 110 */       attributes = newRootElement.getAttributes();
/* 111 */       attributeCount = attributes.getLength();
/* 112 */       for (int i = 0; i < attributeCount; i++) {
/* 113 */         Node node = attributes.item(i);
/* 114 */         existingRootElement.setAttribute(node.getNodeName(), 
/* 115 */           node.getNodeValue());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 120 */       List<Node> nodesToDelete = new ArrayList();
/* 121 */       NodeList children = existingRootElement.getChildNodes();
/* 122 */       int length = children.getLength();
/* 123 */       Node node; 
                for (int i = 0; i < length; i++) {
/* 124 */         node = children.item(i);
/* 125 */         if (isGeneratedNode(node)) {
/* 126 */           nodesToDelete.add(node);
/* 127 */         } else if ((isWhiteSpace(node)) && 
/* 128 */           (isGeneratedNode(children.item(i + 1)))) {
/* 129 */           nodesToDelete.add(node);
/*     */         }
/*     */       }
/*     */       
/* 133 */       for (Node node1 : nodesToDelete) {
/* 134 */         existingRootElement.removeChild(node1);
/*     */       }
/*     */       
/*     */ 
/* 138 */       children = newRootElement.getChildNodes();
/* 139 */       length = children.getLength();
/* 140 */       Node firstChild = existingRootElement.getFirstChild();
/* 141 */       for (int i = 0; i < length; i++) {
/* 142 */         Node node2 = children.item(i);
/*     */         
/* 144 */         if ((i == length - 1) && 
/* 145 */           (isWhiteSpace(node2))) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/* 150 */         Node newNode = existingDocument.importNode(node2, true);
/* 151 */         if (firstChild == null) {
/* 152 */           existingRootElement.appendChild(newNode);
/*     */         } else {
/* 154 */           existingRootElement.insertBefore(newNode, firstChild);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 159 */       return prettyPrint(existingDocument);
/*     */     } catch (Exception e) {
/* 161 */       throw new ShellException(
/* 162 */         Messages.getString("Warning.13", existingFile.getName()), e);
/*     */     }
/*     */   }
/*     */   
/*     */   private static String prettyPrint(Document document) throws ShellException {
/* 167 */     DomWriter dw = new DomWriter();
/* 168 */     String s = dw.toString(document);
/* 169 */     return s;
/*     */   }
/*     */   
/*     */   private static boolean isGeneratedNode(Node node) {
/* 173 */     boolean rc = false;
/*     */     
/* 175 */     if ((node != null) && (node.getNodeType() == 1)) {
/* 176 */       Element element = (Element)node;
/* 177 */       String id = element.getAttribute("id");
/* 178 */       if (id != null) { String[] arrayOfString1;
/* 179 */         int j = (arrayOfString1 = MergeConstants.OLD_XML_ELEMENT_PREFIXES).length; for (int i = 0; i < j; i++) { String prefix = arrayOfString1[i];
/* 180 */           if (id.startsWith(prefix)) {
/* 181 */             rc = true;
/* 182 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 187 */       if (!rc)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 192 */         NodeList children = node.getChildNodes();
/* 193 */         int length = children.getLength();
/* 194 */         for (int i = 0; i < length; i++) {
/* 195 */           Node childNode = children.item(i);
/* 196 */           if (!isWhiteSpace(childNode))
/*     */           {
/* 198 */             if (childNode.getNodeType() != 8) break;
/* 199 */             Comment comment = (Comment)childNode;
/* 200 */             String commentData = comment.getData();
/* 201 */             String[] arrayOfString2; int m = (arrayOfString2 = MergeConstants.OLD_ELEMENT_TAGS).length; for (int k = 0; k < m; k++) { String tag = arrayOfString2[k];
/* 202 */               if (commentData.contains(tag)) {
/* 203 */                 rc = true;
/* 204 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 214 */     return rc;
/*     */   }
/*     */   
/*     */   private static boolean isWhiteSpace(Node node) {
/* 218 */     boolean rc = false;
/*     */     
/* 220 */     if ((node != null) && (node.getNodeType() == 3)) {
/* 221 */       Text tn = (Text)node;
/* 222 */       if (tn.getData().trim().length() == 0) {
/* 223 */         rc = true;
/*     */       }
/*     */     }
/*     */     
/* 227 */     return rc;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\internal\XmlFileMergerJaxp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */