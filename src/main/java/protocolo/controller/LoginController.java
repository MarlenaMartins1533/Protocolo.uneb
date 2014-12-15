/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.controller;

import java.util.ArrayList;
import javax.enterprise.inject.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import protocolo.model.Login;

/**
 *
 * @author Murilo
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/loginForm")
    ModelAndView loginForm(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }
    
    @RequestMapping(value = "/menu")
    ModelAndView menu(){
        ModelAndView modelAndView = new ModelAndView("menu");
        modelAndView.addObject("protocols",new ArrayList());
        return modelAndView;
    }
    
    @RequestMapping(value = "/login")
    ModelAndView login(@ModelAttribute Login login){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
    
}
