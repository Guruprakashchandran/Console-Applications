package com.calculatorapplication.calculator;

import java.util.List;

import com.calculatorapplication.history.History;
import com.calculatorapplication.history.HistoryRepository;

public class CalculatorModel implements CalculatorControllerToModelCall{

	private CalculatorModelToControllerCall calculatorModelToControllerCall;
	public CalculatorModel(CalculatorController calculatorController) {
		
		calculatorModelToControllerCall = calculatorController;
	}
	@Override
	public void addDetails(List<String> list, String exp) {
		
		HistoryRepository.getInstance().addDetails(list, exp);
		calculatorModelToControllerCall.addSuccessfully();
	}
	@Override
	public void getDetails() {
		
		List<History> list = HistoryRepository.getInstance().getDetails();
		calculatorModelToControllerCall.showHistory(list);
	}

}
