package hello.login.domain.login;

import hello.login.web.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter() {
        //스프링부트가 WAS를 들고 띄우기 때문에, 이렇게 해놓으면 WAS를 띄울 때 필터를 같이 넣어준다.
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1); //체인 순서
        filterRegistrationBean.addUrlPatterns("/*"); //모든 URL에 적용

        return filterRegistrationBean;
    }
}
