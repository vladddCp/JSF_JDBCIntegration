package com.journaldev.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

	@Override
	public String toString() {
		return todos.toString();
	}

	// Calendar View Controller
	// Calendar View

}
