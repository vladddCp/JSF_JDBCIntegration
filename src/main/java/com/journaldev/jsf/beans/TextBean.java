package com.journaldev.jsf.beans;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.journaldev.jsf.beans.Text;
import com.journaldev.jsf.dbConnection.DBConnection;

@ManagedBean(name = "textBean")
@SessionScoped
public class TextBean implements Serializable    {
	
	
	private static final long serialVersionUID = 6081417964063918994L;
	private PreparedStatement pstmt = null;
	private Connection connect = null;
	private ResultSet rs = null; 
	private  ArrayList<Text> texts = getAllTexts();
	
	public ArrayList<Text> getAllTexts() {
		try {

			connect = DBConnection.getInstance().getConnection();

			pstmt = connect.prepareStatement("SELECT * from STUFF");
			rs = pstmt.executeQuery();
			ArrayList<Text> textest = new ArrayList<>();
			while (rs.next()) {
				int indx = 1;
				Text text = new Text();
				text.setTextID(rs.getInt(indx++));
				text.setText(rs.getString(indx++));
				text.setTimestamp(rs.getDate(indx++));
				textest.add(text);
			}
			return textest;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Text> getTexts(){
		return texts;
	}
	public void setTexts(ArrayList<Text> texts) {
		this.texts = texts;
	}
 
	@Override
	public String toString() {
		return texts.toString();
	}
}
