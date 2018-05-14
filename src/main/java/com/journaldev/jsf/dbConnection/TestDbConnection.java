package com.journaldev.jsf.dbConnection;

import java.sql.SQLException;

import java.util.ArrayList;

import com.journaldev.jsf.beans.Text;
import com.journaldev.jsf.beans.TextBean;

public class TestDbConnection {
	public static void main(String[] args) {

		ArrayList<Text> texts = new TextBean().getTexts();
		for (Text t : texts) {
			System.out.println(t.toString());

		}
	}
}
