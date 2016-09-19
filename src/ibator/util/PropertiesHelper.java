/*     */ package ibator.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.InvalidPropertiesFormatException;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
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
/*     */ public class PropertiesHelper
/*     */ {
/*     */   public static final int SYSTEM_PROPERTIES_MODE_NEVER = 0;
/*     */   public static final int SYSTEM_PROPERTIES_MODE_FALLBACK = 1;
/*     */   public static final int SYSTEM_PROPERTIES_MODE_OVERRIDE = 2;
/*     */   Properties p;
/*  58 */   private int systemPropertiesMode = 0;
/*     */   
/*     */   public PropertiesHelper(Properties p) {
/*  61 */     if (p == null) throw new IllegalArgumentException("properties must be not null");
/*  62 */     this.p = p;
/*     */   }
/*     */   
/*     */   public PropertiesHelper(Properties p, int systemPropertiesMode) {
/*  66 */     if (p == null) throw new IllegalArgumentException("properties must be not null");
/*  67 */     if ((systemPropertiesMode != 0) && (systemPropertiesMode != 1) && (systemPropertiesMode != 2)) {
/*  68 */       throw new IllegalArgumentException("error systemPropertiesMode mode:" + systemPropertiesMode);
/*     */     }
/*  70 */     this.p = p;
/*  71 */     this.systemPropertiesMode = systemPropertiesMode;
/*     */   }
/*     */   
/*     */   public Properties getProperties() {
/*  75 */     return this.p;
/*     */   }
/*     */   
/*     */   public String getRequiredString(String key) {
/*  79 */     String value = getProperty(key);
/*  80 */     if (isBlankString(value)) {
/*  81 */       throw new IllegalStateException("required property is blank by key=" + key);
/*     */     }
/*  83 */     return value;
/*     */   }
/*     */   
/*     */   public String getNullIfBlank(String key) {
/*  87 */     String value = getProperty(key);
/*  88 */     if (isBlankString(value)) {
/*  89 */       return null;
/*     */     }
/*  91 */     return value;
/*     */   }
/*     */   
/*     */   public String getNullIfEmpty(String key) {
/*  95 */     String value = getProperty(key);
/*  96 */     if ((value == null) || ("".equals(value))) {
/*  97 */       return null;
/*     */     }
/*  99 */     return value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAndTryFromSystem(String key)
/*     */   {
/* 107 */     String value = getProperty(key);
/* 108 */     if (isBlankString(value)) {
/* 109 */       value = getSystemProperty(key);
/*     */     }
/* 111 */     return value;
/*     */   }
/*     */   
/*     */   private String getSystemProperty(String key)
/*     */   {
/* 116 */     String value = System.getProperty(key);
/* 117 */     if (isBlankString(value)) {
/* 118 */       value = System.getenv(key);
/*     */     }
/* 120 */     return value;
/*     */   }
/*     */   
/*     */   public Integer getInteger(String key) {
/* 124 */     String v = getProperty(key);
/* 125 */     if (v == null) {
/* 126 */       return null;
/*     */     }
/* 128 */     return Integer.valueOf(Integer.parseInt(v));
/*     */   }
/*     */   
/*     */   public int getInt(String key, int defaultValue) {
/* 132 */     if (getProperty(key) == null) {
/* 133 */       return defaultValue;
/*     */     }
/* 135 */     return Integer.parseInt(getRequiredString(key));
/*     */   }
/*     */   
/*     */   public int getRequiredInt(String key) {
/* 139 */     return Integer.parseInt(getRequiredString(key));
/*     */   }
/*     */   
/*     */   public Long getLong(String key) {
/* 143 */     if (getProperty(key) == null) {
/* 144 */       return null;
/*     */     }
/* 146 */     return Long.valueOf(Long.parseLong(getRequiredString(key)));
/*     */   }
/*     */   
/*     */   public long getLong(String key, long defaultValue) {
/* 150 */     if (getProperty(key) == null) {
/* 151 */       return defaultValue;
/*     */     }
/* 153 */     return Long.parseLong(getRequiredString(key));
/*     */   }
/*     */   
/*     */   public Long getRequiredLong(String key) {
/* 157 */     return Long.valueOf(Long.parseLong(getRequiredString(key)));
/*     */   }
/*     */   
/*     */   public Boolean getBoolean(String key) {
/* 161 */     if (getProperty(key) == null) {
/* 162 */       return null;
/*     */     }
/* 164 */     return Boolean.valueOf(Boolean.parseBoolean(getRequiredString(key)));
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key, boolean defaultValue) {
/* 168 */     if (getProperty(key) == null) {
/* 169 */       return defaultValue;
/*     */     }
/* 171 */     return Boolean.parseBoolean(getRequiredString(key));
/*     */   }
/*     */   
/*     */   public boolean getRequiredBoolean(String key) {
/* 175 */     return Boolean.parseBoolean(getRequiredString(key));
/*     */   }
/*     */   
/*     */   public Float getFloat(String key) {
/* 179 */     if (getProperty(key) == null) {
/* 180 */       return null;
/*     */     }
/* 182 */     return Float.valueOf(Float.parseFloat(getRequiredString(key)));
/*     */   }
/*     */   
/*     */   public float getFloat(String key, float defaultValue) {
/* 186 */     if (getProperty(key) == null) {
/* 187 */       return defaultValue;
/*     */     }
/* 189 */     return Float.parseFloat(getRequiredString(key));
/*     */   }
/*     */   
/*     */   public Float getRequiredFloat(String key) {
/* 193 */     return Float.valueOf(Float.parseFloat(getRequiredString(key)));
/*     */   }
/*     */   
/*     */   public Double getDouble(String key) {
/* 197 */     if (getProperty(key) == null) {
/* 198 */       return null;
/*     */     }
/* 200 */     return Double.valueOf(Double.parseDouble(getRequiredString(key)));
/*     */   }
/*     */   
/*     */   public double getDouble(String key, double defaultValue) {
/* 204 */     if (getProperty(key) == null) {
/* 205 */       return defaultValue;
/*     */     }
/* 207 */     return Double.parseDouble(getRequiredString(key));
/*     */   }
/*     */   
/*     */   public Double getRequiredDouble(String key) {
/* 211 */     return Double.valueOf(Double.parseDouble(getRequiredString(key)));
/*     */   }
/*     */   
/*     */ 
/*     */   public Object setProperty(String key, int value)
/*     */   {
/* 217 */     return setProperty(key, String.valueOf(value));
/*     */   }
/*     */   
/*     */   public Object setProperty(String key, long value) {
/* 221 */     return setProperty(key, String.valueOf(value));
/*     */   }
/*     */   
/*     */   public Object setProperty(String key, float value) {
/* 225 */     return setProperty(key, String.valueOf(value));
/*     */   }
/*     */   
/*     */   public Object setProperty(String key, double value) {
/* 229 */     return setProperty(key, String.valueOf(value));
/*     */   }
/*     */   
/*     */   public Object setProperty(String key, boolean value) {
/* 233 */     return setProperty(key, String.valueOf(value));
/*     */   }
/*     */   
/*     */ 
/*     */   public String getProperty(String key, String defaultValue)
/*     */   {
/* 239 */     return this.p.getProperty(key, defaultValue);
/*     */   }
/*     */   
/*     */   public String getProperty(String key) {
/* 243 */     String propVal = null;
/* 244 */     if (this.systemPropertiesMode == 2) {
/* 245 */       propVal = getSystemProperty(key);
/*     */     }
/* 247 */     if (propVal == null) {
/* 248 */       propVal = this.p.getProperty(key);
/*     */     }
/* 250 */     if ((propVal == null) && (this.systemPropertiesMode == 1)) {
/* 251 */       propVal = getSystemProperty(key);
/*     */     }
/* 253 */     return propVal;
/*     */   }
/*     */   
/*     */   public Object setProperty(String key, String value) {
/* 257 */     return this.p.setProperty(key, value);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 261 */     this.p.clear();
/*     */   }
/*     */   
/*     */   public Set<Map.Entry<Object, Object>> entrySet() {
/* 265 */     return this.p.entrySet();
/*     */   }
/*     */   
/*     */   public Enumeration<?> propertyNames() {
/* 269 */     return this.p.propertyNames();
/*     */   }
/*     */   
/*     */   public boolean contains(Object value) {
/* 273 */     return this.p.contains(value);
/*     */   }
/*     */   
/*     */   public boolean containsKey(Object key) {
/* 277 */     return this.p.containsKey(key);
/*     */   }
/*     */   
/*     */   public boolean containsValue(Object value) {
/* 281 */     return this.p.containsValue(value);
/*     */   }
/*     */   
/*     */   public Enumeration<Object> elements() {
/* 285 */     return this.p.elements();
/*     */   }
/*     */   
/*     */   public Object get(Object key) {
/* 289 */     return this.p.get(key);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 293 */     return this.p.isEmpty();
/*     */   }
/*     */   
/*     */   public Enumeration<Object> keys() {
/* 297 */     return this.p.keys();
/*     */   }
/*     */   
/*     */   public Set<Object> keySet() {
/* 301 */     return this.p.keySet();
/*     */   }
/*     */   
/*     */   public void list(PrintStream out) {
/* 305 */     this.p.list(out);
/*     */   }
/*     */   
/*     */   public void list(PrintWriter out) {
/* 309 */     this.p.list(out);
/*     */   }
/*     */   
/*     */   public void load(InputStream inStream) throws IOException {
/* 313 */     this.p.load(inStream);
/*     */   }
/*     */   
/*     */   public void loadFromXML(InputStream in) throws IOException, InvalidPropertiesFormatException
/*     */   {
/* 318 */     this.p.loadFromXML(in);
/*     */   }
/*     */   
/*     */   public Object put(Object key, Object value) {
/* 322 */     return this.p.put(key, value);
/*     */   }
/*     */   
/*     */   public void putAll(Map<? extends Object, ? extends Object> t) {
/* 326 */     this.p.putAll(t);
/*     */   }
/*     */   
/*     */ 
/* 330 */   public Object remove(Object key) { return this.p.remove(key); }
/*     */   
/* 335 */   public void save(OutputStream out, String comments) { this.p.save(out, comments); }
/*     */   
/*     */   public int size()
/*     */   {
/* 339 */     return this.p.size();
/*     */   }
/*     */   
/*     */   public void store(OutputStream out, String comments) throws IOException {
/* 343 */     this.p.store(out, comments);
/*     */   }
/*     */   
/*     */   public void storeToXML(OutputStream os, String comment, String encoding) throws IOException
/*     */   {
/* 348 */     this.p.storeToXML(os, comment, encoding);
/*     */   }
/*     */   
/*     */   public void storeToXML(OutputStream os, String comment) throws IOException {
/* 352 */     this.p.storeToXML(os, comment);
/*     */   }
/*     */   
/*     */   public Collection<Object> values() {
/* 356 */     return this.p.values();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 360 */     return this.p.toString();
/*     */   }
/*     */   
/*     */   private static boolean isBlankString(String value) {
/* 364 */     return (value == null) || ("".equals(value.trim()));
/*     */   }
/*     */ }


