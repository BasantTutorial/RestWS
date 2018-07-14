package com.resource.beans;

public class UserInfo {

	private String accNo;

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public UserInfo(String info) {
		this.accNo = info;
	}

	/*approach:2
	 * public String valueOf(UserInfo userInfo) {
	 * 
	 * return String.valueOf(accNo); }
	 */

	@Override
	public String toString() {
		return "accNo: " + accNo + "";
	}

}
