/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.service;

import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author mmanotas
 */
@Path("securityServiceRest")
public class SecurityService {
    
         
    @POST
    @Path("select")
    public void guardar(@FormParam("id") String  id) {
            
            System.out.println("llego el valor "+id);
            
        
    }
}
