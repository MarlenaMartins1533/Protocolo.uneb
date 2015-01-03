/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    
    ProtocolDAO protocolDAO = new ProtocolDAO();//era private
    
    @RequestMapping(value = "/create-protocol")
    public ModelAndView createProtocol() throws ParseException{
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        ModelAndView modelAndView = new ModelAndView("create-protocol");
        modelAndView.addObject("protocolo", new Protocol());
        modelAndView.addObject("data",date.format(new Date()));
        return modelAndView;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("protocolo") Protocol protocol){
        SimpleDateFormat date = new SimpleDateFormat("yyyy");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("codigo", new Codigo());
        protocol.setData(date.format(new Date()));
        String data = protocol.getData();
        data = data.replace("/","");
        protocol.setCodigo(protocol.getId()+ data);
        protocolDAO.add(protocol);
        return modelAndView;
    }
    
    /*
    @RequestMapping(value = "/search")
    public ModelAndView search(@ModelAttribute("codigo") Codigo codigo){
        ModelAndView modelAndView = new ModelAndView("index");
        Protocol protocol = protocolDAO.getProtocolByCodigo(codigo.getCodigo());
        return modelAndView;
    }*/
    
    @RequestMapping(value = "/protocol-detail") //consulta protocolo
    public ModelAndView protocoldetail(@ModelAttribute("codigo") Codigo codigo){
        ModelAndView modelAndView = new ModelAndView("protocol-detail");
        List protocols = protocolDAO.getAllProtocols();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");        
        modelAndView.addObject("data",date.format(new Date()));
        modelAndView.addObject("protocols", protocols);
        Protocol protocol = protocolDAO.getProtocolByCodigo(codigo.getCodigo());
        return modelAndView;
    }
}