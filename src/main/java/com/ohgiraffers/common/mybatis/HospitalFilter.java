package com.ohgiraffers.common.mybatis;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/hospital/*")
public class HospitalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if(httpServletRequest.getMethod().equals("POST")){
            request.setCharacterEncoding("UTF-8");
        }
        chain.doFilter(request,response);
    }
}
