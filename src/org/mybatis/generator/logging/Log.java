package org.mybatis.generator.logging;

public abstract interface Log
{
  public abstract boolean isDebugEnabled();
  
  public abstract void error(String paramString, Throwable paramThrowable);
  
  public abstract void error(String paramString);
  
  public abstract void debug(String paramString);
  
  public abstract void warn(String paramString);
}


/* Location:              C:\Users\lenovo\Desktop\ibator_3.0.6.full.jar!\org\mybatis\generator\logging\Log.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */