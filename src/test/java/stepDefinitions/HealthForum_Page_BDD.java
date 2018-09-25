package stepDefinitions;





import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.Footer_Page;
import pageobject.HealthForum_Page;
import reuseablecomponent.BaseClass;
import utility.Log4j;
/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to visit and validate Health Forum page
 */
public class HealthForum_Page_BDD
{
	@Given("^visit Health_Forum Page$")
	public void visit_Health_Forum_Page() 
	{
		//visiting home page
		Log4j.warn("visiting Health Forum page");
		BaseClass.HardWait3();
		Footer_Page.clickOnHealthForum();
		BaseClass.HardWait3();
	}

	@When("^UrlofHealth_Forum is right$")
	public void urlofhealth_forum_is_right() 
	{
		// checking the url
		String pageTitle=BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle="https://wehealuidev.azurewebsites.net/forum";
		Log4j.warn("checking that wheather it is a valid page or not");
		Assert.assertEquals(ExpectedPageTitle, pageTitle);

	}

	@Then("^Validate the Health_Forum Page$")
	public void validate_the_Health_Forum_Page() 
	{
		//validate the page
		Log4j.warn("checking Health Forum Link");
		String result=HealthForum_Page.getCategoryText();
		Assert.assertEquals("Categories :",result);
	}



}
