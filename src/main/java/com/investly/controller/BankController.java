package com.investly.controller;

import com.investly.model.BankInformation;
import com.investly.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
@Controller
public class BankController {

	@Autowired
	private BankService bankService;

	@RequestMapping("/")
	@ResponseBody
	private String home() {
		List<BankInformation> contacts = bankService.getContacts();
		return contacts.toString();
	}

}
