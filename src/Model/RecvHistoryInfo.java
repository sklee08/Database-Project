package Model;

public class RecvHistoryInfo {

	private String historyDate;
	private int money;
	private String accountNum;
	private String bank;
	
	public RecvHistoryInfo() {
		this.historyDate = "";
		this.money = 0;
		this.accountNum = "";
		this.bank = "";
	}

	public String getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(String history_date) {
		this.historyDate = history_date;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccount_num(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
}
