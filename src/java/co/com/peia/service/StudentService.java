/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.service;

import co.com.peia.config.JsonResponse;
import co.com.peia.entity.PeiaStudent;
import co.com.peia.entity.PeiaStudentBonds;
import co.com.peia.facade.StudentFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Servicio rest que manejara
 * las peticiones del modulo e
 * estuinte
 * 
 * @author marcos manotas
 * @since Fecha de creacion 2/junio/2019
 */
@Path("/studentService")
public class StudentService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EJB
    private StudentFacade studentFacade;
    
    
    /**
     * Metoo implementaado para cargar
     * el lito e bonos asociados a un estudiante
     * 
     * @åuthor Marcos Manotas
     * @since Fecha de Creacion 2/junio/2019
     * 
     * @param idUser
     * @return 
     */
    @POST
    @Path("/getListBondsByIdStudent")
    public String getListBondsByIdStudent(@FormParam("idUser") Integer  idUser){
        
        try{
            
         
            List<PeiaStudentBonds> listStu=this.studentFacade.getListBondsByIdStudent(idUser);
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok",listStu);

            return response.toString();
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
}
