package com.whiskey.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.json.JSONException;

import com.google.gson.Gson;

@Path("/DistilleryService")
public class DistilleryService {
	
	@Path("{distilleryId}")
	@GET
	@Produces("application/json")
	public Response getDistillery(@PathParam("distilleryId") int distilleryId) throws JSONException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			List<Distillery> stlist = session.createQuery("select s from Distillery s where s.DistilleryId = " + distilleryId)
					.getResultList();
			//CaskHistory caskHistory = session.get(CaskHistory.class, new Integer(1));
			session.close();
			//JSONObject jsonObject = new JSONObject(stlist);
			String json = new Gson().toJson(stlist);

			//String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
			return Response.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.entity(json)
					.build();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(505).build();
		}
	}
}
