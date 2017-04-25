/**
 * Created by Heart_Bool on 2017/4/26.
 */
package com.feng.web.configuration.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/***
 * Description:
 *
 * @AUTHOR: HEART_BOOL
 * @EMAIL: 18908069164@163.com
 * @DATE: 2017/4/26 0:18
 */
@Configuration

@MapperScan(basePackages = "com.feng.web.mapper.apis", sqlSessionTemplateRef  = "apisSqlSessionTemplate")
public class APISDataSourceConfiguration {

    @Bean(name = "apisDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.apis")
    public DataSource testDataSource() {
        return new HikariDataSource();
    }

    @Bean(name = "apisSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("apisDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/feng/web/mapper/apis/*/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "apisTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("apisDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "apisSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("apisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
