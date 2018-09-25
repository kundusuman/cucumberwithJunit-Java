package stepDefinitions;



import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.Contact_Us_Page;
import pageobject.Header_Page;
import reuseablecomponent.BaseClass;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to visit and validate contact us page
 */
public class Visit_Contact_Us_Page_BDD 
{
	@Given("^visit Contact Us Page$")
	public void visit_Contact_Us_Page() 
	{
		Log4j.debug("visiting contact us spage");
		BaseClass.HardWait5();
		Header_Page.clickOnContactUs();
		
	}

	@When("^UrlofContact Us is right$")
	public void urlofcontact_Us_is_right()
	{
		//validating the url
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuidev.azurewebsites.net/contactus";
		Assert.assertEquals(ExpectedPageTitle, pageTitle);
	}

	@Then("^Validate the Contact Us Page$")
	public void validate_the_Contact_Us_Page() 
	{
		//validating page content
		Log4j.info("picking the value of title header of a iframe to validate the page");
		String checkContent=Contact_Us_Page.returnContactUsTitle();
		String ExpectedContains="Contact Us";
		Assert.assertEquals(ExpectedContains,checkContent);
	}




}
