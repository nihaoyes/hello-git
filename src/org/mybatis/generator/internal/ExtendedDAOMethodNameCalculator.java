/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import org.apache.ibatis.session.RowBounds;
/*     */ import org.mybatis.generator.api.DAOMethodNameCalculator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.internal.rules.Rules;
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
/*     */ public class ExtendedDAOMethodNameCalculator
/*     */   implements DAOMethodNameCalculator
/*     */ {
/*     */   public String getInsertMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  38 */     StringBuilder sb = new StringBuilder();
/*  39 */     sb.append("insert");
/*  40 */     sb.append(
/*  41 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */     
/*  43 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUpdateByPrimaryKeyWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  55 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  57 */     sb.append("update");
/*  58 */     sb.append(
/*  59 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */     
/*  61 */     Rules rules = introspectedTable.getRules();
/*     */     
/*  63 */     if (!rules.generateUpdateByPrimaryKeyWithBLOBs()) {
/*  64 */       sb.append("ByPrimaryKey");
/*  65 */     } else if (rules.generateRecordWithBLOBsClass()) {
/*  66 */       sb.append("ByPrimaryKey");
/*     */     } else {
/*  68 */       sb.append("ByPrimaryKeyWithoutBLOBs");
/*     */     }
/*     */     
/*  71 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUpdateByPrimaryKeyWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  83 */     StringBuilder sb = new StringBuilder();
/*  84 */     sb.append("update");
/*  85 */     sb.append(
/*  86 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */     
/*  88 */     Rules rules = introspectedTable.getRules();
/*     */     
/*  90 */     if (!rules.generateUpdateByPrimaryKeyWithoutBLOBs()) {
/*  91 */       sb.append("ByPrimaryKey");
/*  92 */     } else if (rules.generateRecordWithBLOBsClass()) {
/*  93 */       sb.append("ByPrimaryKey");
/*     */     } else {
/*  95 */       sb.append("ByPrimaryKeyWithBLOBs");
/*     */     }
/*     */     
/*  98 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getDeleteByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 103 */     StringBuilder sb = new StringBuilder();
/* 104 */     sb.append("delete");
/* 105 */     sb.append(
/* 106 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 107 */     sb.append("ByExample");
/*     */     
/* 109 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getDeleteByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 114 */     StringBuilder sb = new StringBuilder();
/* 115 */     sb.append("delete");
/* 116 */     sb.append(
/* 117 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 118 */     sb.append("ByPrimaryKey");
/*     */     
/* 120 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSelectByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 130 */     StringBuilder sb = new StringBuilder();
/* 131 */     sb.append("select");
/* 132 */     sb.append(
/* 133 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 134 */     sb.append("ByExample");
/*     */     
/* 136 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 138 */     if (rules.generateSelectByExampleWithBLOBs()) {
/* 139 */       sb.append("WithoutBLOBs");
/*     */     }
/*     */     
/* 142 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSelectByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 152 */     StringBuilder sb = new StringBuilder();
/* 153 */     sb.append("select");
/* 154 */     sb.append(
/* 155 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 156 */     sb.append("ByExample");
/*     */     
/* 158 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 160 */     if (rules.generateSelectByExampleWithoutBLOBs()) {
/* 161 */       sb.append("WithBLOBs");
/*     */     }
/*     */     
/* 164 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getSelectByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 169 */     StringBuilder sb = new StringBuilder();
/* 170 */     sb.append("select");
/* 171 */     sb.append(
/* 172 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 173 */     sb.append("ByPrimaryKey");
/*     */     
/* 175 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getUpdateByPrimaryKeySelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 180 */     StringBuilder sb = new StringBuilder();
/* 181 */     sb.append("update");
/* 182 */     sb.append(
/* 183 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 184 */     sb.append("ByPrimaryKeySelective");
/*     */     
/* 186 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getCountByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 191 */     StringBuilder sb = new StringBuilder();
/* 192 */     sb.append("count");
/* 193 */     sb.append(
/* 194 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 195 */     sb.append("ByExample");
/*     */     
/* 197 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getUpdateByExampleSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 202 */     StringBuilder sb = new StringBuilder();
/* 203 */     sb.append("update");
/* 204 */     sb.append(
/* 205 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 206 */     sb.append("ByExampleSelective");
/*     */     
/* 208 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getUpdateByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 213 */     StringBuilder sb = new StringBuilder();
/* 214 */     sb.append("update");
/* 215 */     sb.append(
/* 216 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */     
/* 218 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 220 */     if (!rules.generateUpdateByExampleWithoutBLOBs()) {
/* 221 */       sb.append("ByExample");
/* 222 */     } else if (rules.generateRecordWithBLOBsClass()) {
/* 223 */       sb.append("ByExample");
/*     */     } else {
/* 225 */       sb.append("ByExampleWithBLOBs");
/*     */     }
/*     */     
/* 228 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getUpdateByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 233 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 235 */     sb.append("update");
/* 236 */     sb.append(
/* 237 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */     
/* 239 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 241 */     if (!rules.generateUpdateByExampleWithBLOBs()) {
/* 242 */       sb.append("ByExample");
/* 243 */     } else if (rules.generateRecordWithBLOBsClass()) {
/* 244 */       sb.append("ByExample");
/*     */     } else {
/* 246 */       sb.append("ByExampleWithoutBLOBs");
/*     */     }
/*     */     
/* 249 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getInsertSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 254 */     StringBuilder sb = new StringBuilder();
/* 255 */     sb.append("insert");
/* 256 */     sb.append(
/* 257 */       introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/* 258 */     sb.append("Selective");
/*     */     
/* 260 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getSelectByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable, RowBounds bounds)
/*     */   {
/* 265 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 267 */     if (!rules.generateSelectByExampleWithBLOBs()) {
/* 268 */       return "selectByExample";
/*     */     }
/* 270 */     return "selectByExampleWithoutBLOBs";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getSelectByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable, RowBounds bounds)
/*     */   {
/* 276 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 278 */     if (!rules.generateSelectByExampleWithBLOBs()) {
/* 279 */       return "selectByExample";
/*     */     }
/* 281 */     return "selectByExampleWithoutBLOBs";
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\internal\ExtendedDAOMethodNameCalculator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */