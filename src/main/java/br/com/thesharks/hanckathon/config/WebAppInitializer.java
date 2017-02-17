package br.com.thesharks.hanckathon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.thesharks.hanckathon.config.root.AppSecurityConfig;
import br.com.thesharks.hanckathon.config.root.DevelopmentConfiguration;
import br.com.thesharks.hanckathon.config.root.RootContextConfig;
import br.com.thesharks.hanckathon.config.root.TestConfiguration;
import br.com.thesharks.hanckathon.config.servlet.ServletContextConfig;

/**
 *
 * Replacement for most of the content of web.xml, sets up the root and the
 * servlet context config.
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootContextConfig.class, DevelopmentConfiguration.class, TestConfiguration.class,
				AppSecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ServletContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
