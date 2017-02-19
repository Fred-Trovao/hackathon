package br.com.thesharks.hackathon.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Configuration
@EnableWebMvc
@Import({ SecurityConfig.class })
@ComponentScan(basePackages = { "br.com.thesharks.hackathon.controller" })
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
		return new ResourceUrlEncodingFilter();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0)
				.resourceChain(true).addResolver(new GzipResourceResolver()).addResolver(new PathResourceResolver());

		registry.addResourceHandler("/favicon.ico").addResourceLocations("/resources/favicon.ico");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("resources/index.html");
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasename("classpath:messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jacksonMessageConverter());
	}

	@Bean(name = "objectMapper")
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {

		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();
		Hibernate4Module hibernate4Module = new Hibernate4Module();
		hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
		hibernate4Module.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, false);

		mapper.registerModule(hibernate4Module);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, false);
		mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
		mapper.configure(SerializationFeature.WRAP_EXCEPTIONS, false);

		messageConverter.setObjectMapper(mapper);

		return messageConverter;
	}

}
