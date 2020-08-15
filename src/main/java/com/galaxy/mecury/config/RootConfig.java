package com.galaxy.mecury.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@ComponentScan(value ={"com.galaxy.mecury"},
        excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})})
@Configuration//声明这是一个配置类
@MapperScan("com.galaxy.mecury.dao")
@PropertySource(value = {"classpath:db/jdbc.properties"}, ignoreResourceNotFound=true)
@EnableTransactionManagement
public class RootConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean //7
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 配置数据源
     *
     * @date 2018/6/24
     **/
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(50);
//        dataSource.setMaxEvictableIdleTimeMillis(30000L);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(30);
        return dataSource;
    }

    /**
     * 配置数据源
     *
     * @date 2018/6/24
     **/
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 动态获取SqlMapper
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:db/mapper/*.xml"));
//        sqlSessionFactoryBean.setConfigLocation(resourcePatternResolver.getResource("classpath:db/mybatisConfig.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);

        return dataSourceTransactionManager;
    }
}
