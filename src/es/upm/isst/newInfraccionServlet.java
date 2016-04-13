package es.upm.isst;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;



@SuppressWarnings("serial")
public class NewInfraccionServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		//recogemos los datos de la Infraccion
		Long latitud = (long)Double.parseDouble(req.getParameter("latitud"));
		Long longitud = (long)Double.parseDouble(req.getParameter("longitud"));
		String matriculaInfractor = req.getParameter("matricula");
		String descripcion = req.getParameter("descripcion");
		Date fecha = new Date();
		
		//el id del usuario que está enviando la infracción.
		String userId = req.getParameter("userId");
		
		//si no tiene matricula la denuncia, no es válida
		if (matriculaInfractor == "" || matriculaInfractor == null){
			//TODO: JSON con respuesta de error.
			return;
		}
		
		if (descripcion == null){
			descripcion = "";
		}
		
		//si todo esta bien, guardamos la infraccion y asignamos al usuario que la ha creado.
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();
		Long generatedId = dao.addInfraccion(longitud, latitud, matriculaInfractor, descripcion, fecha);
		
		//una vez guardada la infraccion y generado el id, asignamos al usuario
		dao.matchInfraccionUsuario(generatedId, Long.parseLong(userId));
		
		resp.getWriter().println("GUARDADA INFRACCION CON ID: "+generatedId+" Y HECHO MATCH CON USER ID: "+userId);
		
		
		
	}
}
