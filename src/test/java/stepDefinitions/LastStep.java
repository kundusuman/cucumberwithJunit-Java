package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import utility.Snippet;
import utility.TestSendMail;

public class LastStep
{
	
	public static void laststep()
	{
		String summeryReport= ".\\report\\"+Snippet.getcurrentdateandtime()+"\\ExtendReport"+Snippet.getcurrentdateandtime()+".html";
		try {
			FileUtils.copyFile(new File("./temp//report.html"), new File(summeryReport));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		//new OpenReport(System.getProperty("user.dir")+ summeryReport.substring(1));
		//OpenReport.open();
		
		new TestSendMail(summeryReport.substring(1));
		System.out.println(TestSendMail.sendMain());
	}

}
