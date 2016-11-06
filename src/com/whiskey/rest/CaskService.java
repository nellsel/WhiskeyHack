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

@Path("/CaskService")
public class CaskService {

	@Path("{caskId}")
	@GET
	@Produces("application/json")
	public Response getCask(@PathParam("caskId") int caskId) throws JSONException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			List<Cask> stlist = session.createQuery("select s from Cask s where s.caskId = " + caskId)
					.getResultList();
			//CaskHistory caskHistory = session.get(CaskHistory.class, new Integer(1));
			session.close();
			//JSONObject jsonObject = new JSONObject(stlist);
			String json = new Gson().toJson(stlist);

			//String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
			return Response.status(200).entity(json).build();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(505).build();
		}
	}
}
