package sg.edu.iss.caps;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sg.edu.iss.caps.filter.LogFilter;



@Configuration
public class FilterConfig 
{
	@Bean
	public FilterRegistrationBean<LogFilter> filterRegistrationBean()
	{
		FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
		LogFilter loggingFilter = new LogFilter();

		registrationBean.setFilter(loggingFilter);

		return registrationBean;
	}
}
