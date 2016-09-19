/*    */ package ibator.dialect;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SQLServer2005Dialect
/*    */   extends OracleDialect
/*    */ {
/*    */   public boolean supportsLimit()
/*    */   {
/* 10 */     return true;
/*    */   }
/*    */   
/*    */   public boolean supportsLimitOffset()
/*    */   {
/* 15 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getLimitString(String querySqlString, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
/*    */   {
/* 38 */     StringBuffer pagingBuilder = new StringBuffer();
/* 39 */     String orderby = getOrderByPart(querySqlString);
/* 40 */     String distinctStr = "";
/*    */     
/*    */ 
/* 43 */     String loweredString = querySqlString.toLowerCase();
/* 44 */     String sqlPartString = querySqlString;
/* 45 */     if (loweredString.trim().startsWith("select")) {
/* 46 */       int index = 6;
/* 47 */       if (loweredString.startsWith("select distinct")) {
/* 48 */         distinctStr = "DISTINCT ";
/* 49 */         index = 15;
/*    */       }
/* 51 */       sqlPartString = sqlPartString.substring(index);
/*    */     }
/* 53 */     pagingBuilder.append(sqlPartString);
/*    */     
/*    */ 
/* 56 */     if ((orderby == null) || (orderby.length() == 0)) {
/* 57 */       orderby = "ORDER BY CURRENT_TIMESTAMP";
/*    */     }
/*    */     
/*    */ 
/* 61 */     StringBuffer result = new StringBuffer();
/* 62 */     result.append("WITH query AS (SELECT ")
/* 63 */       .append(distinctStr)
/* 64 */       .append("TOP 100 PERCENT ")
/* 65 */       .append(" ROW_NUMBER() OVER (")
/* 66 */       .append(orderby)
/* 67 */       .append(") as __row_number__, ")
/* 68 */       .append(pagingBuilder)
/* 69 */       .append(") SELECT * FROM query WHERE __row_number__ BETWEEN ")
/* 70 */       .append(offset + 1).append(" AND ").append(offset + limit)
/* 71 */       .append(" ORDER BY __row_number__");
/*    */     
/* 73 */     return result.toString();
/*    */   }
/*    */   
/*    */   static String getOrderByPart(String sql) {
/* 77 */     String loweredString = sql.toLowerCase();
/* 78 */     int orderByIndex = loweredString.indexOf("order by");
/* 79 */     if (orderByIndex != -1)
/*    */     {
/*    */ 
/* 82 */       return sql.substring(orderByIndex);
/*    */     }
/* 84 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\ibator\dialect\SQLServer2005Dialect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */