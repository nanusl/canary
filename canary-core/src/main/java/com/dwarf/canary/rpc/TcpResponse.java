package com.dwarf.canary.rpc;

public class TcpResponse {
	
	private Object result;
	private String requestID;
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	
	
	
}
