/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;
import br.edu.ifsul.model.Produto;
import java.io.Serializable;
import javax.ejb.Stateful;
/**
 *
 * @author Izolante
 */
@Stateful
public class ProdutoDAO<TIPO> extends DAOGenerico<Produto> implements Serializable{
    
    public ProdutoDAO(){
        super();
        classePersistente = Produto.class;
    }
    
}
