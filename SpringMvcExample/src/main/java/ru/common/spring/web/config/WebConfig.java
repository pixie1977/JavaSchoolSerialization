package ru.common.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

//@EnableWebMvc
//@ComponentScan(basePackages = { "com.baeldung.web.controller" })
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("index");
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates");
        templateResolver.setSuffix(".html");
        // some other lines neglected...

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        // some other lines neglected...

        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    @Bean
    public ThemeChangeInterceptor themeChangeInterceptor() {
        ThemeChangeInterceptor interceptor = new ThemeChangeInterceptor();
        interceptor.setParamName("theme");
        return interceptor;
    }

    @Bean
    public BeanNameViewResolver beanNameViewResolver() {
        BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
        beanNameViewResolver.setOrder(1);
        return beanNameViewResolver;
    }

    /**
     * Static resource locations including themes
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**/*")
                .addResourceLocations("/", "/resources/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    /**
     * Spring Boot allows configuring Content Negotiation using properties
     */
    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true)
                .favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }
}