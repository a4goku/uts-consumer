package uts.consumer.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name="uts1")
    @Primary
    @ConfigurationProperties(prefix = "druid.uts1")
    public DataSource uts1DataSource() throws SQLException{
        DataSource uts1DataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.info("------------uts1:{}---------------", uts1DataSource);
        return uts1DataSource;
    }

    @Bean(name="uts2")
    @ConfigurationProperties(prefix = "druid.uts2")
    public DataSource uts2DataSource() throws SQLException{
        DataSource uts2DataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.info("------------uts2:{}---------------", uts2DataSource);
        return uts2DataSource;
    }

    @Bean(name="uts3")
    @ConfigurationProperties(prefix = "druid.uts3")
    public DataSource uts3DataSource() throws SQLException{
        DataSource uts3DataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.info("------------uts3:{}---------------", uts3DataSource);
        return uts3DataSource;
    }

    @Bean(name="uts4")
    @ConfigurationProperties(prefix = "druid.uts4")
    public DataSource uts4DataSource() throws SQLException{
        DataSource uts4DataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.info("------------uts4:{}---------------", uts4DataSource);
        return uts4DataSource;
    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("allow", "localhost");
        reg.addInitParameter("deny", "/deny");
        //reg.addInitParameter("loginUsername", "bhz");
        //reg.addInitParameter("loginPassword", "bhz");
        logger.info("druid console manager init : {}", reg);
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico, /druid/*");
        logger.info("druid filter register : {}", filterRegistrationBean);
        return filterRegistrationBean;
    }

}
