package stepDefinitions;



import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.Header_Page;
import reuseablecomponent.BaseClass;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to visit and validate Home us page
 */
public class Visit_Home_Page_BDD
{
	@Given("^visit Home Page$")
	public void visit_Home_Page() 
	{
		//Waiting for Home page to be load
		BaseClass.HardWait5();
		Header_Page.clickOnHome();
		//visiting about us page
		Log4j.debug("visiting Home Page");
	}

	@When("^Url of Home Page is right$")
	public void url_of_Home_Page_is_right() 
	{
		//validating the url
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuidev.azurewebsites.net/home";
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
	}

	@Then("^Validate the Home Page$")
	public void validate_the_Home_Page() 
	{
		Log4j.debug("visiting HomePage");
	}


}
