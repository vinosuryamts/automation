package TestSuite;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;

import launchbrowser.LaunchBrowser;
import objectholder.storebrowservalue;
import openexcelandgetsheet.OpenExcel2;
import openexcelandgetsheet.Test1operation;

public class Test1 {
	
	public static WebDriver driver = null;
	public static ArrayList<String> browserval;
	public static ArrayList<String> urlval;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			
			//Opening Excel to Read Input
			Sheet sheet = OpenExcel2.readexcelvalues(System.getProperty("user.dir")+"\\input\\BrowserLaunchinput.xlsx", "BrowserValidation");
			
			ArrayList<storebrowservalue> hp = Test1operation.storevalues(sheet);
			
			browserval = new ArrayList<String>(hp.size());
			urlval = new ArrayList<String>(hp.size());
			
			for (storebrowservalue wp : hp)
            {
				browserval.add(wp.getbrowsername());
				urlval.add(wp.geturl());
            }
			
			String firstbrowser = null;
			String urlvalue = null;
			for(int i=0;i<browserval.size();i++) {
				 
				firstbrowser =browserval.get(i);
				urlvalue = urlval.get(i);
				 
		 	
					LaunchBrowser.openingBrowser(driver,firstbrowser);
					driver = LaunchBrowser.driver; 
					
					LaunchBrowser.implicitWait( driver,5, TimeUnit.SECONDS);
					
					LaunchBrowser.navigateto(driver, urlvalue);
					

					LaunchBrowser.implicitWait( driver,5, TimeUnit.SECONDS);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					LaunchBrowser.closedriver(driver);
										
			}
			
			
			
	}

}
