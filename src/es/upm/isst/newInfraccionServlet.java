package es.upm.isst;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class newInfraccionServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.getWriter().println("HOLA!!! ESTOY FUNCIONANDO.. O ESO CREO");
		String param1 = req.getParameter("param1");
		resp.getWriter().println(param1);
	}
}
