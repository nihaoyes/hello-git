/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import org.apache.ibatis.session.RowBounds;
/*     */ import org.mybatis.generator.api.DAOMethodNameCalculator;
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
/*     */ 
/*     */ public class DefaultDAOMethodNameCalculator
/*     */   implements DAOMethodNameCalculator
/*     */ {
/*     */   public String getInsertMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  38 */     return "insert";
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
/*  50 */     Rules rules = introspectedTable.getRules();
/*     */     
/*  52 */     if (!rules.generateUpdateByPrimaryKeyWithBLOBs())
/*  53 */       return "updateByPrimaryKey";
/*  54 */     if (rules.generateRecordWithBLOBsClass()) {
/*  55 */       return "updateByPrimaryKey";
/*     */     }
/*  57 */     return "updateByPrimaryKeyWithoutBLOBs";
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
/*     */   public String getUpdateByPrimaryKeyWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  70 */     Rules rules = introspectedTable.getRules();
/*     */     
/*  72 */     if (!rules.generateUpdateByPrimaryKeyWithoutBLOBs())
/*  73 */       return "updateByPrimaryKey";
/*  74 */     if (rules.generateRecordWithBLOBsClass()) {
/*  75 */       return "updateByPrimaryKey";
/*     */     }
/*  77 */     return "updateByPrimaryKeyWithBLOBs";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getDeleteByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  83 */     return "deleteByExample";
/*     */   }
/*     */   
/*     */   public String getDeleteByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  88 */     return "deleteByPrimaryKey";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSelectByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  98 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 100 */     if (!rules.generateSelectByExampleWithBLOBs()) {
/* 101 */       return "selectByExample";
/*     */     }
/* 103 */     return "selectByExampleWithoutBLOBs";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSelectByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 114 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 116 */     if (!rules.generateSelectByExampleWithoutBLOBs()) {
/* 117 */       return "selectByExample";
/*     */     }
/* 119 */     return "selectByExampleWithBLOBs";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getSelectByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 125 */     return "selectByPrimaryKey";
/*     */   }
/*     */   
/*     */   public String getUpdateByPrimaryKeySelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 130 */     return "updateByPrimaryKeySelective";
/*     */   }
/*     */   
/*     */   public String getCountByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 135 */     return "countByExample";
/*     */   }
/*     */   
/*     */   public String getUpdateByExampleSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 140 */     return "updateByExampleSelective";
/*     */   }
/*     */   
/*     */   public String getUpdateByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 145 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 147 */     if (!rules.generateUpdateByExampleWithoutBLOBs())
/* 148 */       return "updateByExample";
/* 149 */     if (rules.generateRecordWithBLOBsClass()) {
/* 150 */       return "updateByExample";
/*     */     }
/* 152 */     return "updateByExampleWithBLOBs";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getUpdateByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 158 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 160 */     if (!rules.generateUpdateByExampleWithBLOBs())
/* 161 */       return "updateByExample";
/* 162 */     if (rules.generateRecordWithBLOBsClass()) {
/* 163 */       return "updateByExample";
/*     */     }
/* 165 */     return "updateByExampleWithoutBLOBs";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getInsertSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 171 */     return "insertSelective";
/*     */   }
/*     */   
/*     */   public String getSelectByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable, RowBounds bounds)
/*     */   {
/* 176 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 178 */     if (!rules.generateSelectByExampleWithBLOBs()) {
/* 179 */       return "selectByExample";
/*     */     }
/* 181 */     return "selectByExampleWithoutBLOBs";
/*     */   }
/*     */   
/*     */ 
/*     */   public String getSelectByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable, RowBounds bounds)
/*     */   {
/* 187 */     Rules rules = introspectedTable.getRules();
/*     */     
/* 189 */     if (!rules.generateSelectByExampleWithBLOBs()) {
/* 190 */       return "selectByExample";
/*     */     }
/* 192 */     return "selectByExampleWithoutBLOBs";
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\internal\DefaultDAOMethodNameCalculator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */