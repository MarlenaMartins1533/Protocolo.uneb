/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Murilo
 */
@Entity
@Table(name = "protocolo")
public class Protocol {
    private int setorID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    
    private int semestre;
    
    private String nome;
    
    private String endereco;
    
    private String curso;
    
    private String matricula;
    
    private String codigo;
    
    private String rg;
    
    private String objetoRequerimento;
    
    private String esclarescimento;
    
    private String telefone;
    
    private String cpf;
    
    private String data;
    
    private ProtocolStatus status;

    @Override
    public String toString() {
        return "Campos: "+"Id: "+id+ " " +
               "Nome: "+ nome + " " +
               "Endereco: "+endereco+ " " +
               "Telefone: "+telefone+ " " +
               "Semestre: "+semestre+ " " +
               "Cpf: "+cpf+ " " +
               "Data: "+data+ " " +
               "Curso: "+curso+ " " +
               "Matricula: "+ matricula+ " " +
               "Codigo: "+codigo+ " " +
               "Rg: "+rg+ " " +
               "Objeto Requerimento: "+objetoRequerimento+ " " +
               "Esclarescimento: "+esclarescimento;//To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the objetoRequerimento
     */
    public String getObjetoRequerimento() {
        return objetoRequerimento;
    }

    /**
     * @param objetoRequerimento the objetoRequerimento to set
     */
    public void setObjetoRequerimento(String objetoRequerimento) {
        this.objetoRequerimento = objetoRequerimento;
    }

    /**
     * @return the esclarescimento
     */
    public String getEsclarescimento() {
        return esclarescimento;
    }

    /**
     * @param esclarescimento the esclarescimento to set
     */
    public void setEsclarescimento(String esclarescimento) {
        this.esclarescimento = esclarescimento;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public ProtocolStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ProtocolStatus status) {
        this.status = status;
    }

    /**
     * @return the setorID
     */
    public int getSetorID() {
        return setorID;
    }

    /**
     * @param setorID the setorID to set
     */
    public void setSetorID(int setorID) {
        this.setorID = setorID;
    }
}
