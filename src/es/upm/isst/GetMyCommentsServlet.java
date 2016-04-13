package es.upm.isst;

import java.io.IOException;
import java.util.List;

import es.upm.isst.model.InfraccionModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;

@SuppressWarnings("serial")
public class GetMyCommentsServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String myId = req.getParameter("userId");
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();
		List<InfraccionModel> myList = dao.getMyInfracciones(myId);
		
		for (InfraccionModel inf: myList){
			resp.getWriter().println("COMENTARIO ENCONTRADO: "+inf.getDescripcion()+" <br>");
		}
		
		
	}
}