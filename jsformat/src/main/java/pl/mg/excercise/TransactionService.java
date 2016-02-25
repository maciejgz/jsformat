package pl.mg.excercise;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

	public Transaction parseTransaction(String input) {
		String[] splitResult = input.split("@");
		DecimalFormat dcf = new DecimalFormat();
		dcf.setParseBigDecimal(true);
		Transaction transaction = null;
		try {
			transaction = new Transaction(splitResult[1].split(":")[1], splitResult[2].split(":")[1],
					splitResult[3].split(":")[1], splitResult[4].split(":")[1],
					(BigDecimal) dcf.parse(splitResult[5].split(":")[1]));
		} catch (ParseException e) {
			System.err.println("invalid line parse");
		}
		return transaction;
	}

	public BigDecimal sumTransactions(List<Transaction> transactions) {
		BigDecimal bd = new BigDecimal(0);
		for (Transaction transaction : transactions) {
			bd = bd.add(transaction.getAmount());
		}
		return bd;
	}
}
