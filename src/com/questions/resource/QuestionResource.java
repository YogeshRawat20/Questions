package com.questions.resource;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonArray;
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
	  @Path("/getAllSubjects")
	  @GET
	  @Produces({MediaType.APPLICATION_JSON})
//	  @Produces("application/json")
	  public String getAllSubjects(@PathParam("todo") int qId) throws SQLException, IOException {
		System.out.println("getTodo");
		QuestionDao todo = new QuestionDao();
//		JsonObject jsonObject = todo.getQuestion(qId);
		JsonArray array = todo.getAllSubjects();
		String str  =  array.toString();
	    return str;
	  }
}
