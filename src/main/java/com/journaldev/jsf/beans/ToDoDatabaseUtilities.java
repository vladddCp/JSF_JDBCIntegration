package com.journaldev.jsf.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.journaldev.jsf.dbConnection.DBConnection;
import com.journaldev.jsf.dbConnection.JToDoDatabaseStaticFields;

public class ToDoDatabaseUtilities implements JToDoDatabaseStaticFields {

	public static void addToDo(ToDo todo) {
		Connection con = null;
		Statement stmnt = null;

		try {
			con = DBConnection.getInstance().getConnection();
			String todoText = todo.getTodoText();
			Date todoTimestamp = todo.getTimestamp();

			String addToDoSql = "INSERT INTO " + toDo_TableName + "(`" + toDo_TextColumn + "`, `" + toDO_Timestamp
					+ "`)" + " VALUES ('" + todoText + "','" + todoTimestamp + "');";
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
			String todoText = todo.getTodoText();
			Date todoTimestamp = todo.getTimestamp();
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
				String selectToDoSql = "UPDATE `stuff` SET `TEXT`= '"+ todoText+"',`TIMESTAMP`= '"+todoTimestamp+"' "
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
}