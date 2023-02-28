package com.calculatorapplication.history;

public class History {

	private String expression;
	private double answer;

	public History(String expression,double answer) {
		super();
		this.expression = expression;
		this.answer = (double)answer;
	}

	public History(History history) {
		
		this.expression = history.expression;
		this.answer = history.answer;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public double getAnswer() {
		return answer;
	}

	public void setAnswer(double answer) {
		this.answer = answer;
	}

}
