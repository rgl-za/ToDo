package com.todo.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // 자바 기반의 설정 파일
@PropertySource("classpath:/application.properties") // 해당 클래스에서 참조할 properties 파일의 위치를 지정
public class DBConfiguration {

    @Autowired // 빈으로 등록된 인스턴스 (객체)를 클래스에 주입하는데 사용
    private ApplicationContext applicationContext;

    @Bean // configuration 클래스의 메소드 레벨에만 지정이 가능하며 어노테이션 빈이 지정된 객체는 컨테이너에 의해 관리되는 빈으로 등록됨
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/**/*Mapper.xml"));
        factoryBean.setTypeAliasesPackage("com.todo.domain");
        factoryBean.setConfiguration(mybatisConfg());
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    @ConfigurationProperties(prefix="mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfg(){
        return new org.apache.ibatis.session.Configuration();
    }

}
