package generic;

public interface IAutoConst {
	public static final String CHROME_KEY="webdriver.chrome.driver";
	public static final String CHROME_VALUE="./driver/chromedriver.exe";
	
	public static String GECKO_KEY="webdriver.gecko.driver";
	public static String GECKO_VALUE="./driver/geckodriver.exe";
	
	String CONFIG_PATH = "./config.properties";
	String SUMMARY_PATH = "./result/Summary.xlsx";
	
	String INPUT_PATH = "./data/input.xlsx";
	String PHOTO_PATH = "./photo";

}
