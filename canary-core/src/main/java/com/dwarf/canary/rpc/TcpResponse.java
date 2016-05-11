package com.dwarf.canary.rpc;

public class TcpResponse {
	
	private Object result;
	private long requestID;
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public long getRequestID() {
		return requestID;
	}
	public void setRequestID(long requestID) {
		this.requestID = requestID;
	}
	
	
	
}
