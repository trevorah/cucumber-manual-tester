package cucumber.examples.java.calculator;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

public class RpnCalculatorStepdefs {
    private RpnCalculator calc;

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on() {
        calc = new RpnCalculator();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void adding(int arg1, int arg2) {
        calc.push(arg1);
        calc.push(arg2);
        calc.push("+");
    }
    
    @When("^I manually (.+)$")
    public void sayHello(String instruction) {
    	System.out.println("Please " + instruction);
        Console console = System.console();
        
// 	   String sWhatever;
// 	  
//       Scanner scanIn = new Scanner(System.in);
//       sWhatever = scanIn.nextLine();
// 
//       scanIn.close();            
//       System.out.println(sWhatever);
        //read user name, using java.util.Formatter syntax :
        String response = console.readLine("User Name? ");
    	
//    	System.out.println(response);
    }

    
    public static void main(String[] args)
    {
    	RpnCalculatorStepdefs defs = new RpnCalculatorStepdefs();
    	defs.sayHello("hello");
    }
    @Given("^I press (.+)$")
    public void I_press(String what) {
        calc.push(what);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected) {
        assertEquals(expected, calc.value());
    }

    @Before({"~@foo"})
    public void before() {
        System.out.println("Runs before scenarios *not* tagged with @foo");
    }

    @After
    public void after() {

    }

    @Given("^the previous entries:$")
    public void thePreviousEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            calc.push(entry.first);
            calc.push(entry.second);
            calc.push(entry.operation);
        }
    }

    
    public static String getStringFromUser()
    {
	    String str="";
	    try
	    {
	    	str = new BufferedReader(new InputStreamReader(System.in)).readLine();	
	    }
	    catch (IOException e)
	    {
	    	// TODO do exception handling
	    }
	    return str ;
    }
    
    public class Entry {
        Integer first;
        Integer second;
        String operation;
    }
}
