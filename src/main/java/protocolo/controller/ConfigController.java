/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import protocolo.dao.SetorDAO;
import protocolo.dao.UserDAO;
import protocolo.model.Protocol;
import protocolo.model.Setor;
import protocolo.model.User;
import protocolo.model.UserType;


/**
 *
 * @author Murilo
 */
@Controller
public class ConfigController {
    
    private UserDAO userDAO = new UserDAO();
    private SetorDAO setorDAO = new SetorDAO();
    
    @RequestMapping(value = "/config")
    ModelAndView config(){
        ModelAndView modelAndView = new ModelAndView("config");
        return modelAndView;
    }
    
    @RequestMapping(value = "/create-user")
    ModelAndView createUser(){
        ModelAndView modelAndView = new ModelAndView("create-users","usuario",new User());
        modelAndView.addObject("setores", setorDAO.getAllSetores());
        return modelAndView;
    }
    
    @RequestMapping(value = "/create-setor")
    ModelAndView createSetor(){
        ModelAndView modelAndView = new ModelAndView("create-setor","setor",new Setor());
        return modelAndView;
    }
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("usuario") User user){
        ModelAndView modelAndView = new ModelAndView("create-users");
        modelAndView.addObject("usuario", user);
        user.setSetor(setorDAO.getSetorById(user.getSetorID()));
        if(user.getSetor().getNome() == "Protocolo"){
            user.setType(UserType.PROTOCOLO);
        } else {
            user.setType(UserType.SETOR);
        }
        userDAO.add(user);
        return modelAndView;
    }
    
    @RequestMapping(value = "/addSetor", method = RequestMethod.POST)
    public ModelAndView addSetor(@ModelAttribute("setor") Setor setor){
        ModelAndView modelAndView = new ModelAndView("create-setor");
        modelAndView.addObject("setor",setor);
        setorDAO.add(setor);
        return modelAndView;
    }
}
