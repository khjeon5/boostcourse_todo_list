package kr.or.connect.jdbc;

import java.util.ArrayList;

import kr.or.connect.jdbc.dao.ToDoDao;
import kr.or.connect.jdbc.dto.ToDoDto;

public class TestGetTodos {
	public static void main(String[] args) {
		ToDoDao dao = new ToDoDao();
		ArrayList<ToDoDto> list = dao.getToDos();
		for(ToDoDto data:list) {
			System.out.println(data);
		}
	}
}
