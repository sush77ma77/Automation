package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility {
	//config.properties
	public static String getPropertyValue(String path,String key) {
		String v="";
		try {
			Properties p = new Properties();//import from java.util
			p.load(new FileInputStream(path));
			v  = p.getProperty(key);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return v;
	}
	//to send result pass and fail percentage update in excel
	public static void writeResulttoXL(String path,String sheet,int pass,int fail) {
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			w.getSheet(sheet).getRow(1).getCell(0).setCellValue(pass);
			w.getSheet(sheet).getRow(1).getCell(1).setCellValue(fail);
			w.write(new FileOutputStream(path));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get value from excel sheet
	public static String getXLData(String path,String sheet,int r,int c) {
		String v="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(sheet).getRow(r).getCell(c).toString();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return v;
	}
	//get row count from excel sheet
	public static int getXLRowCount(String path,String sheet) {
		int count = 0;
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			count=w.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	//to take screen shot
	public static String getPhoto(WebDriver driver,String folder) {
		Date d = new Date();
		String dateTime = d.toString().replaceAll(":","_");
		String path = folder+"/"+dateTime+".png";
		try {
			TakesScreenshot t = (TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			File destFile = new File(path);
			FileUtils.copyFile(srcFile,destFile);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return path;
	}
	
	//with and without grid
	public static WebDriver openBrowser(WebDriver driver,String ip,String browser) {
		if(ip.equals("localhost")) {
			if(browser.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else {
				driver = new FirefoxDriver();
			}
		}
		else {
			try {
				URL u =new URL("http://"+ip+":4444/wd/hub");
				DesiredCapabilities d = new DesiredCapabilities();
				d.setBrowserName(browser);
				driver = new RemoteWebDriver(u,d);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return driver;
	}
	
}
