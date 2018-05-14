package com.journaldev.jsf.beans;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.journaldev.jsf.beans.ToDo;
import com.journaldev.jsf.dbConnection.DBConnection;

@ManagedBean(name = "todoController")
@SessionScoped
public class ToDoController implements Serializable    {
	
	
	private static final long serialVersionUID = 6081417964063918994L;
	private PreparedStatement pstmt = null;
	private Connection connect = null;
	private ResultSet rs = null; 
	
	
	private  ArrayList<ToDo> todos = getAllToDos();
	
	public ArrayList<ToDo> getAllToDos() {
		
		try {

			connect = DBConnection.getInstance().getConnection();

			pstmt = connect.prepareStatement("SELECT * from STUFF");
			rs = pstmt.executeQuery();
			ArrayList<ToDo> todoList = new ArrayList<>();
			while (rs.next()) {
				int indx = 1;
				ToDo todo = new ToDo();
				todo.setTodoID(rs.getInt(indx++));
				todo.setTodoText(rs.getString(indx++));
				todo.setTimestamp(rs.getDate(indx++));
				todoList.add(todo);
			}
			return todoList;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<ToDo> getTodos(){
		return todos;
	}
	public void setTodos(ArrayList<ToDo> texts) {
		this.todos = texts;
	}
 
	@Override
	public String toString() {
		return todos.toString();
	}
}
