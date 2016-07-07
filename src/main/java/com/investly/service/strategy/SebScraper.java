package com.investly.service.strategy;

import com.investly.model.Bank;
import com.investly.model.BankInformation;
import com.investly.service.strategy.BankScraperStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
public class SebScraper implements BankScraperStrategy {

	private String bankUrl = "http://www.seb.ee/eng/contact/contact";

	@Override
	public BankInformation scrape() {

		Document doc = null;
		try {
			doc = Jsoup.connect(bankUrl).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements content = doc.select(".field-type-text-with-summary");
		Elements tables = content.get(0).select("table");
		Elements tds = tables.get(0).select("td");
		Element number = tds.get(3);

		return new BankInformation(Bank.SEB, number.text());
	}
}
