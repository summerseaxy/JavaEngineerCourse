package com.xrh.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DruidUtil {
    private static DruidDataSource ds;
    private static final ThreadLocal<MySession> localSessions = new ThreadLocal<>();

    static {
        ///实例化数据库连接池对象
        ds = new DruidDataSource();
        //实例化配置对象
        Properties properties = new Properties();
        try {
            //加载配置文件内容
            properties.load(DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void close() {
        MySession mySession = localSessions.get();
        if (mySession != null) {
            mySession.close();
        }
    }

    //获取连接对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //添加参数，得到结果集，关闭流

    public static ResultSet query(String sql, List<Object> params) throws SQLException {

        Connection con = getConnection();
        if (con == null) return null;

        PreparedStatement ps = con.prepareStatement(sql);

        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
        }
        ResultSet rs = ps.executeQuery();

        localSessions.set(new MySession(con, rs, ps));
        return rs;

    }

    public static int update(String sql, List<Object> params) throws SQLException {

        Connection con = getConnection();
        if (con == null) return -1;
        // 预编译语句防止SQL注入
        PreparedStatement ps = con.prepareStatement(sql);//此处不要自己创建preparedStatement

        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
        }
        int count = ps.executeUpdate();
        localSessions.set(new MySession(con, null, ps));
        return count;
    }


    private static class MySession {
        private final Connection connection;
        private final ResultSet resultSet;
        private final PreparedStatement preparedStatement;

        public MySession(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) {
            this.connection = connection;
            this.resultSet = resultSet;
            this.preparedStatement = preparedStatement;
        }

        public void close() {
            //关流时是否输出日志
            boolean log = false;
            try {
                if (resultSet != null) {
                    resultSet.close();
                    if (log) {
                        System.out.println(Thread.currentThread().getName() + "\tclose rs:" + resultSet);
                    }
                }
            } catch (SQLException ignore) {

            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    if (log) {
                        System.out.println(Thread.currentThread().getName() + "\tclose ps:" + preparedStatement);
                    }
                }
            } catch (SQLException ignore) {

            }
            try {
                if (connection != null) {
                    connection.close();
                    if (log) {
                        System.out.println(Thread.currentThread().getName() + "\tclose con:" + connection);
                    }
                }
            } catch (SQLException ignore) {

            }

        }
    }
}
