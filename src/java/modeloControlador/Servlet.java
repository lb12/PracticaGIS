package modeloControlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ModeloDatos bd;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        bd = new ModeloDatos();
        bd.abrirConexion();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Creamos una sesion
        HttpSession s = req.getSession(true);
        res.setContentType("application/json;charset=UTF-8");

        PrintWriter out = res.getWriter();
        try {
            out.println(bd.obtenerFacultades()); //Obtener las facultades.
        } catch (Exception ex) {
            out.println("Se han producido errores en el Servlet");
        } finally {
            out.close();
        }
    }

    @Override
    public void destroy() {
        bd.cerrarConexion();
        super.destroy();
    }

}
