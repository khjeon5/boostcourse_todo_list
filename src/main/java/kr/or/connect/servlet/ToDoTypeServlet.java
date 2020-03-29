package kr.or.connect.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbc.dao.ToDoDao;


@WebServlet({ "/ToDoTypeServlet", "/todotype" })
public class ToDoTypeServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       

    public ToDoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("todo type exec");
		Long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		System.out.println(id +" "+ type);
		
		ToDoDao dao = new ToDoDao();
		if (type.equals("TODO")) {
			type="DOING";
			int updatecount = dao.updateToDo(type, id);
			System.out.println(updatecount);
			
		}else if(type.equals("DOING")) {
			type="DONE";
			int updatecount = dao.updateToDo(type, id);
			System.out.println(updatecount);
		}
	}

}
