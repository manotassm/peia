/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.config;

import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Clase implementada para manejar la respuesta
 * de las consultar y retornar en forma de JSON
 * 
 * @author mmanotas
 * @since Fecha de Creacion: 1/Junio/2019
 */
public class JsonResponse extends JSONSerializer {

    public final static int SUCCESFUL_PROCESSED_STATUS = 10;
    public final static int GENERAL_BUSINESS_LOGIC_ERROR = 20;
    public final static int INVALID_SESSION_STATUS = 21;
    public final static int NOT_FOUND_RESOURCE_STATUS = 22;
    public final static int CONFLICT_STATUS = 23;
    public final static int INTERNAL_ERROR_STATUS = 24;

    private int status;
    private String msg;
    private boolean success;
    private List data;
    private Object object;
    private int total;

    HashMap<String, Object> map = new HashMap<>();

    public static final String MSG = "msg";
    public static final String STATUS = "status";
    public static final String SUCCESS = "success";
    public static final String OBJECT = "object";
    public static final String DATA = "data";
    public static final String TOTAL = "total";

    private void initConfig() {
        this.exclude("*.class");
        this.exclude("*.urlFile");
        this.exclude("*.url_file");
        this.exclude("*.contrasena");
        this.include(DATA);
        this.include(OBJECT);
        this.transform(new DateTransformer("dd/MM/yyyy"), Date.class);
    }

    public void reinit() {
        initConfig();
    }

    public JsonResponse(boolean success, int status, String message) {
        this.initConfig();
        this.status = status;
        this.msg = message;
        this.success = success;
        map = new HashMap<>();
        map.put(STATUS, status);
        map.put(MSG, msg);
        map.put(SUCCESS, success);
    }

    public JsonResponse(boolean success, int status, String message, List data) {
        this.initConfig();
        this.status = status;
        this.msg = message;
        this.success = true;
        this.data = data;

        map = new HashMap<>();
        map.put(MSG, msg);
        map.put(STATUS, status);
        map.put(SUCCESS, success);
        map.put(DATA, data);
    }

    public JsonResponse(boolean success, int status, String message, List data, int total) {
        this.initConfig();
        this.status = status;
        this.success = success;
        this.msg = message;
        this.total = total;
        this.data = data;

        map = new HashMap<>();
        map.put(STATUS, status);
        map.put(MSG, msg);
        map.put(SUCCESS, success);
        map.put(TOTAL, total);
        map.put(DATA, data);
    }

    public JsonResponse(boolean success, int status, String message, List data, long total) {
        this.initConfig();
        this.status = status;
        this.success = success;
        this.msg = message;
        this.data = data;

        map = new HashMap<>();
        map.put(STATUS, status);
        map.put(MSG, msg);
        map.put(SUCCESS, success);
        map.put(TOTAL, total);
        map.put(DATA, data);
    }

    public JsonResponse(boolean success, int status, String message, Object object) {
        this.initConfig();
        this.success = success;
        this.status = status;
        this.msg = message;
        this.object = object;

        map = new HashMap<>();
        map.put(STATUS, status);
        map.put(MSG, msg);
        map.put(SUCCESS, success);
        map.put(OBJECT, object);
    }

    public JsonResponse(boolean success, int status, String message, Object object, boolean special) {
        this.initConfig();
        this.success = success;
        this.status = status;
        this.msg = message;
        this.object = object;

        map = new HashMap<>();
        map.put(STATUS, status);
        map.put(MSG, msg);
        map.put(SUCCESS, success);
        map.put(DATA, object);
    }

    public JsonResponse(boolean success, int status, String message, Object object, List data) {
        this.initConfig();
        this.success = success;
        this.status = status;
        this.msg = message;
        this.object = object;
        this.data = data;

        map = new HashMap<>();
        map.put(STATUS, status);
        map.put(MSG, msg);
        map.put(SUCCESS, success);
        map.put(OBJECT, object);
        map.put(DATA, data);
    }

    public JsonResponse(boolean success, int status, String message, Object object, List data, int total) {
        this.initConfig();
        this.success = success;
        this.status = status;
        this.msg = message;
        this.object = object;
        this.data = data;
        this.total = total;

        map = new HashMap<>();
        map.put(STATUS, status);
        map.put(MSG, msg);
        map.put(SUCCESS, success);
        map.put(OBJECT, object);
        map.put(DATA, data);
        map.put(TOTAL, total);

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        map.remove(DATA);
        map.put(DATA, data);
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.serialize(map);
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        map.remove(OBJECT);
        map.put(OBJECT, object);
        this.object = object;
    }

    public static String undefinedSession() {
        HashMap<String, Object> r = new HashMap<String, Object>();
        r.put(MSG, "La session expiró");
        r.put(SUCCESS, false);
        r.put("JSESSIONID", false);
        return new JSONSerializer().serialize(r);
    }

}
