package com.ruubel.service.observer;

import com.ruubel.model.BankInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 */
@Service
public class BankInformationPublisherService {

	private List<BankInformationReceived> subscribers = new ArrayList<BankInformationReceived>();

	public void subscribe(BankInformationReceived subscriber) {
		subscribers.add(subscriber);
	}

	public void unsubscribe(BankInformationReceived subscriber) {
		subscribers.remove(subscriber);
	}

	public void publish(List<BankInformation> data) {
		for (BankInformationReceived subscriber : subscribers) {
			subscriber.receivedBankInformation(data);
		}
	}

}
