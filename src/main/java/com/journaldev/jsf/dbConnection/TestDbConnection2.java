package com.journaldev.jsf.dbConnection;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.journaldev.jsf.beans.ToDo;
import com.journaldev.jsf.beans.ToDoController;
import com.journaldev.jsf.beans.ToDoDatabaseUtilities;

public class TestDbConnection2 {
	
	
	public static void main(String[] args) {
		ToDoController td = new ToDoController();
		Integer id = new Integer(10);
		ToDo todo = new ToDo( id ,"testDbConnWOWOWOW", Date.valueOf(LocalDate.now()));
		
		td.updateToDo(todo);	
		
		ArrayList<ToDo> toDos = new ToDoController().getTodos();
		for (ToDo t :  toDos) {
			System.out.println(t.toString());}
		
	}
}
