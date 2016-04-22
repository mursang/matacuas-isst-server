package es.upm.isst;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;

@SuppressWarnings("serial")
public class LoginUserServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String op = req.getParameter("operacion");
		if (op.equals("checkIfUserExists")){ //si el usuario existe, devuelvo su id. Sino, devuelvo false.
			String myEmail = req.getParameter("email");
			MatacuasDAO dao = MatacuasDAOImpl.getInstance();
			String myUserId = dao.getUserIdFromEmail(myEmail);		
			JSONObject json = new JSONObject();
			try{
				if (myUserId == "not found"){ //not found
					json.put("status","false");
				}else{ // ok
					json.put("status","true");
					json.put("userId", myUserId);
				}
			}catch(JSONException e){
				e.printStackTrace();
			}
			
			resp.getWriter().println(json.toString());
		}
		
		
		
	}
}