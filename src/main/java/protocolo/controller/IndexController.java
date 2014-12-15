/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import protocolo.model.Codigo;

/**
 *
 * @author Murilo
 */
@Controller
public class IndexController {
    
    @RequestMapping(value = "/")
    ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("codigo", new Codigo());
        return modelAndView;
    }
}
