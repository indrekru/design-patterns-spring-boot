package com.investly.service.observer;

import com.investly.model.BankInformation;

import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 */
public interface BankInformationReceived {
	void receivedBankInformation(List<BankInformation> data);
}
