package demo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class Config extends WebMvcConfigurerAdapter {

	@Bean
	public LocaleResolver localeResolver() {
		final CookieLocaleResolver slr = new CookieLocaleResolver();
		slr.setCookieMaxAge(86400 * 365 * 5);
		slr.setCookieName("lang");
		slr.setDefaultLocale(Locale.ENGLISH);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		final LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		lci.setIgnoreInvalidLocale(true);
		return lci;
	}

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
