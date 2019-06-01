/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.facade;

import co.com.peia.entity.PeiaStudent;
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
public class StudentFacade {
    
    @PersistenceContext(unitName = "AppBondsPU")
    private EntityManager em;
    
    /**
     * Mewtodo iplemetnado para listar todos 
     * los estudiantes en del sistema
     * 
     * author Marcos Manotas
     * since Fecha de creacion 1/junio/20'19
     * @return 
     */
    public  List<PeiaStudent> getListStudent(){
            Query q=em.createNamedQuery("PeiaStudent.findAll");
          
        return q.getResultList();
        
    }
}
