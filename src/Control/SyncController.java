package Control;


import java.io.IOException;

import java.util.Date;

import java.sql.*;
import java.text.SimpleDateFormat;

import Model.*;


public class SyncController {
	
	private UserInfo user;
	private DBController dc;
	private HistoryController hc;
	private CustomerInfoController cic;

	
	ResultSet rs = null;
	Statement stmt = null;
	
	
	private static String sql = "SELECT *FROM ATM_USER";
	
	
	
	public void setRobbeyState(String account) throws ClassNotFoundException, SQLException {
		// 무조건 해당 계좌를 도난 상태로 만듦.
		String s = "update ATM_USER set robbery = '"+1+"' where account_num = '"+account+"';";
		
		dc.initConnect();
		dc.updateSQL(s);
	}
	
	
	public SyncController() {
		this.hc = new HistoryController();
		this.dc = new DBController();
		this.user = new UserInfo();
		this.cic = new CustomerInfoController();

	}
	
	public boolean dupCheck(String account) throws ClassNotFoundException, SQLException {
		dc.initConnect();
		stmt = dc.getConn().createStatement();
		rs = stmt.executeQuery(sql);

		while(rs.next()) {
			if(rs.getString(3).equals(account)) {
				return false;		// 같은 것이 있으면 false 반환
			}
		}
		return true;
	}
	

	
	public boolean calculate(String account_num, String bank, int money) {
		
		UserInfo tmp = find(account_num);
		int result = tmp.getBalance() + money;
		
		if(result < 0) {
			return false;
			// 잔액 부족
		}
		
		String s = "update ATM_USER set balance = '"+result+"' where account_num = '"+account_num+"';";
		
		
		try {
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			stmt.executeUpdate(s);
			
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH : mm : ss");
			String date = dayTime.format(new Date(time));
			
			if(money >0) {
			hc.addRecvHistory(date, money, account_num, bank);
			}
			else {
				hc.addSendHistory(date, -money, account_num, bank);
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

	
	public UserInfo find(String account_num) {
		
		UserInfo tmp = new UserInfo();
		String s = "SELECT *from ATM_USER where account_num = '"+account_num+"';";
		
		
		try {
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			rs = stmt.executeQuery(s);
			rs.next();
			tmp = new UserInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6));
						
		} catch (Exception e) {
			return null;
		}
		
		return tmp;
		
		
	}
	
	public int getAccountNum(String name) {			// db에서 한 사람이 갖고 있는 계좌수 반환.
		String s = "Select account_num from atm_user where name = '"+name+"';";
		int i = 0;
		try {
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			rs = stmt.executeQuery(s);
			
			while(rs.next()) {
				i++;
			}
			return i;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getRowNum(String table) {		//table에 몇개의 정보가 있는지 반환
		String s = "select *from "+table+";";
		int i = 0;
		
		try {
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			rs = stmt.executeQuery(s);
			
			while(rs.next()) {
				i++;
			}
			return i;
			
		}catch (Exception e) {
			return -1;
		}
	}
	public boolean dupCheckCustomer(String identify) {
		String s = "select from customerinfo where identifyNum = '"+identify+"';";
		
		try {
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			rs = stmt.executeQuery(s);
			
			return !(rs.next());
//			if(rs.next()) {
//				//중복 o
//				return false; 
//			}
//			else {
//				return true;
//			}
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean signUp(String identifyNum, String name, String pw, String account_num, String bank) {
		

		
		String s = "INSERT INTO ATM_USER (name, pw, account_num, bank, balance, robbery) VALUE('"+name+"','"+pw+"','"+account_num+"','"+bank+"',0,0);";
		
		try {
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(account_num.equals(rs.getString(3))) {
					return false;
				}
				else if(name.equals(rs.getString(1))) {
					// 추가하고 accountNum ++
					dc.updateSQL(s);
					CustomerInfo ci = cic.getCuntomerInfo(name);
					
					
					
					int cnt = ci.getNum_accounts();
					String sss = "";
					
					if(ci.getIdentifyNum().equals(identifyNum)) {
						// 주민번호가 테이블에 존재할때
						// acconutNum++1
						sss = "update customerInfo set accountNum = "+(cnt+1)+" where name = '"+name+"';";
					}
					else {
						//존재 하지 않음
						//생성해줘야함
						sss = "Insert into customerInfo (identifyNum, name, accountNum) value('"+identifyNum+"', '"+name+"',"+1+");";
					}
//				
					
					dc.updateSQL(sss);
					return true;
				}
			}
			
			dc.updateSQL(s);
			int account = getAccountNum(name);
			String ss = "INSERT INTO customerInfo (identifyNum, name, accountNum) value('"+identifyNum+"', '"+name+"', "+account+");";
			
			if(dupCheckCustomer(identifyNum)) {
				return false;
			}
			else {
				
				dc.updateSQL(ss);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		return true;
	}
	
	public int isStolen(String account) {
		UserInfo tmp = find(account);
		if(tmp == null) {
			return 2;
		}
		else {
		if(tmp.isRobbery()) {
			// 1 == stolen
			return 1;
		}
		else { 	// 0 == not stolen
			return 0;
		}
		
		}
	}
	
	public boolean login(String pw, String account_num, String bank) throws ClassNotFoundException, SQLException {
		
		
		dc.initConnect();
		stmt = dc.getConn().createStatement();
		rs = stmt.executeQuery(sql);

		
		
		while(rs.next()) {
			if(pw.equals(rs.getString(2)) && account_num.equals(rs.getString(3)) && bank.equals(rs.getString(4))) {
				if(rs.getBoolean(6)) {
					// 1 == stolen
					return false;
				}
				else {
					// 0 == not stolen
					return true;
				}
			}
		}
		
		return false;
		
	}
	
}
