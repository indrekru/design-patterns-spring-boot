package com.investly.service.factory;

import com.investly.model.BankInformation;
import com.investly.service.strategy.BankScraperStrategy;
import com.investly.service.strategy.SebScraper;
import com.investly.service.strategy.SwedbankScraper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 */
@Service
public class ScraperFactoryService {

	public List<BankScraperStrategy> createStrategies() {
		return new ArrayList<BankScraperStrategy>() {{
			add(new SebScraper());
			add(new SwedbankScraper());
		}};
	}

}
