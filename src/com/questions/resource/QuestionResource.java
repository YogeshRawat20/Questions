package com.questions.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.questions.dao.QuestionDao;
import com.questions.pojo.Questions;

@Path("/questionId")
public class QuestionResource {
	  @Path("{todo}")
	  @GET
	  @Produces({MediaType.APPLICATION_JSON})
//	  @Produces("application/json")
	  public String getTodo(@PathParam("todo") int qId) {
		System.out.println("getTodo");
		QuestionDao todo = new QuestionDao();
		JsonObject jsonObject = todo.getQuestion(qId);
		String str  =  jsonObject.toString();
	    return str;
	  }
}
