package uts.consumer.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@AutoConfigureAfter(DruidDataSourceConfig.class)
public class MybatisConfiguration {
    @Resource(name = "uts1")
    private DataSource uts1DataSource;

    @Resource(name = "uts2")
    private DataSource uts2DataSource;

    @Resource(name = "uts3")
    private DataSource uts3DataSource;

    @Resource(name = "uts4")
    private DataSource uts4DataSource;

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource roundRobbinDataSourceProxy(){
        Map<Object, Object> targetDataSource = new HashMap<Object, Object>();
        targetDataSource.put(DataBaseContextHolder.DataBaseType.UTS1, uts1DataSource);
        targetDataSource.put(DataBaseContextHolder.DataBaseType.UTS2, uts2DataSource);
        targetDataSource.put(DataBaseContextHolder.DataBaseType.UTS3, uts3DataSource);
        targetDataSource.put(DataBaseContextHolder.DataBaseType.UTS4, uts4DataSource);
        DynamicDataSource proxy = new DynamicDataSource();
        proxy.setTargetDataSources(targetDataSource);
        proxy.setDefaultTargetDataSource(uts1DataSource);

        return proxy;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DynamicDataSource dynamicDataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try{
            bean.setMapperLocations(resolver.getResources("classpath:uts/consumer/mapping/*.xml"));
            SqlSessionFactory sqlSessionFactory = bean.getObject();
            sqlSessionFactory.getConfiguration().setCacheEnabled(Boolean.TRUE);
            return sqlSessionFactory;
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Bean
    public PlatformTransactionManager transactionManager(DynamicDataSource dynamicDataSource) throws Exception{
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dynamicDataSource);
        return txManager;
    }
}
