package pl.mg.excercise;

import java.math.BigDecimal;
import java.util.List;

public class FileLoadExcercise {

	public static void main(String[] args) {
		String path = DataReader.getFilepathFromUser(args);

		DataReader operator = new DataReader();
		List<Transaction> transactions = operator.calculate(path);
		System.out.println(transactions);
		TransactionService service = new TransactionService();
		BigDecimal sumTransactions = service.sumTransactions(transactions);
		System.out.println(sumTransactions);
		System.out.println(transactions);
	}
}
