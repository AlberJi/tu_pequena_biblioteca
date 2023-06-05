package com.alberto.tupequenabiblioteca.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class MensajesConfig implements WebMvcConfigurer {

  @Bean
  public MessageSource messageResource() {
    ReloadableResourceBundleMessageSource messageSource =
            new ReloadableResourceBundleMessageSource();

    messageSource.setBasename("classpath:mensajes");
    messageSource.setDefaultEncoding("UTF-8");

    return messageSource;
  }

  @Bean
  public LocalValidatorFactoryBean getValidator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(messageResource());
    return bean;
  }

  // Los beans siguientes son para la internacionalización de los mensajes/etiquetas/textos
  @Bean
  public LocaleResolver localeResolver() {
    CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    localeResolver.setDefaultLocale(new Locale("es","ES"));
    localeResolver.setCookieName("lang"); // fija el nombre de la cookie donde se almacenará la preferencia de idioma
    return localeResolver;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    localeChangeInterceptor.setParamName("lang"); //fija el nombre del parámetro de la url para cambiar de idioma
    return localeChangeInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

}