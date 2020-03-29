package kr.or.connect.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbc.dao.ToDoDao;


@WebServlet("/ToDoAddServlet")
public class ToDoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ToDoAddServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		ToDoDao dao = new ToDoDao();
		int insertcount = dao.addToDo(title, name, sequence);
		System.out.println(insertcount);
		
		response.sendRedirect("main");
		
	}

}
