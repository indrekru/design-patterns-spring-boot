package com.ruubel.service.observer;

import com.ruubel.model.BankInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 *
 * Observer pattern:
 * Defines a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically.
 * https://www.oodesign.com/observer-pattern.html
 */
@Service
public class BankInformationPublisherService {

	private List<BankInformationReceived> subscribers;

	public BankInformationPublisherService() {
		subscribers = new ArrayList<>();
	}

	/**
	 * Services can "sign up" here to receive updates
	 * @param subscriber
	 */
	public void subscribe(BankInformationReceived subscriber) {
		subscribers.add(subscriber);
	}

	/**
	 * Service can "opt-out" from receiving these updates
	 * @param subscriber
	 */
	public void unsubscribe(BankInformationReceived subscriber) {
		subscribers.remove(subscriber);
	}

	/**
	 * This is called when desired event happens, all subscribers will be informed
	 */
	public void publish(List<BankInformation> data) {
		for (BankInformationReceived subscriber : subscribers) {
			subscriber.receivedBankInformation(data);
		}
	}

}
