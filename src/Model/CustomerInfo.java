package Model;

public class CustomerInfo {

	private String identifyNum;
	private String name;
	private int numAccount;
	
	public CustomerInfo() {
		this.identifyNum = "";
		this.name = "";
		this.numAccount = 0;
	}

	public String getIdentifyNum() {
		return identifyNum;
	}

	public void setIdentifyNum(String identifyNum) {
		this.identifyNum = identifyNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum_accounts() {
		return numAccount;
	}

	public void setNumAccounts(int numAccounts) {
		this.numAccount = numAccounts;
	}
	
	
}
