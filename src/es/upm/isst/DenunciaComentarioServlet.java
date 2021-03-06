package es.upm.isst;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;

@SuppressWarnings("serial")
public class DenunciaComentarioServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String user_id = req.getParameter("userId");
		String comentario_id = req.getParameter("comentarioId");
		
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();
		Long generatedId = dao.newDenuncia(comentario_id, user_id);
		
		 
		JSONObject json = new JSONObject();
		// respondemos en formato JSON el userId
		try {
			json.put("denunciaId", generatedId);
			json.put("status", 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		// finally output the json string  
		resp.getWriter().println(json.toString());		
	}
}