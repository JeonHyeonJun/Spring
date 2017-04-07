package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Loan;

@Service
public class LoanService {
	
	public List<Loan> calculateLoan(double amount, double rate, int period, int type){
		double b_month = (rate / 100) / 12;
		double d = Math.pow((1 + b_month), period);
		
		List<Loan> list = new ArrayList<Loan>();
		
		if (type == 1) {
			double result = ((amount * b_month) * d) / (d - 1);
			int result2 = (int) (result + 0.5);
			for (int i = 0; i < period; i++) {
				Loan loan = new Loan();
				double eja = amount * b_month;
				int eja2 = (int) (eja + 0.5);
				double one = result - eja;
				int one2 = (int) (one + 0.5);
				double zan = amount - one;
				int zan2 = (int) (zan + 0.5);
//				loan.idx = i+1;
//				loan.thisMonthOrigin = result2;
//				loan.thisMonthRate = one2;
//				loan.amount = eja2;
//				loan.readyMonth = zan2;
				loan.setIdx(i+1);
				loan.setThisMonthOrigin(result2);
				loan.setThisMonthRate(one2);
				loan.setAmount(eja2);
				loan.setReadyMonth(zan2);
				list.add(loan);
				amount = zan;
			}
		}
		else if (type == 2) {
			double result = amount / period;
			int result2 = (int) (result + 0.5);
			for (int i = 0; i < period; i++) {
				Loan loan = new Loan();
				double eja = amount * b_month;
				int eja2 = (int) (eja + 0.5);
				double sang = result + eja;
				int sang2 = (int) (sang + 0.5);
				double zan = amount - result;
				int zan2 = (int) (zan + 0.5);
				loan.idx = i+1;
				loan.thisMonthOrigin = sang2;
				loan.thisMonthRate = result2;
				loan.amount = eja2;
				loan.readyMonth = zan2;
				list.add(loan);
				amount= zan;
			}
		}
		return list;
	}
}
