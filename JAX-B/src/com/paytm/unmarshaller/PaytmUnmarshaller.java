package com.paytm.unmarshaller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.paytm.service.online.PaytmType;

public class PaytmUnmarshaller {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext
				.newInstance("com.paytm.service.online");
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<PaytmType> jaxbElement = (JAXBElement<PaytmType>) unmarshaller
				.unmarshal(new File("E:\\RestWS\\JAX-B\\resourse\\paytm.xml"));
		PaytmType paytmType = jaxbElement.getValue();

		System.out.println("USERNAME: " + paytmType.getUser().getUserName());
		System.out.println("PASSWORD: " + paytmType.getUser().getPassword());

	}

}
