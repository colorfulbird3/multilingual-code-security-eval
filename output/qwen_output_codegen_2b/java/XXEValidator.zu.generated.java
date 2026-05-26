 <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Ikwembe Kudugelwabefakwesake
// - Ikwembe kudugelwabefakwesake okuhli ezimweni ezigenele kufanele kufanele kwenziwe ezinjengokungatholakali kwefayela noma izindlela ezingenalutho/ezingenalutho.
// - Ikwembe kudugelwabefakwesake okuhli ezimweni ezigenele kufanele kufanele kwenziwe ezinjengokungatholakali kwefayela noma izindlela ezingenalutho/ezingenalutho.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```

package com.example.config;

import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ImportResource({
    "/applicationContext.xml",
    "/applicationContext-jndi.xml" })
public class AppConfig {

    @Bean
    public JndiTemplate jndiTemplate() {
        JndiTemplate jndiTemplate = new JndiTemplate();
        jndiTemplate.setResourceRef(true);
        return jndiTemplate;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "messages")
    public ResourceBundleMessageSource messages() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     *
     *
     * @param configPath
     * @param validatorFactory bean
     * @return
     */
    @Bean
    public com.example.service.ConfigService configService(@Qualifier("configPath") String configPath,
        @Qualifier("validatorFactoryBean") LocalValidatorFactoryBean validatorFactoryBean) {
        return new com.example.service.ConfigService(configPath, validatorFactoryBean);
    }

    @Bean
    public com.example.config.Config config(com.example.service.ConfigService configService) {
        return new com.example.config.Config(configService);
    }
}
