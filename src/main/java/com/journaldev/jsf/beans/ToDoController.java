package com.journaldev.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.journaldev.jsf.beans.ToDo;

@ManagedBean(name = "todoController")
@SessionScoped
public class ToDoController implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;
	private ArrayList<ToDo> todos;

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
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("todolul", todo);
		
		return "updateTodo.xhtml";
	}
	
	@Override
	public String toString() {
		return todos.toString();
	}

	// Calendar View Controller
	// Calendar View

}
