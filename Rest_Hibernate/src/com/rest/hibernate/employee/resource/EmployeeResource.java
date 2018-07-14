package com.rest.hibernate.employee.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.hibernate.employee.bean.EmployeeBean;
import com.rest.hibernate.employee.bo.EmployeeBO;
import com.rest.hibernate.employee.service.EmployeeService;

@Path("/employee")
public class EmployeeResource {
	@Path("/save")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response saveEmployee(@BeanParam EmployeeBean employeeBean) {
		EmployeeBean bean = new EmployeeBean();
		String records = new EmployeeService().save(new EmployeeBO(bean
				.getEmpId(), bean.getName(), bean.getDept(), bean.getSalary()));
		return Response.ok().entity(records).build();
	}
}
