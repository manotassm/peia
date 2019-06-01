/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mmanotas
 */
@Stateless
public class AdminPeiaFacade {
    
     @PersistenceContext(unitName = "AppBondsPU")
    private EntityManager em;
}
