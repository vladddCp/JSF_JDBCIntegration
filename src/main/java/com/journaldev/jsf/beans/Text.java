package com.journaldev.jsf.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "text")
public class Text implements Serializable{


	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Text [textID=" + textID + ", text=" + text + ", timestamp=" + timestamp + "]";
	}

	private Integer textID;
	private String text;
	private Date timestamp;

	public Integer getTextID() {
		return textID;
	}

	public void setTextID(Integer id) {
		this.textID = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Text(Integer textID, String text, Date timestamp) {
		super();
		this.textID = textID;
		this.text = text;
		this.timestamp = timestamp;
	}

	public Text() {
	}


}
