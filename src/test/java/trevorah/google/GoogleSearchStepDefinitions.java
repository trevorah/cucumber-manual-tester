package trevorah.google;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchStepDefinitions
{
	private WebDriver driver;
    
	@Given("^I have accessed the google homepage$")
	public void I_have_accessed_the_google_homepage()
	{
	    driver = new FirefoxDriver();
	    driver.get("http://www.google.com");
	}
	
	@When("^I search for (.+)$")
	public void searchFor(String searchTerm)
	{
		 WebElement element = driver.findElement(By.name("q"));
		 element.sendKeys(searchTerm);
	     element.submit();
	}
	
	@After
	public void cleanup()
	{
		if(driver != null)
		{
			driver.close();
		}
	}
}
