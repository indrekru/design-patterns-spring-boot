package com.investly.service;

import com.investly.model.BankInformation;
import com.investly.service.factory.ScraperFactoryService;
import com.investly.service.observer.BankInformationPublisherService;
import com.investly.service.strategy.BankScraperStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
@Service
public class BankService {

	@Autowired
	private BankInformationPublisherService bankInformationPublisherService;

	@Autowired
	private ScraperFactoryService scraperFactoryService;

	private List<BankScraperStrategy> strategies;

	@PostConstruct
	public void setup() {
		strategies = scraperFactoryService.createStrategies();
	}

	public List<BankInformation> getContacts() {
		List<BankInformation> bankInformations = new ArrayList<BankInformation>();
		for (BankScraperStrategy strategy : strategies) {
			BankInformation bank = strategy.scrape();
			bankInformations.add(bank);
		}
		bankInformationPublisherService.publish(bankInformations);
		return bankInformations;
	}

}
