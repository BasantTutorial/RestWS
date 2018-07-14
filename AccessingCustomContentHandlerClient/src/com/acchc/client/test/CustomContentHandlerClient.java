package com.acchc.client.test;

import com.acchc.dto.Profile;
import com.acchc.dto.RegisterInfo;
import com.acchc.invoker.MatrimonyResourceInvoker;

public class CustomContentHandlerClient {
	public static void main(String[] args) {
		MatrimonyResourceInvoker invoker = new MatrimonyResourceInvoker();
		RegisterInfo info = new RegisterInfo();
		
		info.setName("Basanta Kumar Hota");
		info.setAge(23);
		info.setGender("Male");
		info.setReligion("Hindu,Bramhin");
		Profile profile = invoker.register(info);
		
		System.out.println("PesonId: " + profile.getId());
		System.out.println("Name: " + profile.getName());
		System.out.println("MemberType: " + profile.getMemberType());
		System.out.println("Visits: " + profile.getVisits());
	}
}
