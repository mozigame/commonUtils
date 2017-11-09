package com.babel.common.lottery.status.errorlog;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodeEnum {
	PRIZE_DELAY(1, "未开奖"), PRIZE_BEFORE(2, "官方提前开奖"), NORMANAL(0, "无异常");

	ErrorCodeEnum(int status, String statusName) {
		this.status = status;
		this.statusName = statusName;
	}

	private int status;
	private String statusName;

	static Map<Integer, ErrorCodeEnum> enumMap = new HashMap<>();

	static {
		for (ErrorCodeEnum flowState : ErrorCodeEnum.values()) {
			enumMap.put(flowState.getStatus(), flowState);
		}
	}

	public static ErrorCodeEnum getState(int status) {
		return enumMap.get(status);
	}

	public static Map<Integer, ErrorCodeEnum> getErrorCodeMap() {
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
