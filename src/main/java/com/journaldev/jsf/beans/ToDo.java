package com.journaldev.jsf.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "todo")
public class ToDo implements Serializable{


	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Text [textID=" + todoID + ", text=" + todoText + ", timestamp=" + timestamp + "]";
	}

	private Integer todoID;
	private String todoText;
	private Date timestamp;

	public Integer getTodoID() {
		return todoID;
	}

	public void setTodoID(Integer id) {
		this.todoID = id;
	}

	public String getTodoText() {
		return todoText;
	}

	public void setTodoText(String text) {
		this.todoText = text;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public ToDo(Integer todoID, String todoText, Date timestamp) {
		super();
		this.todoID = null;
		this.todoText = todoText;
		this.timestamp = timestamp;
	}

	public ToDo(String todoText, Date timestamp) {
		super();
		this.todoID = null;
		this.todoText = todoText;
		this.timestamp = timestamp;
	}
	public ToDo() {
	}


}
