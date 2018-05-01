package cn.nuaa.tomax.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/30 16:51
 */
@Configuration
@ComponentScan("cn.nuaa.tomax")
public class AppConfig {
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/design_pattern?useUnicode=true&characterEncoding=utf-8&useSSL=true");
        ds.setUsername("root");
        ds.setPassword("");
        ds.setInitialSize(3);
        ds.setMaxTotal(200);
        ds.setMaxIdle(50);
        ds.setMinIdle(5);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
