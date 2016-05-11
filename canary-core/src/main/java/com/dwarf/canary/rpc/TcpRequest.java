package com.dwarf.canary.rpc;

/**
 * 请求ID、接口名称、方法名、方法参数、超时时间
 * @author jiyu
 *
 */
public class TcpRequest {
	
	private long requestID;
	private String interfaceName;
	private String methodName;
	private Object[] parameters;
	
	public long getRequestID() {
		return requestID;
	}
	public void setRequestID(long requestID) {
		this.requestID = requestID;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getParameters() {
		return parameters;
	}
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
	
	
	
}
