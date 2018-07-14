package com.srl.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/transaction")
public class BankResource {

	/*
	 * Here This Class Is My Locator class which helps to identify/locate my
	 * SubResource by helps pathParm if request comes with
	 * http://localhost:4040/rootContext/rest/transaction/sbi then it forward to
	 * my subClass ,it will identifyBasedOn @Path("/sbi") and go to
	 * getSBIResourceLocator() method and instantiate
	 * StateBankOfIndiaSubResource class and call the method
	 * ========================================================================
	 * http://localhost:4040/rootContext/rest/transaction/axis then it forward
	 * to my subClass ,it will identifyBasedOn @Path("/axis") and go to
	 * getAXISResourceLocator() method and instantiate AxisBankSubResource class
	 * and call the method
	 */

	/*
	 * APPROACH:1(hERE WE NEED TO TAKE 2 LOCATOR METHOD WHICH WE CAN OPTIMISE AS
	 * PER BELOW) =============
	 * 
	 * @Path("/sbi") 
	 * public StateBankOfIndiaSubResource getSBIResourceLocator(){
	 * return new StateBankOfIndiaSubResource(); 
	 * }
	 * 
	 * @Path("/axis") 
	 * public AxisBankSubResource getAXISResourceLocator() {
	 * return new AxisBankSubResource();
	 *  }
	 */

	@Path("/{recourceType}")
	public Object getSubResourceLocator(
			@PathParam("recourceType") String resourceType) {
		if (resourceType.equalsIgnoreCase("sbi")) {
			return new StateBankOfIndiaSubResource();
		} else if (resourceType.equalsIgnoreCase("axis")) {
			return new AxisBankSubResource();
		} else {
			return null;
		}
	}

}
