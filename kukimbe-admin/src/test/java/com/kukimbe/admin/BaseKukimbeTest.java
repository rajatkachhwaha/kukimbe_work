package com.kukimbe.admin;

import com.kukimbe.admin.config.KukimbeAppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by chuck on 8/16/16.
 */
@WebAppConfiguration
@PropertySource({"classpath:kukimbe.properties"})
@ContextConfiguration(classes= KukimbeAppConfig.class, loader = AnnotationConfigWebContextLoader.class)
@ComponentScan(basePackages = "com.kukimbe")
public abstract class BaseKukimbeTest  extends AbstractTestNGSpringContextTests {
    private final static Logger LOG = LoggerFactory.getLogger(BaseKukimbeTest.class);
    @Value("${active.api.key}")
    String apikey;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigTest() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
