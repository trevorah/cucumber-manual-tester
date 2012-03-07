package trevorah.google;

import static org.junit.Assert.*;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManualStepDefinitions
{
    
    @Given("^I have manually (.+)$")
    public void askToGivenManually(String instruction) throws IOException
    {
    	System.out.println("Please ensure that you have " + instruction);
    	String response = askAndGetResponse("Have you done this? ");
    	if(!instructionSuccessful(response))
    	{
    		String failureDetails = askAndGetResponse("What was wrong? ");
    		fail(failureDetails);
    	}
    }
    
    @When("^I manually (.+)$")
    public void askToWhenManually(String instruction) throws IOException
    {
    	System.out.println("Please " + instruction);
    	String response = askAndGetResponse("Have you done this? ");
    	if(!instructionSuccessful(response))
    	{
    		String failureDetails = askAndGetResponse("What was wrong? ");
    		fail(failureDetails);
    	}
    }
    
    @Then("^I can manually check that (.+)$")
    public void askToThenManually(String instruction) throws IOException
    {
    	System.out.println("Please check that " + instruction);
    	String response = askAndGetResponse("Does this pass? ");
    	if(!instructionSuccessful(response))
    	{
    		String failureDetails = askAndGetResponse("What was wrong? ");
    		fail(failureDetails);
    	}
    }
    
    private String askAndGetResponse(String question) throws IOException
    {
    	System.out.print(question);
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String line = bufferedReader.readLine();
    	return line;
    }
    
    private boolean instructionSuccessful(String response)
    {
    	if(response.equals("y") || response.equals("yes"))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
