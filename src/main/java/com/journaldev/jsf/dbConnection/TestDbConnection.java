package com.journaldev.jsf.dbConnection;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.journaldev.jsf.beans.ToDo;
import com.journaldev.jsf.beans.ToDoController;
import com.journaldev.jsf.beans.ToDoDatabaseUtilities;

public class TestDbConnection {
	public static void main(String[] args) {
		
		System.out.println("MERGE :" + ToDoDatabaseUtilities.getToDo(5));
		
		// INSERT
		ToDo todo = new ToDo( null,"testDbConn", Date.valueOf(LocalDate.now()));
		ToDoController td = new ToDoController();
		td.addToDo(todo);
						
		//VIEW
		ArrayList<ToDo> toDos = new ToDoController().getTodos();
		for (ToDo t :  toDos) {
			System.out.println(t.toString());
			if("testDbConn".equals(t.getTodoText())) {
				ToDoDatabaseUtilities.removeToDo(t);
			}
			if(t.getTodoID().equals(Integer.parseInt("6"))){
			t.setTodoText("updated.");
			ToDoDatabaseUtilities.editToDoText(t);
		}
		}
		
		
	}
}
