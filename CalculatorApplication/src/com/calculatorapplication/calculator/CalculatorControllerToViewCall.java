package com.calculatorapplication.calculator;

import java.util.List;

import com.calculatorapplication.history.History;

public interface CalculatorControllerToViewCall {

	void addSuccessfully();

	void showDetails(List<History> list);

}
