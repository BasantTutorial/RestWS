package com.paytm.marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.paytm.service.online.FeedBackType;
import com.paytm.service.online.PaytmType;
import com.paytm.service.online.RechargeType;
import com.paytm.service.online.UserType;

public class PaytmMarshaller {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Throwable {
		JAXBContext jContext = JAXBContext
				.newInstance("com.paytm.service.online");
		Marshaller marshaller = jContext.createMarshaller();

		RechargeType rType = new RechargeType();
		rType.setPlaneName("Full-Talk");
		rType.setPaymentType("OnLine");
		rType.setAmount(1001);

		FeedBackType feedBackType = new FeedBackType();
		feedBackType.setAmount(1001);
		feedBackType.setUserName("Basanta");
		feedBackType.setPassword("Dugu");
		feedBackType.setStatus("Active");

		UserType userType = new UserType();
		userType.setFeedBack(feedBackType);
		userType.setUserName(feedBackType.getUserName());
		userType.setPassword(feedBackType.getPassword());

		PaytmType paytmType = new PaytmType();
		paytmType.setRecharge(rType);
		paytmType.setUser(userType);

		marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(paytmType, System.out);

	}

}
