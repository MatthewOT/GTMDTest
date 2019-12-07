package com.gtmdtest.platform.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-12-07 13:18
 **/
@WebFilter(urlPatterns="/*")
public class CrossFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CrossFilter");
        HttpServletResponse res=(HttpServletResponse) servletResponse;
        res.addHeader("Access-Control-Allow-Origin", "*");
        // res.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        res.addHeader("Access-Control-Allow-Methods", "*");
        res.addHeader("Access-Control-Allow-Methods", "POST");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
