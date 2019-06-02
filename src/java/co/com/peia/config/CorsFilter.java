package co.com.peia.config;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase implementada para gestionar
 * el filtro ded las peticiones realizadas 
 * al servidor esto con el fin e manejar
 * que tipos e consultas estan permitiddas realizar
 * conexion con el servior
 * 
 * @author marco manotas
 */
@WebFilter(asyncSupported = true, urlPatterns = {"/*"})
public class CorsFilter implements Filter {

    /**
     * Default constructor.
     */
    public CorsFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * Metoo implemento para recibir header de
     * peticiones y tener control del tipo permitido
     * 
     * @author marcos manotas
     * 
     * @param servletRequest
     * @param servletResponse
     * @param chain
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse response = (HttpServletResponse) res;
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST");
        response.addHeader("X-FRAME-OPTIONS", "DENY");
        response.setHeader("Allow", "GET,POST");
        
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
