package objectholder;

public class storebrowservalue {
	public  String browser;
	public String url;
	
	public storebrowservalue(String browsername,String url) {
		this.browser = browsername;
		this.url = url;
	}
	
	public String getbrowsername() {
		return this.browser;
	}
	
	public String geturl() {
		return this.url;
	}
	
	public void setbrowsername(String name) {
		this.browser = name;
	}
	
	public void setbrowserurl(String url) {
		this.url = url;
	}

}
