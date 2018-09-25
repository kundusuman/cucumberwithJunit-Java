package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.About_Us_Page;
import pageobject.Header_Page;
import reuseablecomponent.BaseClass;
import utility.Log4j;

/**
 * @author Suman Kundu(M1047073)
 * @Date 10/9/2018
 * @purpose this class is used to visit and validate about us page
 */
public class Visit_About_Us_Page_BDD {
	@Given("^visit About Us Page$")
	public void visit_About_Us_Page() {// visiting about us page
		Log4j.debug("visiting aboutus spage");
		BaseClass.HardWait5();
		Header_Page.clickOnAboutUs();
	}

	@When("^Url of About Us is right$")
	public void url_of_About_Us_is_right() {
		// valiadting the url
		String pageTitle = BaseClass.driver.getCurrentUrl();
		String ExpectedPageTitle = "https://wehealuidev.azurewebsites.net/aboutus";
		Log4j.warn("comparing the page url to validate the page");
		Assert.assertEquals(ExpectedPageTitle, pageTitle);

	}

	@Then("^Validate the About Us Page$")
	public void validate_the_About_Us_Page() {
		// validating page content
		Log4j.info("picking the value of title header of a iframe to validate the page");
		BaseClass.HardWait5();
		String checkContent = About_Us_Page.returnAboutUsTitle();
		String ExpectedContains = "About Us";
		Assert.assertEquals(ExpectedContains, checkContent);
	}

}
