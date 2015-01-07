/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat; //formatar data
import java.util.List;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import protocolo.dao.ProtocolDAO;
import protocolo.dao.SetorDAO;
import protocolo.dao.UserDAO;
import protocolo.model.Login;
import protocolo.model.User;

/**
 *
 * @author Murilo
 */
@Controller
public class LoginController {
    private UserDAO userDAO = new UserDAO();
    
    @RequestMapping(value = "/loginForm")
    ModelAndView loginForm(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login",new Login());
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        modelAndView.addObject("data",date.format(new Date()));
        return modelAndView;
    }
    
    @RequestMapping(value = "/menu")
    ModelAndView menu(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("menu");
        User user = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("protocols",userDAO.getUserById(user.getId()).getSetor().getProtocols());
        System.out.println();
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/login")
    ModelAndView login(@ModelAttribute Login login,HttpSession session){
        ModelAndView modelAndView;
        User user = userDAO.getUserByUsername(login.getUsername());
        if(user == null){
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("message", "Usuario "+login.getUsername()+" nao existe");
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            modelAndView.addObject("data",date.format(new Date()));
            return modelAndView;
        } else {
            if(user.getPassword().equals(login.getPassword())){
                session.setAttribute("usuario_logado", user);
                modelAndView = new ModelAndView("menu");
                modelAndView.addObject("usuario", user.getNome());
                List protocols = null;
                if(user.getSetor() != null){
                    protocols = user.getSetor().getProtocols();
                }
                modelAndView.addObject("protocols", protocols);
                return modelAndView;
            } else {
                modelAndView = new ModelAndView("login");
                modelAndView.addObject("message", "Senha Incorreta");
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                modelAndView.addObject("data",date.format(new Date()));
                return modelAndView;
            }
        }
    }    
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("login","login",new Login());
        session.setAttribute("usuario_logado", null);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        modelAndView.addObject("data",date.format(new Date()));
        return modelAndView;
    }
    
    @RequestMapping(value = "/erro")
    ModelAndView erro(){
        ModelAndView modelAndView = new ModelAndView("erro");
        return modelAndView;
    }    
}
