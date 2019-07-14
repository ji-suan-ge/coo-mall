package cn.edu.hfut.coomall.config.filter;

import cn.edu.hfut.coomall.config.wrapper.BodyReaderWrapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 葛学文
 * @date 2019/7/14 11:38
 */
@Configuration
public class BodyReaderFilterConfig {
    @Bean
    public FilterRegistrationBean<BodyReaderFilter> Filters() {
        FilterRegistrationBean<BodyReaderFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new BodyReaderFilter());
        registrationBean.addUrlPatterns("/have/*");
        registrationBean.setName("bodyReaderFilter");
        return registrationBean;
    }
}

class BodyReaderFilter implements Filter {

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper=null;
        if(servletRequest instanceof HttpServletRequest) {
            requestWrapper=new BodyReaderWrapper((HttpServletRequest)servletRequest);
        }
        if(requestWrapper==null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(requestWrapper, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
