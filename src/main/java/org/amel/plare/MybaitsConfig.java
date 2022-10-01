package org.amel.plare;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "org.amel.plare.mapper")
public class MybaitsConfig {
	
	@Bean
	public SqlSessionFactory sqlsessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setTypeAliasesPackage("org.amel.plare.vo");
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath:/mapper/*.xml"));
		
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
