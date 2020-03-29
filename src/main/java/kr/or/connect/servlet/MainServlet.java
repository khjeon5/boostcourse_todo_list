package kr.or.connect.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.connect.jdbc.dao.ToDoDao;
import kr.or.connect.jdbc.dto.ToDoDto;


@WebServlet({ "/MainServlet", "/main" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
        super();
    }


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToDoDao dao = new ToDoDao();
		ArrayList<ToDoDto> list = dao.getToDos();
		
		JSONArray ja = new JSONArray();
		for (ToDoDto d : list) {
			JSONObject jo = new JSONObject();
			jo.put("id",d.getId());
			jo.put("name",d.getName());
			String regDate = d.getRegDate().substring(0,10);
			jo.put("regDate",regDate);		
			jo.put("sequence",d.getSequence());
			jo.put("title",d.getTitle());
			jo.put("type",d.getType());
			ja.add(jo);
		}
		request.setAttribute("ja", ja);
		RequestDispatcher requestDispatehcer = request.getRequestDispatcher("/main.jsp");
        requestDispatehcer.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
