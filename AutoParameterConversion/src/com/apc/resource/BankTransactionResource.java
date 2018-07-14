package com.apc.resource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.resource.beans.UserInfo;

@Path("/bank")
public class BankTransactionResource {

	@Path("/balance/{accNo}/{name}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getBalance(@PathParam("accNo") String accountNo,
			@PathParam("name") String userName) {
		if (accountNo.equals("acc1") && userName.equals("user1")) {
			return 1000;
		}
		return 0.0;
	}

	/*
	 * Array Is Not Supported In Jersey Implementation:-??????
	 * ======================================================
	 * 
	 * @Path("/ministatement")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String
	 * getMinistatement(@QueryParam("info") int[] info) { return "Info:1 -" +
	 * info[0] + " Info:2 -" + info[1] + " Info:3 -" + info[2]; }
	 */

	@Path("/account")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAccountInfo(@QueryParam("user") List<String> info) {
		StringBuffer sb = null;
		sb = new StringBuffer();
		int count = 0;
		for (String getInfo : info) {
			count++;
			sb.append("\nInfo: " + count + "-").append(getInfo);
		}
		return sb.toString();
	}

	@GET
	@Path("/register")
	@Produces(MediaType.TEXT_PLAIN)
	public String registerUser(@QueryParam("userInfo") UserInfo userInfo) {
		StringBuffer sb = null;
		int count = 0;
		sb = new StringBuffer();
		Map<String, UserInfo> users = new ConcurrentHashMap<>();
		users.put("User:" + count, userInfo);
		sb.append(users);
		return sb.toString();

	}

}
