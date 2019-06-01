/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.service;

import co.com.peia.config.JsonResponse;
import co.com.peia.entity.PeiaReserveMoney;
import co.com.peia.entity.PeiaSecUser;
import co.com.peia.entity.PeiaStudent;
import co.com.peia.entity.PeiaStudentBonds;
import co.com.peia.entity.PeiaTickets;
import co.com.peia.facade.AdminFacade;
import co.com.peia.facade.StudentFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Servicio rest que manejara los procesos 
 * de negocio realizados por el administrador
 * 
 * @author marcos manotas
 */
@Path("/adminService")
public class AdminService  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private AdminFacade adminFacade;
    @EJB
    private StudentFacade StudentFacade;
    
    /**
     * Metodo implemetnado para guardar los
     * nuevos registros de dinero en el sistema
     * 
     * @author marcos Manotas
     * 
     * @since Fecha de Creacion 1/Junio /2019
     * 
     * @param idUser
     * @param idTicket
     * @param cant
     * @return 
     */
    @POST
    @Path("/saveMoney")
    public String saveMoney(@FormParam("idUser") Integer  idUser,
                            @FormParam("idTicket") Integer idTicket,
                            @FormParam("cant") Integer cant){
        try {
            
            this.adminFacade.saveMoney(idUser, idTicket,cant);
            List<PeiaReserveMoney> list=this.adminFacade.findAllRegistre();
            
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok",list);

            return response.toString();
            
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
    
    /**
     * ¨metodo implem,entado para buyscar todos
     * los registros de dinero ingresados en el sistema
     * 
     * @author marcos Manotas
     * @since Fecha de Creacion 1/Junio /2019
     * 
     * @return 
     */
    @POST
    @Path("/findAllRegistre")
    public String findAllRegistre(@DefaultValue("") @FormParam("query") String query) {
            
        try {
            
            List<PeiaReserveMoney> listtick=this.adminFacade.findAllRegistre();
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok",listtick);

            return response.toString();
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
    
    /**
     * ¨metodo implem,entado para buyscar todos
     * los billetes registrados de distintas denominaciones
     * 
     * @author marcos Manotas
     * @since Fecha de Creacion 1/Junio /2019
     * 
     * @return 
     */
    @POST
    @Path("/findAllTickets")
    public String findAllTickets(@DefaultValue("") @FormParam("query") String query) {
            
        try {
            
            List<PeiaTickets> listtick=this.adminFacade.findAllTickets();
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok",listtick);

            return response.toString();
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
    
    
    
     /**
     * Metodo implemetnado para guardar los
     * nuevos bonos
     * 
     * @author marcos Manotas
     * 
     * @since Fecha de Creacion 1/Junio /2019
     * 
     * @param idUser
     * @param idTicket
     * @param cant
     * @return 
     */
    @POST
    @Path("/saveBono")
    public String saveBono(@FormParam("idStudent") Integer  idStudent,
                            @FormParam("cantBono") Integer cantBono,
                            @FormParam("idUser") Integer idUser){
        try {
            
            this.adminFacade.saveBono(idStudent, cantBono,idUser);
            List<PeiaStudentBonds> list=this.adminFacade.findAllBono();
            
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok",list);

            return response.toString();
            
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
    
    /**
     * ¨metodo implem,entado para buyscar todos
     * los bonos registrados
     * 
     * @author marcos Manotas
     * @since Fecha de Creacion 1/Junio /2019
     * 
     * @return 
     */
    @POST
    @Path("/findAllBono")
    public String findAllBono(@DefaultValue("") @FormParam("query") String query) {
            
        try {
            
            List<PeiaStudentBonds> listBonsd=this.adminFacade.findAllBono();
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok",listBonsd);

            return response.toString();
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
    
    /**
     * ¨metodo implem,entado para buyscar todos
     * los billetes registrados de distintas denominaciones
     * 
     * @author marcos Manotas
     * @param query
     * @since Fecha de Creacion 1/Junio /2019
     * 
     * @return 
     */
    @POST
    @Path("/findAllStudent")
    public String findAllStudent(@DefaultValue("") @FormParam("query") String query) {
            
        try {
            
            List<PeiaStudent> listStudent=this.StudentFacade.getListStudent();
            JsonResponse response = new JsonResponse(true, JsonResponse.SUCCESFUL_PROCESSED_STATUS, "Ok",listStudent);

            return response.toString();
        } catch (Exception e) {
            return new JsonResponse(false, JsonResponse.INTERNAL_ERROR_STATUS, "Ha ocurrido un error al procesar la solicitud").toString();
        }
    }
}
