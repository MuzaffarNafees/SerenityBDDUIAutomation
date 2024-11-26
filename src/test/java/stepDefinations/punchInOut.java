package stepDefinations;

import actions.punchInOutMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class punchInOut {
	
	@Steps
	punchInOutMethod myActions;
	
	  @Given("User launches the OrangeHRM web application")
	    public void userLaunchesApplication() {
		  myActions.openLoginPage();
		  
	    }

	    @When("User enters valid username")
	    public void userEntersUsername() {
	    	myActions.enterUsername();

	    }

	    @When("User enters valid password and logs into the application")
	    public void userLogsIn() {
	    	myActions.enterPassword();

	    }

	    @When("User clicks on the \"Time\" section")
	    public void userClicksOnTimeSection() throws InterruptedException {
	    	myActions.clickOnTimeSection();

	    }

	    @When("User clicks on the \"Attendance\" dropdown button")
	    public void userClicksOnAttendanceDropdown() {
	    	myActions.attendenceDropDown();

	    }

	    @When("User selects {string} from the dropdown")
	    public void user_selects_from_the_dropdown(String string) {
	    	myActions.punInOutSection();

	    }

	    @When("User clicks on \"Punch In\"")
	    public void userClicksOnPunchIn() throws InterruptedException {
	    	myActions.clickOnIn();
	    }

	    @Then("After a short time, User clicks on \"Punch Out\"")
	    public void userClicksOnPunchOut() {
	    	myActions.clickOnOut();

	    }

	    @When("User clicks on the \"Profile\" section")
	    public void userClicksOnProfileSection() {
	    	myActions.clickOnProfilePic();

	    }

	    @Then("User logs out of the application")
	    public void userLogsOut() {
	    	myActions.logOut();

	    }

	
	
	

}
