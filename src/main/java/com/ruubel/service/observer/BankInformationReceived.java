package com.ruubel.service.observer;

import com.ruubel.model.BankInformation;

import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 */
public interface BankInformationReceived {
	void receivedBankInformation(List<BankInformation> data);
}
