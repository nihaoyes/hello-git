/*    */ package ibator.dialect;
/*    */ 
/*    */ 
/*    */ public class HSQLDialect
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
/*    */   public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
/* 17 */     boolean hasOffset = offset > 0;
/* 18 */     return new StringBuffer(sql.length() + 10)
/* 19 */       .append(sql)
/* 20 */       .insert(sql.toLowerCase().indexOf("select") + 6, " top " + limitPlaceholder)
/* 21 */       .toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\ibator\dialect\HSQLDialect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */