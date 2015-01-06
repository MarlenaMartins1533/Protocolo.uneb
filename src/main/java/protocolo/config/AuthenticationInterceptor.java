/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Murilo
 */
class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if(request.getSession().getAttribute("usuario_logado") == null){
            String uri = request.getRequestURI();
            if(uri.endsWith("/Protocolo.uneb") || uri.endsWith("create-protocol")
                    || uri.endsWith("/loginForm") || uri.endsWith("/login")
                    || uri.endsWith("/add")){
                return true;
            } else {
               response.sendRedirect("/Protocolo.uneb/login");
               return false;
            }
        } else {
            String uri = request.getRequestURI();
            if(uri.endsWith("/loginForm") || uri.endsWith("/login")){
                response.sendRedirect("/Protocolo.uneb/menu");
                return false;
            } else {
                return true;
            }
        }
    }

 }