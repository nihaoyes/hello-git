/*    */ package ibator.dialect;
/*    */ 
/*    */ public class PostgreSQLDialect
/*    */   extends Dialect
/*    */ {
/*    */   public boolean supportsLimit()
/*    */   {
/*  8 */     return true;
/*    */   }
/*    */   
/*    */   public boolean supportsLimitOffset() {
/* 12 */     return true;
/*    */   }
/*    */   
/*    */   public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
/*    */   {
/* 17 */     return 
/*    */     
/* 19 */       sql.length() + 20 + sql + (offset > 0 ? " limit " + limitPlaceholder + " offset " + offsetPlaceholder : new StringBuilder(" limit ").append(limitPlaceholder).toString());
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\ibator\dialect\PostgreSQLDialect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */