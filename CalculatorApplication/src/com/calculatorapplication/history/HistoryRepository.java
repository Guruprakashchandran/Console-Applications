package com.calculatorapplication.history;

import java.util.LinkedList;
import java.util.List;

public class HistoryRepository {

	private static HistoryRepository historyRepository;
	private HistoryRepository() {}
	private List<History> calculationHistory = new LinkedList<>(); 
	public static HistoryRepository getInstance() {
		
		if(historyRepository == null) {
			
			historyRepository = new HistoryRepository();
		}
		return historyRepository;
	}
	public void addDetails(List<String> list,String exp) {
		
		History history = new History(exp,Double.parseDouble(list.get(0)));
		calculationHistory.add(history);
	}
	public List<History> getDetails(){
		
		List<History> list = new LinkedList<>();
		History history;
		for(int i = 0;i<calculationHistory.size();++i) {
			
			history = new History(calculationHistory.get(i));
			list.add(history);
		}
		return list;
	}
}
