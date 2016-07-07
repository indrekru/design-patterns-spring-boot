package com.investly.service.observer;

import com.investly.model.BankInformation;
import com.investly.service.observer.BankInformationPublisherService;
import com.investly.service.observer.BankInformationReceived;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 */
@Service
public class PrinterService implements BankInformationReceived {

	@Autowired
	private BankInformationPublisherService bankInformationPublisherService;

	@PostConstruct
	public void setup() {
		bankInformationPublisherService.subscribe(this);
	}


	@Override
	public void receivedBankInformation(List<BankInformation> data) {
		System.out.println("Printing: " + data);
	}
}
