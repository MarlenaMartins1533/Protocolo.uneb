/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        modelAndView.addObject("action","addUser");
        modelAndView.addObject("botao","Cadastrar");
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
    
    @RequestMapping(value="/listUser")
    public ModelAndView listUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("list-user");
        modelAndView.addObject("users", userDAO.getAllUsers());
        User user = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario",user.getNome());
        return modelAndView;
    }
  
    @RequestMapping(value = "/EditUser/{id}")
    public ModelAndView editUser(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("create-users");
        User user = userDAO.getUserById(id);
        modelAndView.addObject("usuario", user);
        modelAndView.addObject("setores", setorDAO.getAllSetores());
        modelAndView.addObject("action","EditUserBD");
        modelAndView.addObject("botao","Salvar");
        return modelAndView;
    }
    
    @RequestMapping(value = "/EditUserBD")
    public ModelAndView editUserBD(@ModelAttribute("usuario") User user,HttpSession session){
        Setor setor = setorDAO.getSetorById(user.getSetorID());
        user.setSetor(setor);
        userDAO.edit(user);
        ModelAndView modelAndView = new ModelAndView("list-user");
        modelAndView.addObject("users", userDAO.getAllUsers());
        User u = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario",u.getNome());
        return modelAndView;
    }
    
    @RequestMapping(value = "/DeleteUser/{id}")
    public ModelAndView deleteUser(@PathVariable int id,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("list-user");
        User user = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario",user.getNome());
        user = userDAO.getUserById(id);
        userDAO.delete(user);
        modelAndView.addObject("users", userDAO.getAllUsers());
        return modelAndView;
    }
    
    //Setor
    @RequestMapping(value="/listSetor")
    public ModelAndView listSetor(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("list-setor");
        modelAndView.addObject("setores", setorDAO.getAllSetores());
        User user = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario",user.getNome());
        return modelAndView;
    }
  
    @RequestMapping(value = "/EditSetor/{id}")
    public ModelAndView editSetor(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("create-setor");
        Setor setor = setorDAO.getSetorById(id);
        modelAndView.addObject("setor", setor);
        modelAndView.addObject("action","EditSetorBD");
        modelAndView.addObject("botao","Salvar");
        return modelAndView;
    }
    
    @RequestMapping(value = "/EditSetorBD")
    public ModelAndView editSetorBD(@ModelAttribute("usuario") Setor setor,HttpSession session){
        setorDAO.edit(setor);
        ModelAndView modelAndView = new ModelAndView("list-setor");
        modelAndView.addObject("setores", setorDAO.getAllSetores());
        User user = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario",user.getNome());
        return modelAndView;
    }
    
    @RequestMapping(value = "/DeleteSetor/{id}")
    public ModelAndView deleteSetor(@PathVariable int id,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("list-setor");
        User user = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario",user.getNome());
        Setor setor = setorDAO.getSetorById(id);
        setorDAO.delete(setor);
        modelAndView.addObject("setores", setorDAO.getAllSetores());
        return modelAndView;
    }
}
