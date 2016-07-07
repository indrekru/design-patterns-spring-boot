package com.investly.service.strategy;

import com.investly.model.Bank;
import com.investly.model.BankInformation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
public class SwedbankScraper implements BankScraperStrategy {

	private String bankUrl = "https://www.swedbank.ee/private/home/more/channels?language=EST";

	@Override
	public BankInformation scrape() {
		Document doc = null;
		try {
			doc = Jsoup.connect(bankUrl).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements footers = doc.select("#legacy-footer");
		Elements lefts = footers.get(0).select(".left");
		String number = lefts.get(0).text();

		return new BankInformation(Bank.SWEDBANK, number);
	}
}
