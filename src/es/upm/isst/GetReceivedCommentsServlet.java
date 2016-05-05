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
public class GetReceivedCommentsServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String myId = req.getParameter("userId");
		MatacuasDAO dao = MatacuasDAOImpl.getInstance();
		List<InfraccionModel> myList = dao.getReceivedComments(myId);		
		
		JSONObject jsonGeneral = new JSONObject();
		// respondemos en formato JSON
		int contador = 0;
		try{
		for (InfraccionModel inf: myList){
			
				JSONObject json = new JSONObject();
			
			json.put("id",inf.getId().toString());
			
			json.put("latitud",inf.getLatitud().toString());
			json.put("longitud",inf.getLongitud().toString());
			json.put("matricula", inf.getMatricula());
			json.put("descripcion",inf.getDescripcion());
			json.put("aprobada", ""+inf.getAprobada());
			
			String dateStr=String.format("%td/%tm/%tY", inf.getFecha(),inf.getFecha(),inf.getFecha());
			json.put("fecha", dateStr);
			
			jsonGeneral.put(""+contador, json);
			
				
			
			contador++;
		}
		}catch(JSONException e){
			e.printStackTrace();
		}

		resp.getWriter().println(jsonGeneral.toString());
		
	}
}