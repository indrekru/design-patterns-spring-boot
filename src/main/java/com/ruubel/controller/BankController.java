package com.ruubel.controller;

import com.ruubel.model.BankInformation;
import com.ruubel.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

	private BankService bankService;

	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	@GetMapping
	private ResponseEntity banks() {
		List<BankInformation> contacts = bankService.getContacts();
		return new ResponseEntity(contacts, HttpStatus.OK);
	}

}
