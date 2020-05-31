package it.cs367.connection;

import lombok.experimental.UtilityClass;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

@UtilityClass
public class DbUtils {

    public DataSource getDataSource(){
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:tcp://localhost:1521/test");
        ds.setUser("sa");
        ds.setPassword("");
        return  ds;
    }
}
