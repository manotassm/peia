/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.facade;

import co.com.peia.entity.PeiaReserveMoney;
import co.com.peia.entity.PeiaStudent;
import co.com.peia.entity.PeiaStudentBonds;
import co.com.peia.entity.PeiaTickets;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mmanotas
 */
@Stateless
public class AdminFacade {
    
     @PersistenceContext(unitName = "AppBondsPU")
    private EntityManager em;
     
     /**
      * Metodo implemetnado para guardar los
      * dineros ingresados
      * 
      * @author Marcos Manotas
     * @param idUser
     * @param idTicket
     * @param cantInteger
      * @return 
      */
    public void saveMoney(Integer idUser,
                          Integer idTicket,
                          Integer cantInteger){
        PeiaReserveMoney pr=new PeiaReserveMoney();
        pr.setCant(cantInteger);
        pr.setCreationDate(new Date());
        pr.setIdPeiaTickets(new PeiaTickets(idTicket));
        pr.setIdCreacionUser(idUser);
        
        em.persist(pr);
        em.flush();
        
    }
    /**
      * Metodo implemetnado para listar
      * todos los registros de dinero
      * 
      * @author Marcos Manotas
      * @return 
      */
    public List<PeiaReserveMoney> findAllRegistre(){
        
        Query q=em.createNamedQuery("PeiaReserveMoney.findAll");
          
        return q.getResultList();
    }

    /**
      * Metodo implemetnado para listar
      * todos los distintos tipos
      * de billetes.
      * 
      * @author Marcos Manotas
      * @return 
      */
    public List<PeiaTickets> findAllTickets(){
        
        Query q=em.createNamedQuery("PeiaTickets.findAll");
          
        return q.getResultList();
    }
    
    /**
      * Metodo implemetnado para guardar los
      * bonos de los estudiantes
      * 
      * @author Marcos Manotas
      * @return 
      */
    public void saveBono(Integer idStudent,
                          Integer cantBono,
                          Integer idUser){
        
        PeiaStudentBonds pr=new PeiaStudentBonds();
        pr.setValue(Double.parseDouble(cantBono.toString()));
        pr.setCreationDate(new Date());
        pr.setIdCreationUser(idUser);
        pr.setIdStudent(new PeiaStudent(idStudent));
        
        em.persist(pr);
        em.flush();
        
    }
    /**
      * Metodo implemetnado para listar
      * todos los registros de dinero
      * 
      * @author Marcos Manotas
      * @return 
      */
    public List<PeiaStudentBonds> findAllBono(){
        
        Query q=em.createNamedQuery("PeiaStudentBonds.findAll");
          
        return q.getResultList();
    }
}
