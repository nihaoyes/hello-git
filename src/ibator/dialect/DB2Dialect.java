/*    */ package ibator.dialect;
/*    */ 
/*    */ 
/*    */ public class DB2Dialect
/*    */   extends Dialect
/*    */ {
/*    */   public boolean supportsLimit()
/*    */   {
/*  9 */     return true;
/*    */   }
/*    */   
/*    */   public boolean supportsLimitOffset() {
/* 13 */     return true;
/*    */   }
/*    */   
/*    */   private static String getRowNumber(String sql) {
/* 17 */     StringBuffer rownumber = new StringBuffer(50)
/* 18 */       .append("rownumber() over(");
/*    */     
/* 20 */     int orderByIndex = sql.toLowerCase().indexOf("order by");
/*    */     
/* 22 */     if ((orderByIndex > 0) && (!hasDistinct(sql))) {
/* 23 */       rownumber.append(sql.substring(orderByIndex));
/*    */     }
/*    */     
/* 26 */     rownumber.append(") as rownumber_,");
/*    */     
/* 28 */     return rownumber.toString();
/*    */   }
/*    */   
/*    */   private static boolean hasDistinct(String sql) {
/* 32 */     return sql.toLowerCase().indexOf("select distinct") >= 0;
/*    */   }
/*    */   
/*    */   public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
/* 36 */     int startOfSelect = sql.toLowerCase().indexOf("select");
/*    */     
/* 38 */     StringBuffer pagingSelect = new StringBuffer(sql.length() + 100)
/* 39 */       .append(sql.substring(0, startOfSelect))
/* 40 */       .append("select * from ( select ")
/* 41 */       .append(getRowNumber(sql));
/*    */     
/* 43 */     if (hasDistinct(sql))
/*    */     {
/*    */ 
/* 46 */       pagingSelect.append(" row_.* from ( ").append(sql.substring(startOfSelect)).append(" ) as row_");
/*    */     }
/*    */     else {
/* 49 */       pagingSelect.append(sql.substring(startOfSelect + 6));
/*    */     }
/*    */     
/* 52 */     pagingSelect.append(" ) as temp_ where rownumber_ ");
/*    */     
/*    */ 
/* 55 */     if (offset > 0)
/*    */     {
/* 57 */       String endString = offsetPlaceholder + "+" + limitPlaceholder;
/* 58 */       pagingSelect.append("between " + offsetPlaceholder + "+1 and " + endString);
/*    */     }
/*    */     else {
/* 61 */       pagingSelect.append("<= " + limitPlaceholder);
/*    */     }
/*    */     
/* 64 */     return pagingSelect.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\ibator\dialect\DB2Dialect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */