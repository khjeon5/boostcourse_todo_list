package kr.or.connect.jdbc;

import kr.or.connect.jdbc.dao.ToDoDao;

public class TestUpdateToDo {
	public static void main(String[] args) {		
		ToDoDao dao = new ToDoDao();
		Integer updatecount = dao.updateToDo("DOING", (long) 2);
		System.out.println(updatecount);
	}
}
