package application;

/*
 * This class controls the payment information. 
 */

public class Payment {
	boolean isCash, isCredit;
	int total, sCode;
	long cardNumber;
	String expirationDate, cardType, cardHolder;
	
	public Payment() {
		isCash = false;
		isCredit = false;
		total = 0;
		sCode = 0;
		cardNumber = 000000;
		expirationDate = "";
		cardType = "";
		cardHolder = "";
	}
	
	public Payment(boolean isCash, boolean isCredit, int total, int sCode,
			long cardNumber, String experationDate, String cardType,
			String cardHolder) {
		this.isCash = isCash;
		this.isCredit = isCredit;
		this.total = total;
		this.sCode = sCode;
		this.cardNumber = cardNumber;
		this.expirationDate = experationDate;
		this.cardType = cardType;
		this.cardHolder = cardHolder;
	}

	public boolean isCash() {
		return isCash;
	}

	public void setCash(boolean isCash) {
		this.isCash = isCash;
	}

	public boolean isCredit() {
		return isCredit;
	}

	public void setCredit(boolean isCredit) {
		this.isCredit = isCredit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getsCode() {
		return sCode;
	}

	public void setsCode(int sCode) {
		this.sCode = sCode;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	@Override
	public String toString() {
		return "Payment [isCash=" + isCash + ", isCredit=" + isCredit + ", total=" + total + ", sCode=" + sCode
				+ ", cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", cardType=" + cardType
				+ ", cardHolder=" + cardHolder + "]";
	}
	
	
	

}
