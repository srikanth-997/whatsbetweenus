package com.seleniumexpress.Rc.config;

import org.hibernate.Hibernate;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RCalAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { HiberConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class arr[]= {RelationCalculatorAppConfig.class};
		
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = {"/"};
		return arr;
	}

}
