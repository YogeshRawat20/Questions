package com.questions.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.questions.connect.DBConnector;
import com.questions.pojo.Questions;

public class QuestionDao {
	public JsonObject getQuestion( int qId){
		System.out.println("getQuestions");
		JsonArray bigArray = new JsonArray();
		JsonObject jsonResponse = new JsonObject();
//		ArrayList<String> pracid = new ArrayList<String>();
		String query ="select questions.qId, questions.qText,"+
						" choices.choice"+
						" from questions right join choices on questions.qId = choices.qId"+
						" where questions.qId = "+qId;
		jsonResponse.addProperty("qid", qId);
		jsonResponse.addProperty("qtid", qId);
		JsonObject qdata = new JsonObject();
		JsonObject choice = new JsonObject();
		JsonArray correctAnswer = new JsonArray();
		try(Statement stmt=DBConnector.getInstance().getStatement();
				ResultSet rst=stmt.executeQuery(query))
		{
		String count="0";
		while (rst.next())
			{
				System.out.println("RESULT SET : "+count);
				if(Integer.parseInt(count.trim()) == 0){
					jsonResponse.addProperty("qtext", "A");
					qdata.addProperty("qs", rst.getString(2));
				}
				choice.addProperty(count.trim(), rst.getString(3));
				count  = (Integer.parseInt(count)+1)+"";
				
			}
//		qdata.addProperty("choice", choice);
		qdata.add("choice", choice);
		} catch (SQLException | IOException e1)
		{
		}
		jsonResponse.add("qdata", qdata);
		query="select answers.choiceId from answers where qId ="+qId;
		try(Statement stmt=DBConnector.getInstance().getStatement();
				ResultSet rst=stmt.executeQuery(query))
		{
		while (rst.next())
			{
				String ans = rst.getInt(1)+"";
				correctAnswer.add(new JsonPrimitive(rst.getInt(1)));
			}
		} catch (SQLException | IOException e1)
		{
		}
		jsonResponse.add("correctAnswer", correctAnswer);
		jsonResponse.addProperty("spid", qId);
		jsonResponse.addProperty("createdtime", qId);
		System.out.println("JSON RESPONSE : "+jsonResponse);
		return jsonResponse;
	}
}
