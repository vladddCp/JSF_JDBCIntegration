package com.journaldev.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.journaldev.jsf.beans.ToDo;

@ManagedBean(name = "todoController")

public class ToDoController implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;
	private ArrayList<ToDo> todos;
	private ToDo todo;
	
	public ArrayList<ToDo> getTodos() {
		return ToDoDatabaseUtilities.getAllToDos();
	}

	public void setTodos(ArrayList<ToDo> texts) {
		this.todos = texts;
	}

	public void addToDo(ToDo todo) {
		ToDoDatabaseUtilities.addToDo(todo);
	}

	public String loadToDo(int toDoID) {
		
		ToDo todo = ToDoDatabaseUtilities.getToDo(toDoID);
		
		// put in the attribute in order to be used from the page
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
		
		requestMap.put("todo" , todo);
		
		return "updateTodo.xhtml";
	}
	
	public String updateToDo(ToDo todo) {
		ToDoDatabaseUtilities.editToDoText(todo);
		return "todoList.xhtml";
	}
	
	@Override
	public String toString() {
		return todos.toString();
	}

	public ToDo getTodo() {
		return todo;
	}

	public void setTodo(ToDo todo) {
		this.todo = todo;
	}

	// Calendar View Controller
	// Calendar View

}
