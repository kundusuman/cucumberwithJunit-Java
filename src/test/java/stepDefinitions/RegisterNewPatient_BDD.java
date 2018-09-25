package stepDefinitions;



import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.Header_Page;
import pageobject.Register_As_A_Patient_Page;
import reuseablecomponent.BaseClass;
import utility.ExcelUtils;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to Register in a page using valid crediantial
 */
public class RegisterNewPatient_BDD
{

	@Given("^visit Register new Patient Page$")
	public void visit_Register_new_Patient_Page() 
	{
		//visiting signup page
		BaseClass.HardWait5();
		Log4j.info("clicking in the signup link");
		Header_Page.clickOnSignUp();
		BaseClass.HardWait5();
	}

	@When("^Url of Register Patient page is right$")
	public void url_of_Register_Patient_page_is_right() 
	{
		//validating the url
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuidev.azurewebsites.net/signup";
		Log4j.warn("comparing the value to check wheather this page is signup page or not");
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
	}



	@Then("^Add new Patient$")
	public void add_new_Patient()
	{
		//giving valid crediantial to signup
		Log4j.info("giving valid crediantial to signup");
		Log4j.warn("error may occure due to excel sheet failure");
		
		Register_As_A_Patient_Page.putName(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "USERNAME"));
		Register_As_A_Patient_Page.putEmail(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "EMAIL"));
		Register_As_A_Patient_Page.putPassword(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "PASSWORD"));
		Register_As_A_Patient_Page.putPhoneno(ExcelUtils.getViaTEST("RegisterAsAPatientPage_Test", "MOBILENO"));
		Register_As_A_Patient_Page.clickSubmit();
		BaseClass.HardWait5();
		Register_As_A_Patient_Page.clickOkButton();
		
	   
	}

}
