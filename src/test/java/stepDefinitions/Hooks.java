package stepDefinitions;

/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is a cucumber hook
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import reuseablecomponent.BaseClass;
import utility.ExcelUtils;
import utility.Log4j;
import utility.OpenReport;
import utility.Snippet;
import utility.Test_ShowListener;

public class Hooks {
	private static int count = 0;
	

	@Before
	public void beforeScenario(Scenario scenario) {
		
		Test_ShowListener.set(scenario.getName());
		if (count == 0) {
			
			Log4j.startTestCase("WeHealU");
			FileReader reader = null;
			Properties p = null;
			// reading the property file
			try {
				reader = new FileReader("./CustomizeThings.properties");
				p = new Properties();
				p.load(reader);
			} catch (FileNotFoundException e) {
				Log4j.error("property file load fail");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				Log4j.error("property file load fail");
			}
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			new BaseClass(driver);
			BaseClass.driver.manage().window().maximize();
			Log4j.debug("maximizing window");
			Log4j.debug("opening url");
			// opening url from propertyfile
			BaseClass.driver.get(p.getProperty("url"));
			try {
				ExcelUtils.setExcelFile(p.getProperty("sheet"));
			} catch (Exception e) {
				Log4j.error("ExcelSheet load fails");
			}
		}
		
			
		count++;

	}

	@After
	public void afterScenario() {
		
		Test_ShowListener.end();
		Log4j.endTestCase("WeHealU");
		// BaseClass.driver.close();
	
		
	}
}