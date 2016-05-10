package es.upm.isst;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import es.upm.isst.dao.MatacuasDAO;
import es.upm.isst.dao.MatacuasDAOImpl;
import es.upm.isst.model.InfraccionModel;

@SuppressWarnings("serial")
public class GetComentarioModerarServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();
		List<InfraccionModel> listaInfraccion = dao.getInfraccionModerar();	
		if (listaInfraccion.size()>0){
			InfraccionModel infraccion = listaInfraccion.get(0);
			try{
				JSONObject json = new JSONObject();
				json.put("status",true);
				json.put("id",infraccion.getId().toString());
				json.put("matricula", infraccion.getMatricula());
				json.put("descripcion",infraccion.getDescripcion());
				resp.getWriter().println(json.toString());
			}catch(JSONException e){
				e.printStackTrace();
			}
		}else{
			try{
				JSONObject json = new JSONObject();
				json.put("status",false);
				resp.getWriter().println(json.toString());
			}catch(JSONException e){
				e.printStackTrace();
			}
		}
	}
}