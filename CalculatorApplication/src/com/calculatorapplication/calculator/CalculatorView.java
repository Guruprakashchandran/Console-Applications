package com.calculatorapplication.calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.calculatorapplication.history.History;

public class CalculatorView implements CalculatorControllerToViewCall {

	private Scanner scan = new Scanner(System.in);
	private CalculatorViewToControllerCall calculatorViewToControllerCall;

	public CalculatorView() {

		calculatorViewToControllerCall = new CalculatorController(this);
	}

	public static void main(String[] args) {

		new CalculatorView().mainPage();
	}

	private void mainPage() {

		System.out.println("*****************CALCULATOR*********************");
		boolean isIterate = true;
		while (isIterate) {
			
			System.out.println("\n1) show History\n2) Calculation\n3) Exit");
			System.out.print("\nEnter Input : ");
			int input = scan.nextInt();
			switch (input) {

			case 1:
				calculatorViewToControllerCall.getDetails();
				break;
			case 2:
				getExpression();
				break;
			case 3:
				System.out.println("Exitted!!!");
				isIterate = false;
				break;
			default:
				System.out.println("Wrong Input!!!");
			}
		}
	}

	private void getExpression() {

		List<String> list = new LinkedList<>();
		getInput(list);
	}

	private void getInput(List<String> list) {

		try {
			String s = "";
			if (list.size() > 0) {

				for (int i = 0; i < list.size(); ++i) {
					s += list.get(i);
				}
				System.out.println("Expression : " + s);
			}
			System.out.print("\nEnter Number : ");
			String num = scan.next();
			list.add(Integer.toString(Integer.parseInt(num)));
			s += num;
			System.out.println("\nIf You Want Exit Press 2 ");
			System.out.println("else Press Other Numbers");
			String input = scan.next();
			if (input.equals("2")) {

				solution(list, s);
			} else {

				getOperator(list);
			}

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("\nWrong Input!!!");
			System.out.println("Re Enter the Input!!!");
			getInput(list);
		}
//		finally {}
	}

	private void solution(List<String> list, String exp) {

		for (int i = 0; i < list.size(); ++i) {

			if (list.get(i).equals("*")) {

				double value = Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1));
				list.set(i, Double.toString(value));
				list.remove(i + 1);
				list.remove(--i);
			} else if (list.get(i).equals("/")) {

				double value = Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1));
				list.set(i, Double.toString(value));
				list.remove(i + 1);
				list.remove(--i);
			}
		}
		for (int i = 0; i < list.size(); ++i) {

			if (list.get(i).equals("+")) {

				double value = Double.parseDouble(list.get(i - 1)) + Double.parseDouble(list.get(i + 1));
				list.set(i, Double.toString(value));
				list.remove(i + 1);
				list.remove(--i);
			} else if (list.get(i).equals("-")) {

				double value = Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1));
				list.set(i, Double.toString(value));
				list.remove(i + 1);
				list.remove(--i);
			}
		}
		System.out.println("\nExpression : "+exp);
		Double value = Double.parseDouble(list.get(0));
		if (value.equals(Double.valueOf(value.intValue()))) {
			System.out.println("\nOutput : " + value.intValue());
		} else {
			System.out.println("\nOutput " + value);
		}
		calculatorViewToControllerCall.addDetails(list, exp);
	}

	private void getOperator(List<String> list) {

		System.out.println("\n********Opertion********");
		System.out.println("\n	1) Addition");
		System.out.println("	2) Subtraction");
		System.out.println("	3) Multiplication");
		System.out.println("	4) Divition");
		System.out.print("\nEnter Option : ");
		String oper = scan.next();
		switch (oper) {

		case "1":
			list.add("+");
			getInput(list);
			break;
		case "2":
			list.add("-");
			getInput(list);
			break;
		case "3":
			list.add("*");
			getInput(list);
			break;
		case "4":
			list.add("/");
			getInput(list);
			break;
		default:
			System.out.println("\nWrong Input!!!");
			System.out.println("Re Enter the Input!!!");
			getOperator(list);
		}
	}

	@Override
	public void addSuccessfully() {

		System.out.println("\nAdded Successfully!!!");
	}

	@Override
	public void showDetails(List<History> list) {

		if (list.size() > 0) {
			boolean isExit = false;
			for (int i = list.size() - 1; i >= 0 && isExit == false;) {

				try {

					System.out.println("\nExpression - "+list.get(i).getExpression());
//				System.out.println("Answer : "+list.get(i).getAnswer());
					Double value = list.get(i).getAnswer();
					if (value.equals(Double.valueOf(value.intValue()))) {
						System.out.println("\nOutput : " + value.intValue());
					} else {
						System.out.println("\nOutput " + value);
					}
					System.out.println("\n1) Get Answer");
					System.out.println("2) Next Answer");
					System.out.println("3) Exitted");
					System.out.print("\nEnter Input : ");
					int input = scan.nextInt();
					switch (input) {

					case 1:
						List<String> detail = new LinkedList<>();
						detail.add(Double.toString(list.get(i).getAnswer()));
						getOperator(detail);
						isExit = true;
						break;
					case 2:
						--i;
						if(i == -1) {
							
							System.out.println("\nHistory is Empty!!!");
						}
						break;
					case 3:
						System.out.println("Exitted");
						isExit = true;
						break;
					default:

					}
				} catch (Exception e) {

					System.out.println("\nWrong Input!!!");
				}
			}
		} else {

			System.out.println("\nNo History!!!");
		}
	}
}
