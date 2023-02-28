package com.calculatorapplication.calculator;

import java.util.List;

import com.calculatorapplication.history.History;

public class CalculatorController implements CalculatorViewToControllerCall,CalculatorModelToControllerCall{

	private CalculatorControllerToViewCall calculatorControllerToViewCall;
	private CalculatorControllerToModelCall calculatorControllerToModelCall;
	public CalculatorController(CalculatorView calculatorView) {
		
		calculatorControllerToViewCall = calculatorView;
		calculatorControllerToModelCall = new CalculatorModel(this);
	}
	@Override
	public void addDetails(List<String> list, String exp) {
		
		calculatorControllerToModelCall.addDetails(list,exp);
	}
	@Override
	public void addSuccessfully() {
		
		calculatorControllerToViewCall.addSuccessfully();
	}
	@Override
	public void getDetails() {
		
		calculatorControllerToModelCall.getDetails();
	}
	@Override
	public void showHistory(List<History> list) {
		
		calculatorControllerToViewCall.showDetails(list);
	}
}
