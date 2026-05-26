:
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
//
// @author Jan Pokorsky

@EnableAutoConfiguration
@EnableWebMvc
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("kA5SYFS*By2");
//        return dataSource;
//    }
//
//    @Bean
//    @Override
//    public LocaleResolver localeResolver() {
//        final LocaleContextHolder localeContextHolder = new LocaleContextHolder(Locale.getDefault());
//        return new LocaleContextResolver(localeContextHolder);
//    }
//
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames("messages");
//        return messageSource;
//    }
//
//    @Bean
//    public EnvironmentHandler environmentHandler() {
//        EnvironmentHandler handler = new EnvironmentHandler();
//        handler.setEnvironment(new StandardEnvironment());
//        return handler;
//    }
//
//    @Bean
//    public Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }
//
//    @Bean
//    public ValidatorFactory validatorFactory() {
//        return new ValidatorFactoryImpl();
//    }
//
//    @Bean
//    public RequestContextListener requestContextListener() {
//        return new RequestContextListener();
//    }
//
//    @Bean
//    public FlashMapManager flashMapManager() {
//        return new DefaultFlashMapManager();
//    }
//
//    @Bean
//    public FlashMapRepository flashMapRepository() {
//        return new DefaultFlashMapRepository();
//    }

    @Bean
    public RequestDataValueProcessor requestDataValueProcessor() {
        return new RequestDataValueProcessor();
    }

//    @Bean
//    public RequestContextListener requestContextListener() {
//        return new RequestContextListener();
//    }
//
//    @Bean
//    public MessageSourceAccessor messageSourceAccessor() {
//        return new MessageSourceAccessor(messageSource());
//    }
}
