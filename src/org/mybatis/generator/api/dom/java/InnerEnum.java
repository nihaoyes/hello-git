/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
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
/*     */ public class InnerEnum
/*     */   extends JavaElement
/*     */ {
/*     */   private List<Field> fields;
/*     */   private List<InnerClass> innerClasses;
/*     */   private List<InnerEnum> innerEnums;
/*     */   private FullyQualifiedJavaType type;
/*     */   private Set<FullyQualifiedJavaType> superInterfaceTypes;
/*     */   private List<Method> methods;
/*     */   private List<String> enumConstants;
/*     */   
/*     */   public InnerEnum(FullyQualifiedJavaType type)
/*     */   {
/*  54 */     this.type = type;
/*  55 */     this.fields = new ArrayList();
/*  56 */     this.innerClasses = new ArrayList();
/*  57 */     this.innerEnums = new ArrayList();
/*  58 */     this.superInterfaceTypes = new HashSet();
/*  59 */     this.methods = new ArrayList();
/*  60 */     this.enumConstants = new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Field> getFields()
/*     */   {
/*  67 */     return this.fields;
/*     */   }
/*     */   
/*     */   public void addField(Field field) {
/*  71 */     this.fields.add(field);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<InnerClass> getInnerClasses()
/*     */   {
/*  78 */     return this.innerClasses;
/*     */   }
/*     */   
/*     */   public void addInnerClass(InnerClass innerClass) {
/*  82 */     this.innerClasses.add(innerClass);
/*     */   }
/*     */   
/*     */   public List<InnerEnum> getInnerEnums() {
/*  86 */     return this.innerEnums;
/*     */   }
/*     */   
/*     */   public void addInnerEnum(InnerEnum innerEnum) {
/*  90 */     this.innerEnums.add(innerEnum);
/*     */   }
/*     */   
/*     */   public List<String> getEnumConstants() {
/*  94 */     return this.enumConstants;
/*     */   }
/*     */   
/*     */   public void addEnumConstant(String enumConstant) {
/*  98 */     this.enumConstants.add(enumConstant);
/*     */   }
/*     */   
/*     */   public String getFormattedContent(int indentLevel) {
/* 102 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 104 */     addFormattedJavadoc(sb, indentLevel);
/* 105 */     addFormattedAnnotations(sb, indentLevel);
/*     */     
/* 107 */     OutputUtilities.javaIndent(sb, indentLevel);
/* 108 */     if (getVisibility() == JavaVisibility.PUBLIC) {
/* 109 */       sb.append(getVisibility().getValue());
/*     */     }
/*     */     
/* 112 */     sb.append("enum ");
/* 113 */     sb.append(getType().getShortName());
/*     */     
/* 115 */     if (this.superInterfaceTypes.size() > 0) {
/* 116 */       sb.append(" implements ");
/*     */       
/* 118 */       boolean comma = false;
/* 119 */       for (FullyQualifiedJavaType fqjt : this.superInterfaceTypes) {
/* 120 */         if (comma) {
/* 121 */           sb.append(", ");
/*     */         } else {
/* 123 */           comma = true;
/*     */         }
/*     */         
/* 126 */         sb.append(fqjt.getShortName());
/*     */       }
/*     */     }
/*     */     
/* 130 */     sb.append(" {");
/* 131 */     indentLevel++;
/*     */     
/* 133 */     Iterator<String> strIter = this.enumConstants.iterator();
/* 134 */     while (strIter.hasNext()) {
/* 135 */       OutputUtilities.newLine(sb);
/* 136 */       OutputUtilities.javaIndent(sb, indentLevel);
/* 137 */       String enumConstant = (String)strIter.next();
/* 138 */       sb.append(enumConstant);
/*     */       
/* 140 */       if (strIter.hasNext()) {
/* 141 */         sb.append(',');
/*     */       } else {
/* 143 */         sb.append(';');
/*     */       }
/*     */     }
/*     */     
/* 147 */     if (this.fields.size() > 0) {
/* 148 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/* 151 */     Iterator<Field> fldIter = this.fields.iterator();
/* 152 */     while (fldIter.hasNext()) {
/* 153 */       OutputUtilities.newLine(sb);
/* 154 */       Field field = (Field)fldIter.next();
/* 155 */       sb.append(field.getFormattedContent(indentLevel));
/* 156 */       if (fldIter.hasNext()) {
/* 157 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */     
/* 161 */     if (this.methods.size() > 0) {
/* 162 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/* 165 */     Object mtdIter = this.methods.iterator();
/* 166 */     while (((Iterator)mtdIter).hasNext()) {
/* 167 */       OutputUtilities.newLine(sb);
/* 168 */       Method method = (Method)((Iterator)mtdIter).next();
/* 169 */       sb.append(method.getFormattedContent(indentLevel, false));
/* 170 */       if (((Iterator)mtdIter).hasNext()) {
/* 171 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */     
/* 175 */     if (this.innerClasses.size() > 0) {
/* 176 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/* 179 */     Iterator<InnerClass> icIter = this.innerClasses.iterator();
/* 180 */     while (icIter.hasNext()) {
/* 181 */       OutputUtilities.newLine(sb);
/* 182 */       InnerClass innerClass = (InnerClass)icIter.next();
/* 183 */       sb.append(innerClass.getFormattedContent(indentLevel));
/* 184 */       if (icIter.hasNext()) {
/* 185 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */     
/* 189 */     if (this.innerEnums.size() > 0) {
/* 190 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */     
/* 193 */     Iterator<InnerEnum> ieIter = this.innerEnums.iterator();
/* 194 */     while (ieIter.hasNext()) {
/* 195 */       OutputUtilities.newLine(sb);
/* 196 */       InnerEnum innerEnum = (InnerEnum)ieIter.next();
/* 197 */       sb.append(innerEnum.getFormattedContent(indentLevel));
/* 198 */       if (ieIter.hasNext()) {
/* 199 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */     
/* 203 */     indentLevel--;
/* 204 */     OutputUtilities.newLine(sb);
/* 205 */     OutputUtilities.javaIndent(sb, indentLevel);
/* 206 */     sb.append('}');
/*     */     
/* 208 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<FullyQualifiedJavaType> getSuperInterfaceTypes()
/*     */   {
/* 215 */     return this.superInterfaceTypes;
/*     */   }
/*     */   
/*     */   public void addSuperInterface(FullyQualifiedJavaType superInterface) {
/* 219 */     this.superInterfaceTypes.add(superInterface);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Method> getMethods()
/*     */   {
/* 226 */     return this.methods;
/*     */   }
/*     */   
/*     */   public void addMethod(Method method) {
/* 230 */     this.methods.add(method);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public FullyQualifiedJavaType getType()
/*     */   {
/* 237 */     return this.type;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\api\dom\java\InnerEnum.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */