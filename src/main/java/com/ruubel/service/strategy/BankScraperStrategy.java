package com.ruubel.service.strategy;

import com.ruubel.model.BankInformation;

/**
 * Created by indrek.ruubel on 02/07/2016.
 *
 * Strategy pattern:
 * Define a family of algorithms, encapsulate each one, and make them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 * https://www.oodesign.com/strategy-pattern.html
 */
public interface BankScraperStrategy {
	BankInformation scrape();
}
