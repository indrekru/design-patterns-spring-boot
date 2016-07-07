package com.investly.service.strategy;

import com.investly.model.BankInformation;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
public interface BankScraperStrategy {
	BankInformation scrape();
}
