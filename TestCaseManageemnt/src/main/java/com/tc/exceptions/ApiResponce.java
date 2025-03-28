package com.tc.exceptions;

public class ApiResponce {

	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isS() {
		return Status;
	}
	public void setS(boolean s) {
		this.Status = s;
	}
	String msg;
	boolean Status ;
	public ApiResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponce(String msg, boolean s) {
		super();
		this.msg = msg;
		this.Status = s;
	}
	
	
	
	
}
