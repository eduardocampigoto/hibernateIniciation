package br.com.hibernate.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
	
	
	public Date stringToDate(String dataStr){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
			Date data = sdf.parse(dataStr);
			return data;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public String dateToString(Date data){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
			String dataStr = sdf.format(data).toString();
			return dataStr;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String objectToString(Object dataObj){
		try {
			Date data = (Date) dataObj;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
			String dataStr = sdf.format(data).toString();
			return dataStr;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
