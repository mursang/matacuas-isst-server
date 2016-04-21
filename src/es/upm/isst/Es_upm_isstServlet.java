package es.upm.isst;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;
import es.upm.isst.model.InfraccionModel;
import es.upm.isst.model.UserModel;

@SuppressWarnings("serial")
public class Es_upm_isstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();
		
		List<UserModel> myList = dao.getAllUsers();
		resp.getWriter().println("LISTADO DE USUARIOS EN LA BBDD:<br>");
		for (UserModel user: myList){
			resp.getWriter().println(user.getName());
			resp.getWriter().println(user.getId());
		}
		
		Date myDate = new Date();		
		//dao.addInfraccion((long)-34.543,(long)30.012,"2823832-HKQ","Descripcion guay",myDate);
		resp.getWriter().println("AÑADIDA INFRACCION.<br>");
		
		List<InfraccionModel> infraccionesList = dao.getAllInfracciones();
		resp.getWriter().println("LISTADO DE INFRACCIONES EN LA BBDD:<br>");
		for (InfraccionModel inf: infraccionesList){
			resp.getWriter().println(inf.getDescripcion());
			resp.getWriter().println(inf.getFecha());
		}
	}
}
