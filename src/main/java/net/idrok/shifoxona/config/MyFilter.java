package net.idrok.shifoxona.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component

public class MyFilter implements Filter {

    @Override
    public void doFilter(
                            ServletRequest servletRequest,
                            ServletResponse servletResponse,
                            FilterChain filterChain) throws IOException, ServletException {
        System.out.println("bir");
        HttpServletRequest hsrq = (HttpServletRequest) servletRequest;
        HttpServletResponse hsrp = (HttpServletResponse) servletResponse;
        String login = hsrq.getHeader("login");
        System.out.println(login);
        if(login !=null && login.equals("admin")){
            hsrp.setHeader("status", "malades");
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            hsrp.setHeader("status", "Sizga bu sahifaga kirish taqiqlangan!");
        }
    }
}
