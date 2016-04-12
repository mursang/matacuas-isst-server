package es.upm.isst;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;
import es.upm.isst.model.UserModel;

@SuppressWarnings("serial")
public class Es_upm_isstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();	
		List<UserModel> myList = dao.getAllUsers();
		for (UserModel user: myList){
			resp.getWriter().println(user.getName());
			resp.getWriter().println(user.getId());
		}
	}
}
