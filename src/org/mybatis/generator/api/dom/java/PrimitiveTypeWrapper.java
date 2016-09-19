/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrimitiveTypeWrapper
/*     */   extends FullyQualifiedJavaType
/*     */ {
/*     */   private static PrimitiveTypeWrapper booleanInstance;
/*     */   
/*     */ 
/*     */ 
/*     */   private static PrimitiveTypeWrapper byteInstance;
/*     */   
/*     */ 
/*     */ 
/*     */   private static PrimitiveTypeWrapper characterInstance;
/*     */   
/*     */ 
/*     */ 
/*     */   private static PrimitiveTypeWrapper doubleInstance;
/*     */   
/*     */ 
/*     */ 
/*     */   private static PrimitiveTypeWrapper floatInstance;
/*     */   
/*     */ 
/*     */ 
/*     */   private static PrimitiveTypeWrapper integerInstance;
/*     */   
/*     */ 
/*     */ 
/*     */   private static PrimitiveTypeWrapper longInstance;
/*     */   
/*     */ 
/*     */ 
/*     */   private static PrimitiveTypeWrapper shortInstance;
/*     */   
/*     */ 
/*     */   private String toPrimitiveMethod;
/*     */   
/*     */ 
/*     */ 
/*     */   private PrimitiveTypeWrapper(String fullyQualifiedName, String toPrimitiveMethod)
/*     */   {
/*  46 */     super(fullyQualifiedName);
/*  47 */     this.toPrimitiveMethod = toPrimitiveMethod;
/*     */   }
/*     */   
/*     */   public String getToPrimitiveMethod() {
/*  51 */     return this.toPrimitiveMethod;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getBooleanInstance() {
/*  55 */     if (booleanInstance == null) {
/*  56 */       booleanInstance = new PrimitiveTypeWrapper("java.lang.Boolean", 
/*  57 */         "booleanValue()");
/*     */     }
/*     */     
/*  60 */     return booleanInstance;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getByteInstance() {
/*  64 */     if (byteInstance == null) {
/*  65 */       byteInstance = new PrimitiveTypeWrapper("java.lang.Byte", 
/*  66 */         "byteValue()");
/*     */     }
/*     */     
/*  69 */     return byteInstance;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getCharacterInstance() {
/*  73 */     if (characterInstance == null) {
/*  74 */       characterInstance = new PrimitiveTypeWrapper("java.lang.Character", 
/*  75 */         "charValue()");
/*     */     }
/*     */     
/*  78 */     return characterInstance;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getDoubleInstance() {
/*  82 */     if (doubleInstance == null) {
/*  83 */       doubleInstance = new PrimitiveTypeWrapper("java.lang.Double", 
/*  84 */         "doubleValue()");
/*     */     }
/*     */     
/*  87 */     return doubleInstance;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getFloatInstance() {
/*  91 */     if (floatInstance == null) {
/*  92 */       floatInstance = new PrimitiveTypeWrapper("java.lang.Float", 
/*  93 */         "floatValue()");
/*     */     }
/*     */     
/*  96 */     return floatInstance;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getIntegerInstance() {
/* 100 */     if (integerInstance == null) {
/* 101 */       integerInstance = new PrimitiveTypeWrapper("java.lang.Integer", 
/* 102 */         "intValue()");
/*     */     }
/*     */     
/* 105 */     return integerInstance;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getLongInstance() {
/* 109 */     if (longInstance == null) {
/* 110 */       longInstance = new PrimitiveTypeWrapper("java.lang.Long", 
/* 111 */         "longValue()");
/*     */     }
/*     */     
/* 114 */     return longInstance;
/*     */   }
/*     */   
/*     */   public static PrimitiveTypeWrapper getShortInstance() {
/* 118 */     if (shortInstance == null) {
/* 119 */       shortInstance = new PrimitiveTypeWrapper("java.lang.Short", 
/* 120 */         "shortValue()");
/*     */     }
/*     */     
/* 123 */     return shortInstance;
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\api\dom\java\PrimitiveTypeWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */