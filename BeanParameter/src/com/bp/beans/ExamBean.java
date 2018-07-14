package com.bp.beans;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class ExamBean {
	@PathParam("regId")
	private long registrationId;
	@QueryParam("collegeName")
	private String collegeName;
	@DefaultValue("BPUT")
	@QueryParam("universityName")
	private String universityName;
	@PathParam("semNo")
	private int semistarNo;
	@QueryParam("branch")
	private String branchName;
	@MatrixParam("rollNo")
	private int rollNo;

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public int getSemistarNo() {
		return semistarNo;
	}

	public void setSemistarNo(int semistarNo) {
		this.semistarNo = semistarNo;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

}
