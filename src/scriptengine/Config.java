package scriptengine;

public class Config {

	private String version = "" ;
	
	private int server = 0 ;
	
	private String ip = "" ;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getServer() {
		return server;
	}

	public void setServer(int server) {
		this.server = server;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "version = " + getVersion() + ",server = " + getServer() + ",ip = " + getIp() ;
	}
}
