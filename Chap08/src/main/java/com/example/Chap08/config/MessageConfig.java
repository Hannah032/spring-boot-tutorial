package com.example.Chap08.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
//@ComponentScan("server")
public class MessageConfig implements WebMvcConfigurer {
    // 메시지 소스 빈 설정1
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/i18n"); // messages.properties 파일을 기본으로 사용
        messageSource.setDefaultEncoding("UTF-8"); // 인코딩 설정
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setAlwaysUseMessageFormat(true);

        return messageSource;
    }
    // 메시지 소스 빈 설정2
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:messages/i18n"); // messages.properties 파일을 기본으로 사용
//
//        return messageSource;
//    }

    // LocaleResolver 빈 설정
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.KOREAN); // 기본 로케일 설정

        System.out.println("localeResolver Bean created");
        return resolver;
    }
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor Interceptor = new LocaleChangeInterceptor();
        Interceptor.setParamName("language"); // 요청 파라미터 이름 설정 (예: ?lang=ko)
        return Interceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
