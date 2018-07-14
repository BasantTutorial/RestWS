package com.bp.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bp.beans.ExamBean;

@Path("/exam")
public class ExamInfo {

	/*
	 * Request:
	 * http://localhost:4040/BeanParameter/rest/exam/search/1001215067/8
	 * ?collegeName=East&branch=ElectricalEngineearing;rollNo=8
	 * 
	 * Response:-REGISTRATION_ID: 1001215067 COLLEGE_NAME: East UNIVERSITY_NAME:
	 * BPUT SEMISTER: 8 BRANCH: ElectricalEngineearing; ROLLNO: 8
	 */

	/*
	 * Here Instead Of Writing All The Parameter In Method Level Its prefer to
	 * gather them one bean and the bean instantiation takes place by runtime
	 * itself Which Make Our Code clean and flexibility.. This Feature Added in
	 * JAX-RS 2.0 In JAX-RS 1.0 This Feature is not there
	 */

	@Path("/search/{regId}/{semNo}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getReasult(@BeanParam ExamBean exam) {

		return "REGISTRATION_ID: " + exam.getRegistrationId()
				+ " COLLEGE_NAME: " + exam.getCollegeName()
				+ " UNIVERSITY_NAME: " + exam.getUniversityName()
				+ " SEMISTER: " + exam.getSemistarNo() + " BRANCH: "
				+ exam.getBranchName() + " ROLLNO: " + exam.getRollNo();
	}
}
