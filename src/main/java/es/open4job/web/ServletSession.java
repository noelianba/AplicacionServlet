package es.open4job.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.open4job.web.model.dao.BaseDatosDAO;
import es.open4job.web.model.dao.EstacionServicioDAO;
import es.open4job.web.model.vo.EstacionServicio;

/**
 * Servlet implementation class ServletSession
 */
public class ServletSession extends HttpServlet {
	
	public static final Logger logger = Logger
			.getLogger(EstacionServicioDAO.class.getName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				HttpSession session = request.getSession(true);
				
				BaseDatosDAO bbdd = new BaseDatosDAO();

				try {
					Connection conexion = bbdd.abrirConexion();
					EstacionServicioDAO estacionServicio = new EstacionServicioDAO();
					String idIn = (String) session.getAttribute("id");
					int id = Integer.parseInt(idIn);
					EstacionServicio estacionesServicio = estacionServicio.getListadoEstacionServicio(id, conexion);
					session.setAttribute("estacion", estacionesServicio);
					request.getRequestDispatcher("miestacionSession.jsp").forward(request, response);
					// Vista
					//PrintWriter out = response.getWriter();
					
					//request.setAttribute("estacion", estacionesServicio);
					//session.setAttribute("estacion", estacionesServicio);

					
					/*out.println("<html>");
					out.println("<body>");
					out.println("<h1>Estación Servicio: "
							+ estacionesServicio.toString() + "</h1>");
					out.println("</body>");
					out.println("</html>");*/
				} catch (ClassNotFoundException e) {
					logger.log(Level.SEVERE,
							"ClassNotFoundException : " + e.getMessage());
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
				}

				bbdd.cerrarConexion();
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
