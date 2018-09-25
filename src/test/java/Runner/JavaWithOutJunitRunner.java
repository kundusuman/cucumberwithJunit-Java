package Runner;

import cucumber.api.cli.Main;
import reuseablecomponent.BaseClass;
import stepDefinitions.LastStep;
public class JavaWithOutJunitRunner {
	public static void main(String[] args) throws Throwable {

		String argv[]=new String[] { "--glue", "stepDefinitions", // the package which contains the glue classes
				"./Features",
				"--tags",
				"@TestCon",
				"--plugin",
				"com.cucumber.listener.ExtentCucumberFormatter:temp/report.html" };
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		byte exitstatus = Main.run(argv, contextClassLoader);
		LastStep.laststep();
		BaseClass.driver.close();

	}

}
