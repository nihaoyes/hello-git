/*    */ package ibator.dialect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SQLServer2008Dialect
/*    */   extends SQLServerDialect
/*    */ {
/*    */   public boolean supportsLimit()
/*    */   {
/* 16 */     return true;
/*    */   }
/*    */   
/*    */   public boolean supportsLimitOffset()
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public String getLimitString(String querySqlString, int offset, int limit)
/*    */   {
/* 26 */     if (offset == 0) { return super.getLimitString(querySqlString, offset, limit);
/*    */     }
/* 28 */     StringBuilder sb = new StringBuilder(querySqlString.trim());
/*    */     
/* 30 */     String querySqlLowered = querySqlString.trim().toLowerCase();
/* 31 */     int orderByIndex = querySqlLowered.toLowerCase().indexOf("order by");
/* 32 */     String orderby = orderByIndex > 0 ? querySqlString.substring(orderByIndex) : "ORDER BY CURRENT_TIMESTAMP";
/*    */     
/*    */ 
/* 35 */     if (orderByIndex > 0) { sb.delete(orderByIndex, orderByIndex + orderby.length());
/*    */     }
/*    */     
/* 38 */     int selectIndex = querySqlLowered.trim().startsWith("select distinct") ? 15 : 6;
/*    */     
/*    */ 
/* 41 */     sb.insert(selectIndex, " ROW_NUMBER() OVER (" + orderby + ") as __hibernate_row_nr__,");
/*    */     
/*    */ 
/* 44 */     sb.insert(0, "WITH query AS (").append(") SELECT * FROM query ");
/* 45 */     sb.append("WHERE __hibernate_row_nr__ ");
/* 46 */     if (offset > 0) sb.append("BETWEEN ").append(offset).append(" AND ").append(limit); else {
/* 47 */       sb.append(" <= ").append(limit);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 52 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\ibator\dialect\SQLServer2008Dialect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */