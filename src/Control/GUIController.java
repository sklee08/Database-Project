package Control;

import java.io.IOException;
import java.nio.channels.AcceptPendingException;

import View.*;
import java.util.ArrayList;


public class GUIController {
	
	private AccountDup accountDup;
	private AtmDrawl atmDrawl;
	private AtmInput atmInput;
	private AtmMake atmMake;
	private AtmModel atmModel;
	private AtmTrans atmTrans;
	private AtmTransLogin atmTransLogin;
	private AtmTransView atmTransView;
	private AtmView atmView;
	private InvalidAccountNum invalidAccountNum;
	private InvalidPassword invalidPassword;
	private LackBalance lackBalance;
	private RobberedAccount robberedAccount;
	private WorkSuccess workSuccess;
	private LoginFail loginFail;
	private AtmViewResult atmViewResult;
	private AtmRobberyLogin atmRobberyLogin;
	private AlreadyRobbery alreadyRobbery;
	private AtmTransViewResult atmTransViewResult;
	
	
	public void popAtmTransViewResult(String account, ArrayList<String> logrecv, ArrayList<String> logsend) {
		this.atmTransViewResult = new AtmTransViewResult(account, logrecv, logsend);
		this.atmTransViewResult.setVisible(true);
	}
	
	public void popAlreadyRobbery() {
		this.alreadyRobbery = new AlreadyRobbery();
		this.alreadyRobbery.setVisible(true);
	}
	
	
	public void popAtmRobberyLogin() {
		this.atmRobberyLogin = new AtmRobberyLogin();
		this.atmRobberyLogin.setVisible(true);
	}
	
	public void popAtmViewResult(String name, String accountNum, int money) {
		this.atmViewResult = new AtmViewResult(name, accountNum, money);
		this.atmViewResult.setVisible(true);
	}
	
	public void popAccountDup() {
		this.accountDup = new AccountDup();
		
	}
	
	public void popLoginFail() {
		this.loginFail = new LoginFail();
		this.loginFail.setVisible(true);
	}
	
	public void popWorkSuccess() {
		this.workSuccess = new WorkSuccess();
		workSuccess.setVisible(true);
	}
	
	public void popAtmDrawl() {
		this.atmDrawl = new AtmDrawl();
		this.atmDrawl.setVisible(true);
	}
	
	public void popAtmInput() {
		this.atmInput = new AtmInput();
	}
	
	public void popAtmMake() {
		this.atmMake = new AtmMake();
	}
	
	public void popAtmModel() throws IOException {
		this.atmModel = new AtmModel();
		atmModel.setVisible(true);
	}

	
	public void popAtmTrans(String fromAccount) {
		this.atmTrans = new AtmTrans(fromAccount);
		this.atmTrans.setVisible(true);
	}
	
	public void popAtmTransLogin() {
		this.atmTransLogin = new AtmTransLogin();
	}
	
	public void popAtmTransView() {
		this.atmTransView = new AtmTransView();
	}
	
	public void popAtmView() {
		this.atmView = new AtmView();
	}
	
	public void popInvalidAccountNum() {
		this.invalidAccountNum = new InvalidAccountNum();
	}
	
	public void popInvalidPassword() {
		this.invalidPassword = new InvalidPassword();
	}
	
	public void popLackBalance() {
		this.lackBalance = new LackBalance();
	}
	
	public void popRobberedAccount() {
		this.robberedAccount = new RobberedAccount();
		this.robberedAccount.setVisible(true);
	}
	
	
	
	
	
	
	
	
}
