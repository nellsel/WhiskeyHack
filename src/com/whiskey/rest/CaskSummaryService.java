package com.whiskey.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.json.JSONException;

import com.google.gson.Gson;

@Path("/CaskSummaryService")
public class CaskSummaryService {

	@GET
	@Produces("application/json")
	public Response getCaskSummary() throws JSONException {

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			List<CaskHistory> stlist = session.createQuery("select s from CaskHistory s").getResultList();
			session.close();

			HashMap<Integer, List<String>> hashMap = new HashMap<Integer, List<String>>();
			for (CaskHistory caskHistory : stlist) {
				int caskId = caskHistory.getCaskId();
				String alcoholtype = caskHistory.getAlcoholType();

				if (!hashMap.containsKey(caskId)) {
					List<String> alcoholTypeList = new ArrayList<String>();
					alcoholTypeList.add(alcoholtype);
					hashMap.put(caskId, alcoholTypeList);
				} else {
					hashMap.get(caskId).add(caskHistory.getAlcoholType());
				}
			}
			List<CaskSummary> caskSummaryList = new ArrayList<CaskSummary>();
			for (Integer caskId : hashMap.keySet()) {
				List<String> alcoholTypes = hashMap.get(caskId);
				CaskSummary summary = new CaskSummary();
				summary.CaskId = caskId;
				summary.History = "";
				for (String alcholType : alcoholTypes) {

					summary.History += alcholType + ", ";
				}
				caskSummaryList.add(summary);
			}

			String json = new Gson().toJson(caskSummaryList);

			return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(json).build();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(505).build();
		}
	}
}

class CaskSummary {
	public int CaskId;
	public String History;

}
