package es.upm.isst;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;

@SuppressWarnings("serial")
public class AprobarComentarioServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String comentario_id = req.getParameter("comentarioId");
		
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();
		dao.aprobarComentario(comentario_id);
	}
}