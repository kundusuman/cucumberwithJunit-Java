package Runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.cli.Main;
import cucumber.api.junit.Cucumber;
import reuseablecomponent.BaseClass;
import stepDefinitions.LastStep;
import utility.Test_ShowListener;
/**
 *  @author suman
 *  @purpose Test runner used to run cucumber script using features files
 * also called this class in pom for sequential execution of cucumber script
 *
 *
 */

		
public class MyRunner 
{
	
	
	@Test
	public void cucumber()
	{
		String argv[]=new String[] { "--glue", "stepDefinitions", // the package which contains the glue classes
				"./Features",
				"--tags",
				"@TestCon",
				"--plugin",
				"com.cucumber.listener.ExtentCucumberFormatter:temp/report.html" };
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		try {
			byte exitstatus = Main.run(argv, contextClassLoader);
		} catch (IOException e) {
			
		}
	}
	
	@AfterClass
	public static void Afterclass()
	{
		BaseClass.driver.close();
		Test_ShowListener.end();
		LastStep.laststep();
		
		
	}
   
	
}
