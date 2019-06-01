/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.facade;

import co.com.peia.entity.PeiaSecUser;
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
public class SecurityFacade {
    
    @PersistenceContext(unitName = "AppBondsPU")
    private EntityManager em;
    

    /**
     * Metodo impementado para realizar la verificacion de
     * los datos de acceso a cajero.
     * 
     * @author Marcos Manotas
     * @since Fecha de Creacion: 1/Juno/2019
     * 
     * @param nick
     * @param pass
     * @param idRol
     * @return 
     */
    public  PeiaSecUser loginUser(String nick,String pass,Integer idRol){
        Query q=em.createNamedQuery("PeiaSecUser.loginUser");
        q.setParameter("nick", nick);
        q.setParameter("pass", pass);
        q.setParameter("idRol", idRol);
            
        return (PeiaSecUser)q.getSingleResult();
        
    }
}
