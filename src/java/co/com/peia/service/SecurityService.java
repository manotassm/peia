/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.service;

import co.com.peia.config.JsonResponse;
import co.com.peia.entity.PeiaSecUser;
import co.com.peia.entity.PeiaStudent;
import co.com.peia.facade.SecurityFacade;
import co.com.peia.facade.StudentFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Servicio rest que manejara
 * login a la aplicacion
 * 
 * @author marcos manotas
 */
@Path("/securityServiceRest")
public class SecurityService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EJB
    private StudentFacade studentFacade;
    @EJB
    private SecurityFacade securityFacade;
    
    @POST
    @Path("/login")
    public String login(@FormParam("idRol") Integer  idRol,
                        @FormParam("user") String  user,
                        @FormParam("pass") String  pass){
        try {
            
            PeiaSecUser userLogin=this.securityFacade.loginUser(user, pass,idRol);
            
            
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Usuario Logueado",userLogin);

            return response.toString();
            
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
    
    
    @POST
    @Path("/select")
    public String guardar(@FormParam("id") String  id) {
            
        try {
            
            List<PeiaStudent> listStu=this.studentFacade.getListStudent();
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok Hola",listStu);

            return response.toString();
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
}
