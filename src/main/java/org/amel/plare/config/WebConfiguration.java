package org.amel.plare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	private WebMvcInterceptor webMvcInterceptor;

	@Autowired
	public WebConfiguration(WebMvcInterceptor webMvcInterceptor) {
		this.webMvcInterceptor = webMvcInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(webMvcInterceptor).addPathPatterns("/**");
	}
}