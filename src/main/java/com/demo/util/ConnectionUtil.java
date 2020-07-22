package com.demo.util;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.apache.commons.dbcp.BasicDataSource;
import oracle.jdbc.OracleConnection;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtil {
    private static  String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static Integer count = new Integer(0);
    public static  final String URL = "jdbc:oracle:thin:@//58.181.168.177:9721/XE";
    public static  final String USER_NAME_DB = "JOBREPORT";
    public static  final String PASSWORD_DB = "JOBREPORT";

    private static BasicDataSource dataSource = null;

    private Connection connection;

    public ConnectionUtil(){}

    public synchronized Connection getOracleConnection() {
        try{
            //Connection connection = null;
            try{
                // connection = dataSource.getConnection().unwrap(OracleConnection.class);
                if(dataSource == null ){

                    dataSource = new BasicDataSource();
                    dataSource.setDriverClassName(DRIVER_CLASS);
                    dataSource.setUrl(URL);
                    dataSource.setUsername(USER_NAME_DB);
                    dataSource.setPassword(PASSWORD_DB);
                    dataSource.setMaxActive(600);
                    dataSource.setMaxIdle(300);
                    dataSource.setInitialSize(100);
                    dataSource.setMaxWait(-1);
                    dataSource.setTimeBetweenEvictionRunsMillis(60*10000);


                }
                connection = dataSource.getConnection().unwrap(OracleConnection.class);
                count++;
                if(dataSource.getNumActive() > 100){
                    dataSource.close();
                    if(connection!=null){
                        connection.close();
                    }
                    throw new RuntimeException("reset connection");
                }
            }catch (Exception ex){

                ex.printStackTrace();

            }

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return connection;
    }

    public Connection getConnectionByDataSource() {
        //Connection connection = null;
        try{
            if(connection!=null){
                connection.close();
            }
            connection = null;
            if(dataSource==null){
                return connection;
            }
            try{

                connection = DataSourceUtils.getConnection(dataSource).getMetaData().getConnection();

            }catch (Exception ex){
                ex.printStackTrace();
            }

        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }

        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
