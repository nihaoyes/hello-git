/*    */ package ibator.dialect;
/*    */ 
/*    */ public class DerbyDialect extends Dialect
/*    */ {
/*    */   public boolean supportsLimit() {
/*  6 */     return false;
/*    */   }
/*    */   
/*    */   public boolean supportsLimitOffset() {
/* 10 */     return false;
/*    */   }
/*    */   
/*    */   public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
/* 14 */     throw new UnsupportedOperationException("paged queries not supported");
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\ibator\dialect\DerbyDialect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */