/*     */ package ibator.dialect;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ public class SQLServerDialect extends Dialect
/*     */ {
/*     */   public boolean supportsLimitOffset()
/*     */   {
/*  10 */     return false;
/*     */   }
/*     */   
/*     */   public boolean supportsLimit() {
/*  14 */     return true;
/*     */   }
/*     */   
/*     */   static int getAfterSelectInsertPoint(String sql) {
/*  18 */     int selectIndex = sql.toLowerCase().indexOf("select");
/*  19 */     int selectDistinctIndex = sql.toLowerCase().indexOf(
/*  20 */       "select distinct");
/*  21 */     return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
/*     */   }
/*     */   
/*     */   public String getLimitString(String sql, int offset, int limit) {
/*  25 */     return getLimitString(sql, offset, null, limit, null);
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
/*     */   public String getLimitString(String querySelect, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
/*     */   {
/*  55 */     querySelect = querySelect.toLowerCase();
/*     */     
/*  57 */     int index = querySelect.indexOf("from");
/*  58 */     String table = querySelect.substring(index + 4);
/*  59 */     String tempTable = table.trim();
/*  60 */     if (tempTable.indexOf(" ") > -1)
/*  61 */       table = table.trim().substring(0, table.trim().indexOf(" "));
/*  62 */     table = table.trim();
/*     */     
/*     */ 
/*  65 */     String pk_name = null;
/*  66 */     Object obj = getExample();
/*  67 */     Class c = obj.getClass();
/*     */     try {
/*  69 */       Field pk_field = c.getDeclaredField("pk_name");
/*  70 */       pk_field.setAccessible(true);
/*  71 */       pk_name = (String)pk_field.get(obj);
/*     */     }
/*     */     catch (SecurityException e) {
/*  74 */       e.printStackTrace();
/*     */     } catch (NoSuchFieldException e) {
/*  76 */       throw new RuntimeException(c.getName() + "类缺少pk_name属性值");
/*     */     } catch (IllegalArgumentException e) {
/*  78 */       throw new RuntimeException("pk_name属性类型必须是java.lang.String型");
/*     */     } catch (IllegalAccessException e) {
/*  80 */       e.printStackTrace();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  85 */     String orderbyString = "";
/*  86 */     int orderIndex = querySelect.indexOf("order");
/*  87 */     if (orderIndex > -1) {
/*  88 */       orderbyString = querySelect.substring(orderIndex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  93 */     String whereString = "";
/*  94 */     int whereIndex = querySelect.indexOf("where");
/*  95 */     int endWhereIndex = -1;
/*  96 */     if (whereIndex > -1) {
/*     */       try
/*     */       {
/*  99 */         Method method = c.getDeclaredMethod("getSQL", new Class[0]);
/* 100 */         whereString = (String)method.invoke(obj, new Object[0]);
/*     */       } catch (Exception e) {
/* 102 */         throw new RuntimeException(e.getMessage());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 108 */     String tempQuString = querySelect;
/*     */     
/* 110 */     tempQuString = tempQuString.substring(0, index);
/* 111 */     tempQuString = tempQuString + " from " + table;
/*     */     
/* 113 */     StringBuffer sb = new StringBuffer(tempQuString);
/*     */     
/* 115 */     sb.insert(7, "top " + limit + " ");
/*     */     
/*     */ 
/*     */ 
/* 119 */     if (whereIndex > -1) {
/* 120 */       sb.append(" ").append("where ").append(whereString);
/*     */     }
/*     */     
/* 123 */     if (offset < 1) {
/* 124 */       if (orderIndex > -1) {
/* 125 */         sb.append(" ").append(orderbyString);
/*     */       }
/* 127 */       return sb.toString();
/*     */     }
/*     */     
/*     */ 
/* 131 */     if (whereIndex > -1) {
/* 132 */       sb.append(" and ");
/*     */     } else {
/* 134 */       sb.append(" ").append("where ");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */     sb.append(pk_name).append(" not in (select top ").append(offset).append(" ").append(pk_name).append(" ").append(" from ").append(table).append(" ");
/*     */     
/*     */ 
/*     */ 
/* 146 */     if (whereIndex > -1) {
/* 147 */       sb.append(" where ").append(whereString);
/*     */     }
/*     */     
/* 150 */     if (orderIndex > -1) {
/* 151 */       sb.append(" ").append(orderbyString);
/*     */     }
/*     */     
/* 154 */     sb.append(")");
/*     */     
/* 156 */     if (orderIndex > -1) {
/* 157 */       sb.append(" ").append(orderbyString);
/*     */     }
/*     */     
/* 160 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\ibator\dialect\SQLServerDialect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */