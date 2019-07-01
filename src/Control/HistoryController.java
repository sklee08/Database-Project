package Control;

import Model.*;
import java.util.ArrayList;
import java.sql.*;

public class HistoryController {


	private DBController dc;
	private SyncController sc;
	private ResultSet rs = null;
	private Statement stmt = null;
	
	public HistoryController() {
		this.dc = new DBController();
//		this.sc = new SyncController();
		rs = null;
		stmt = null;
	}
	
	public void addSendHistory(String date, int money, String accountNum, String bank) {
		String s = "Insert into sendHistory (date, money, accountNum, bank) value('"+date+"',"+money+",'"+accountNum+"','"+bank+"');";
		
		try {
		dc.initConnect();
		dc.updateSQL(s);
		} catch(Exception e) {
			
		}
	}
	
	public void addRecvHistory(String date, int money, String accountNum, String bank) {
String s = "Insert into recvHistory (date, money, accountNum, bank) value('"+date+"',"+money+",'"+accountNum+"','"+bank+"');";
		
		try {
		dc.initConnect();
		dc.updateSQL(s);
		} catch(Exception e) {
			
		}
	}
	
	public ArrayList<String> getSendHistory(SyncController sc, String account) {
		try {
			
			String s = "select *from sendhistory where accountNum = '"+account+"';";
			ArrayList<String> arr = new ArrayList<String>();
			
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			rs = stmt.executeQuery(s);
			
			while(rs.next()) {
				
				arr.add("date : "+rs.getString(1)+", money : "+rs.getInt(2)+", account : "+rs.getString(3)+", bank : "+rs.getString(4)+".");
			}
			return arr;
			//  show history
			
			
		} catch (Exception e) {
			
			return null;
		}
		
		
		
	}
	
	public ArrayList<String> getRecvHistory(SyncController sc, String account) {
		try {
			
			String s = "select *from recvhistory where accountNum = '"+account+"';";
			ArrayList<String> arr = new ArrayList<String>();
			
			dc.initConnect();
			stmt = dc.getConn().createStatement();
			rs = stmt.executeQuery(s);
			
			while(rs.next()) {
				System.out.println("recv error");
				arr.add("date : "+rs.getString(1)+", money : "+rs.getInt(2)+", account : "+rs.getString(3)+", bank : "+rs.getString(4)+".");
			}
			return arr;
			//  show history
			
		} catch (Exception e) {
			
			return null;
		}
		
		
		
	}
	
	

}
