package com.tc.exceptions;

public class ResNotFoundExc extends  RuntimeException {

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ResNotFoundExc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	String msg;
	int id;
	

	public ResNotFoundExc(String msg,int i) {
		super(String.format("%s  : %s ",msg, i ));

		this.msg = msg;
		this.id=i;
	}
	
	
	
	
	
	
}
