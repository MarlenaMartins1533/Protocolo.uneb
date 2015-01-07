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
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import protocolo.dao.ProtocolDAO;
import protocolo.dao.SetorDAO;
import protocolo.model.Codigo;
import protocolo.model.Protocol;
import protocolo.model.ProtocolStatus;
import protocolo.model.Setor;
import protocolo.model.User;

/**
 *
 * @author Murilo
 */
@Controller
public class ProtocolController {
    
    ProtocolDAO protocolDAO = new ProtocolDAO();//era private
    SetorDAO setorDAO = new SetorDAO();
    
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
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        ModelAndView modelAndView = new ModelAndView("protocol-detail-external");
        modelAndView.addObject("message", "Salve Este Codigo, pois sem ele não será possivel acessar a página.");
        // Setando dados de insercao
        protocol.setStatus(ProtocolStatus.PENDENTE);
        protocolDAO.add(protocol);
        
        // Setando codigo
        protocolDAO.getProtocolById(protocol.getId());
        protocol.setData(date.format(new Date()));
        String data = protocol.getData();
        data = data.replace("/","");        
        protocol.setCodigo(protocol.getId()+ data);
        protocolDAO.edit(protocol);
        
        //Colocando no setor
        modelAndView.addObject("protocolo", protocol);
        Setor setor = setorDAO.getSetorById(1);
        setor.addProtocols(protocol);
        setorDAO.edit(setor);
        
        return modelAndView;
    }
    
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute Codigo codigo){
        ModelAndView modelAndView;
        Protocol protocol = protocolDAO.getProtocolByCodigo(codigo.getCodigo());
        if(protocol == null){
            modelAndView = new ModelAndView("index");
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            modelAndView.addObject("data",date.format(new Date()));
            modelAndView.addObject("message","Protocolo Inexistente");
        } else {
            modelAndView = new ModelAndView("protocol-detail-external");
            modelAndView.addObject("protocolo", protocol);    
            modelAndView.addObject("data", protocol.getData());
        }
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/protocol-detail/{codigo}") //consulta protocolo
    public ModelAndView protocoldetail(@PathVariable String codigo,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("protocol-detail");
        Protocol protocol = protocolDAO.getProtocolByCodigo(codigo);
        modelAndView.addObject("protocolo", protocol);
        modelAndView.addObject("codigo", protocol.getCodigo());
        modelAndView.addObject("data",protocol.getData());
        User user = (User)session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario",user.getNome());
        List setores = setorDAO.getAllSetores();
        modelAndView.addObject("setores",setores);
        return modelAndView;
    }
    
    @RequestMapping(value = "/encaminhar", method = RequestMethod.POST)
    public ModelAndView encaminhar(@ModelAttribute("protocolo")Protocol protocol,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("menu");
        //Transferir protocolo de setor
        Setor setor = setorDAO.getSetorById(protocol.getSetorID());
        setor.addProtocols(protocol);
        setorDAO.edit(setor);
        
        //Retirar protocolo do outro setor
        User user = (User)session.getAttribute("usuario_logado");
        setor = setorDAO.getSetorById(user.getSetor().getId());
        setor.deleteProtocol(protocol);
        setorDAO.edit(setor);
        
        //Setar a view
        modelAndView.addObject("usuario",user.getNome());
        modelAndView.addObject("protocols",setor.getProtocols());
        return modelAndView;
    }
    
    @RequestMapping(value = "/deferir/{codigo}")
    public ModelAndView deferir(@PathVariable String codigo,HttpSession session){
    ModelAndView modelAndView = new ModelAndView("menu");
        Protocol protocol = protocolDAO.getProtocolByCodigo(codigo);
        protocol.setStatus(ProtocolStatus.DEFERIDO);
        protocolDAO.edit(protocol);
        
        User user = (User)session.getAttribute("usuario_logado");
        Setor setor = setorDAO.getSetorById(user.getSetor().getId());
        modelAndView.addObject("usuario",user.getNome());
        modelAndView.addObject("protocols",setor.getProtocols());
        return modelAndView;
    }
    
    @RequestMapping(value = "/indeferir/{codigo}")
    public ModelAndView indeferir(@PathVariable String codigo,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("menu");
        User user = (User)session.getAttribute("usuario_logado");
        Setor setor = setorDAO.getSetorById(user.getSetor().getId());
        Protocol protocol = protocolDAO.getProtocolByCodigo(codigo);
        protocol.setStatus(ProtocolStatus.INDEFERIDO);
        protocolDAO.edit(protocol);
        modelAndView.addObject("usuario",user.getNome());
        modelAndView.addObject("protocols",setor.getProtocols());
        return modelAndView;
    }
}