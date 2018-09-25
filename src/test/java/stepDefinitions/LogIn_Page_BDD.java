package stepDefinitions;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to login in a page using valid user email and password
 */


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.Header_Page;
import pageobject.Login_Patient_Page;
import reuseablecomponent.BaseClass;
import utility.ExcelUtils;
import utility.Log4j;

public class LogIn_Page_BDD
{
	@Given("^visit Login Page$")
	public void visit_Login_Page() 
	{
		//opening the log in page
		Log4j.info("visiting login page");
		BaseClass.HardWait3();
		Log4j.warn("error may occur during visiting");
		Header_Page.clickOnLogin();
		BaseClass.HardWait3();
	}

	@When("^Url of Login Page is right$")
	public void url_of_Login_Page_is_right() throws Throwable 
	{
		//validating the url
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuidev.azurewebsites.net/login";
		Log4j.warn("checking that wheather it is a valid page or not");
		
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
	}




	@Then("^Log in in Login with a valid crediantial$")
	public void log_in_in_Login_with_a_valid_crediantial()
	{
		//login using valid credintial
		BaseClass.HardWait3();
		Log4j.info("inserting a useremail and password crediential"); 
		Login_Patient_Page.putEmail(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "EMAIL"));
		Login_Patient_Page.putPassword(ExcelUtils.getViaTEST("LoginPatientPage_Test", "PASSWORD"));
		Login_Patient_Page.clickLogin();
	    
	}

	@Then("^Log out$")
	public void log_out() 
	{
		//login using valid credintial
		BaseClass.HardWait3();
		Log4j.info("logging out from a account");
		try {
		Login_Patient_Page.clickLogoutLink();
		Login_Patient_Page.clickLogoutButton();
		BaseClass.HardWait0();
		Login_Patient_Page.clickOkButtonAfterLogout();
		}
		catch(Exception e)
		{
			Log4j.error("Login was not sucessfull for that log out fails");
		}
	    
	}

}
