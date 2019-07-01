package Control;

import Model.*;
import java.sql.*;


public class CustomerInfoController {
	
	private DBController dc;
	ResultSet rs;
	Statement stmt;
	
	
	public CustomerInfoController() {
		this.dc = new DBController();
		rs = null;
		stmt = null;
	}
	
	public void addCustomerInfo(CustomerInfo ci) throws ClassNotFoundException, SQLException {
		
		String s = "Insert into CustomerInfo (identifyNum, name, accountNum) value ('"+ci.getIdentifyNum()+"', '"+ci.getName()+"',"+ci.getNum_accounts()+");";
		
		dc.initConnect();
		dc.updateSQL(s);
	}
	
	public CustomerInfo getCuntomerInfo(String name) throws ClassNotFoundException, SQLException {
		CustomerInfo tmp = new CustomerInfo();
		
		String s = "select *from customerInfo where name = '"+name+"';";
		
		dc.initConnect();
		stmt = dc.getConn().createStatement();
		rs = stmt.executeQuery(s);
		if(rs.next()) {
			// 찾음
			tmp.setIdentifyNum(rs.getString(1));
			tmp.setName(name);
			tmp.setNumAccounts(rs.getInt(3));
			return tmp;
		}
		else {
			//못 찾음
			return tmp;
		}
		
		
		
	}
	
	
}
