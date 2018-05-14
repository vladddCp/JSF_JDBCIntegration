package com.journaldev.jsf.beans;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.journaldev.jsf.dbConnection.DBConnection;
import com.journaldev.jsf.dbConnection.JToDoDatabaseStaticFields;

@ManagedBean(name = "todoDBUtil")
public class ToDoDatabaseUtilities implements JToDoDatabaseStaticFields {

	public static void addToDo(ToDo todo) {
		Connection con = null;
		Statement stmnt = null;

		try {
			con = DBConnection.getInstance().getConnection();
			String todoText = todo.getTodoText();
			Date todoTimestamp = todo.getTimestamp();
			String date = new SimpleDateFormat("yyyy-MM-dd").format(todoTimestamp);

			String addToDoSql = "INSERT INTO " + toDo_TableName + "(`" + toDo_TextColumn + "`, `" + toDO_Timestamp
					+ "`)" + " VALUES ('" + todoText + "','" + date + "');";
			stmnt = con.createStatement();
			stmnt.executeUpdate(addToDoSql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				stmnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void removeToDo(ToDo todo) {
		Connection con = null;
		Statement stmnt = null;
		try {
			con = DBConnection.getInstance().getConnection();
			Integer todoID = todo.getTodoID();
			String removeToDoSql = "DELETE FROM `stuff` WHERE `ID` = " + todoID.intValue();
			stmnt = con.createStatement();
			stmnt.executeUpdate(removeToDoSql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				stmnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void editToDoText(ToDo todo) {
		Connection con = null;
		Statement stmnt = null;
		try {
			con = DBConnection.getInstance().getConnection();
			Integer todoID = todo.getTodoID();
			String todoText = todo.getTodoText();
			Date todoTimestamp = todo.getTimestamp();
			String selectToDoSql = "UPDATE `stuff` SET `TEXT`= '" + todoText + "',`TIMESTAMP`= '" + todoTimestamp + "' "
					+ "WHERE ID = " + todoID;
			stmnt = con.createStatement();
			stmnt.executeUpdate(selectToDoSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				stmnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<ToDo> getAllToDos() {
		PreparedStatement pstmt = null;
		Connection connect = null;
		ResultSet rs = null;

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
				e.printStackTrace();
			}
		}
		return null;
	}
}