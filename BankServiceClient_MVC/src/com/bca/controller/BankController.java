package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {

	@RequestMapping("/show.mvc")
	public String getFormPage() {
		return "bankForm";
	}
}
