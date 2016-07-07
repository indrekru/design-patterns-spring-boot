package com.investly.service.observer;

import com.investly.model.BankInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 */
@Service
public class SaverService implements BankInformationReceived {

	@Autowired
	private BankInformationPublisherService bankInformationPublisherService;

	@PostConstruct
	public void setup() {
		bankInformationPublisherService.subscribe(this);
	}

	@Override
	public void receivedBankInformation(List<BankInformation> data) {
		System.out.println("Saving: " + data);
	}
}
