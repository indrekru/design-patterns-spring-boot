package com.ruubel.service.strategy;

import com.ruubel.model.Bank;
import com.ruubel.model.BankInformation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
public class SwedbankScraper implements BankScraperStrategy {

	private String bankUrl = "https://www.swedbank.ee/private/home/more/channels?language=EST";

	@Override
	public BankInformation scrape() {
		String number = "FAILED";
		try {
			Document doc = Jsoup.connect(bankUrl).get();

			Elements footers = doc.select("section.footer-section");
			Element tel = footers.get(0).select("div.tel").get(0);
			number = tel.text();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new BankInformation(Bank.SWEDBANK, number);
	}
}
