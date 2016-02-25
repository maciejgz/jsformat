package pl.mg.excercise;

import java.math.BigDecimal;

public class Transaction {

	private String name = null;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSrcIBAN() {
		return srcIBAN;
	}

	public void setSrcIBAN(String srcIBAN) {
		this.srcIBAN = srcIBAN;
	}

	public String getDstIBAN() {
		return dstIBAN;
	}

	public void setDstIBAN(String dstIBAN) {
		this.dstIBAN = dstIBAN;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	private String surname = null;
	private String srcIBAN = null;
	private String dstIBAN = null;
	private BigDecimal amount = null;

	public Transaction(String name, String surname, String srcIBAN, String dstIBAN, BigDecimal amount) {
		this.name = name;
		this.surname = surname;
		this.srcIBAN = srcIBAN;
		this.dstIBAN = dstIBAN;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [name=" + name + ", surname=" + surname + ", srcIBAN=" + srcIBAN + ", dstIBAN=" + dstIBAN
				+ ", amount=" + amount + "]";
	}

}
