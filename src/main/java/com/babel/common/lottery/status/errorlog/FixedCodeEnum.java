package com.babel.common.lottery.status.errorlog;

import java.util.HashMap;
import java.util.Map;

public enum FixedCodeEnum {

	
     PRIZE_TIME_UPDATE(1, "录入官方实际开奖时间"), PRIZE_ISSUE_INVILIDATE(2, "号码验证失败需补录"),
     ORDER_CANCEL(3, "撤销本期方案"), RESERVE_CANCEL(4, "撤销后期追号"),
     PRIZE_HOLD(5, "暂缓派奖"), PRIZE_CONTINUE(6, "继续派奖"),
     PRIZE_ISSUE_RESET(7, "重新录入开奖号码")
     
     ;
	
	
	FixedCodeEnum(int status, String statusName) {
		this.status = status;
		this.statusName = statusName;
	}

	private int status;
	private String statusName;

	static Map<Integer, FixedCodeEnum> enumMap = new HashMap<>();

	static {
		for (FixedCodeEnum flowState : FixedCodeEnum.values()) {
			enumMap.put(flowState.getStatus(), flowState);
		}
	}

	public static FixedCodeEnum getState(int status) {
		return enumMap.get(status);
	}

	public static Map<Integer, FixedCodeEnum> getStatusMap() {
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
