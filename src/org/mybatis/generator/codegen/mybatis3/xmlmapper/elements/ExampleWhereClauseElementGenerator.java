/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.config.Context;
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
/*     */ public class ExampleWhereClauseElementGenerator
/*     */   extends AbstractXmlElementGenerator
/*     */ {
/*     */   private boolean isForUpdateByExample;
/*     */   
/*     */   public ExampleWhereClauseElementGenerator(boolean isForUpdateByExample)
/*     */   {
/*  37 */     this.isForUpdateByExample = isForUpdateByExample;
/*     */   }
/*     */   
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  42 */     XmlElement answer = new XmlElement("sql");
/*     */     
/*  44 */     if (this.isForUpdateByExample)
/*     */     {
/*  46 */       answer.addAttribute(new Attribute(
/*  47 */         "id", this.introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
/*     */     } else {
/*  49 */       answer.addAttribute(new Attribute(
/*  50 */         "id", this.introspectedTable.getExampleWhereClauseId()));
/*     */     }
/*     */     
/*  53 */     this.context.getCommentGenerator().addComment(answer);
/*     */     
/*  55 */     XmlElement whereElement = new XmlElement("where");
/*  56 */     answer.addElement(whereElement);
/*     */     
/*  58 */     XmlElement outerForEachElement = new XmlElement("foreach");
/*  59 */     if (this.isForUpdateByExample) {
/*  60 */       outerForEachElement.addAttribute(new Attribute(
/*  61 */         "collection", "example.oredCriteria"));
/*     */     } else {
/*  63 */       outerForEachElement.addAttribute(new Attribute(
/*  64 */         "collection", "oredCriteria"));
/*     */     }
/*  66 */     outerForEachElement.addAttribute(new Attribute("item", "criteria"));
/*  67 */     outerForEachElement.addAttribute(new Attribute("separator", "or"));
/*  68 */     whereElement.addElement(outerForEachElement);
/*     */     
/*  70 */     XmlElement ifElement = new XmlElement("if");
/*  71 */     ifElement.addAttribute(new Attribute("test", "criteria.valid"));
/*  72 */     outerForEachElement.addElement(ifElement);
/*     */     
/*  74 */     XmlElement trimElement = new XmlElement("trim");
/*  75 */     trimElement.addAttribute(new Attribute("prefix", "("));
/*  76 */     trimElement.addAttribute(new Attribute("suffix", ")"));
/*  77 */     trimElement.addAttribute(new Attribute("prefixOverrides", "and"));
/*     */     
/*  79 */     ifElement.addElement(trimElement);
/*     */     
/*  81 */     trimElement.addElement(getMiddleForEachElement(null));
/*     */     
/*     */ 
/*  84 */     Iterator localIterator = this.introspectedTable.getNonBLOBColumns().iterator();
/*  83 */     while (localIterator.hasNext()) {
/*  84 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)localIterator.next();
/*  85 */       if (StringUtility.stringHasValue(introspectedColumn
/*  86 */         .getTypeHandler()))
/*     */       {
/*  88 */         trimElement.addElement(getMiddleForEachElement(introspectedColumn));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  93 */     if (this.context.getPlugins().sqlMapExampleWhereClauseElementGenerated(answer, 
/*  94 */       this.introspectedTable)) {
/*  95 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */   
/*     */   private XmlElement getMiddleForEachElement(IntrospectedColumn introspectedColumn)
/*     */   {
/* 101 */     StringBuilder sb = new StringBuilder();
/*     */     String typeHandlerString;
/*     */     String criteriaAttribute;
/*     */     boolean typeHandled;
/* 105 */     if (introspectedColumn == null) {
/* 106 */        criteriaAttribute = "criteria.criteria";
/* 107 */        typeHandled = false;
/* 108 */       typeHandlerString = null;
/*     */     } else {
/* 110 */       sb.setLength(0);
/* 111 */       sb.append("criteria.");
/* 112 */       sb.append(introspectedColumn.getJavaProperty());
/* 113 */       sb.append("Criteria");
/* 114 */       criteriaAttribute = sb.toString();
/*     */       
/* 116 */       typeHandled = true;
/*     */       
/* 118 */       sb.setLength(0);
/* 119 */       sb.append(",typeHandler=");
/* 120 */       sb.append(introspectedColumn.getTypeHandler());
/* 121 */       typeHandlerString = sb.toString();
/*     */     }
/*     */     
/* 124 */     XmlElement middleForEachElement = new XmlElement("foreach");
/* 125 */     middleForEachElement.addAttribute(new Attribute(
/* 126 */       "collection", criteriaAttribute));
/* 127 */     middleForEachElement.addAttribute(new Attribute("item", "criterion"));
/*     */     
/* 129 */     XmlElement chooseElement = new XmlElement("choose");
/* 130 */     middleForEachElement.addElement(chooseElement);
/*     */     
/* 132 */     XmlElement when = new XmlElement("when");
/* 133 */     when.addAttribute(new Attribute("test", "criterion.noValue"));
/* 134 */     when.addElement(new TextElement("and ${criterion.condition}"));
/* 135 */     chooseElement.addElement(when);
/*     */     
/* 137 */     when = new XmlElement("when");
/* 138 */     when.addAttribute(new Attribute("test", "criterion.singleValue"));
/* 139 */     sb.setLength(0);
/* 140 */     sb.append("and ${criterion.condition} #{criterion.value");
/* 141 */     if (typeHandled) {
/* 142 */       sb.append(typeHandlerString);
/*     */     }
/* 144 */     sb.append('}');
/* 145 */     when.addElement(new TextElement(sb.toString()));
/* 146 */     chooseElement.addElement(when);
/*     */     
/* 148 */     when = new XmlElement("when");
/* 149 */     when.addAttribute(new Attribute("test", "criterion.betweenValue"));
/* 150 */     sb.setLength(0);
/* 151 */     sb.append("and ${criterion.condition} #{criterion.value");
/* 152 */     if (typeHandled) {
/* 153 */       sb.append(typeHandlerString);
/*     */     }
/* 155 */     sb.append("} and #{criterion.secondValue");
/* 156 */     if (typeHandled) {
/* 157 */       sb.append(typeHandlerString);
/*     */     }
/* 159 */     sb.append('}');
/* 160 */     when.addElement(new TextElement(sb.toString()));
/* 161 */     chooseElement.addElement(when);
/*     */     
/* 163 */     when = new XmlElement("when");
/* 164 */     when.addAttribute(new Attribute("test", "criterion.listValue"));
/* 165 */     when.addElement(new TextElement("and ${criterion.condition}"));
/* 166 */     XmlElement innerForEach = new XmlElement("foreach");
/* 167 */     innerForEach
/* 168 */       .addAttribute(new Attribute("collection", "criterion.value"));
/* 169 */     innerForEach.addAttribute(new Attribute("item", "listItem"));
/* 170 */     innerForEach.addAttribute(new Attribute("open", "("));
/* 171 */     innerForEach.addAttribute(new Attribute("close", ")"));
/* 172 */     innerForEach.addAttribute(new Attribute("separator", ","));
/* 173 */     sb.setLength(0);
/* 174 */     sb.append("#{listItem");
/* 175 */     if (typeHandled) {
/* 176 */       sb.append(typeHandlerString);
/*     */     }
/* 178 */     sb.append('}');
/* 179 */     innerForEach.addElement(new TextElement(sb.toString()));
/* 180 */     when.addElement(innerForEach);
/* 181 */     chooseElement.addElement(when);
/*     */     
/* 183 */     return middleForEachElement;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\codegen\mybatis3\xmlmapper\elements\ExampleWhereClauseElementGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */