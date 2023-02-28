package com.calculatorapplication.calculator;

import java.util.List;

import com.calculatorapplication.history.History;

public interface CalculatorModelToControllerCall {

	void addSuccessfully();

	void showHistory(List<History> list);
}
