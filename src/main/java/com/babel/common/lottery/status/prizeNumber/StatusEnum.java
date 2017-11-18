package com.babel.common.lottery.status.prizeNumber;

import java.util.HashMap;
import java.util.Map;

import com.babel.common.lottery.status.errorlog.ErrorCodeEnum;

public enum StatusEnum {

	
PRIZE_DELAY(1, "未开奖"), PRIZE_BEFORE(2, "官方提前开奖"), NORMANAL(0, "无异常"),CANCEL(3, "已撤单");

	
	/*
	 0 未开奖
	 1 未开奖
	 2 提前开奖
	 3 已撤单
	 */
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
