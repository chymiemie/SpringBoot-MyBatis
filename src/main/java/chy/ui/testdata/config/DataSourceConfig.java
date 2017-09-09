package chy.ui.testdata.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "chy.ui.testdata.dao", sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	@Bean(name = "SqlSessionFactory")
	@Primary
	public SqlSessionFactory primarySqlSessionFactoryBean(@Qualifier("dataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(datasource);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	@Primary
	public PlatformTransactionManager centerTransactionManager(@Qualifier("dataSource") DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}

}