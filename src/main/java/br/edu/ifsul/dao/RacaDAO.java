/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;
import br.edu.ifsul.model.Raca;
import java.io.Serializable;
import javax.ejb.Stateful;
/**
 *
 * @author Izolante
 */
@Stateful
public class RacaDAO<TIPO> extends DAOGenerico<Raca> implements Serializable{
    
    public RacaDAO(){
        super();
        classePersistente = Raca.class;
    }
    
}
