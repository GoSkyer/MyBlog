package org.gosky.blog.base;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DruidConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dds = new DruidDataSource();
        dds.setProxyFilters(Arrays.asList(statFilter(),logFilter()));
//        dds.setProxyFilters(Collections.singletonList(logFilter()));
        return dds;
    }

    @Bean
    public Filter statFilter() {
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }


    @Bean
    public Filter logFilter() {
        Log4jFilter logFilter = new Log4jFilter();
        logFilter.setDataSourceLogEnabled(true);
        logFilter.setStatementLogEnabled(false);
        logFilter.setStatementLogErrorEnabled(true);
        logFilter.setStatementExecutableSqlLogEnable(true);
        return logFilter;
    }
}
