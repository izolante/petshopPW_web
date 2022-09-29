/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Izolante
 */
public class DAOGenerico<TIPO> implements Serializable {
    
    private List<TIPO> listaObjetos;
    private List<TIPO> listaTodos;
    @PersistenceContext(unitName = "my_persistence_unit")
    protected EntityManager em;
    protected Class classePersistente;

    public DAOGenerico(){
    
    }
    /**
     * @return the listaObjetos
     */
    public List<TIPO> getListaObjetos() {
        String jpql = "from " + classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }
    
    public void persist(TIPO obj) throws Exception {
        
        em.persist(obj);
    }
    
    public void merge(TIPO obj) throws Exception {
        
        em.merge(obj);
    }
    
    public void remove(TIPO obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public TIPO getObjectByID(Object id) throws Exception {
        return (TIPO) em.find(classePersistente, id);
    }
    
    /**
     * @param listaObjetos the listaObjetos to set
     */
    public void setListaObjetos(List<TIPO> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    /**
     * @return the listaTodos
     */
    public List<TIPO> getListaTodos() {
        String jpql = "from " + classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }

    /**
     * @param listaTodos the listaTodos to set
     */
    public void setListaTodos(List<TIPO> listaTodos) {
        this.listaTodos = listaTodos;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the classePersistente
     */
    public Class getClassePersistente() {
        return classePersistente;
    }

    /**
     * @param classePersistente the classePersistente to set
     */
    public void setClassePersistente(Class classePersistente) {
        this.classePersistente = classePersistente;
    }
    
    
}
