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
import protocolo.dao.ProtocolDAO;
import protocolo.model.Codigo;
import protocolo.model.Protocol;

/**
 *
 * @author Murilo
 */
@Controller
public class ProtocolController {
    
    private ProtocolDAO protocolDAO = new ProtocolDAO();
    
    @RequestMapping(value = "/create-protocol")
    public ModelAndView createProtocol(){
        ModelAndView modelAndView = new ModelAndView("create-protocol");
        modelAndView.addObject("protocolo", new Protocol());
        return modelAndView;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("protocolo") Protocol protocol){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("codigo", new Codigo());
        protocol.setCodigo(protocol.getId()+protocol.getData());
        protocolDAO.add(protocol);
        return modelAndView;
    }
    
    @RequestMapping(value = "/search")
    public ModelAndView search(@ModelAttribute("codigo") Codigo codigo){
        ModelAndView modelAndView = new ModelAndView("index");
        Protocol protocol = protocolDAO.getProtocolByCodigo(codigo.getCodigo());
        return modelAndView;
    }
}
