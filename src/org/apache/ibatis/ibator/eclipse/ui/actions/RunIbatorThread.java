
package org.apache.ibatis.ibator.eclipse.ui.actions;

import ibator.Activator;
import ibator.Globar;
import ibator.util.DBUtil;
import ibator.vo.ConfigVO;
import ibator.vo.DBVO;
import java.sql.*;
import java.util.*;
import org.apache.ibatis.ibator.api.EclipseProgressCallback;
import org.apache.ibatis.ibator.api.EclipseShellCallback;
import org.apache.ibatis.ibator.internal.db.ConnectionFactory;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.*;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.db.SqlReservedWords;

public class RunIbatorThread
    implements IWorkspaceRunnable
{

    public RunIbatorThread(IProject iproject, List warnings)
    {
        this.iproject = iproject;
        this.warnings = warnings;
    }

    public void run(IProgressMonitor monitor)
        throws CoreException
    {
        SubMonitor  subMonitor = SubMonitor.convert(monitor, 1000);
        subMonitor.beginTask("Generating mybatis :", 1000);
        Globar.isWord = true;
        try
        {
            String projectName = iproject.getName();
            subMonitor.subTask("Parsing Configuration");
            Properties properties = new Properties();
            Configuration config = new Configuration();
            String path;
            for(Iterator iterator = Globar.classpath.iterator(); iterator.hasNext(); config.addClasspathEntry(path))
                path = (String)iterator.next();

            Context context = new Context(ModelType.CONDITIONAL);
            if(Globar.isWord)
            {
                context.addProperty("autoDelimitKeywords", "true");
                if(Globar.global.getDbVo().getDialect().toUpperCase().startsWith("MYSQL"))
                {
                    context.addProperty("beginningDelimiter", "`");
                    context.addProperty("endingDelimiter", "`");
                } else
                if(Globar.global.getDbVo().getDialect().toUpperCase().startsWith("SQLSERVER"))
                {
                    context.addProperty("beginningDelimiter", "[");
                    context.addProperty("endingDelimiter", "]");
                } else
                {
                    context.addProperty("beginningDelimiter", "\"");
                    context.addProperty("endingDelimiter", "\"");
                }
            }
            JDBCConnectionConfiguration jdbc = new JDBCConnectionConfiguration();   //建立连接，取得catalog。
            jdbc.setConnectionURL(Globar.global.getDbVo().getUrl());
            jdbc.setDriverClass(Globar.global.getDbVo().getDriver());
            jdbc.setPassword(Globar.global.getDbVo().getPassword());
            jdbc.setUserId(Globar.global.getDbVo().getUsername());
            context.setJdbcConnectionConfiguration(jdbc);
            Connection con = ConnectionFactory.getInstance().getConnection(jdbc);
            String catalog = con.getCatalog();
            if(Globar.tables.size() == 0)
            {
                if(Globar.global.getDbVo().getDialect().startsWith("SQLServer"))
                {
                    ResultSet rs;
                    TableConfiguration tconfig;
                    for(rs = con.getMetaData().getTables(catalog, null, "%", new String[] {"TABLE"}); rs != null && rs.next(); DBUtil.setTableConfig(con, tconfig))
                    {
                        String name = rs.getString("table_name");
                        tconfig = new TableConfiguration(context);
                        tconfig.setTableName(name);
                        context.addTableConfiguration(tconfig);
                        if(Globar.isWord && SqlReservedWords.containsWord(name))
                            tconfig.setDelimitIdentifiers(Globar.isWord);
                    }

                    rs.close();
                } else
                {
                    TableConfiguration configuration = new TableConfiguration(context);
                    configuration.setSchema(Globar.global.getDbVo().getUsername());
                    if(Globar.isWord && SqlReservedWords.containsWord(configuration.getTableName()))
                        configuration.setDelimitIdentifiers(Globar.isWord);
                    DBUtil.setTableConfig(con, configuration);
                    context.addTableConfiguration(configuration);
                }
            } else
            {
                TableConfiguration configuration;
                // 获取选择表的一些配置
                for(Iterator iterator1 = Globar.tables.iterator(); iterator1.hasNext(); context.addTableConfiguration(configuration))
                {
                    String table = (String)iterator1.next();
                    configuration = new TableConfiguration(context);//获得table设置，很多是默认的。
                    if(!Globar.global.getDbVo().getDialect().startsWith("SQLServer"))
                        configuration.setSchema(Globar.global.getDbVo().getUsername());
                    if(Globar.isWord && SqlReservedWords.containsWord(table)) //数据库预留关键词是否和表重名，如果重名，就加上界定符
                        configuration.setDelimitIdentifiers(Globar.isWord);
                    configuration.setTableName(table);
                    DBUtil.setTableConfig(con, configuration);//获得表的主键配置（是否自增长）
                }

            }
            context.setId("ibator");
            JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();//table To javabean 配置
            javaModelGeneratorConfiguration.setTargetPackage(Globar.pojoPath);
            javaModelGeneratorConfiguration.setTargetProject(projectName);
            context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
            JavaClientGeneratorConfiguration daoGeneratorConfiguration = new JavaClientGeneratorConfiguration();// DAO bean 配置
            daoGeneratorConfiguration.setTargetPackage(Globar.daoPath);
            daoGeneratorConfiguration.setTargetProject(projectName);
            String type = Globar.global.getDaoType();//选择的DAO类型
            if(type.equals("xml"))
                daoGeneratorConfiguration.setConfigurationType("XMLMAPPER");
            else
            if(type.equals("mixed-mapper"))
                daoGeneratorConfiguration.setConfigurationType("MIXEDMAPPER");
            else
            if(type.equals("annotation"))
                daoGeneratorConfiguration.setConfigurationType("ANNOTATEDMAPPER");
            context.setJavaClientGeneratorConfiguration(daoGeneratorConfiguration);
            context.setTargetRuntime(org.mybatis.generator.api.IntrospectedTable.TargetRuntime.MYBATIS3.toString());//MYBATIS3
            SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();//sql Mapper配置
            sqlMapGeneratorConfiguration.setTargetPackage(Globar.xmlPath);
            sqlMapGeneratorConfiguration.setTargetProject(projectName);
            context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
            CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();//字段注释配置？
            context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
            if(Globar.global.isComment())
                DefaultCommentGenerator.suppressAllComments = false;
            else
                DefaultCommentGenerator.suppressAllComments = true;
            config.addContext(context);
            context.getJdbcConnectionConfiguration().addProperty("remarks", "true");
            subMonitor.worked(50);
            con.close();
            monitor.subTask("\u6B63\u5728\u751F\u6210\u6587\u4EF6\uFF0C\u8BF7\u7A0D\u5019...");
            EclipseShellCallback callback = new EclipseShellCallback();
            if(Globar.global.isOverride())//配置 覆盖
                callback.setOverwriteEnabled(true);
            else
                callback.setMergeSupported(true);
            SubMonitor spm = subMonitor.newChild(950);
            MyBatisGenerator ibator = new MyBatisGenerator(config, callback, new ArrayList());
//             开始生成代码
            ibator.generate(new EclipseProgressCallback(spm));
        }
        catch(Exception e)
        {
            Status status = new Status(4, "org.apache.ibatis.ibator.eclipse.ui", 4, e.getMessage(), e);
            Activator.getDefault().getLog().log(status);
            MultiStatus multiStatus = new MultiStatus("org.apache.ibatis.ibator.eclipse.ui", 4, "Invalid Configuration\n  See Details for more Information", null);
            throw new CoreException(multiStatus);
        }
  
        monitor.done();
        return;
    }

    private IProject iproject;
    private List warnings;
}


