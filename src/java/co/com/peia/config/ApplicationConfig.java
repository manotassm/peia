/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Cle implememtada para gestionar
 * toos los servicios REST eclarados en
 * la aplicacion
 * 
 * @uthor Marco Manotas
 * 
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {
     
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.com.peia.service.AdminService.class);
        resources.add(co.com.peia.service.SecurityService.class);
        resources.add(co.com.peia.service.StudentService.class);
        resources.add(co.com.peia.service.hola.class);
    }
}
