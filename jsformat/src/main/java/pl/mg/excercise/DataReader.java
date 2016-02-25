package pl.mg.excercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataReader {

	TransactionService transactionService = new TransactionService();

	public static String getFilepathFromUser(String[] args) {
		String path = null;
		if (args != null && args.length > 0 && !"".equals(args[0])) {
			path = args[0];
		} else {
			path = readPathFromConsole();
		}
		return path;
	}

	private static String readPathFromConsole() {
		System.out.println("Podaj ścieżkę do pliku:");
		BufferedReader bufferRead = null;
		String result = null;
		try {
			bufferRead = new BufferedReader(new InputStreamReader(System.in));
			result = bufferRead.readLine();
		} catch (IOException e) {
			if (bufferRead != null) {
				try {
					bufferRead.close();
				} catch (IOException e1) {
				}
			}
		}
		return result;
	}

	public ArrayList<Transaction> calculate(String path) {

		ArrayList<Transaction> transactions = new ArrayList<Transaction>();

		File dataFile = new File(path);
		BufferedReader buffered = null;
		InputStreamReader input = null;
		FileInputStream fileReader = null;
		try {
			fileReader = new FileInputStream(dataFile);
			input = new InputStreamReader(fileReader, "UTF-8");
			buffered = new BufferedReader(input);
			String line = null;
			while ((line = buffered.readLine()) != null) {
				System.out.println(line);
				transactions.add(transactionService.parseTransaction(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
				}
			}
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
				}
			}
			if (buffered != null) {
				try {
					buffered.close();
				} catch (IOException e) {
				}
			}
		}
		return transactions;
	}
}
