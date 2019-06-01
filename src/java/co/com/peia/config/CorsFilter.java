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

// Enable it for Servlet 3.x implementations
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
        
        //Comentar cuando se trabaje angular en modo desarrollo para saltar sesion

//        if (session == null) {
//            if ("XMLHttpRequest".equals(httpReq.getHeader("x-requested-with"))) {
//                response.setStatus(401);
//                response.setContentType("application/json");
//                response.getWriter().write( GenericJSONResponse.undefinedSession());
//                return;
//            } else {
//                response.setStatus(401);
//                response.getWriter().write("La sesión expiró");
//                return;
//            }
//        }
        //fin filtro session
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
