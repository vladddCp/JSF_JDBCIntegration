package com.journaldev.jsf.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "todo") 
public class ToDo implements Serializable {

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

	public ToDo() {
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

	public void click() {
		PrimeFaces.current().ajax().update("form:display");
		PrimeFaces.current().executeScript("PF('dlg').show()");
	}
}
