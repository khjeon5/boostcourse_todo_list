package kr.or.connect.jdbc;

import kr.or.connect.jdbc.dao.ToDoDao;

public class TestAddToDo {
	public static void main(String[] args) {
		ToDoDao dao = new ToDoDao();
		Integer insertcount= dao.addToDo("spring", "Grey", 2);
		System.out.println(insertcount);
	}
}
