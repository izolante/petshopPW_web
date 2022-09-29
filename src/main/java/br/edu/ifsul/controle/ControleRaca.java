/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.RacaDAO;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.edu.ifsul.model.Raca;
import br.edu.ifsul.util.Util;
import javax.ejb.EJB;

/**
 *
 * @author Izolante
 */
@Named(value = "controleRaca")
@ViewScoped
public class ControleRaca implements Serializable {
    
    @EJB
    private RacaDAO<Raca> dao;
    private Raca objeto;
    
    public ControleRaca() {
        
    }
    
    public String listar() {
        return "/privado/raca/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Raca();
    }
    
    public void alterar(Object id) {
        
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id) {
        
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if(objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    /**
     * @return the dao
     */
    public RacaDAO<Raca> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(RacaDAO<Raca> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Raca getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Raca objeto) {
        this.objeto = objeto;
    }
    
}
