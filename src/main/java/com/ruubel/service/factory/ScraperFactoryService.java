package com.ruubel.service.factory;

import com.ruubel.service.strategy.BankScraperStrategy;
import com.ruubel.service.strategy.SebScraper;
import com.ruubel.service.strategy.SwedbankScraper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 *
 * Factory pattern:
 * - creates objects without exposing the instantiation logic to the client.
 * - refers to the newly created object through a common interface
 * https://www.oodesign.com/factory-pattern.html
 */
@Service
public class ScraperFactoryService {

	private List<BankScraperStrategy> strategies;

	public ScraperFactoryService() {
		strategies = createStrategies();
	}

	/**
	 * Internally creates objects, does not expose instantiation logic to the client.
	 */
	private List<BankScraperStrategy> createStrategies() {
		return new ArrayList<BankScraperStrategy>() {{
			add(new SebScraper());
			add(new SwedbankScraper());
		}};
	}

	/**
	 * Refers to the newly created object through a common interface
	 */
	public List<BankScraperStrategy> getStrategies() {
		return strategies;
	}

}
