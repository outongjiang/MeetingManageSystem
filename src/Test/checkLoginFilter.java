package Test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(value = {"/jsp/*"})
public class checkLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型转化为http协议的请求对象
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        String uri=req.getRequestURI();
        System.out.println("doFilter");
        //获取会话变量success，判断是否为空；为空则表示尚未登录页面；


        if(req.getSession().getAttribute("username")==null){
            Cookie cookies[]=req.getCookies();
            for(Cookie c:cookies){
                if("username".equals(c.getName())){
                    req.getSession().setAttribute("username",c.getValue());
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            }
            resp.sendRedirect("/VD/login.jsp");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
