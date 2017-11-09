package com.babel.common.lottery.status.errorlog;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {

	
	HANDING(1, "处理中"), SUCCESS(2, "处理成功");
	
	
	StatusEnum(int status, String statusName) {
		this.status = status;
		this.statusName = statusName;
	}

	private int status;
	private String statusName;

	static Map<Integer, StatusEnum> enumMap = new HashMap<>();

	static {
		for (StatusEnum flowState : StatusEnum.values()) {
			enumMap.put(flowState.getStatus(), flowState);
		}
	}

	public static StatusEnum getState(int status) {
		return enumMap.get(status);
	}

	public static Map<Integer, StatusEnum> getStatusMap() {
		return enumMap;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
