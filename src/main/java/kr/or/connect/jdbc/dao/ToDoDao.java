package kr.or.connect.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.connect.jdbc.dto.ToDoDto;

public class ToDoDao{

	private String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private String dbuser = "connectuser";
	private String dbpasswd = "connect123!@#";

//=================================addToDo method===============================================
	public Integer addToDo(String title, String name, int sequence) {
		Integer insertcount = null;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "INSERT INTO todo(title,name,sequence) VALUES(?,?,?)";

		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setInt(3, sequence);
			insertcount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertcount;
	}// addToDo

//=================================getToDos method===============================================
	public ArrayList<ToDoDto> getToDos() {
		ArrayList<ToDoDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT id,title,name,sequence,type,regdate FROM todo ORDER BY regdate desc";
		
		try {
			conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			try {
				while (rs.next()) {
					ToDoDto todo = new ToDoDto();
					todo.setId(rs.getLong(1));
					todo.setTitle(rs.getString(2));
					todo.setName(rs.getString(3));
					todo.setSequence(rs.getInt(4));
					todo.setType(rs.getString(5));
					todo.setRegDate(rs.getString(6));
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}// getToDos

//=================================updateToDo method===============================================
	public Integer updateToDo(String type, Long id) {
		Integer updatecount = null;
		Connection conn=null;
		PreparedStatement ps =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE todo SET type=? WHERE id=?";
		try {
			conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setLong(2, id);
			updatecount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updatecount;
	}
}// ToDoDao
