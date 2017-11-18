package com.babel.common.lottery.status.errorlog;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodeEnum {
	PRIZE_DELAY(1, "未开奖"), PRIZE_BEFORE(2, "官方提前开奖"), NORMANAL(0, "无异常"),CANCEL(3, "无异常"),NOT_THE_SAME(4,"结果不一致");

	
	/*
	0 未开奖
	 1 已开奖
	 2 提前开奖
	 3 已撤单
	 */
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
