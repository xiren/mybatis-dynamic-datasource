package com.example.mybatisdynamicdatasource.config;

import com.example.mybatisdynamicdatasource.datasource.DynamicDataSource;
import com.example.mybatisdynamicdatasource.datasource.DynamicDataSourceName;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class AppConfiguration {

    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource initWriteDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.read")
    public DataSource initReadDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource getDynamicDataSource(
            @Lazy @Qualifier("readDataSource") DataSource readDataSource,
            @Lazy @Qualifier("writeDataSource") DataSource writeDataSource
    ) {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = Map.of(
                DynamicDataSourceName.READ, readDataSource,
                DynamicDataSourceName.WRITE, writeDataSource);
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }
}
