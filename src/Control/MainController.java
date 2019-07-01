package Control;

public class MainController {

	private SyncController sc;
	private DBController dc;
	private CustomerInfoController cic;
	private GUIController gc;
	private HistoryController hc;
	
	public MainController() {
		this.sc = new SyncController();
		this.dc = new DBController();
		this.cic = new CustomerInfoController();
		this.gc = new GUIController();
		this.hc = new HistoryController();
	}

	public SyncController getSc() {
		return sc;
	}

	public void setSc(SyncController sc) {
		this.sc = sc;
	}

	public DBController getDc() {
		return dc;
	}

	public void setDc(DBController dc) {
		this.dc = dc;
	}

	
	public CustomerInfoController getCic() {
		return cic;
	}

	public void setCic(CustomerInfoController cic) {
		this.cic = cic;
	}

	public GUIController getGc() {
		return gc;
	}

	public void setGc(GUIController gc) {
		this.gc = gc;
	}

	public HistoryController getHc() {
		return hc;
	}

	public void setHc(HistoryController hc) {
		this.hc = hc;
	}
	
	
}
