package comcch.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import comcch.dto.Recipt;
import comcch.dto.Subscriber;

@Path("/paytm")
public class PaytmResource {
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/recharge")
	public Recipt recharge(Subscriber subscriber) {

		Recipt recipt = null;
		recipt = new Recipt();

		recipt.setMobileNo(subscriber.getMobileNo());
		recipt.setPlaneName(subscriber.getPlanName());
		recipt.setAmount(subscriber.getAmount());
		recipt.setStatus("SUCCESS");

		return recipt;
	}
}
