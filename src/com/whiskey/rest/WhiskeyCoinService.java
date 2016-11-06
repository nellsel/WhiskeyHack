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
import org.json.JSONObject;

import com.google.gson.Gson;


@Path("/WhiskeyCoinService")
public class WhiskeyCoinService {

	@Path("{caskId}")
	@GET
	@Produces("application/json")
	public Response getCaskHistory(@PathParam("caskId") int caskId) throws JSONException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			List<CaskHistory> stlist = session.createQuery("select s from CaskHistory s where s.CaskId = " + caskId)
					.getResultList();
			session.close();
			
			String json = new Gson().toJson(stlist);

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
