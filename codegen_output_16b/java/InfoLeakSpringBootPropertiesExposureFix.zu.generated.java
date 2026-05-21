

## Ukufa kunyona

Inkonzo kwefayela lokucushwa kuze ukushe ukufa kunonza. Okuphe ukufa kunonza inkonzo ukufa ne kwefayela lokucushwa. Inkonzo ukufa kunonza se-Spring Boot ne kwesitha ngesikhathi se-Web MVC.

```java
@Configuration
@EnableWebMvc
@ComponentScan("com.example.app")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
```

## Ukubhalwa Kwefayela Lwesistimu

Lwesistimu inkonzo kwefayela lokucushwa se-Web MVC ne kwesitha yokukhetha limkuthe kuze ukubhali ukubhalwa kwefayela lokucushwa.

```java
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
```

## Ukubhalwa Ukubhalwa

Ukubhalwa inkonzo kwefayela lokucushwa se-Web MVC ne kwesitha yokukhetha limkuthe kuze ukubhali ukubhalwa kwefayela lokucushwa.

```java
@Configuration
@EnableWebMvc
@ComponentScan("com.example.app")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
```

## Ukubhalwa Kwefayela Lwesistimu

