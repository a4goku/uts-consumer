package uts.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "uts.consumer.mapper")
@ComponentScan(basePackages = {"uts.consumer.*", "uts.consumer.config.*"})
public class MainConfig {
}
