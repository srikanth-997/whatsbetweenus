package com.seleniumexpress.Rc.config;

import java.util.Properties;


import java.util.logging.Logger;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages= {"com.seleniumexpress.Rc"})
@PropertySource("classpath:resources/email.properties")
public class RelationCalculatorAppConfig implements WebMvcConfigurer {
	
	@Autowired
	 private Environment env;

		Logger logger = Logger.getLogger(RelationCalculatorAppConfig.class.getName());

		@Bean
		public InternalResourceViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

			viewResolver.setPrefix("/WEB-INF/view/");
			viewResolver.setSuffix(".jsp");

			return viewResolver;

		}

		@Bean
		public MessageSource messageSource() {
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasename("message");
			System.out.println("messageResource mthd exctd");
			return messageSource;
		}

		@Bean(name = "validator")
		public LocalValidatorFactoryBean validator() {
			LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
			localValidatorFactoryBean.setValidationMessageSource(messageSource());
			System.out.println("Relation validator method exctd");
			return localValidatorFactoryBean;
		}

		@Bean
		public JavaMailSender configureJavaMailSender() {
			logger.info("Fetching host value" + env.getProperty("email.host"));

			JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
			javaMailSenderImpl.setHost(env.getProperty("email.host"));
			javaMailSenderImpl.setUsername(env.getProperty("email.userName"));
			javaMailSenderImpl.setPassword(env.getProperty("email.password"));
			javaMailSenderImpl.setPort(getProperty("email.port"));
			javaMailSenderImpl.setJavaMailProperties(getMailproperty());

			return javaMailSenderImpl;
		}

		private Properties getMailproperty() {
			Properties mailProperties = new Properties();
			mailProperties.put("mail.smtp.starttls.enable", true);
			mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			return mailProperties;
		}

		int getProperty(String key) {
			String property = env.getProperty(key);
			return Integer.parseInt(property);
		}

		@Override
		public org.springframework.validation.Validator getValidator() {
			System.out.println("validator method exctd");
			return validator();
		}

}
