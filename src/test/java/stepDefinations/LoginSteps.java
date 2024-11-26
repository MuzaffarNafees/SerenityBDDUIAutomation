package stepDefinations;

import static org.assertj.core.api.Assertions.assertThat;

import actions.LoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginSteps {

	@Steps
	LoginActions loginActions;

	@Given("the user is on the OrangeHRM login page")
	public void the_user_is_on_the_OrangeHRM_login_page() {
		loginActions.openLoginPage();
	}

	@When("the user enters username {string} and password {string}")
	public void the_user_enters_username_and_password(String username, String password) {
		loginActions.enterUsername(username);
		loginActions.enterPassword(password);
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		loginActions.clickLoginButton();
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		assertThat(loginActions.getDriver().getCurrentUrl()).contains("/dashboard");
	}
}
