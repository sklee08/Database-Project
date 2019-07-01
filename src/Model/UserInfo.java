package Model;

public class UserInfo {
	
	private String name;
	private String pw;
	private String accountNum;
	private String bank;
	private int balance;
	private boolean robbery;
	
	public UserInfo() {
		this.name = "";
		this.pw = "";
		this.accountNum = "";
		this.bank = "";
		this.balance = 0;
		this.robbery = false;
	}
	
	public UserInfo(String name, String pw, String account_num, String bank, int balance, boolean robbery) {
		this.name = name;
		this.pw= pw;
		this.accountNum = account_num;
		this.bank = bank;
		this.balance = balance;
		this.robbery = robbery;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAccount_num() {
		return accountNum;
	}

	public void setAccount_num(String account_num) {
		this.accountNum = account_num;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isRobbery() {
		return robbery;
	}

	public void setRobbery(boolean robbery) {
		this.robbery = robbery;
	}
	

}
