package kr.re.kitri.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/ajax-server")
public class AjaxServer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청에 대한 응답 (데이터 보내줌)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("ajax를 통한 통신 데이터");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		JsonObject json = new JsonObject();
		json.addProperty("id", id);
		json.addProperty("name", name);
		// {"id":"admin", "name":"관리자"}
		
		JsonObject json2 = new JsonObject();
		json2.addProperty("id", "user");
		json2.addProperty("name", "사용자");
		// {"id":"user", "name":"사용자"}
		
		JsonArray jsonArr = new JsonArray();
		jsonArr.add(json);
		jsonArr.add(json2);
		//[{"id":"admin", "name":"관리자"},{"id":"user", "name":"사용자"}]
		
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(jsonArr);
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonResponse);
		
		
		
	}

}
