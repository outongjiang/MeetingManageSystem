package Test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/Welcome.jsp")
public class myFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入Filter");
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        if(req.getSession().getAttribute("password")!=null){
            System.out.println("ccc");
            filterChain.doFilter(servletRequest,servletResponse);

        }else{
            resp.sendRedirect("/VD/updatePassword.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
