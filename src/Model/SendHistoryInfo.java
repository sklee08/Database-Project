package Model;


public class SendHistoryInfo {
	
	private String history_date;
	private int money;
	private String account_num;
	private String bank;
	
	public SendHistoryInfo() {
		this.history_date = "";
		this.money = 0;
		this.account_num = "";
		this.bank = "";
	}

	public String getHistory_date() {
		return history_date;
	}

	public void setHistory_date(String history_date) {
		this.history_date = history_date;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
}
