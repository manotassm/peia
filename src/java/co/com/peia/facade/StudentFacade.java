/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.facade;

import co.com.peia.entity.PeiaStudent;
import co.com.peia.entity.PeiaStudentBonds;
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
    
    /**
     * Metodo implementado para cargar la lista
     * de bonos asginados a un estudiante en especifico
     * 
     * @author Marcos Manotas
     * @param idSecUser
     * @since Fecha de Creacion 2/junio/2019
     * @return 
     */
    public List<PeiaStudentBonds> getListBondsByIdStudent(Integer idSecUser){
        
        Query q=em.createNativeQuery("SELECT psb.* " +
                    "	FROM peia_student_bonds psb " +
                    "		inner join peia_student ps on psb.id_student=ps.id " +
                    "where ps.id_sec_user=?idSecUser", PeiaStudentBonds.class);
        q.setParameter("idSecUser",idSecUser);
        
          
        return q.getResultList();
        
    }
}
